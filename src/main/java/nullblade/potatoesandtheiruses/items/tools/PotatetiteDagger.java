package nullblade.potatoesandtheiruses.items.tools;

import nullblade.potatoesandtheiruses.PotatoMain;
import nullblade.potatoesandtheiruses.items.materials.GemPotatetite;
import org.waveapi.api.items.models.SimpleToolModel;
import org.waveapi.api.items.recipes.WaveShapedRecipe;
import org.waveapi.api.items.recipes.ingredients.SimpleItemIngredient;
import org.waveapi.api.items.tools.WaveSwordItem;
import org.waveapi.api.items.tools.WaveToolMaterial;
import org.waveapi.api.file.texture.Texture;

public class PotatetiteDagger extends WaveSwordItem {
    public PotatetiteDagger() {
        super("potatetite_dagger",
                new WaveToolMaterial()
                    .setRepairIngredient(new SimpleItemIngredient(GemPotatetite.instance))
                        .setAttackDamage(1.5f)
                        .setBaseDurability(700)
                        .setEnchantability(1)
                , PotatoMain.instance);
        setModel(new SimpleToolModel(new Texture("potato_uses/items/tools/potatetite_dagger.png")));
        setTab(PotatoMain.tab);
        setAttackDamage(0);
        setAttackSpeed(-1.0f);

        addTranslation("en_us", "Potatetite Dagger");

        new WaveShapedRecipe(this,
                    new String[]{
                            " P",
                            "S "
                    },
                PotatoMain.instance)
                .addIngredient('P', "potato_uses:potatetite")
                .addIngredient('S', "minecraft:stick");


    }

}
