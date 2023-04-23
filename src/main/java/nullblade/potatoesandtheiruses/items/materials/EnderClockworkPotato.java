package nullblade.potatoesandtheiruses.items.materials;

import nullblade.potatoesandtheiruses.PotatoMain;
import org.waveapi.api.items.WaveItem;
import org.waveapi.api.items.models.SimpleItemModel;
import org.waveapi.api.items.models.SimpleToolModel;
import org.waveapi.api.items.recipes.WaveShapedRecipe;
import org.waveapi.api.file.texture.Texture;

public class EnderClockworkPotato extends WaveItem {
    public EnderClockworkPotato() {
        super("ender_clockwork_potato", PotatoMain.instance);
        setModel(new SimpleItemModel(new Texture("potato_uses/items/materials/ender_potato.png")));
        setTab(PotatoMain.tab);

        addTranslation("en_us", "Ender Clockwork Potato");

        new WaveShapedRecipe(this,
                    new String[]{
                            ".E.",
                            "E#E",
                            ".E."
                    },
                PotatoMain.instance)
                .addIngredient('#', "potato_uses:clockwork_potato")
                .addIngredient('E', "minecraft:ender_pearl")
                .addIngredient('.', "minecraft:blaze_powder");
    }

}
