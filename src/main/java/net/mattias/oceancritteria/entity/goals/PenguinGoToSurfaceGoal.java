package net.mattias.oceancritteria.entity.goals;

import net.mattias.oceancritteria.entity.custom.PenguinEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class PenguinGoToSurfaceGoal extends Goal {
    private final PenguinEntity penguin;
    private final double speed;
    private BlockPos targetSurfacePos;

    private static final int AIR_THRESHOLD = 600;

    public PenguinGoToSurfaceGoal(PenguinEntity penguin, double speed) {
        this.penguin = penguin;
        this.speed = speed;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    private boolean canBreathe() {
        return !this.penguin.isEyeInFluid(FluidTags.WATER);
    }

    @Override
    public boolean canUse() {
        return this.penguin.isUnderWater() &&
                this.penguin.getAirSupply() < AIR_THRESHOLD &&
                !canBreathe();
    }

    @Override
    public boolean canContinueToUse() {
        return this.penguin.isUnderWater() &&
                !canBreathe() &&
                this.penguin.getAirSupply() < (AIR_THRESHOLD + 200);
    }

    @Override
    public void start() {
        this.targetSurfacePos = findNearestSurface();
        if (this.targetSurfacePos != null) {
            this.penguin.getNavigation().moveTo(
                    this.targetSurfacePos.getX() + 0.5,
                    this.targetSurfacePos.getY(),
                    this.targetSurfacePos.getZ() + 0.5,
                    this.speed
            );
        }
    }

    @Override
    public void tick() {
        if (this.penguin.tickCount % 40 == 0) {
            BlockPos newTarget = findNearestSurface();
            if (newTarget != null && !newTarget.equals(this.targetSurfacePos)) {
                this.targetSurfacePos = newTarget;
                this.penguin.getNavigation().moveTo(
                        this.targetSurfacePos.getX() + 0.5,
                        this.targetSurfacePos.getY(),
                        this.targetSurfacePos.getZ() + 0.5,
                        this.speed
                );
            }
        }

        if (this.targetSurfacePos == null) {
            this.penguin.getNavigation().moveTo(
                    this.penguin.getX(),
                    this.penguin.getY() + 10,
                    this.penguin.getZ(),
                    this.speed
            );
            this.penguin.setXRot(45.0f);
        }
    }

    @Override
    public void stop() {
        this.penguin.getNavigation().stop();
        this.targetSurfacePos = null;
    }

    @Nullable
    private BlockPos findNearestSurface() {
        Level level = this.penguin.level();
        BlockPos currentPos = this.penguin.blockPosition();
        BlockPos bestSurface = null;
        double closestDistance = Double.MAX_VALUE;

        for (int yOffset = 1; yOffset <= 20; yOffset++) {
            for (int xOffset = -4; xOffset <= 4; xOffset++) {
                for (int zOffset = -4; zOffset <= 4; zOffset++) {
                    BlockPos checkPos = currentPos.offset(xOffset, yOffset, zOffset);

                    if (level.getFluidState(checkPos).is(FluidTags.WATER) &&
                            !level.getFluidState(checkPos.above()).is(FluidTags.WATER)) {

                        double distance = currentPos.distSqr(checkPos);
                        if (distance < closestDistance) {
                            closestDistance = distance;
                            bestSurface = checkPos;
                        }
                    }
                }
            }
            if (bestSurface != null) {
                break;
            }
        }

        return bestSurface;
    }
}