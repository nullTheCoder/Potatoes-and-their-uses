package nullblade.potatoesandtheiruses.items.food;

import nullblade.potatoesandtheiruses.PotatoMain;
import org.waveapi.api.items.WaveItem;
import org.waveapi.api.items.models.SimpleItemModel;
import org.waveapi.api.items.models.SimpleToolModel;
import org.waveapi.api.items.recipes.WaveShapedRecipe;
import org.waveapi.api.file.texture.Texture;

public class BucketOfConcrete extends WaveItem {
    public BucketOfConcrete() {
        super("bucket_of_concrete", PotatoMain.instance);
        setModel(new SimpleItemModel(new Texture("potato_uses/items/food/bucket_of_concrete.png")));
        setTab(PotatoMain.tab);
        makeFood(4, 0.5f);

        addTranslation("en_us", "Bucket of Concrete");

        new WaveShapedRecipe(this,
                    new String[]{
                            "GGS",
                            "GSS",
                            " B "
                    },
                PotatoMain.instance)
                .addIngredient('B', "potato_uses:edible_bucket")
                .addIngredient('S', "minecraft:sand")
                .addIngredient('G', "minecraft:gravel");
    }

}
