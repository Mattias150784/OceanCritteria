package net.mattias.oceancritteria.entity.goals;

import net.mattias.oceancritteria.entity.custom.PenguinEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class PenguinSwimGoal extends Goal {
    private final PenguinEntity penguin;
    private final double speedModifier;
    private int interval;
    private Vec3 targetPos;
    private int ticksRunning = 0;
    private int stuckCounter = 0;

    public PenguinSwimGoal(PenguinEntity penguin, double speedModifier) {
        this.penguin = penguin;
        this.speedModifier = speedModifier;
        this.interval = 80;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        if (!this.penguin.isInWater()) {
            return false;
        }

        if (this.penguin.needsAir()) {
            return false;
        }

        if (this.penguin.getRandom().nextInt(this.interval) != 0) {
            return false;
        }

        this.targetPos = this.getRandomSwimPosition();
        return this.targetPos != null;
    }

    @Override
    public boolean canContinueToUse() {
        if (!this.penguin.isInWater() || this.penguin.needsAir()) {
            return false;
        }

        return this.targetPos != null &&
                !this.penguin.getNavigation().isDone() &&
                this.penguin.distanceToSqr(this.targetPos) > 2.0 &&
                this.ticksRunning < 200;
    }

    @Override
    public void start() {
        if (this.targetPos != null) {
            this.penguin.getNavigation().moveTo(this.targetPos.x, this.targetPos.y, this.targetPos.z, this.speedModifier);
        }
        this.ticksRunning = 0;
        this.stuckCounter = 0;
    }

    @Override
    public void tick() {
        this.ticksRunning++;

        if (this.penguin.getDeltaMovement().y > 0) {
            this.penguin.setDeltaMovement(this.penguin.getDeltaMovement().multiply(1.0, 0.3, 1.0));
        }

        if (this.penguin.position().y > this.penguin.level().getSeaLevel() - 2) {
            this.stuckCounter++;
            if (this.stuckCounter > 20) {
                Vec3 downwardPos = this.getDeepSwimPosition();
                if (downwardPos != null) {
                    this.targetPos = downwardPos;
                    this.penguin.getNavigation().moveTo(this.targetPos.x, this.targetPos.y, this.targetPos.z, this.speedModifier);
                    this.stuckCounter = 0;
                }
            }
        } else {
            this.stuckCounter = 0;
        }

        if (this.ticksRunning % 80 == 0) {
            Vec3 newTarget = this.getRandomSwimPosition();
            if (newTarget != null) {
                this.targetPos = newTarget;
                this.penguin.getNavigation().moveTo(this.targetPos.x, this.targetPos.y, this.targetPos.z, this.speedModifier);
            }
        }
    }

    @Override
    public void stop() {
        this.penguin.getNavigation().stop();
        this.targetPos = null;
        this.ticksRunning = 0;
        this.stuckCounter = 0;
    }

    @Nullable
    private Vec3 getRandomSwimPosition() {
        Vec3 currentPos = this.penguin.position();
        Level level = this.penguin.level();
        double seaLevel = level.getSeaLevel();

        for (int attempts = 0; attempts < 15; attempts++) {
            double offsetX = (this.penguin.getRandom().nextDouble() * 16 - 8);
            double offsetZ = (this.penguin.getRandom().nextDouble() * 16 - 8);

            double offsetY;
            if (currentPos.y > seaLevel - 3) {
                offsetY = this.penguin.getRandom().nextDouble() * -8 - 2;
            } else {
                offsetY = (this.penguin.getRandom().nextDouble() * 8 - 6);
            }

            Vec3 candidatePos = currentPos.add(offsetX, offsetY, offsetZ);
            BlockPos candidateBlock = BlockPos.containing(candidatePos);

            if (isValidSwimTarget(candidateBlock)) {
                return candidatePos;
            }
        }

        return null;
    }

    @Nullable
    private Vec3 getDeepSwimPosition() {
        Vec3 currentPos = this.penguin.position();
        Level level = this.penguin.level();

        for (int attempts = 0; attempts < 10; attempts++) {
            double offsetX = (this.penguin.getRandom().nextDouble() * 12 - 6);
            double offsetZ = (this.penguin.getRandom().nextDouble() * 12 - 6);
            double offsetY = this.penguin.getRandom().nextDouble() * -10 - 5; // Force deep

            Vec3 candidatePos = currentPos.add(offsetX, offsetY, offsetZ);
            BlockPos candidateBlock = BlockPos.containing(candidatePos);

            if (isValidSwimTarget(candidateBlock)) {
                return candidatePos;
            }
        }

        return null;
    }

    private boolean isValidSwimTarget(BlockPos pos) {
        Level level = this.penguin.level();

        boolean hasWater = level.getFluidState(pos).is(FluidTags.WATER) &&
                level.getFluidState(pos.above()).is(FluidTags.WATER) &&
                level.getFluidState(pos.above(2)).is(FluidTags.WATER);

        boolean notSolid = !level.getBlockState(pos).isSolidRender(level, pos) &&
                !level.getBlockState(pos.above()).isSolidRender(level, pos.above());

        boolean validHeight = pos.getY() >= level.getMinBuildHeight() + 8 &&
                pos.getY() < level.getSeaLevel() + 5;

        return hasWater && notSolid && validHeight;
    }
}