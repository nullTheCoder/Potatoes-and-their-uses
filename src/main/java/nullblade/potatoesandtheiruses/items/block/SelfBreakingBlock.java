package nullblade.potatoesandtheiruses.items.block;

import nullblade.potatoesandtheiruses.PotatoMain;
import nullblade.potatoesandtheiruses.items.materials.ShardPotatetite;
import org.waveapi.api.content.items.block.WaveBlock;
import org.waveapi.api.content.items.block.model.BlockModel;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SelfBreakingBlock extends WaveBlock {

    public SelfBreakingBlock() {
        super("self_breaking_block", PotatoMain.instance);
        setTab(PotatoMain.tab);

        addTranslation("en_us", "Self Breaking Block");

        setDrop();
        setHardness(2);
        makePickaxeEffective();

        enableRandomTick();

        setModels(new SixSidedBlockModel("potato_uses/items/blocks/self_breaking_block.png"));

        new WaveShapedRecipe(this,
                    new String[]{
                            "PSP",
                            "SIS",
                            "PSP"
                    },
                PotatoMain.instance)
                .addIngredient('P', "potato_uses:potatetite")
                .addIngredient('S', "minecraft:stone")
                .addIngredient('I', "minecraft:iron_ingot");
        lore = new TranslatedText("self_breaking_block", PotatoMain.instance);
        lore2 = new TranslatedText("self_breaking_block", PotatoMain.instance);
        lore.addTranslation("en_us", "This block breaks itself after a bit.");
        lore2.addTranslation("en_us", "When it breaks, it drops potatetite shards.");
    }

    private static TranslatedText lore;
    private static TranslatedText lore2;
    @Override
    public void onRandomTick(BlockState state, BlockPos pos, World world) {
        world.breakBlock(pos, false);
        ItemStack drop = ShardPotatetite.instance.getDefaultStack();
        drop.setAmount(4);
        world.dropItem(pos.toVector3().add(0.5, 0.5, 0.5), drop);
    }

    @Override
    public List<Text> addToolTip(ItemStack stack) {
        return Arrays.asList(lore, lore2);
    }
}
