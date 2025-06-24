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
    }

    @Override
    public void tick() {
        this.ticksRunning++;

        if (this.ticksRunning % 60 == 0) {
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
    }

    @Nullable
    private Vec3 getRandomSwimPosition() {
        Vec3 currentPos = this.penguin.position();
        Level level = this.penguin.level();

        for (int attempts = 0; attempts < 10; attempts++) {
            double offsetX = (this.penguin.getRandom().nextDouble() * 12 - 6);
            double offsetZ = (this.penguin.getRandom().nextDouble() * 12 - 6);
            double offsetY = (this.penguin.getRandom().nextDouble() * 4 - 2);

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

        return level.getFluidState(pos).is(FluidTags.WATER) &&
                level.getFluidState(pos.above()).is(FluidTags.WATER) &&
                !level.getBlockState(pos).isSolidRender(level, pos) &&
                pos.getY() >= level.getMinBuildHeight() + 5 &&
                pos.getY() < level.getMaxBuildHeight() - 5;
    }
}