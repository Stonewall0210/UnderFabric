package io.github.Stonewall0210.underfabric;

import io.github.Stonewall0210.underfabric.blocks.savePoint;
import io.github.Stonewall0210.underfabric.entities.characters.napstablook;
import io.github.Stonewall0210.underfabric.items.WeaponMaterial;
import io.github.Stonewall0210.underfabric.items.consumables.*;
import io.github.Stonewall0210.underfabric.items.weapons.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Arrays;

public class UnderFabric implements ModInitializer {
	// Create items that are not weapons, weapons are done further down.
	public static final Item HEART_RED = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final bandageConsumable BANDAGE_CONSUMABLE = new bandageConsumable(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final monsterCandy MONSTER_CANDY = new monsterCandy(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final spiderDonut SPIDER_DONUT = new spiderDonut(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final spiderCider SPIDER_CIDER = new spiderCider(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final bscotchPie BSCOTCH_PIE = new bscotchPie(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final snailPie SNAIL_PIE = new snailPie(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final snowmanPiece SNOWMAN_PIECE = new snowmanPiece(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final niceCream NICE_CREAM = new niceCream(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final bisicle BISICLE = new bisicle(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final unisicle UNISICLE = new unisicle(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final cinnamonBunny CINNAMON_BUNNY = new cinnamonBunny(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final astronautFood ASTRONAUT_FOOD = new astronautFood(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final crabApple CRAB_APPLE = new crabApple(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final seaTea SEA_TEA = new seaTea(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final abandonedQuiche ABANDONED_QUICHE = new abandonedQuiche(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final temmieFlakes TEMMIE_FLAKES = new temmieFlakes(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final dogSalad DOG_SALAD = new dogSalad(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final instantNoodles INSTANT_NOODLES = new instantNoodles(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final hotDog HOT_DOG = new hotDog(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final hotCat HOT_CAT = new hotCat(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final junkFood JUNK_FOOD = new junkFood(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final hushPuppy HUSH_PUPPY = new hushPuppy(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final starfait STARFAIT = new starfait(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final glamburger GLAMBURGER = new glamburger(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final legendaryHero LEGENDARY_HERO = new legendaryHero(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final faceSteak FACE_STEAK = new faceSteak(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final popatoChisps POPATO_CHISPS = new popatoChisps(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final badMemory BAD_MEMORY = new badMemory(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final lastDream LAST_DREAM = new lastDream(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final puppyIceCream PUPPY_ICE_CREAM = new puppyIceCream(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final pumpkinRings PUMPKIN_RINGS = new pumpkinRings(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final rockCandy ROCK_CANDY = new rockCandy(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final croquetRoll CROQUET_ROLL = new croquetRoll(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final ghostFruit GHOST_FRUIT = new ghostFruit(new FabricItemSettings().group(ItemGroup.FOOD));
	public static final stoicOnion STOIC_ONION = new stoicOnion(new FabricItemSettings().group(ItemGroup.FOOD));

	// Create blocks
	public static final Block RUINS_DEFAULT = new Block(FabricBlockSettings.of(Material.STONE).strength(1.3f));
	public static final Block RUINS_PATH = new Block(FabricBlockSettings.of(Material.STONE).strength(1.2f));
	public static final Block RUINS_BRICK = new Block(FabricBlockSettings.of(Material.STONE).strength(1.7f));
	public static final Block RUINS_LEAVES = new Block(FabricBlockSettings.of(Material.LEAVES).strength(0.3f));
	public static final Block SAVE_POINT = new savePoint(FabricBlockSettings.of(Material.AIR).strength(18000000f));

	//Create sounds
	public static final Identifier CONSUME_ITEM_ID = new Identifier("underfabric:sound.consume");
	public static SoundEvent CONSUME_ITEM = new SoundEvent(CONSUME_ITEM_ID);
	public static final Identifier FLOWEY_MUS_ID = new Identifier("underfabric:music.flowey");
	public static SoundEvent FLOWEY_MUS = new SoundEvent(FLOWEY_MUS_ID);
	public static final Identifier DOG_SALAD_SOUND_ID = new Identifier("underfabric:sound.dog_salad");
	public static SoundEvent DOG_SALAD_SOUND = new SoundEvent(DOG_SALAD_SOUND_ID);
	public static final Identifier CAT_SALAD_ID = new Identifier("underfabric:sound.cat_salad");
	public static SoundEvent CAT_SALAD = new SoundEvent(CAT_SALAD_ID);
	public static Identifier GHOSTFIGHT_ID = new Identifier("underfabric:music.ghostbattle");
	public static SoundEvent GHOSTFIGHT = new SoundEvent(GHOSTFIGHT_ID);

	//Create entities
	public static final EntityType<napstablook> NAPSTABLOOK_ENTITY_ENTITY_TYPE = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier("underfabric", "napstablook"),
			FabricEntityTypeBuilder.create(SpawnGroup.MISC, napstablook::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
	);

	@Override
	public void onInitialize() {
		System.out.println("Registering global UnderFabric objects:");

		System.out.println("Registering UnderFabric items...");
		// Register Items
		Registry.register(Registry.ITEM, new Identifier("underfabric", "heart_red"), HEART_RED);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "bandage_consumable"), BANDAGE_CONSUMABLE);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "monster_candy"), MONSTER_CANDY);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "spider_donut"), SPIDER_DONUT);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "spider_cider"), SPIDER_CIDER);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "bscotch_pie"), BSCOTCH_PIE);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "snail_pie"), SNAIL_PIE);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "snowman_piece"), SNOWMAN_PIECE);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "nice_cream"), NICE_CREAM);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "bisicle"), BISICLE);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "unisicle"), UNISICLE);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "cinnamon_bunny"), CINNAMON_BUNNY);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "astronaut_food"), ASTRONAUT_FOOD);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "crab_apple"), CRAB_APPLE);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "sea_tea"), SEA_TEA);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "abandoned_quiche"), ABANDONED_QUICHE);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "temmie_flakes"), TEMMIE_FLAKES);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "dog_salad"), DOG_SALAD);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "instant_noodles"), INSTANT_NOODLES);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "hot_dog"), HOT_DOG);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "hot_cat"), HOT_CAT);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "junk_food"), JUNK_FOOD);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "hush_puppy"), HUSH_PUPPY);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "starfait"), STARFAIT);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "glamburger"), GLAMBURGER);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "legendary_hero"), LEGENDARY_HERO);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "face_steak"), FACE_STEAK);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "popato_chisps"), POPATO_CHISPS);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "bad_memory"), BAD_MEMORY);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "last_dream"), LAST_DREAM);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "puppy_ice_cream"), PUPPY_ICE_CREAM);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "pumpkin_rings"), PUMPKIN_RINGS);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "rock_candy"), ROCK_CANDY);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "croquet_roll"), CROQUET_ROLL);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "ghost_fruit"), GHOST_FRUIT);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "stoic_onion"), STOIC_ONION);

		System.out.println("Registering UnderFabric weapons...");
		//Register Weapons
		Registry.register(Registry.ITEM, new Identifier("underfabric", "toy_knife"), TOY_KNIFE);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "tough_glove"), TOUGH_GLOVE);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "ballet_shoes"), BALLET_SHOES);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "torn_notebook"), TORN_NOTEBOOK);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "burnt_pan"), BURNT_PAN);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "empty_gun"), EMPTY_GUN);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "worn_dagger"), WORN_DAGGER);
		Registry.register(Registry.ITEM, new Identifier("underfabric", "real_knife"), REAL_KNIFE);

		System.out.println("Registering UnderFabric blocks...");
		// Register blocks
		Registry.register(Registry.BLOCK, new Identifier("underfabric", "ruins_default"), RUINS_DEFAULT);
		Registry.register(Registry.BLOCK, new Identifier("underfabric", "ruins_path"), RUINS_PATH);
		Registry.register(Registry.BLOCK, new Identifier("underfabric", "ruins_brick"), RUINS_BRICK);
		Registry.register(Registry.BLOCK, new Identifier("underfabric", "ruins_leaves"), RUINS_LEAVES);
		Registry.register(Registry.BLOCK, new Identifier("underfabric", "save_point"), SAVE_POINT);

		System.out.println("Registering UnderFabric block items...");
		// Register Items for Blocks registered above
		Registry.register(Registry.ITEM, new Identifier("underfabric", "ruins_default"), new BlockItem(RUINS_DEFAULT, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("underfabric", "ruins_path"), new BlockItem(RUINS_PATH, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("underfabric", "ruins_brick"), new BlockItem(RUINS_BRICK, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("underfabric", "ruins_leaves"), new BlockItem(RUINS_LEAVES, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
		Registry.register(Registry.ITEM, new Identifier("underfabric", "save_point"), new BlockItem(SAVE_POINT, new FabricItemSettings().group(ItemGroup.DECORATIONS)));

		System.out.println("Registering UnderFabric sounds...");
		// Register sounds
		Registry.register(Registry.SOUND_EVENT, UnderFabric.CONSUME_ITEM_ID, CONSUME_ITEM);
		Registry.register(Registry.SOUND_EVENT, UnderFabric.FLOWEY_MUS_ID, FLOWEY_MUS);
		Registry.register(Registry.SOUND_EVENT, UnderFabric.DOG_SALAD_SOUND_ID, DOG_SALAD_SOUND);
		Registry.register(Registry.SOUND_EVENT, UnderFabric.CAT_SALAD_ID, CAT_SALAD);
		Registry.register(Registry.SOUND_EVENT, UnderFabric.GHOSTFIGHT_ID, GHOSTFIGHT);

		System.out.println("Registering Underfabric entities (global)...");
		// Register entity related code
		FabricDefaultAttributeRegistry.register(NAPSTABLOOK_ENTITY_ENTITY_TYPE, napstablook.createMobAttributes());

		// Ascii art!
		for (String s : Arrays.asList("Registered UnderFabric objects.", " ", " ", " ", "░░░░██░░████████░░██░░░░░░░░░░░░░░░░░░░░░░░░░░", "░░██░░██░░░░░░░░██░░██░░░░░░░░░░░░░░░░░░░░░░░░", "░░██░░░░░░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░░░░░░░", "░░██░░░░░░░░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░░░░░", "██░░░░██░░░░██░░░░░░░░░░██░░░░░░░░░░░░░░░░░░░░", "██░░░░░░░░░░░░░░░░░░░░░░░░████░░░░░░░░░░░░░░░░", "██░░░░░░████░░░░░░░░░░░░░░░░░░██████████████░░", "██░░██░░██░░░░██░░░░░░░░░░░░░░░░░░░░░░░░░░░░██", "██░░░░████████░░░░░░░░░░░░░░░░░░░░░░░░██████░░", "██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░", "██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░", "██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░", "██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░", "██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░░░", "░░██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░░░", "░░██░░░░████░░░░████████░░░░████░░░░██░░░░░░░░", "░░██░░░░████░░██░░░░░░██░░██░░██░░░░██░░░░░░░░", "░░██░░██░░░░██░░░░░░░░░░██░░░░██░░██░░░░░░░░░░", "░░░░██░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░░░░░░░", "Arf Arf!")) {
			System.out.println(s);
		}
	}

	// Create items to registered namespaces as per above
	// The settings here are overridden by the settings within the item class itself, modifications are done there
	public static ToolItem TOY_KNIFE = new ToyKnife(WeaponMaterial.INSTANCE, 2, -2.4F, new Item.Settings().group(ItemGroup.COMBAT));
	public static ToolItem TOUGH_GLOVE = new ToughGlove(WeaponMaterial.INSTANCE, 4, -1F, new Item.Settings().group(ItemGroup.COMBAT));
	public static ToolItem BALLET_SHOES = new BalletShoes(WeaponMaterial.INSTANCE, 6, -1.5F, new Item.Settings().group(ItemGroup.COMBAT));
	public static ToolItem TORN_NOTEBOOK = new TornNotebook(WeaponMaterial.INSTANCE, 1, -0.5F, new Item.Settings().group(ItemGroup.COMBAT));
	public static ToolItem BURNT_PAN = new BurntPan(WeaponMaterial.INSTANCE, 10, -3F, new Item.Settings().group(ItemGroup.COMBAT));
	public static ToolItem EMPTY_GUN = new EmptyGun(WeaponMaterial.INSTANCE, 10, -3F, new Item.Settings().group(ItemGroup.COMBAT));
	public static ToolItem WORN_DAGGER = new WornDagger(WeaponMaterial.INSTANCE, 15, -2.5F, new Item.Settings().group(ItemGroup.COMBAT));
	public static ToolItem REAL_KNIFE = new RealKnife(WeaponMaterial.INSTANCE, 99, -1F, new Item.Settings().group(ItemGroup.COMBAT));

	// Creates the creative tab items, they can otherwise be found at the bottom of the search tab, and nowhere else.
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
			new Identifier("underfabric", "creative_tab"))
			.icon(() -> new ItemStack(UnderFabric.HEART_RED))
			.appendItems(stacks -> {
				// Items
				stacks.add(new ItemStack(UnderFabric.HEART_RED));
				// Weapons
				stacks.add(new ItemStack(UnderFabric.TOY_KNIFE));
				stacks.add(new ItemStack(UnderFabric.TOUGH_GLOVE));
				stacks.add(new ItemStack(UnderFabric.BALLET_SHOES));
				stacks.add(new ItemStack(UnderFabric.TORN_NOTEBOOK));
				stacks.add(new ItemStack(UnderFabric.BURNT_PAN));
				stacks.add(new ItemStack(UnderFabric.EMPTY_GUN));
				stacks.add(new ItemStack(UnderFabric.WORN_DAGGER));
				stacks.add(new ItemStack(UnderFabric.REAL_KNIFE));
				// Consumables
				stacks.add(new ItemStack(UnderFabric.BANDAGE_CONSUMABLE));
				stacks.add(new ItemStack(UnderFabric.MONSTER_CANDY));
				stacks.add(new ItemStack(UnderFabric.SPIDER_DONUT));
				stacks.add(new ItemStack(UnderFabric.SPIDER_CIDER));
				stacks.add(new ItemStack(UnderFabric.BSCOTCH_PIE));
				stacks.add(new ItemStack(UnderFabric.SNAIL_PIE));
				stacks.add(new ItemStack(UnderFabric.SNOWMAN_PIECE));
				stacks.add(new ItemStack(UnderFabric.NICE_CREAM));
				stacks.add(new ItemStack(UnderFabric.BISICLE));
				stacks.add(new ItemStack(UnderFabric.UNISICLE));
				stacks.add(new ItemStack(UnderFabric.CINNAMON_BUNNY));
				stacks.add(new ItemStack(UnderFabric.ASTRONAUT_FOOD));
				stacks.add(new ItemStack(UnderFabric.CRAB_APPLE));
				stacks.add(new ItemStack(UnderFabric.SEA_TEA));
				stacks.add(new ItemStack(UnderFabric.ABANDONED_QUICHE));
				stacks.add(new ItemStack(UnderFabric.TEMMIE_FLAKES));
				stacks.add(new ItemStack(UnderFabric.DOG_SALAD));
				stacks.add(new ItemStack(UnderFabric.INSTANT_NOODLES));
				stacks.add(new ItemStack(UnderFabric.HOT_DOG));
				stacks.add(new ItemStack(UnderFabric.HOT_CAT));
				stacks.add(new ItemStack(UnderFabric.JUNK_FOOD));
				stacks.add(new ItemStack(UnderFabric.HUSH_PUPPY));
				stacks.add(new ItemStack(UnderFabric.STARFAIT));
				stacks.add(new ItemStack(UnderFabric.GLAMBURGER));
				stacks.add(new ItemStack(UnderFabric.LEGENDARY_HERO));
				stacks.add(new ItemStack(UnderFabric.FACE_STEAK));
				stacks.add(new ItemStack(UnderFabric.POPATO_CHISPS));
				stacks.add(new ItemStack(UnderFabric.BAD_MEMORY));
				stacks.add(new ItemStack(UnderFabric.LAST_DREAM));
				stacks.add(new ItemStack(UnderFabric.PUPPY_ICE_CREAM));
				stacks.add(new ItemStack(UnderFabric.PUMPKIN_RINGS));
				stacks.add(new ItemStack(UnderFabric.ROCK_CANDY));
				stacks.add(new ItemStack(UnderFabric.CROQUET_ROLL));
				stacks.add(new ItemStack(UnderFabric.GHOST_FRUIT));
				stacks.add(new ItemStack(UnderFabric.STOIC_ONION));
				// Blocks
				stacks.add(new ItemStack(UnderFabric.RUINS_DEFAULT));
				stacks.add(new ItemStack(UnderFabric.RUINS_PATH));
				stacks.add(new ItemStack(UnderFabric.RUINS_BRICK));
				stacks.add(new ItemStack(UnderFabric.RUINS_LEAVES));
			})
			.build();
}