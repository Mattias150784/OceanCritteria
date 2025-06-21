package net.mattias.oceancritteria.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class FrozenArrowEffect extends MobEffect {
    public FrozenArrowEffect() {
        super(MobEffectCategory.HARMFUL, 0x80EFFF); // Bright Blue
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {

        entity.setIsInPowderSnow(true);
        if (entity.canFreeze()) {
            int frozenTicks = entity.getTicksFrozen();
            entity.setTicksFrozen(Math.min(entity.getTicksRequiredToFreeze(), frozenTicks + 1));
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}