package nullblade.potatoesandtheiruses.items.tools;

import nullblade.potatoesandtheiruses.PotatoMain;
import org.waveapi.api.entities.DamageSource;
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
import java.util.List;

public class TeleportStick extends WaveItem {
    public TeleportStick() {
        super("teleport_stick", PotatoMain.instance);
        setModel(new SimpleToolModel(new Texture("potato_uses/items/tools/teleport_stick.png")));
        setTab(PotatoMain.tab);
        setDurability(40);


        addTranslation("en_us", "Teleport Stick");

        new WaveShapedRecipe(this,
                    new String[]{
                            " DC",
                            " SD",
                            "S  "
                    },
                PotatoMain.instance)
                .addIngredient('S', "potato_uses:reinforced_stick")
                .addIngredient('C', "potato_uses:warp_core")
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
        return getItemUseResult(item, player, world, 35, 3);
    }

    public static ItemUseResult getItemUseResult(ItemStack item, EntityPlayer player, World world, int distance, int correctness) {
        BlockPos pos = player.getBlockLookingAt(distance, false);
        if (pos != null) {
            for (int i = 0 ; i < correctness ; i++) {
                pos = pos.addY(1);
                if (!world.isBlockSolid(pos) &&
                        !world.isBlockSolid((pos.addY(1)))) {
                    item.damage(1, player);
                    player.setPosition(pos.toVector3().add(0.5, 0.1, 0.5));
                    return ItemUseResult.SUCCESS;
                }
            }
        } else {
            player.damage(DamageSource.GENERIC, 2);
        }

        return ItemUseResult.SUCCESS;
    }
}
