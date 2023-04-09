package nullblade.potatoesandtheiruses.items.materials;

import nullblade.potatoesandtheiruses.PotatoMain;
import org.waveapi.api.content.items.WaveItem;
import org.waveapi.api.content.items.models.SimpleItemModel;
import org.waveapi.api.content.items.models.SimpleToolModel;
import org.waveapi.api.content.items.recipes.WaveShapedRecipe;
import org.waveapi.api.content.tags.Tags;
import org.waveapi.api.file.texture.Texture;

public class MagicalLens extends WaveItem {

    public static MagicalLens instance;

    public MagicalLens() {
        super("magic_lens", PotatoMain.instance);
        instance = this;
        setModel(new SimpleItemModel(new Texture("potato_uses/items/materials/magical_lens.png")));
        setTab(PotatoMain.tab);

        addTranslation("en_us", "Magical Lens");

        new WaveShapedRecipe(this,
                    new String[]{
                            "G G",
                            " P ",
                            "G G"
                    },
                PotatoMain.instance)
                .addIngredient('P', "potato_uses:poison_essence")
                .addIngredient('G', "minecraft:gold_nugget");
    }

}
