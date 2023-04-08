package nullblade.potatoesandtheiruses.items.materials;

import nullblade.potatoesandtheiruses.PotatoMain;
import org.waveapi.api.content.items.WaveItem;
import org.waveapi.api.content.items.models.SimpleToolModel;
import org.waveapi.api.content.items.recipes.WaveShapedRecipe;
import org.waveapi.api.file.texture.Texture;

public class GemPotatetite extends WaveItem {
    public GemPotatetite() {
        super("potatetite_gem", PotatoMain.instance);
        setModel(new SimpleToolModel(new Texture("potato_uses/items/materials/potatetite_gem.png")));
        setTab(PotatoMain.tab);

        addTranslation("en_us", "Potatetite Gem");

        new WaveShapedRecipe(this,
                    new String[]{
                            "PGP",
                            "GEG",
                            "PGP"
                    },
                PotatoMain.instance)
                .addIngredient('P', "potato_uses:potatetite")
                .addIngredient('G', "minecraft:gold_ingot")
                .addIngredient('E', "minecraft:emerald")
                .setResultCount(2);
    }

}
