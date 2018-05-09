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
    CreativeTabs spawnEggs = new CreativeTabs("spawnEggs") {
      @Override
      public ItemStack getTabIconItem() {
        return new ItemStack(Items.SPAWN_EGG);
      }
    };
    Blocks.MOB_SPAWNER.setCreativeTab(CreativeTabs.DECORATIONS);
    Items.SPAWN_EGG.setCreativeTab(spawnEggs);
    registerEgg("zombie", Items.ROTTEN_FLESH);
    registerEgg("spider", Items.STRING);
    registerEgg("enderman", Items.ENDER_PEARL);
    registerEgg("blaze", Items.BLAZE_POWDER);
    registerEgg("cave_spider", Items.SPIDER_EYE);
    registerEgg("wither_skeleton", Items.STONE_SWORD);
    registerEgg("creeper", Items.GUNPOWDER);
    registerEgg("skeleton", Items.BONE);
    registerEgg("zombie_pigman", Items.GOLD_NUGGET);
    registerEgg("magma_cube", Items.MAGMA_CREAM);
    registerEgg("guardian", Items.PRISMARINE_SHARD);
    registerEgg("pig", Items.PORKCHOP);
    registerEgg("cow", Items.BEEF);
    registerEgg("chicked", Items.FEATHER);
    registerEgg("villager", Items.EMERALD);
    registerEgg("sheep", Blocks.WOOL);
    registerEgg("silverfish", Blocks.STONE);
    registerEgg("ghast", Items.GHAST_TEAR);
    registerEgg("ocelot", Items.FISH);
    registerEgg("horse", Items.LEATHER);
    registerEgg("rabbit", Items.RABBIT);
    registerEgg("llama", Blocks.CARPET);
    registerEgg("parrot", Items.COOKIE);
    registerEgg("mooshroom", Blocks.RED_MUSHROOM);
    registerEgg("witch", Items.SPLASH_POTION);
    registerEgg("slime", Items.SLIME_BALL);
    registerEgg("wolf", Items.COOKED_BEEF);
    registerEgg("elder_guardian", Blocks.SEA_LANTERN);
    registerEgg("bat", Items.FLINT);
    registerEgg("endermite", Items.ENDER_EYE);
    registerEgg("polar_bear", Blocks.SNOW);
    registerEgg("shulker", Items.SHULKER_SHELL);
    registerEgg("vindication_illager", Items.IRON_AXE);
    registerEgg("evocation_illager", Items.TOTEM_OF_UNDYING);
    registerEgg("zombie_villager", Items.GOLDEN_APPLE);
    registerEgg("donkey", Blocks.CHEST);
    registerEgg("vex", Items.IRON_SWORD);
    registerEgg("skeleton_horse", Blocks.BONE_BLOCK);
  }
  private void registerEgg(String mob, Block ingredient) {
    registerEgg(mob, Item.getItemFromBlock(ingredient));
  }
  private void registerEgg(String mob, Item ingredient) {
    ResourceLocation eggsGroup = new ResourceLocation("craftablemobs:eggs");
    ItemStack egg = new ItemStack(Items.SPAWN_EGG);
    ItemMonsterPlacer.applyEntityIdToItemStack(egg, new ResourceLocation("minecraft:" + mob));
    GameRegistry.addShapedRecipe(new ResourceLocation("craftablemobs:" + mob + "_egg"), eggsGroup, egg, new Object[] {
      "III",
      "IEI",
      "III",
      'I', ingredient,
      'E', Items.SPAWN_EGG
    });
  }
}
