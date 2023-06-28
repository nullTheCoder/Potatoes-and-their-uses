package nullblade.potatoesandtheiruses;

import org.waveapi.api.items.WaveItem;
import org.waveapi.api.items.block.blockentities.types.ContainerTile;
import org.waveapi.api.items.inventory.ItemStack;
import org.waveapi.api.math.BlockPos;
import org.waveapi.api.world.World;

public class Utils {
    public static void drop(BlockPos pos, ContainerTile tile, World world, WaveItem[] items, int[] amounts) {
        for (int i = 0 ; i < items.length ; i++) {
            ItemStack stack = items[i].getDefaultStack();
            stack.setAmount(amounts[i]);
            int totalInserted = tile == null ? 0 : tile.giveItem(stack);
            if (amounts[i] > totalInserted) {
                stack = items[i].getDefaultStack();
                stack.setAmount(amounts[i] - totalInserted);
                world.dropItem(pos.toVector3().add(0.5, 0.5, 0.5), stack);
            }
        }
    }
}
