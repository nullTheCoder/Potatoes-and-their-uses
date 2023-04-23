package nullblade.potatoesandtheiruses.items.block;

import nullblade.potatoesandtheiruses.PotatoMain;
import org.waveapi.api.items.block.MinecraftBlocks;
import org.waveapi.api.items.block.WaveBlock;
import org.waveapi.api.items.block.model.SixSidedBlockModel;
import org.waveapi.api.items.recipes.WaveShapedRecipe;
import org.waveapi.api.math.BlockPos;
import org.waveapi.api.misc.Text;
import org.waveapi.api.misc.TranslatedText;
import org.waveapi.api.entities.entity.living.EntityPlayer;
import org.waveapi.api.items.inventory.ItemStack;
import org.waveapi.api.items.ItemUseResult;
import org.waveapi.api.items.UseHand;
import org.waveapi.api.world.BlockState;
import org.waveapi.api.world.World;

import java.util.Collections;
import java.util.List;

public class EnderBlock extends WaveBlock {
    public EnderBlock() {
        super("ender_block", PotatoMain.instance);

        addTranslation("en_us", "Ender Block");

        setDrop();
        setHardness(3);
        setTab(PotatoMain.tab);
        makePickaxeEffective();
        setModels(new SixSidedBlockModel("potato_uses/items/blocks/ender_block.png"));

        new WaveShapedRecipe(this,
                    new String[]{
                            "SLS",
                            "E#E",
                            "SSS"
                    },
                PotatoMain.instance)
                .addIngredient('L', "potato_uses:magic_lens")
                .addIngredient('S', "minecraft:stone")
                .addIngredient('E', "potato_uses:ender_clockwork_potato")
                .addIngredient('#', "potato_uses:warp_core");

        lore = new TranslatedText("ender_block_lore", PotatoMain.instance).addTranslation("en_us", "§8§o*Teleports behind you*");
    }

    private static TranslatedText lore;

    @Override
    public List<Text> addToolTip(ItemStack stack) {
        return Collections.singletonList(lore);
    }

    @Override
    public ItemUseResult onUse(BlockState blockState, BlockPos pos, World world, EntityPlayer entityPlayer, UseHand useHand) {
        if (!world.isClientSide()) {
            BlockPos newPos = new BlockPos(entityPlayer.getPosition().add(entityPlayer.getLookVector().multiply(-3, 0, -3)));

            if (world.getBlockState(newPos).getBlock() == MinecraftBlocks.AIR) {
                world.setBlockState(newPos, blockState);
                world.setBlockState(pos, MinecraftBlocks.AIR.getDefaultState());
            }

        }
        return ItemUseResult.SUCCESS;
    }
}
