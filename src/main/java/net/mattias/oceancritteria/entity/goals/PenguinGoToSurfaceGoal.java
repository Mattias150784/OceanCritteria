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

    private static final int AIR_THRESHOLD = 300; // 15 seconds

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
        return this.penguin.isUnderWater() && !canBreathe();
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }

    @Override
    public void start() {
        this.targetSurfacePos = findNearestSurface();
    }

    @Override
    public void tick() {
        if (this.targetSurfacePos == null || this.penguin.tickCount % 20 == 0) {
            this.targetSurfacePos = findNearestSurface();
        }

        if (this.targetSurfacePos != null) {
            this.penguin.getMoveControl().setWantedPosition(
                    this.targetSurfacePos.getX() + 0.5,
                    this.targetSurfacePos.getY() + 0.5,
                    this.targetSurfacePos.getZ() + 0.5,
                    this.speed * 1.5
            );
            this.penguin.getLookControl().setLookAt(
                    this.targetSurfacePos.getX() + 0.5,
                    this.targetSurfacePos.getY() + 1.0,
                    this.targetSurfacePos.getZ() + 0.5
            );
        } else {
            this.penguin.getMoveControl().setWantedPosition(
                    this.penguin.getX(),
                    this.penguin.getY() + 5,
                    this.penguin.getZ(),
                    this.speed * 1.5
            );
            this.penguin.getLookControl().setLookAt(
                    this.penguin.getX(),
                    this.penguin.getY() + 10,
                    this.penguin.getZ()
            );
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

        for (int yOffset = 0; yOffset < 15; yOffset++) {
            for (int xOffset = -3; xOffset <= 3; xOffset++) {
                for (int zOffset = -3; zOffset <= 3; zOffset++) {
                    BlockPos checkPos = currentPos.offset(xOffset, yOffset, zOffset);

                    if (level.getFluidState(checkPos).is(FluidTags.WATER) &&
                            !level.getFluidState(checkPos.above()).is(FluidTags.WATER)) {
                        return checkPos;
                    }
                }
            }
        }
        return null;
    }
}