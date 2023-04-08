package nullblade.potatoesandtheiruses.items.materials;

import nullblade.potatoesandtheiruses.PotatoMain;
import org.waveapi.api.content.items.WaveItem;
import org.waveapi.api.content.items.models.SimpleToolModel;
import org.waveapi.api.content.items.recipes.WaveShapedRecipe;
import org.waveapi.api.file.texture.Texture;

public class EnderClockworkPotato extends WaveItem {
    public EnderClockworkPotato() {
        super("ender_clockwork_potato", PotatoMain.instance);
        setModel(new SimpleToolModel(new Texture("potato_uses/items/materials/ender_potato.png")));
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
