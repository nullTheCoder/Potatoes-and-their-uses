package nullblade.potatoesandtheiruses.items.materials;

import nullblade.potatoesandtheiruses.PotatoMain;
import org.waveapi.api.content.items.WaveItem;
import org.waveapi.api.content.items.models.SimpleToolModel;
import org.waveapi.api.content.items.recipes.WaveShapedRecipe;
import org.waveapi.api.file.texture.Texture;

public class Potatetite extends WaveItem {
    public Potatetite() {
        super("potatetite", PotatoMain.instance);
        setModel(new SimpleToolModel(new Texture("potato_uses/items/materials/potatetite.png")));
        setTab(PotatoMain.tab);

        addTranslation("en_us", "Potatetite");

        new WaveShapedRecipe(this,
                    new String[]{
                            "PGP",
                            "IPI",
                            "PGP"
                    },
                PotatoMain.instance)
                .addIngredient('P', "minecraft:potato")
                .addIngredient('G', "minecraft:gold_nugget")
                .addIngredient('I', "minecraft:iron_nugget")
                .setResultCount(4);
    }

}
