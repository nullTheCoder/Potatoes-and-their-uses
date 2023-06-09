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
    }
}
