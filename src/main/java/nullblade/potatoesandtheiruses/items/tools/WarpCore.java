package nullblade.potatoesandtheiruses.items.tools;

import nullblade.potatoesandtheiruses.PotatoMain;
import nullblade.potatoesandtheiruses.items.materials.GemPotatetite;
import org.waveapi.api.items.WaveItem;
import org.waveapi.api.items.block.MinecraftBlocks;
import org.waveapi.api.items.models.SimpleToolModel;
import org.waveapi.api.items.recipes.WaveShapedRecipe;
import org.waveapi.api.items.recipes.ingredients.SimpleItemIngredient;
import org.waveapi.api.items.tools.WaveSwordItem;
import org.waveapi.api.items.tools.WaveToolMaterial;
import org.waveapi.api.file.texture.Texture;
import org.waveapi.api.math.BlockPos;
import org.waveapi.api.misc.Text;
import org.waveapi.api.misc.TranslatedText;
import org.waveapi.api.entities.DamageSource;
import org.waveapi.api.entities.entity.living.EntityPlayer;
import org.waveapi.api.items.inventory.ItemStack;
import org.waveapi.api.items.ItemUseResult;
import org.waveapi.api.items.UseHand;
import org.waveapi.api.world.World;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WarpCore extends WaveItem {
    public WarpCore() {
        super("warp_core", PotatoMain.instance);
        setModel(new SimpleToolModel(new Texture("potato_uses/items/tools/warp_core.png")));
        setTab(PotatoMain.tab);
        setDurability(20);


        addTranslation("en_us", "Warp Core");

        new WaveShapedRecipe(this,
                    new String[]{
                            "IEI",
                            "IDI"
                    },
                PotatoMain.instance)
                .addIngredient('E', "potato_uses:ender_clockwork_potato")
                .addIngredient('I', "minecraft:iron_ingot")
                .addIngredient('D', "minecraft:diamond");

        lore = new TranslatedText("warp_core.lore1", PotatoMain.instance)
                .addTranslation("en_us", "§8Teleports you to the block you are looking at.");
        lore2 = new TranslatedText("warp_core.lore2", PotatoMain.instance)
                .addTranslation("en_us", "§8If teleportation fails, damages you.");
    }

    private static TranslatedText lore;
    private static TranslatedText lore2;

    @Override
    public List<Text> addToolTip(ItemStack stack) {
        return Arrays.asList(lore, lore2);
    }

    @Override
    public ItemUseResult onUse(ItemStack item, UseHand hand, EntityPlayer player, World world) {
        return TeleportStick.getItemUseResult(item, player, world, 25, 1);
    }
}
