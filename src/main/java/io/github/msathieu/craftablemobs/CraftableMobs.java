package io.github.msathieu.craftablemobs;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = "craftablemobs", version = "1.0.0")
public class CraftableMobs {
  @EventHandler
  public void init(FMLInitializationEvent event) {
    Blocks.MOB_SPAWNER.setCreativeTab(CreativeTabs.DECORATIONS);
    ResourceLocation eggs_group = new ResourceLocation("craftablemobs:eggs");
    GameRegistry.addShapedRecipe(new ResourceLocation("craftablemobs:egg"), eggs_group, new ItemStack(Items.SPAWN_EGG, 9), new Object[] {
      "III",
      "IGI",
      "III",
      'G', Items.GHAST_TEAR,
      'I', Items.IRON_INGOT
    });
    GameRegistry.addShapedRecipe(new ResourceLocation("craftablemobs:spawner"), new ResourceLocation(""), new ItemStack(Blocks.MOB_SPAWNER), new Object[] {
      "BBB",
      "BDB",
      "BBB",
      'B', Blocks.IRON_BARS,
      'D', Blocks.DIAMOND_BLOCK
    });
    register_egg("zombie", Items.ROTTEN_FLESH);
    register_egg("spider", Items.STRING);
    register_egg("enderman", Items.ENDER_PEARL);
    register_egg("blaze", Items.BLAZE_POWDER);
    register_egg("cave_spider", Items.SPIDER_EYE);
    register_egg("wither_skeleton", Items.STONE_SWORD);
    register_egg("creeper", Items.GUNPOWDER);
    register_egg("skeleton", Items.BONE);
    register_egg("zombie_pigman", Items.GOLD_NUGGET);
    register_egg("magma_cube", Items.MAGMA_CREAM);
    register_egg("guardian", Items.PRISMARINE_SHARD);
    register_egg("pig", Items.PORKCHOP);
    register_egg("cow", Items.BEEF);
    register_egg("chicked", Items.FEATHER);
    register_egg("villager", Items.EMERALD);
    register_egg("sheep", Blocks.WOOL);
    register_egg("silverfish", Blocks.STONE);
    register_egg("ghast", Items.GHAST_TEAR);
    register_egg("ocelot", Items.FISH);
    register_egg("horse", Items.LEATHER);
    register_egg("rabbit", Items.RABBIT);
    register_egg("llama", Blocks.CARPET);
    register_egg("parrot", Items.COOKIE);
    register_egg("mooshroom", Blocks.RED_MUSHROOM);
    register_egg("witch", Items.SPLASH_POTION);
    register_egg("slime", Items.SLIME_BALL);
    register_egg("wolf", Items.COOKED_BEEF);
    register_egg("elder_guardian", Blocks.SEA_LANTERN);
    register_egg("bat", Items.FLINT);
    register_egg("endermite", Items.ENDER_EYE);
    register_egg("polar_bear", Blocks.SNOW);
    register_egg("shulker", Items.SHULKER_SHELL);
    register_egg("vindication_illager", Items.IRON_AXE);
    register_egg("evocation_illager", Items.TOTEM_OF_UNDYING);
    register_egg("zombie_villager", Items.GOLDEN_APPLE);
  }
  private void register_egg(String mob, Block ingredient) {
    register_egg(mob, Item.getItemFromBlock(ingredient));
  }
  private void register_egg(String mob, Item ingredient) {
    ResourceLocation eggs_group = new ResourceLocation("craftablemobs:eggs");
    ItemStack egg = new ItemStack(Items.SPAWN_EGG);
    ItemMonsterPlacer.applyEntityIdToItemStack(egg, new ResourceLocation("minecraft:" + mob));
    GameRegistry.addShapedRecipe(new ResourceLocation("craftablemobs:" + mob + "_egg"), eggs_group, egg, new Object[] {
      "III",
      "IEI",
      "III",
      'I', ingredient,
      'E', Items.SPAWN_EGG
    });
  }
}
