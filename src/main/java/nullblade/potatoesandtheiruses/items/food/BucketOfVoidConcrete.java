package nullblade.potatoesandtheiruses.items.food;

import nullblade.potatoesandtheiruses.PotatoMain;
import org.waveapi.api.file.texture.Texture;
import org.waveapi.api.items.WaveItem;
import org.waveapi.api.items.models.SimpleItemModel;
import org.waveapi.api.items.recipes.WaveShapedRecipe;

public class BucketOfVoidConcrete extends WaveItem {
    public BucketOfVoidConcrete() {
        super("bucket_of_void_concrete", PotatoMain.instance);
        setModel(new SimpleItemModel(new Texture("potato_uses/items/food/bucket_of_void_concrete.png")));
        setTab(PotatoMain.tab);
        makeFood(10, 0.5f);

        addTranslation("en_us", "Bucket of Void Concrete");

        new WaveShapedRecipe(this,
                    new String[]{
                            "BBB",
                            "BVB",
                            "BBB"
                    },
                PotatoMain.instance)
                .addIngredient('B', "potato_uses:bucket_of_concrete")
                .addIngredient('V', "potato_uses:void_potato")
                .setResultCount(2);
    }

}
