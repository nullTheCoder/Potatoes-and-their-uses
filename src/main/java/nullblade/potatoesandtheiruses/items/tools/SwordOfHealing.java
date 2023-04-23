package nullblade.potatoesandtheiruses.items.tools;

import nullblade.potatoesandtheiruses.PotatoMain;
import nullblade.potatoesandtheiruses.items.materials.GemPotatetite;
import org.waveapi.api.items.WaveItem;
import org.waveapi.api.items.models.SimpleToolModel;
import org.waveapi.api.items.recipes.WaveShapedRecipe;
import org.waveapi.api.items.recipes.ingredients.SimpleItemIngredient;
import org.waveapi.api.items.tools.WaveSwordItem;
import org.waveapi.api.items.tools.WaveToolMaterial;
import org.waveapi.api.file.texture.Texture;
import org.waveapi.api.misc.Text;
import org.waveapi.api.misc.TranslatedText;
import org.waveapi.api.entities.entity.living.EntityPlayer;
import org.waveapi.api.items.inventory.ItemStack;
import org.waveapi.api.items.ItemUseResult;
import org.waveapi.api.items.UseHand;
import org.waveapi.api.world.World;

import java.util.Collections;
import java.util.List;

public class SwordOfHealing extends WaveSwordItem {
    public SwordOfHealing() {
        super("sword_of_healing",
                new WaveToolMaterial()
                    .setRepairIngredient(new SimpleItemIngredient(GemPotatetite.instance))
                        .setAttackDamage(4.5f)
                        .setBaseDurability(1200)

                , PotatoMain.instance);
        setModel(new SimpleToolModel(new Texture("potato_uses/items/tools/sword_of_healing.png")));
        setTab(PotatoMain.tab);
        setAttackDamage(0);

        addTranslation("en_us", "Potato Sword Of Healing");

        new WaveShapedRecipe(this,
                    new String[]{
                            " EG",
                            "PGE",
                            "SP "
                    },
                PotatoMain.instance)
                .addIngredient('G', "potato_uses:potatetite_gem")
                .addIngredient('P', "potato_uses:clockwork_potato")
                .addIngredient('E', "minecraft:emerald")
                .addIngredient('S', "minecraft:stick");

        lore = new TranslatedText("sword_of_healing.lore1", PotatoMain.instance)
                .addTranslation("en_us", "§8When used will heal you at the cost of a lot of durability.");
    }

    private static TranslatedText lore;

    @Override
    public List<Text> addToolTip(ItemStack stack) {
        return Collections.singletonList(lore);
    }

    @Override
    public ItemUseResult onUse(ItemStack item, UseHand hand, EntityPlayer player, World world) {
        if (!world.isClientSide() && player.getHealth() < player.getMaxHealth()) {
            item.damage(250, player);
            player.setHealth(player.getHealth() + 2);
        }
        if (player.getHealth() < player.getMaxHealth()) {
            return ItemUseResult.SUCCESS;
        } else {
            return ItemUseResult.PASS;
        }
    }
}
