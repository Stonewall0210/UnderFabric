package io.github.Stonewall0210.underfabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class UnderFabric implements ModInitializer {
	// Create items that are not weapons, weapons are done further down.
	public static final Item HEART_RED = new Item(new FabricItemSettings().group(ItemGroup.MISC));

	// Create blocks
	public static final Block RUINS_DEFAULT = new Block(FabricBlockSettings.of(Material.STONE));
	public static final Block RUINS_PATH = new Block(FabricBlockSettings.of(Material.STONE));
	public static final Block RUINS_BRICK = new Block(FabricBlockSettings.of(Material.STONE));
	public static final Block RUINS_LEAVES = new Block(FabricBlockSettings.of(Material.LEAVES));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		System.out.println("Registering UnderFabric objects:");
		System.out.println("Registering UnderFabric items...");
		// Register Items, Weapons are done below, others are done above
		Registry.register(Registry.ITEM, new Identifier("underfabric", "toy_knife"), TOY_KNIFE);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "heart_red"), HEART_RED);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "tough_glove"), TOUGH_GLOVE);
		System.out.println("Registering UnderFabric blocks...");
		// Register blocks
		Registry.register(Registry.BLOCK, new Identifier("underfabric", "ruins_default"), RUINS_DEFAULT);
		Registry.register(Registry.BLOCK, new Identifier("underfabric", "ruins_path"), RUINS_PATH);
		Registry.register(Registry.BLOCK, new Identifier("underfabric", "ruins_brick"), RUINS_BRICK);
		Registry.register(Registry.BLOCK, new Identifier("underfabric", "ruins_leaves"), RUINS_LEAVES);
		System.out.println("Registering UnderFabric block items...");
		// Register Items for Blocks registered above
		Registry.register(Registry.ITEM, new Identifier("underfabric", "ruins_default"), new BlockItem(RUINS_DEFAULT, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("underfabric", "ruins_path"), new BlockItem(RUINS_PATH, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("underfabric", "ruins_brick"), new BlockItem(RUINS_BRICK, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("underfabric", "ruins_leaves"), new BlockItem(RUINS_LEAVES, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		System.out.println("Registered UnderFabric objects.");
	}

	public static ToolItem TOY_KNIFE = new SwordItem(WeaponMaterial.INSTANCE, 2, -2.4F, new Item.Settings().group(ItemGroup.COMBAT));
	public static ToolItem TOUGH_GLOVE = new CustomAxeItem(WeaponMaterial.INSTANCE, 4, -1F, new Item.Settings().group(ItemGroup.COMBAT));

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
			new Identifier("underfabric", "creative_tab"))
			.icon(() -> new ItemStack(UnderFabric.HEART_RED))
			.appendItems(stacks -> {
				stacks.add(new ItemStack(UnderFabric.HEART_RED));
				stacks.add(new ItemStack(UnderFabric.TOY_KNIFE));
				stacks.add(new ItemStack(UnderFabric.TOUGH_GLOVE));
				stacks.add(new ItemStack(UnderFabric.RUINS_DEFAULT));
				stacks.add(new ItemStack(UnderFabric.RUINS_PATH));
				stacks.add(new ItemStack(UnderFabric.RUINS_BRICK));
				stacks.add(new ItemStack(UnderFabric.RUINS_LEAVES));
			})
			.build();
}