package nullblade.potatoesandtheiruses.items.block;

import nullblade.potatoesandtheiruses.PotatoMain;
import org.waveapi.api.content.items.MinecraftItems;
import org.waveapi.api.content.items.block.WaveBlock;
import org.waveapi.api.content.items.block.blockentities.DeltaTicking;
import org.waveapi.api.content.items.block.blockentities.TileEntityBlock;
import org.waveapi.api.content.items.block.blockentities.TileEntityCreation;
import org.waveapi.api.content.items.block.blockentities.WaveTileEntity;
import org.waveapi.api.content.items.block.blockentities.types.ContainerTile;
import org.waveapi.api.content.items.block.model.TopBottomSidesBlockModel;
import org.waveapi.api.content.items.recipes.WaveShapedRecipe;
import org.waveapi.api.misc.Text;
import org.waveapi.api.misc.TranslatedText;
import org.waveapi.api.world.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PotatoBeacon extends WaveBlock implements TileEntityBlock {

    public static PotatoBeacon instance;
    public PotatoBeacon() {
        super("potato_beacon", PotatoMain.instance);
        instance = this;

        setTab(PotatoMain.tab);

        addTranslation("en_us", "Potato Beacon");

        setDrop();
        setHardness(2);
        makePickaxeEffective();

        enableRandomTick();

        setModels(new TopBottomSidesBlockModel(
                "potato_uses/items/blocks/potato_beacon/top.png",
                "potato_uses/items/blocks/potato_beacon/bottom.png",
                "potato_uses/items/blocks/potato_beacon/side.png"
        ));

        new WaveShapedRecipe(this,
                    new String[]{
                            "DDD",
                            "E#E",
                            "GEG"
                    },
                PotatoMain.instance)
                .addIngredient('G', "potato_uses:ender_clockwork_potato")
                .addIngredient('E', "potato_uses:ender_block")
                .addIngredient('#', "minecraft:beacon")
                .addIngredient('D', "minecraft:diamond");
        lore = new TranslatedText("beacon_1", PotatoMain.instance);
        lore2 = new TranslatedText("beacon_2", PotatoMain.instance);
        lore3 = new TranslatedText("beacon_3", PotatoMain.instance);
        lore.addTranslation("en_us", "§8Summons potatoes from another reality under it.");
        lore2.addTranslation("en_us", "§8Requires a reversed beacon base on top of itself.");
        lore3.addTranslation("en_us", "§8Use potato beacon probe on beacon for more info.");
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
                int amount = (int) Math.floor(ticks / 10.0);
                ticks -= amount * 10;

            }
        }

    }

}
