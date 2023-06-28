package nullblade.potatoesandtheiruses.items.block;

import nullblade.potatoesandtheiruses.PotatoMain;
import nullblade.potatoesandtheiruses.Utils;
import nullblade.potatoesandtheiruses.items.materials.GemPotatetite;
import nullblade.potatoesandtheiruses.items.materials.Potatetite;
import nullblade.potatoesandtheiruses.items.materials.PrimordialPotatoShard;
import nullblade.potatoesandtheiruses.items.materials.VoidPotato;
import org.waveapi.api.items.MinecraftItems;
import org.waveapi.api.items.WaveItem;
import org.waveapi.api.items.block.MinecraftBlocks;
import org.waveapi.api.items.block.WaveBlock;
import org.waveapi.api.items.block.blockentities.DeltaTicking;
import org.waveapi.api.items.block.blockentities.TileEntityBlock;
import org.waveapi.api.items.block.blockentities.TileEntityCreation;
import org.waveapi.api.items.block.blockentities.WaveTileEntity;
import org.waveapi.api.items.block.blockentities.types.ContainerTile;
import org.waveapi.api.items.block.model.TopBottomSidesBlockModel;
import org.waveapi.api.items.inventory.ItemStack;
import org.waveapi.api.items.recipes.WaveShapedRecipe;
import org.waveapi.api.math.BlockPos;
import org.waveapi.api.misc.Text;
import org.waveapi.api.misc.TranslatedText;
import org.waveapi.api.world.World;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class VoidPotatoMiner extends WaveBlock implements TileEntityBlock {

    public static VoidPotatoMiner instance;
    public VoidPotatoMiner() {
        super("potato_void_miner", PotatoMain.instance);
        instance = this;

        setTab(PotatoMain.tab);

        addTranslation("en_us", "Void Potato Miner");

        setDrop();
        setHardness(2);
        makePickaxeEffective();

        setModels(new TopBottomSidesBlockModel(
                "potato_uses/items/blocks/void_miner/top.png",
                "potato_uses/items/blocks/void_miner/bottom.png",
                "potato_uses/items/blocks/void_miner/side.png"
        ));

        new WaveShapedRecipe(this,
                    new String[]{
                            "C#C",
                            ".#.",
                            ".D."
                    },
                PotatoMain.instance)
                .addIngredient('C', "potato_uses:clockwork_potato")
                .addIngredient('#', "minecraft:golden_pickaxe")
                .addIngredient('D', "minecraft:diamond")
                .addIngredient('.', "minecraft:iron_ingot");
        lore = new TranslatedText("void_miner_1", PotatoMain.instance);
        lore2 = new TranslatedText("void_miner_2", PotatoMain.instance);
        lore3 = new TranslatedText("void_miner_3", PotatoMain.instance);
        lore.addTranslation("en_us", "§8Mines void potatoes out of the void");
        lore2.addTranslation("en_us", "§8Requires bedrock under it to function");
        lore3.addTranslation("en_us", "§8Outputs potatoes on top of itself");
    }

    private static TranslatedText lore;
    private static TranslatedText lore2;
    private static TranslatedText lore3;

    @Override
    public List<Text> addToolTip(ItemStack stack) {
        return Arrays.asList(lore, lore2, lore3);
    }

    @Override
    public Class<? extends WaveTileEntity> getTileEntity() {
        return Tile.class;
    }

    public static class Tile extends WaveTileEntity implements DeltaTicking {

        Random random = new Random();

        public Tile(TileEntityCreation creation) {
            super(creation);
        }

        int ticks = 0;

        @Override
        public void tick(int passed) {
            ticks += passed;
            if (ticks > 400) {
                if (getWorld().getBlockState(getPosition().add(0, -1, 0)).getBlock() != MinecraftBlocks.BEDROCK) {
                    return;
                }

                BlockPos pos = getPosition().add(0, 1, 0);
                ContainerTile tile = getWorld().getTileEntity(pos, ContainerTile.class);
                int amount = (int) Math.floor(ticks / 400.0);
                ticks -= amount * 400;
                for (int i = 0; i < amount; i++) {
                    if (random.nextFloat() > 0.8) {
                        Utils.drop(pos, tile, getWorld(),
                                new WaveItem[]{
                                        VoidPotato.instance
                                }, new int[] {
                                        1
                                });
                    }
                }
            }
        }

    }

}
