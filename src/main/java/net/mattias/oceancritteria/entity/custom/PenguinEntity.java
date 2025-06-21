package net.mattias.oceancritteria.entity.custom;

import net.mattias.oceancritteria.entity.ModEntities;
import net.mattias.oceancritteria.entity.goals.*;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.AmphibiousPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.PolarBear;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class PenguinEntity extends Animal {
    public PenguinEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setMaxUpStep(1.0F);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState swimAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            setupAnimationStates();
        }

        if (!this.level().isClientSide()) {
            if (this.isUnderWater()) {
                BlockPos headPos = this.blockPosition().above();
                if (this.level().getFluidState(headPos).is(FluidTags.WATER)) {
                    this.setAirSupply(this.getAirSupply() - 1);
                    if (this.getAirSupply() == -20) {
                        this.setAirSupply(0);
                        this.hurt(this.damageSources().drown(), 2.0F);
                    }
                } else {
                    this.setAirSupply(this.getMaxAirSupply());
                }
            } else {
                this.setAirSupply(this.getMaxAirSupply());
            }
        }
    }

    private void setupAnimationStates() {
        if (this.isUnderWater() || (this.isInWater() && !this.onGround())) {
            this.idleAnimationState.stop();
            this.swimAnimationState.startIfStopped(this.tickCount);
        } else {
            this.swimAnimationState.stop();
            if (this.idleAnimationTimeout <= 0) {
                this.idleAnimationTimeout = this.random.nextInt(40) + 80;
                this.idleAnimationState.start(this.tickCount);
            } else {
                --this.idleAnimationTimeout;
            }
        }
    }

    @Override
    public boolean canStandOnFluid(FluidState fluidState) {
        return false;
    }

    @Override
    protected float getWaterSlowDown() {
        return 0.9F;
    }

    @Override
    protected PathNavigation createNavigation(Level level) {
        return new AmphibiousPathNavigation(this, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new PenguinGoToSurfaceGoal(this, 2.0D));
        this.goalSelector.addGoal(1, new PenguinSwimGoal(this, 1.2D));
        this.goalSelector.addGoal(2, new PanicGoal(this, 1.5D));
        this.goalSelector.addGoal(3, new BreedGoal(this, 1.15D));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.0D,
                Ingredient.of(Items.COD, Items.SALMON, Items.COOKED_SALMON, Items.COOKED_COD), false));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(6, new PenguinGoToLandGoal(this, 1.2D));
        this.goalSelector.addGoal(7, new PenguinGoToWaterGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new PenguinLandStrollGoal(this));
        this.goalSelector.addGoal(9, new AvoidEntityGoal(this, PolarBear.class, 8.0F, 1.0F, 1.0F));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(11, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 10D)
                .add(Attributes.MOVEMENT_SPEED, 0.22D)
                .add(Attributes.FOLLOW_RANGE, 24D);
    }

    @Override
    public void travel(Vec3 pTravelVector) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(this.getSpeed() * 0.25F, pTravelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(
                    this.getDeltaMovement().x * 0.85D,
                    this.getDeltaMovement().y * 0.98D,
                    this.getDeltaMovement().z * 0.85D
            );
        } else {
            super.travel(pTravelVector);
        }
    }

    @Override
    public int getMaxAirSupply() {
        return 200; // 10 seconds
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return ModEntities.PENGUIN.get().create(pLevel);
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(Items.COD) || pStack.is(Items.SALMON) ||
                pStack.is(Items.COOKED_COD) || pStack.is(Items.COOKED_SALMON);
    }

    // The sounds are temporary until I get custom Penguin sounds

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.DOLPHIN_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.DOLPHIN_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.DOLPHIN_DEATH;
    }

    @Override
    public float getSpeed() {
        float baseSpeed = (float) this.getAttributeValue(Attributes.MOVEMENT_SPEED);
        if (this.isInWater()) {
            return baseSpeed * 1.8F;
        }
        return baseSpeed;
    }
}