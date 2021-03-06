package io.github.Stonewall0210.underfabric.items.consumables;

import io.github.Stonewall0210.underfabric.UnderFabric;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Random;

public class monsterCandy extends Item {
    public monsterCandy(Item.Settings group) {
        super(new FabricItemSettings().group(ItemGroup.FOOD).maxCount(1));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.playSound(UnderFabric.CONSUME_ITEM, 1.0F, 1.0F);
        playerEntity.setStackInHand(hand, new ItemStack(Items.AIR));
        playerEntity.heal(10);
        if (world.isClient) {
            Random rand = new Random();
            int flavourText = rand.nextInt(2);
            if (flavourText == 0) {
                playerEntity.sendMessage(new TranslatableText("text.underfabric.monster_candy.use.1"), false);
            }
            else {
                playerEntity.sendMessage(new TranslatableText("text.underfabric.monster_candy.use.2"), false);
            }
        }
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
