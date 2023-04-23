package nullblade.potatoesandtheiruses.items.fun;

import nullblade.potatoesandtheiruses.PotatoMain;
import org.waveapi.api.items.block.WaveBlock;
import org.waveapi.api.items.recipes.WaveShapedRecipe;
import org.waveapi.api.math.BlockPos;
import org.waveapi.api.entities.entity.living.EntityPlayer;
import org.waveapi.api.items.ItemUseResult;
import org.waveapi.api.items.UseHand;
import org.waveapi.api.world.BlockState;
import org.waveapi.api.world.World;

public class Blok extends WaveBlock {
    public Blok() {
        super("blok", PotatoMain.instance);

        addTranslation("en_us", "Blok");

        setDrop();
        setHardness(0);

        new WaveShapedRecipe(this,
                    new String[]{
                            "SPS",
                            "III",
                            "SPS"
                    },
                PotatoMain.instance)
                .addIngredient('P', "potato_uses:potatetite")
                .addIngredient('S', "minecraft:stone")
                .addIngredient('I', "minecraft:iron_nugget");
    }

    @Override
    public ItemUseResult onUse(BlockState blockState, BlockPos pos, World world, EntityPlayer entityPlayer, UseHand useHand) {
        if (!world.isClientSide()) {
            entityPlayer.sendMessage("Blok");
        }
        return ItemUseResult.SUCCESS;
    }
}
