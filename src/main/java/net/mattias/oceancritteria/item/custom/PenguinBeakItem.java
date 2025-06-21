package net.mattias.oceancritteria.item.custom;

import net.mattias.oceancritteria.sound.ModSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PenguinBeakItem extends Item {
    private static final int COOLDOWN_TICKS = 40;

    public PenguinBeakItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            level.playSound(
                    null,
                    player.getX(), player.getY(), player.getZ(),
                    ModSounds.PENGUIN_BEAK_HONK.get(),
                    SoundSource.PLAYERS,
                    1.0F, //Volume
                    1.0F // Pitch
            );

            player.getCooldowns().addCooldown(this, COOLDOWN_TICKS);

        }

        return InteractionResultHolder.success(itemStack);
    }
}