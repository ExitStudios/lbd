package net.exitstudios.lbd.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

import java.util.Objects;

public class MetalDetectorItem extends Item {

    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient) {
            BlockPos click = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= click.getY() + 64; i++) {
                BlockState state = context.getWorld().getBlockState(click.down(i));

                if (isMetallicOre(state)) {
                    outputMetallicOreCoordinates(click.down(i), player, state.getBlock());
                    foundBlock = true;
                    break;
                }
            }

            if(!foundBlock) {
                assert player != null;
                player.sendMessage(Text.literal("No ore found"), false);
            }
        }

        context.getStack().damage(1, Objects.requireNonNull(context.getPlayer()),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return ActionResult.SUCCESS;
    }

    public boolean isMetallicOre(BlockState state) {
        return state.isOf(Blocks.IRON_BLOCK) || state.isOf(Blocks.COPPER_ORE) || state.isOf(Blocks.DIAMOND_ORE);
    }

    public void outputMetallicOreCoordinates(BlockPos pos, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Found " + block.asItem().getName().getString() +
                " at position (" + pos.getX() + ", " + pos.getY() + ", " + pos.getZ() + ")"), false);
    }

}
