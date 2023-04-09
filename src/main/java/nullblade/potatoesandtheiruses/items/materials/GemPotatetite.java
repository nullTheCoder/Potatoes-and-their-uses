package nullblade.potatoesandtheiruses.items.materials;

import nullblade.potatoesandtheiruses.PotatoMain;
import org.waveapi.api.content.items.WaveItem;
import org.waveapi.api.content.items.models.SimpleItemModel;
import org.waveapi.api.content.items.models.SimpleToolModel;
import org.waveapi.api.content.items.recipes.WaveShapedRecipe;
import org.waveapi.api.content.tags.Tags;
import org.waveapi.api.file.texture.Texture;

public class GemPotatetite extends WaveItem {

    public static GemPotatetite instance;

    public GemPotatetite() {
        super("potatetite_gem", PotatoMain.instance);
        instance = this;
        setModel(new SimpleItemModel(new Texture("potato_uses/items/materials/potatetite_gem.png")));
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
                .addIngredient('E', "minecraft:poisonous_potato")
                .setResultCount(2);

        tag(Tags.GEM);

    }

}
