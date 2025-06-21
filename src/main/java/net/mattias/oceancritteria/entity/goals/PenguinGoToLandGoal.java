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

        if (this.penguin.isInWater() && this.penguin.getRandom().nextInt(40) == 0) {
            this.targetLandPos = this.findNearestLand();
            return this.targetLandPos != null;
        }
        return false;
    }

    @Override
    public boolean canContinueToUse() {
        return !this.penguin.getNavigation().isDone() && this.penguin.isInWater();
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
        this.cooldown = 120;
        this.targetLandPos = null;
    }

    @Nullable
    private BlockPos findNearestLand() {
        BlockPos penguinPos = this.penguin.blockPosition();
        BlockPos bestPos = null;
        double closestDistance = Double.MAX_VALUE;

        for (int radius = 3; radius <= 12; radius += 3) {
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
        return this.penguin.level().getBlockState(below).isSolidRender(this.penguin.level(), below) &&
                this.penguin.level().getBlockState(pos).isAir() &&
                this.penguin.level().getBlockState(pos.above()).isAir() &&
                !this.penguin.level().getFluidState(pos).isEmpty() == false;
    }
}