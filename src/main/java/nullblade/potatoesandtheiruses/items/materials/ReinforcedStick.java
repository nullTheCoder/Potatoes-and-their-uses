package nullblade.potatoesandtheiruses.items.materials;

import nullblade.potatoesandtheiruses.PotatoMain;
import org.waveapi.api.items.WaveItem;
import org.waveapi.api.items.models.SimpleItemModel;
import org.waveapi.api.items.models.SimpleToolModel;
import org.waveapi.api.items.recipes.WaveShapedRecipe;
import org.waveapi.api.file.texture.Texture;

public class ReinforcedStick extends WaveItem {
    public ReinforcedStick() {
        super("reinforced_stick", PotatoMain.instance);
        setModel(new SimpleItemModel(new Texture("potato_uses/items/materials/reinforced_stick.png")));
        setTab(PotatoMain.tab);

        addTranslation("en_us", "Reinforced Stick");

        new WaveShapedRecipe(this,
                    new String[]{
                            " GS",
                            "GSG",
                            "SG "
                    },
                PotatoMain.instance)
                .addIngredient('S', "minecraft:stick")
                .addIngredient('G', "potato_uses:potatetite_gem");
    }

}
