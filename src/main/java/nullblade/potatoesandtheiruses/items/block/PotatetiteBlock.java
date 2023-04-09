package nullblade.potatoesandtheiruses.items.block;

import nullblade.potatoesandtheiruses.PotatoMain;
import org.waveapi.api.content.items.block.MinecraftBlocks;
import org.waveapi.api.content.items.block.WaveBlock;
import org.waveapi.api.content.items.block.model.SixSidedBlockModel;
import org.waveapi.api.content.items.recipes.WaveShapedRecipe;
import org.waveapi.api.math.BlockPos;
import org.waveapi.api.misc.Text;
import org.waveapi.api.misc.TranslatedText;
import org.waveapi.api.world.entity.living.EntityPlayer;
import org.waveapi.api.world.inventory.ItemStack;
import org.waveapi.api.world.inventory.ItemUseResult;
import org.waveapi.api.world.inventory.UseHand;
import org.waveapi.api.world.world.BlockState;
import org.waveapi.api.world.world.World;

import java.util.Collections;
import java.util.List;

public class PotatetiteBlock extends WaveBlock {
    public PotatetiteBlock() {
        super("potatetite_block", PotatoMain.instance);

        addTranslation("en_us", "Potatetite Block");

        setDrop();
        setHardness(3);
        setTab(PotatoMain.tab);
        makePickaxeEffective();
        setMiningLevelRequired(1);
        setModels(new SixSidedBlockModel("potato_uses/items/blocks/potatetite_block.png"));

        new WaveShapedRecipe(this,
                    new String[]{
                            "PPP",
                            "PPP",
                            "PPP"
                    },
                PotatoMain.instance)
                .addIngredient('P', "potato_uses:potatetite");

        new WaveShapedRecipe("potato_uses:potatetite",
                new String[]{
                        "P"
                },
                PotatoMain.instance)
                .addIngredient('P', "potato_uses:potatetite_block")
                .setResultCount(9);

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
