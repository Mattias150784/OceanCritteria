package net.mattias.oceancritteria.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.navigation.AmphibiousPathNavigation;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import org.jetbrains.annotations.Nullable;

public abstract class BaseAmphibian extends Animal {
    private boolean wasInWater = false;

    protected BaseAmphibian(EntityType<? extends Animal> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
        this.setPathfindingMalus(BlockPathTypes.WALKABLE, 0.0f);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0f);
    }

    @Override
    protected PathNavigation createNavigation(Level pLevel) {
        return new AmphibiousPathNavigation(this, pLevel);
    }

    @Override
    public void aiStep() {
        super.aiStep();

        boolean currentlyInWater = this.isInWaterOrBubble();

        if (currentlyInWater != wasInWater) {
            if (currentlyInWater) {
                switchToWaterNavigation();
            } else {
                switchToGroundNavigation();
            }
            wasInWater = currentlyInWater;
        }
    }

    private void switchToGroundNavigation() {
        this.navigation = new GroundPathNavigation(this, this.level());
        this.moveControl = new MoveControl(this);
        this.lookControl = new LookControl(this);
    }

    private void switchToWaterNavigation() {
        this.navigation = new WaterBoundPathNavigation(this, this.level());
        this.moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 0.02F, 0.1F, true);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    public MobType getMobType() {
        return MobType.WATER;
    }

    public boolean checkSpawnObstruction(LevelReader p_30348_) {
        return p_30348_.isUnobstructed(this);
    }

    public int getAmbientSoundInterval() {
        return 120;
    }

    public int getExperienceReward() {
        return 1 + this.level().random.nextInt(3);
    }

    protected void handleAirSupply(int p_30344_) {
        if (this.isAlive() && !this.isInWaterOrBubble()) {
            this.setAirSupply(p_30344_ - 1);
            if (this.getAirSupply() == -20) {
                this.setAirSupply(0);
                this.hurt(this.damageSources().drown(), 2.0F);
            }
        } else {
            this.setAirSupply(300);
        }
    }

    public void baseTick() {
        int airSupply = this.getAirSupply();
        super.baseTick();
        this.handleAirSupply(airSupply);
    }

    public boolean isPushedByFluid() {
        return false;
    }

    public boolean canBeLeashed(Player p_30346_) {
        return false;
    }

    public static boolean checkSurfaceWaterAnimalSpawnRules(EntityType<? extends WaterAnimal> p_218283_, LevelAccessor p_218284_, MobSpawnType p_218285_, BlockPos p_218286_, RandomSource p_218287_) {
        int seaLevel = p_218284_.getSeaLevel();
        int minY = seaLevel - 13;
        return p_218286_.getY() >= minY && p_218286_.getY() <= seaLevel &&
                p_218284_.getFluidState(p_218286_.below()).is(FluidTags.WATER) &&
                p_218284_.getBlockState(p_218286_.above()).is(Blocks.WATER);
    }
}