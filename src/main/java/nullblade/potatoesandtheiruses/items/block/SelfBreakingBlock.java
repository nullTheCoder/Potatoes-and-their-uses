package nullblade.potatoesandtheiruses.items.block;

import nullblade.potatoesandtheiruses.PotatoMain;
import nullblade.potatoesandtheiruses.items.materials.ShardPotatetite;
import org.waveapi.api.items.block.WaveBlock;
import org.waveapi.api.items.block.model.BlockModel;
import org.waveapi.api.items.block.model.SixSidedBlockModel;
import org.waveapi.api.items.block.model.TopBottomSidesBlockModel;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SelfBreakingBlock extends WaveBlock {

    public static SelfBreakingBlock instance;
    public SelfBreakingBlock() {
        super("self_breaking_block", PotatoMain.instance);
        instance = this;

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
        lore = new TranslatedText("lore_self_breaking_block", PotatoMain.instance);
        lore2 = new TranslatedText("lore_self_breaking_block_2", PotatoMain.instance);
        lore.addTranslation("en_us", "§8This block breaks itself after a bit.");
        lore2.addTranslation("en_us", "§8When it breaks, it drops potatetite shards.");
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
