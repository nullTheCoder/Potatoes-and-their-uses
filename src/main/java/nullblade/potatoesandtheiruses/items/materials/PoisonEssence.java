package nullblade.potatoesandtheiruses.items.materials;

import nullblade.potatoesandtheiruses.PotatoMain;
import org.waveapi.api.content.items.WaveItem;
import org.waveapi.api.content.items.models.SimpleToolModel;
import org.waveapi.api.content.items.recipes.WaveShapedRecipe;
import org.waveapi.api.file.texture.Texture;

public class PoisonEssence extends WaveItem {
    public PoisonEssence() {
        super("poison_essence", PotatoMain.instance);
        setModel(new SimpleToolModel(new Texture("potato_uses/items/materials/poison_essence.png")));
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
