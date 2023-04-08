package nullblade.potatoesandtheiruses.items.block;

import nullblade.potatoesandtheiruses.PotatoMain;
import nullblade.potatoesandtheiruses.items.materials.ShardPotatetite;
import org.waveapi.api.content.items.block.MinecraftBlocks;
import org.waveapi.api.content.items.block.WaveBlock;
import org.waveapi.api.content.items.block.model.SixSidedBlockModel;
import org.waveapi.api.content.items.block.model.TopBottomSidesBlockModel;
import org.waveapi.api.content.items.recipes.WaveShapedRecipe;
import org.waveapi.api.math.BlockPos;
import org.waveapi.api.misc.Text;
import org.waveapi.api.misc.TranslatedText;
import org.waveapi.api.world.inventory.ItemStack;
import org.waveapi.api.world.world.BlockState;
import org.waveapi.api.world.world.World;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SelfBreakingPlacer extends WaveBlock {

    public SelfBreakingPlacer() {
        super("breaking_block_plcater", PotatoMain.instance);
        setTab(PotatoMain.tab);

        addTranslation("en_us", "Self Breaking Block Creator");

        setDrop();
        setHardness(2);
        makePickaxeEffective();

        enableRandomTick();

        setModels(new TopBottomSidesBlockModel(
                "potato_uses/items/blocks/breaking_block_placer/top.png",
                "potato_uses/items/blocks/breaking_block_placer/bottom.png",
                "potato_uses/items/blocks/breaking_block_placer/side.png"
        ));

        new WaveShapedRecipe(this,
                    new String[]{
                            "GCG",
                            "GCG",
                            " D "
                    },
                PotatoMain.instance)
                .addIngredient('C', "potato_uses:clockwork_potato")
                .addIngredient('D', "minecraft:diamond")
                .addIngredient('G', "minecraft:gold_ingot");

        lore = new TranslatedText("lore_self_breaking_block_placer", PotatoMain.instance);
        lore.addTranslation("en_us", "§8This block creates Self Breaking Blocks under itself randomly.");
    }

    private static TranslatedText lore;
    @Override
    public void onRandomTick(BlockState state, BlockPos pos, World world) {
        if (world.getBlockState(pos.addY(-1)).getBlock() == MinecraftBlocks.AIR) {
            world.setBlockState(pos.addY(-1), SelfBreakingBlock.instance.getDefaultState());
        }
    }

    @Override
    public List<Text> addToolTip(ItemStack stack) {
        return Collections.singletonList(lore);
    }
}
