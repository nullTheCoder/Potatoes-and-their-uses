package nullblade.potatoesandtheiruses.items.tools;

import nullblade.potatoesandtheiruses.PotatoMain;
import nullblade.potatoesandtheiruses.items.block.PotatetiteBlock;
import nullblade.potatoesandtheiruses.items.block.PotatoBeacon;
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
import org.waveapi.api.world.BlockState;
import org.waveapi.api.world.World;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PotatoBeaconProbe extends WaveItem {
    public PotatoBeaconProbe() {
        super("potato_beacon_probe", PotatoMain.instance);
        setModel(new SimpleToolModel(new Texture("potato_uses/items/tools/potato_beacon_probe.png")));
        setTab(PotatoMain.tab);

        setMaxStackSize(1);

        addTranslation("en_us", "Potato Beacon Probe");

        new WaveShapedRecipe(this,
                    new String[]{
                            " EL",
                            " SE",
                            "S  "
                    },
                PotatoMain.instance)
                .addIngredient('S', "potato_uses:reinforced_stick")
                .addIngredient('L', "potato_uses:magic_lens")
                .addIngredient('E', "potato_uses:ender_clockwork_potato");

        lore = new TranslatedText("beacon_probe_lore", PotatoMain.instance)
                .addTranslation("en_us", "§8Probe your Potato Beacon");

        err = new TranslatedText("probe_error", PotatoMain.instance)
                .addTranslation("en_us", "This is not a Potato Beacon.");

        worked = new TranslatedText("probe_work", PotatoMain.instance)
                .addTranslation("en_us", "§1=-----------------------=\n" +
                        "§cLevel: %d/4\n" +
                        "Every 20 seconds gives:\n" +
                        "<Level 0>\n> 1 potato\n" +
                        "<Level 1>\n> 1-8 potatoes \n> 1-2 poisoned potatoes\n" +
                        "<Level 2>\n> 1-12 potatoes \n> 1-4 poisoned potatoes \n> 1-3 potatetite \n> 0-1 potatetite gems\n" +
                        "<Level 3>\n> 1-24 potatoes \n> 1-6 poisoned potatoes \n> 1-6 potatetite \n> 1-2 potatetite gems\n" +
                        "<Level 4>\n> 1-32 potatoes \n> 1-8 poisoned potatoes \n> 1-8 potatetite \n> 1-4 potatetite gems \n> 0-1 Primordial Potato Shards\n" +
                        "§1=-----------------------=");

    }

    private static TranslatedText lore;

    private static TranslatedText err;

    private static TranslatedText worked;

    @Override
    public List<Text> addToolTip(ItemStack stack) {
        return Collections.singletonList(lore);
    }

    @Override
    public ItemUseResult onUse(ItemStack item, UseHand hand, EntityPlayer player, World world) {
        if (!world.isClientSide()) return ItemUseResult.SUCCESS;

        BlockPos pos = player.getBlockLookingAt(5, false);
        if (pos != null) {
            BlockState state = world.getBlockState(pos);
            if (state.getBlock() instanceof PotatoBeacon) {
                int level = 0;
                lvl_loop: while (level < 4) {
                    level++;
                    for (int x = -level ; x < level ; x++) {
                        for (int z = -level ; z < level ; z++) {
                            if (!(world.getBlockState(pos.add(x, level, z)).getBlock() instanceof PotatetiteBlock)) {
                                level--;
                                break lvl_loop;
                            }
                        }
                    }
                }
                player.sendMessage(worked.withValues(level));
            } else {
                player.sendMessage(err);
            }
        } else {
            player.damage(DamageSource.GENERIC, 2);
        }

        return ItemUseResult.SUCCESS;
    }
}
