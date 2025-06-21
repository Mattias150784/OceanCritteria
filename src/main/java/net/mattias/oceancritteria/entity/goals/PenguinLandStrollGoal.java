package net.mattias.oceancritteria.entity.goals;

import net.mattias.oceancritteria.entity.custom.PenguinEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class PenguinLandStrollGoal extends RandomStrollGoal {
    private final PenguinEntity penguin;

    public PenguinLandStrollGoal(PenguinEntity penguin) {
        super(penguin, 0.8D, 60);
        this.penguin = penguin;
    }

    @Override
    public boolean canUse() {
        return !this.penguin.isInWater() && super.canUse();
    }

    @Override
    public boolean canContinueToUse() {
        return !this.penguin.isInWater() && super.canContinueToUse();
    }

    @Override
    @Nullable
    protected Vec3 getPosition() {
        Vec3 landPos = LandRandomPos.getPos(this.mob, 10, 7);

        if (landPos != null) {
            BlockPos targetBlock = new BlockPos((int)landPos.x, (int)landPos.y, (int)landPos.z);
            if (this.penguin.level().getFluidState(targetBlock).isEmpty()) {
                return landPos;
            }
        }

        return null;
    }
}