package net.exitstudios.lbd.item;

import net.exitstudios.lbd.LBD;
import net.exitstudios.lbd.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup LBD_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(LBD.MOD_ID, "lbd"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.lbd"))
                    .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RAW_RUBY);
                        entries.add(ModItems.METAL_DETECTOR);
                        entries.add(ModItems.STRAWBERRY);
                        entries.add(ModItems.COAL_BRIQUETTE);

                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RAW_RUBY_BLOCK);
                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                        entries.add(ModBlocks.NETHER_RUBY_ORE);
                        entries.add(ModBlocks.SOUND_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        LBD.LOGGER.info("Registering Mod Items Groups For " + LBD.MOD_ID);

    }

}
