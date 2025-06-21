package net.mattias.oceancritteria.entity.goals;

import net.mattias.oceancritteria.entity.custom.PenguinEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class PenguinSwimGoal extends Goal {
    private final PenguinEntity penguin;
    private final double speedModifier;
    private int interval;
    private int timeToNextUpdate;
    private double wantedX;
    private double wantedY;
    private double wantedZ;
    private boolean forceTrigger;

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

        if (this.forceTrigger) {
            Vec3 targetPos = this.getRandomSwimPosition();
            if (targetPos == null) {
                return false;
            }
            this.wantedX = targetPos.x;
            this.wantedY = targetPos.y;
            this.wantedZ = targetPos.z;
            this.forceTrigger = false;
            return true;
        }

        if (this.penguin.getRandom().nextInt(reducedTickDelay(this.interval)) != 0) {
            return false;
        }

        if (this.penguin.getNavigation().isDone()) {
            Vec3 targetPos = this.getRandomSwimPosition();
            if (targetPos == null) {
                return false;
            }
            this.wantedX = targetPos.x;
            this.wantedY = targetPos.y;
            this.wantedZ = targetPos.z;
            return true;
        }
        return false;
    }

    @Override
    public boolean canContinueToUse() {
        return this.penguin.isInWater() && !this.penguin.getNavigation().isDone() && this.timeToNextUpdate > 0;
    }

    @Override
    public void start() {
        this.penguin.getNavigation().moveTo(this.wantedX, this.wantedY, this.wantedZ, this.speedModifier * 1.2D);
        this.timeToNextUpdate = this.adjustedTickDelay(120 + this.penguin.getRandom().nextInt(100));
    }

    @Override
    public void tick() {
        --this.timeToNextUpdate;

        if (this.penguin.getNavigation().isDone() || this.timeToNextUpdate <= 0) {
            this.forceTrigger = true;
        }
    }

    @Override
    public void stop() {
        this.penguin.getNavigation().stop();
    }

    public void trigger() {
        this.forceTrigger = true;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    @Nullable
    private Vec3 getRandomSwimPosition() {
        Vec3 vanillaPos = BehaviorUtils.getRandomSwimmablePos(this.penguin, 15, 10);
        if (vanillaPos != null && isValidSwimTarget(BlockPos.containing(vanillaPos))) {
            return vanillaPos;
        }

        return this.findCustomSwimPosition();
    }

    @Nullable
    private Vec3 findCustomSwimPosition() {
        Vec3 currentPos = this.penguin.position();
        int attempts = 0;

        while (attempts < 20) {
            attempts++;

            double offsetX = (this.penguin.getRandom().nextDouble() * 20 - 10);
            double offsetZ = (this.penguin.getRandom().nextDouble() * 20 - 10);
            double offsetY = (this.penguin.getRandom().nextDouble() * 10 - 5);

            Vec3 targetPos = currentPos.add(offsetX, offsetY, offsetZ);
            BlockPos targetBlock = BlockPos.containing(targetPos);

            if (isValidSwimTarget(targetBlock)) {
                return targetPos;
            }
        }


        return DefaultRandomPos.getPos(this.penguin, 10, 7);
    }

    private boolean isValidSwimTarget(BlockPos pos) {
        Level level = this.penguin.level();

        return level.getFluidState(pos).is(FluidTags.WATER) &&
                level.getFluidState(pos.above()).is(FluidTags.WATER) &&
                !level.getBlockState(pos).isSolidRender(level, pos) &&
                !level.getBlockState(pos.above()).isSolidRender(level, pos.above()) &&
                pos.getY() >= level.getMinBuildHeight() &&
                pos.getY() < level.getMaxBuildHeight();
    }
}