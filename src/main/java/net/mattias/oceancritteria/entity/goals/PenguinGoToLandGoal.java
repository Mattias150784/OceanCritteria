package net.mattias.oceancritteria.entity.goals;

import net.mattias.oceancritteria.entity.custom.PenguinEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class PenguinGoToLandGoal extends Goal {
    private final PenguinEntity penguin;
    private final double speedModifier;
    private BlockPos targetLandPos;
    private int cooldown = 0;

    public PenguinGoToLandGoal(PenguinEntity penguin, double speedModifier) {
        this.penguin = penguin;
        this.speedModifier = speedModifier;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        if (this.cooldown > 0) {
            --this.cooldown;
            return false;
        }
        if (!this.penguin.isInWater()) {
            return false;
        }

        boolean shouldGoToLand = this.penguin.getTimeInWater() > 1200 ||
                this.penguin.getAirSupply() < 1200 ||
                this.penguin.getRandom().nextInt(300) == 0;

        if (shouldGoToLand) {
            this.targetLandPos = this.findNearestLand();
            return this.targetLandPos != null;
        }
        return false;
    }

    @Override
    public boolean canContinueToUse() {
        return this.targetLandPos != null &&
                !this.penguin.getNavigation().isDone() &&
                this.penguin.isInWater() && // Stop if we reached land
                this.penguin.distanceToSqr(this.targetLandPos.getX(), this.targetLandPos.getY(), this.targetLandPos.getZ()) > 4.0;
    }

    @Override
    public void start() {
        if (this.targetLandPos != null) {
            this.penguin.getNavigation().moveTo(
                    this.targetLandPos.getX() + 0.5,
                    this.targetLandPos.getY(),
                    this.targetLandPos.getZ() + 0.5,
                    this.speedModifier
            );
        }
    }

    @Override
    public void stop() {
        this.penguin.getNavigation().stop();
        this.cooldown = 150;
        this.targetLandPos = null;
    }

    @Nullable
    private BlockPos findNearestLand() {
        BlockPos penguinPos = this.penguin.blockPosition();
        BlockPos bestPos = null;
        double closestDistance = Double.MAX_VALUE;

        for (int radius = 3; radius <= 15; radius += 3) {
            for (int x = -radius; x <= radius; x++) {
                for (int z = -radius; z <= radius; z++) {
                    if (Math.abs(x) != radius && Math.abs(z) != radius) continue;

                    for (int y = -2; y <= 4; y++) {
                        BlockPos checkPos = penguinPos.offset(x, y, z);

                        if (isValidLandPosition(checkPos)) {
                            double distance = penguinPos.distSqr(checkPos);
                            if (distance < closestDistance) {
                                closestDistance = distance;
                                bestPos = checkPos;
                            }
                        }
                    }
                }
            }
            if (bestPos != null) break;
        }

        return bestPos;
    }

    private boolean isValidLandPosition(BlockPos pos) {
        BlockPos below = pos.below();
        boolean hasValidGround = this.penguin.level().getBlockState(below).isSolidRender(this.penguin.level(), below);
        boolean hasSpace = this.penguin.level().getBlockState(pos).isAir() &&
                this.penguin.level().getBlockState(pos.above()).isAir();
        boolean isNotInWater = this.penguin.level().getFluidState(pos).isEmpty();

        if (!hasValidGround || !hasSpace || !isNotInWater) {
            return false;
        }

        boolean hasNearbyWater = false;
        for (int dx = -3; dx <= 3 && !hasNearbyWater; dx++) {
            for (int dz = -3; dz <= 3 && !hasNearbyWater; dz++) {
                for (int dy = -2; dy <= 1 && !hasNearbyWater; dy++) {
                    BlockPos nearbyPos = pos.offset(dx, dy, dz);
                    if (this.penguin.level().getFluidState(nearbyPos).isSource()) {
                        hasNearbyWater = true;
                    }
                }
            }
        }

        return hasNearbyWater;
    }
}