package net.mattias.oceancritteria.entity.custom.projectile;

import net.mattias.oceancritteria.effect.ModEffects;
import net.mattias.oceancritteria.entity.ModEntities;
import net.mattias.oceancritteria.item.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.core.particles.DustParticleOptions;
import org.joml.Vector3f;

public class IceArrow extends AbstractArrow {
    private static final Vector3f ICE_BLUE_COLOR = new Vector3f(0.5f, 0.94f, 1.0f);

    public IceArrow(EntityType<? extends AbstractArrow> entityType, Level level) {
        super(entityType, level);
    }

    public IceArrow(Level level, LivingEntity shooter) {
        super(ModEntities.ICE_ARROW.get(), shooter, level);
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ModItems.ICE_ARROW.get());
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide && !this.inGround) {
            DustParticleOptions particle = new DustParticleOptions(ICE_BLUE_COLOR, 1.0f);

            for (int i = 0; i < 2; i++) {
                this.level().addParticle(
                        particle,
                        this.getX(),
                        this.getY(),
                        this.getZ(),
                        (this.random.nextFloat() - 0.5f) * 0.05f,
                        (this.random.nextFloat() - 0.5f) * 0.05f,
                        (this.random.nextFloat() - 0.5f) * 0.05f
                );
            }
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity target = result.getEntity();

        if (target instanceof LivingEntity livingTarget) {
            livingTarget.setTicksFrozen(140);
            livingTarget.addEffect(new MobEffectInstance(ModEffects.FROZEN_BY_ARROW.get(), 140, 0, false, false));

            if (this.level().isClientSide) {
                DustParticleOptions particle = new DustParticleOptions(ICE_BLUE_COLOR, 1.0f);

                for (int i = 0; i < 12; i++) {
                    this.level().addParticle(
                            particle,
                            target.getX(),
                            target.getY() + target.getBbHeight() * 0.5,
                            target.getZ(),
                            (this.random.nextDouble() - 0.5) * 0.2,
                            (this.random.nextDouble() - 0.5) * 0.2,
                            (this.random.nextDouble() - 0.5) * 0.2
                    );
                }
            }
        }
    }
}