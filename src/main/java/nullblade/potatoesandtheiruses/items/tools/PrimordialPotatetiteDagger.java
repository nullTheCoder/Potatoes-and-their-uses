package nullblade.potatoesandtheiruses.items.tools;

import nullblade.potatoesandtheiruses.PotatoMain;
import nullblade.potatoesandtheiruses.items.materials.GemPotatetite;
import org.waveapi.api.items.Rarity;
import org.waveapi.api.items.models.SimpleToolModel;
import org.waveapi.api.items.recipes.WaveShapedRecipe;
import org.waveapi.api.items.recipes.ingredients.SimpleItemIngredient;
import org.waveapi.api.items.tools.WaveSwordItem;
import org.waveapi.api.items.tools.WaveToolMaterial;
import org.waveapi.api.file.texture.Texture;

public class PrimordialPotatetiteDagger extends WaveSwordItem {
    public PrimordialPotatetiteDagger() {
        super("primordial_potatetite_dagger",
                new WaveToolMaterial()
                    .setRepairIngredient(new SimpleItemIngredient(GemPotatetite.instance))
                        .setAttackDamage(2.0f)
                        .setBaseDurability(700)
                , PotatoMain.instance);
        setModel(new SimpleToolModel(new Texture("potato_uses/items/tools/primordial_potatetite_dagger.png")));
        setTab(PotatoMain.tab);
        setAttackDamage(0);
        setAttackSpeed(0f);

        setRarity(Rarity.EPIC);
        addTranslation("en_us", "Primordial Potatetite Dagger");

        new WaveShapedRecipe(this,
                    new String[]{
                            " P",
                            "S "
                    },
                PotatoMain.instance)
                .addIngredient('P', "potato_uses:primordial_potato")
                .addIngredient('S', "potato_uses:potatetite_dagger");


    }

}
