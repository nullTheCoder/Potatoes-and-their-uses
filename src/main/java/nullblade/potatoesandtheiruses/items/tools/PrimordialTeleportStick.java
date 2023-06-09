package nullblade.potatoesandtheiruses.items.tools;

import nullblade.potatoesandtheiruses.PotatoMain;
import org.waveapi.api.items.Rarity;
import org.waveapi.api.items.WaveItem;
import org.waveapi.api.items.block.MinecraftBlocks;
import org.waveapi.api.items.models.SimpleToolModel;
import org.waveapi.api.items.recipes.WaveShapedRecipe;
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

public class PrimordialTeleportStick extends WaveItem {
    public PrimordialTeleportStick() {
        super("primordial_teleport_stick", PotatoMain.instance);
        setModel(new SimpleToolModel(new Texture("potato_uses/items/tools/primordial_teleport_stick.png")));
        setTab(PotatoMain.tab);
        setDurability(300);
        setRarity(Rarity.EPIC);


        addTranslation("en_us", "Primordial Teleport Stick");

        new WaveShapedRecipe(this,
                    new String[]{
                            " E#",
                            " CE",
                            "S  "
                    },
                PotatoMain.instance)
                .addIngredient('S', "potato_uses:reinforced_stick")
                .addIngredient('C', "potato_uses:advanced_teleport_stick")
                .addIngredient('E', "potato_uses:ender_block")
                .addIngredient('#', "potato_uses:primordial_potato");

        lore = new TranslatedText("warp_core.lore1", PotatoMain.instance)
                .addTranslation("en_us", "§8Teleports you to the block you are looking at.");
    }

    private static TranslatedText lore;

    @Override
    public List<Text> addToolTip(ItemStack stack) {
        return Collections.singletonList(lore);
    }

    @Override
    public ItemUseResult onUse(ItemStack item, UseHand hand, EntityPlayer player, World world) {
        return TeleportStick.getItemUseResult(item, player, world, 80, 16);
    }
}
