package net.mattias.oceancritteria.entity.goals;

import net.mattias.oceancritteria.entity.custom.PenguinEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.ai.goal.Goal;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class PenguinGoToWaterGoal extends Goal {
    private final PenguinEntity penguin;
    private final double speedModifier;
    private BlockPos targetWaterPos;
    private int cooldown = 0;

    public PenguinGoToWaterGoal(PenguinEntity penguin, double speedModifier) {
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

        if (this.penguin.isInWater()) {
            return false;
        }

        if (this.penguin.needsAir()) {
            return false;
        }

        boolean shouldGoToWater = this.penguin.getTimeOnLand() > 600 ||
                this.penguin.getRandom().nextInt(200) == 0;

        if (shouldGoToWater) {
            this.targetWaterPos = this.findNearestWater();
            return this.targetWaterPos != null;
        }
        return false;
    }

    @Override
    public boolean canContinueToUse() {
        return this.targetWaterPos != null &&
                !this.penguin.getNavigation().isDone() &&
                !this.penguin.isInWater() &&
                this.penguin.distanceToSqr(this.targetWaterPos.getX(), this.targetWaterPos.getY(), this.targetWaterPos.getZ()) > 2.0;
    }

    @Override
    public void start() {
        if (this.targetWaterPos != null) {
            this.penguin.getNavigation().moveTo(
                    this.targetWaterPos.getX() + 0.5,
                    this.targetWaterPos.getY(),
                    this.targetWaterPos.getZ() + 0.5,
                    this.speedModifier
            );
        }
    }

    @Override
    public void stop() {
        this.penguin.getNavigation().stop();
        this.cooldown = 100;
        this.targetWaterPos = null;
    }

    @Nullable
    private BlockPos findNearestWater() {
        BlockPos penguinPos = this.penguin.blockPosition();
        BlockPos bestPos = null;
        double bestDistance = Double.MAX_VALUE;

        for (int radius = 2; radius <= 12; radius += 2) {
            for (int x = -radius; x <= radius; x++) {
                for (int z = -radius; z <= radius; z++) {
                    if (Math.abs(x) != radius && Math.abs(z) != radius) continue;

                    for (int y = -3; y <= 2; y++) {
                        BlockPos checkPos = penguinPos.offset(x, y, z);

                        if (this.penguin.level().getFluidState(checkPos).is(FluidTags.WATER) &&
                                this.penguin.level().getFluidState(checkPos.above()).is(FluidTags.WATER)) {

                            double distance = penguinPos.distSqr(checkPos);
                            if (distance < bestDistance) {
                                bestDistance = distance;
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
}