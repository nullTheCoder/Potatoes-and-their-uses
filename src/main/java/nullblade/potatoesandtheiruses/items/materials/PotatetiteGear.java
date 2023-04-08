package nullblade.potatoesandtheiruses.items.materials;

import nullblade.potatoesandtheiruses.PotatoMain;
import org.waveapi.api.content.items.WaveItem;
import org.waveapi.api.content.items.models.SimpleToolModel;
import org.waveapi.api.content.items.recipes.WaveShapedRecipe;
import org.waveapi.api.file.texture.Texture;

public class PotatetiteGear extends WaveItem {
    public PotatetiteGear() {
        super("potatetite_gear", PotatoMain.instance);
        setModel(new SimpleToolModel(new Texture("potato_uses/items/materials/potatetite_gear.png")));
        setTab(PotatoMain.tab);

        addTranslation("en_us", "Potatetite Gear");

        new WaveShapedRecipe(this,
                    new String[]{
                            " S ",
                            "SPS",
                            " S "
                    },
                PotatoMain.instance)
                .addIngredient('P', "potato_uses:potatetite")
                .addIngredient('S', "potato_uses:potatetite_shard")
                .setResultCount(2);
    }

}
