package nullblade.potatoesandtheiruses.items.block;

import nullblade.potatoesandtheiruses.PotatoMain;
import nullblade.potatoesandtheiruses.items.materials.PotatoPoison;
import org.waveapi.api.items.MinecraftItems;
import org.waveapi.api.items.block.WaveBlock;
import org.waveapi.api.items.block.blockentities.DeltaTicking;
import org.waveapi.api.items.block.blockentities.TileEntityBlock;
import org.waveapi.api.items.block.blockentities.TileEntityCreation;
import org.waveapi.api.items.block.blockentities.WaveTileEntity;
import org.waveapi.api.items.block.blockentities.types.ContainerTile;
import org.waveapi.api.items.block.model.TopBottomSidesBlockModel;
import org.waveapi.api.items.recipes.WaveShapedRecipe;
import org.waveapi.api.misc.Text;
import org.waveapi.api.misc.TranslatedText;
import org.waveapi.api.items.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Poisoner extends WaveBlock implements TileEntityBlock {

    public static Poisoner instance;
    public Poisoner() {
        super("poisoner", PotatoMain.instance);
        instance = this;

        setTab(PotatoMain.tab);

        addTranslation("en_us", "Potato Poisoner");

        setDrop();
        setHardness(2);
        makePickaxeEffective();

        enableRandomTick();

        setModels(new TopBottomSidesBlockModel(
                "potato_uses/items/blocks/poison_splitter/top.png",
                "potato_uses/items/blocks/poison_splitter/top.png",
                "potato_uses/items/blocks/poisoner_side.png"
        ));

        new WaveShapedRecipe(this,
                    new String[]{
                            "SGS",
                            "S#S",
                            " S "
                    },
                PotatoMain.instance)
                .addIngredient('G', "potato_uses:potatetite_gear")
                .addIngredient('S', "minecraft:stone")
                .addIngredient('#', "potato_uses:poison_essence");
        lore = new TranslatedText("lore_poisoner_block", PotatoMain.instance);
        lore2 = new TranslatedText("lore_poisoner_2", PotatoMain.instance);
        lore3 = new TranslatedText("lore_poisoner_3", PotatoMain.instance);
        lore.addTranslation("en_us", "§8Takes potatoes from container on top.");
        lore2.addTranslation("en_us", "§8Outputs poisonous potatoes down");
        lore3.addTranslation("en_us", "§8With 50% chance outputs a normal potato instead");
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
            if (ticks > 10) {
                int amount = (int)Math.floor(ticks / 10.0);
                ticks -= amount * 10;
                ContainerTile tile = getWorld().getTileEntity(getPosition().addY(1), ContainerTile.class);
                if (tile == null)
                    return;
                int total = 0;
                for (int i = 0 ; i < tile.getSize() ; i++) {
                    if (total == amount) {
                        break;
                    }
                    ItemStack stack = tile.getStack(i);
                    if (stack.is(MinecraftItems.POTATO)) {
                        int can = Math.min(amount - total, stack.getAmount());
                        total += can;
                        stack.setAmount(stack.getAmount() - can);
                    }
                }
                if (total == 0) return;
                int converted = random.nextInt(total+1);

                ContainerTile down = getWorld().getTileEntity(getPosition().addY(-1), ContainerTile.class);
                ItemStack potato = MinecraftItems.POTATO.getDefaultStack();
                potato.setAmount(total - converted);
                int totalInserted = down == null ? 0 : down.giveItem(potato);
                if ((total - converted) > totalInserted) {
                    potato = MinecraftItems.POTATO.getDefaultStack();
                    potato.setAmount((total - converted) - totalInserted);
                    getWorld().dropItem(getPosition().toVector3().add(0.5, -1, 0.5), potato);
                }

                ItemStack poison = MinecraftItems.POISONOUS_POTATO.getDefaultStack();
                poison.setAmount(converted);
                totalInserted = down == null ? 0 : down.giveItem(poison);
                if (converted > totalInserted) {
                    poison = MinecraftItems.POISONOUS_POTATO.getDefaultStack();
                    poison.setAmount(converted - totalInserted);
                    getWorld().dropItem(getPosition().toVector3().add(0.5, -1, 0.5), poison);
                }
            }
        }

    }

}
