package nullblade.potatoesandtheiruses.items.tools;

import nullblade.potatoesandtheiruses.PotatoMain;
import org.waveapi.api.content.items.WaveItem;
import org.waveapi.api.content.items.block.MinecraftBlocks;
import org.waveapi.api.content.items.models.SimpleToolModel;
import org.waveapi.api.content.items.recipes.WaveShapedRecipe;
import org.waveapi.api.file.texture.Texture;
import org.waveapi.api.math.BlockPos;
import org.waveapi.api.misc.Text;
import org.waveapi.api.misc.TranslatedText;
import org.waveapi.api.world.entity.DamageSource;
import org.waveapi.api.world.entity.living.EntityPlayer;
import org.waveapi.api.world.inventory.ItemStack;
import org.waveapi.api.world.inventory.ItemUseResult;
import org.waveapi.api.world.inventory.UseHand;
import org.waveapi.api.world.world.World;

import java.util.Arrays;
import java.util.List;

public class AdvancedTeleportStick extends WaveItem {
    public AdvancedTeleportStick() {
        super("advanced_teleport_stick", PotatoMain.instance);
        setModel(new SimpleToolModel(new Texture("potato_uses/items/tools/advanced_teleport_stick.png")));
        setTab(PotatoMain.tab);
        setDurability(60);


        addTranslation("en_us", "Advanced Teleport Stick");

        new WaveShapedRecipe(this,
                    new String[]{
                            " EL",
                            " CE",
                            "S  "
                    },
                PotatoMain.instance)
                .addIngredient('S', "potato_uses:reinforced_stick")
                .addIngredient('C', "potato_uses:teleport_stick")
                .addIngredient('L', "potato_uses:magic_lens")
                .addIngredient('E', "potato_uses:ender_clockwork_potato");

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
        BlockPos pos = player.getBlockLookingAt(40, false);
        if (pos != null) {
            for (int i = 0 ; i < 5 ; i++) {
                pos = pos.addY(1);
                if (world.getBlockState(pos).getBlock() == MinecraftBlocks.AIR &&
                        world.getBlockState(pos.addY(1)).getBlock() == MinecraftBlocks.AIR) {
                    item.damage(1, player);
                    player.setPosition(pos.toVector3().add(0.5, 1.0, 0.5));
                    return ItemUseResult.SUCCESS;
                }
            }
        } else {
            player.damage(DamageSource.GENERIC, 2);
        }

        return ItemUseResult.SUCCESS;
    }
}