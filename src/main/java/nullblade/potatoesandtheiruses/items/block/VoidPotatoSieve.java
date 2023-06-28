package nullblade.potatoesandtheiruses.items.block;

import nullblade.potatoesandtheiruses.PotatoMain;
import nullblade.potatoesandtheiruses.Utils;
import nullblade.potatoesandtheiruses.items.materials.PotatoPoison;
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

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class VoidPotatoSieve extends WaveBlock implements TileEntityBlock {

    public static VoidPotatoSieve instance;
    public VoidPotatoSieve() {
        super("potato_void_sieve", PotatoMain.instance);
        instance = this;

        setTab(PotatoMain.tab);

        addTranslation("en_us", "Void Potato Sieve");

        setDrop();
        setHardness(2);
        makePickaxeEffective();

        setModels(new TopBottomSidesBlockModel(
                "potato_uses/items/blocks/void_sieve/top.png",
                "potato_uses/items/blocks/void_sieve/bottom.png",
                "potato_uses/items/blocks/void_sieve/side.png"
        ));

        new WaveShapedRecipe(this,
                    new String[]{
                            "V#V",
                            ". .",
                            ". ."
                    },
                PotatoMain.instance)
                .addIngredient('V', "potato_uses:void_potato")
                .addIngredient('#', "potato_uses:magic_lens")
                .addIngredient('.', "potato_uses:reinforced_stick");
        lore = new TranslatedText("void_sieve_1", PotatoMain.instance);
        lore2 = new TranslatedText("void_sieve_2", PotatoMain.instance);
        lore3 = new TranslatedText("void_sieve_3", PotatoMain.instance);
        lore.addTranslation("en_us", "§8Takes void potatoes from above itself");
        lore2.addTranslation("en_us", "§8Sieves through them");
        lore3.addTranslation("en_us", "§8Outputs tiny amounts of resources below it");
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
            if (ticks > 30) {
                int amount = (int)Math.floor(ticks / 30.0);
                ticks -= amount * 30;
                ContainerTile tile = getWorld().getTileEntity(getPosition().addY(1), ContainerTile.class);
                if (tile == null)
                    return;
                int total = 0;
                for (int i = 0 ; i < tile.getSize() ; i++) {
                    if (total == amount) {
                        break;
                    }
                    ItemStack stack = tile.getStack(i);
                    if (stack.is(VoidPotato.instance)) {
                        int can = Math.min(amount - total, stack.getAmount());
                        total += can;
                        stack.setAmount(stack.getAmount() - can);
                    }
                }
                if (total == 0) return;

                BlockPos pos = getPosition().add(0, -1, 0);
                ContainerTile chest = getWorld().getTileEntity(pos, ContainerTile.class);

                for (int i = 0 ; i < total ; i++) {
                    Utils.drop(pos, chest, getWorld(), new WaveItem[]{
                            MinecraftItems.STONE, // 0
                            MinecraftItems.AMETHYST_SHARD, // 1
                            MinecraftItems.IRON_NUGGET, // 2
                            MinecraftItems.IRON_INGOT, // 3
                            MinecraftItems.GOLD_NUGGET, // 4
                            MinecraftItems.GOLD_INGOT, // 5
                            MinecraftItems.DIAMOND, // 6
                    }, new int[] {
                            random.nextInt(5), // 0
                            random.nextFloat() > 0.7 ? 1 : 0, // 1
                            random.nextFloat() > 0.6 ? 1 : 0, // 2
                            random.nextFloat() > 0.9 ? 1 : 0, // 3
                            random.nextFloat() > 0.8 ? 1 : 0, // 4
                            random.nextFloat() > 0.95 ? 1 : 0, // 5
                            random.nextFloat() > 0.995 ? 1 : 0, // 6
                    });
                }

            }
        }

    }

}
