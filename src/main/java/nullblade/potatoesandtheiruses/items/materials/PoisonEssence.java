package nullblade.potatoesandtheiruses.items.materials;

import nullblade.potatoesandtheiruses.PotatoMain;
import org.waveapi.api.items.WaveItem;
import org.waveapi.api.items.models.SimpleItemModel;
import org.waveapi.api.items.models.SimpleToolModel;
import org.waveapi.api.items.recipes.WaveShapedRecipe;
import org.waveapi.api.file.texture.Texture;

public class PoisonEssence extends WaveItem {
    public PoisonEssence() {
        super("poison_essence", PotatoMain.instance);
        setModel(new SimpleItemModel(new Texture("potato_uses/items/materials/poison_essence.png")));
        setTab(PotatoMain.tab);

        addTranslation("en_us", "Poison Essence");

        new WaveShapedRecipe(this,
                    new String[]{
                            " P ",
                            "P.P",
                            " P "
                    },
                PotatoMain.instance)
                .addIngredient('P', "potato_uses:potato_poison")
                .addIngredient('.', "minecraft:gold_nugget");
    }

}
