package nullblade.potatoesandtheiruses.items.food;

import nullblade.potatoesandtheiruses.PotatoMain;
import org.waveapi.api.content.items.WaveItem;
import org.waveapi.api.content.items.models.SimpleItemModel;
import org.waveapi.api.content.items.models.SimpleToolModel;
import org.waveapi.api.content.items.recipes.WaveShapedRecipe;
import org.waveapi.api.file.texture.Texture;

public class EdibleBucket extends WaveItem {
    public EdibleBucket() {
        super("edible_bucket", PotatoMain.instance);
        setModel(new SimpleItemModel(new Texture("potato_uses/items/food/edible_bucket.png")));
        setTab(PotatoMain.tab);
        makeFood(2, 0.5f);

        addTranslation("en_us", "Edible Bucket");

        new WaveShapedRecipe(this,
                    new String[]{
                            "   ",
                            "P P",
                            " P "
                    },
                PotatoMain.instance)
                .addIngredient('P', "potato_uses:potatetite");
    }

}
