package net.mattias.oceancritteria.entity.goals;

import net.mattias.oceancritteria.entity.custom.PenguinEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.pathfinder.Path;

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

        if (!this.penguin.isInWater() && this.penguin.getRandom().nextInt(100) == 0) {
            this.targetWaterPos = this.findNearestWater();
            if (this.targetWaterPos != null) {
                Path path = this.penguin.getNavigation().createPath(this.targetWaterPos, 1);
                return path != null;
            }
        }
        return false;
    }

    @Override
    public boolean canContinueToUse() {
        return !this.penguin.getNavigation().isDone() && !this.penguin.isInWater();
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
        this.cooldown = 120;
        this.targetWaterPos = null;
    }

    @Nullable
    private BlockPos findNearestWater() {
        BlockPos penguinPos = this.penguin.blockPosition();
        BlockPos bestPos = null;
        double bestDistance = Double.MAX_VALUE;

        for (int x = -10; x <= 10; x++) {
            for (int z = -10; z <= 10; z++) {
                for (int y = -3; y <= 3; y++) {
                    BlockPos checkPos = penguinPos.offset(x, y, z);

                    if (this.penguin.level().getFluidState(checkPos).is(FluidTags.WATER)) {
                        double distance = penguinPos.distSqr(checkPos);
                        if (distance < bestDistance) {
                            bestDistance = distance;
                            bestPos = checkPos;
                        }
                    }
                }
            }
        }

        return bestPos;
    }
}