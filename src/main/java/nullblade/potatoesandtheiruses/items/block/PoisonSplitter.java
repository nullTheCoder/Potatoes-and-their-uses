package nullblade.potatoesandtheiruses.items.block;

import nullblade.potatoesandtheiruses.PotatoMain;
import nullblade.potatoesandtheiruses.items.materials.PotatoPoison;
import nullblade.potatoesandtheiruses.items.materials.ShardPotatetite;
import org.waveapi.api.items.MinecraftItems;
import org.waveapi.api.items.WaveItem;
import org.waveapi.api.items.block.WaveBlock;
import org.waveapi.api.items.block.blockentities.DeltaTicking;
import org.waveapi.api.items.block.blockentities.TileEntityBlock;
import org.waveapi.api.items.block.blockentities.TileEntityCreation;
import org.waveapi.api.items.block.blockentities.WaveTileEntity;
import org.waveapi.api.items.block.blockentities.types.ContainerTile;
import org.waveapi.api.items.block.model.SixSidedBlockModel;
import org.waveapi.api.items.block.model.TopBottomSidesBlockModel;
import org.waveapi.api.items.recipes.WaveShapedRecipe;
import org.waveapi.api.items.tags.Tags;
import org.waveapi.api.math.BlockPos;
import org.waveapi.api.misc.Text;
import org.waveapi.api.misc.TranslatedText;
import org.waveapi.api.items.inventory.ItemStack;
import org.waveapi.api.world.BlockState;
import org.waveapi.api.world.World;

import java.util.Arrays;
import java.util.List;

public class PoisonSplitter extends WaveBlock implements TileEntityBlock {

    public static PoisonSplitter instance;
    public PoisonSplitter() {
        super("poison_splitter", PotatoMain.instance);
        instance = this;

        setTab(PotatoMain.tab);

        addTranslation("en_us", "Poison Splitter");

        setDrop();
        setHardness(2);
        makePickaxeEffective();

        enableRandomTick();

        setModels(new TopBottomSidesBlockModel(
                "potato_uses/items/blocks/poison_splitter/top.png",
                "potato_uses/items/blocks/poison_splitter/top.png",
                "potato_uses/items/blocks/poison_splitter/side.png"
        ));

        new WaveShapedRecipe(this,
                    new String[]{
                            ".S.",
                            "G#G",
                            " . "
                    },
                PotatoMain.instance)
                .addIngredient('G', "potato_uses:potatetite_gear")
                .addIngredient('S', Tags.SAND)
                .addIngredient('.', Tags.COBBLESTONE)
                .addIngredient('#', "potato_uses:clockwork_potato");
        lore = new TranslatedText("lore_self_breaking_block", PotatoMain.instance);
        lore2 = new TranslatedText("lore_self_breaking_block_2", PotatoMain.instance);
        lore.addTranslation("en_us", "§8Takes poisoned potatoes from container on top.");
        lore2.addTranslation("en_us", "§8Outputs potatoes and potato poison down.");
    }

    private static TranslatedText lore;
    private static TranslatedText lore2;

    @Override
    public List<Text> addToolTip(ItemStack stack) {
        return Arrays.asList(lore, lore2);
    }

    @Override
    public Class<? extends WaveTileEntity> getTileEntity() {
        return Tile.class;
    }

    public static class Tile extends WaveTileEntity implements DeltaTicking {

        public Tile(TileEntityCreation creation) {
            super(creation);
        }

        int ticks = 0;

        @Override
        public void tick(int passed) {
            ticks += passed;
            if (ticks > 20) {
                int amount = (int)Math.floor(ticks / 20.0);
                ticks -= amount * 20;
                ContainerTile tile = getWorld().getTileEntity(getPosition().addY(1), ContainerTile.class);
                if (tile == null)
                    return;
                int total = 0;
                for (int i = 0 ; i < tile.getSize() ; i++) {
                    if (total == amount) {
                        break;
                    }
                    ItemStack stack = tile.getStack(i);
                    if (stack.is(MinecraftItems.POISONOUS_POTATO)) {
                        int can = Math.min(amount - total, stack.getAmount());
                        total += can;
                        stack.setAmount(stack.getAmount() - can);
                    }
                }
                if (total == 0) return;
                ContainerTile down = getWorld().getTileEntity(getPosition().addY(-1), ContainerTile.class);
                ItemStack potato = MinecraftItems.POTATO.getDefaultStack();
                potato.setAmount(total);
                int totalInserted = down == null ? 0 : down.giveItem(potato);
                if (total > totalInserted) {
                    potato = MinecraftItems.POTATO.getDefaultStack();
                    potato.setAmount(total - totalInserted);
                    getWorld().dropItem(getPosition().toVector3().add(0.5, -1, 0.5), potato);
                }

                ItemStack poison = PotatoPoison.instance.getDefaultStack();
                poison.setAmount(total);
                totalInserted = down == null ? 0 : down.giveItem(poison);
                if (total > totalInserted) {
                    poison = PotatoPoison.instance.getDefaultStack();
                    poison.setAmount(total - totalInserted);
                    getWorld().dropItem(getPosition().toVector3().add(0.5, -1, 0.5), poison);
                }
            }
        }

    }

}
