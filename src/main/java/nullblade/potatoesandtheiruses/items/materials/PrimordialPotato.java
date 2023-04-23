package nullblade.potatoesandtheiruses.items.materials;

import nullblade.potatoesandtheiruses.PotatoMain;
import org.waveapi.api.items.Rarity;
import org.waveapi.api.items.WaveItem;
import org.waveapi.api.items.models.SimpleItemModel;
import org.waveapi.api.items.recipes.WaveShapedRecipe;
import org.waveapi.api.items.tags.Tags;
import org.waveapi.api.file.texture.Texture;

public class PrimordialPotato extends WaveItem {
    public static WaveItem instance;

    public PrimordialPotato() {
        super("primordial_potato", PotatoMain.instance);
        instance = this;
        setModel(new SimpleItemModel(new Texture("potato_uses/items/materials/primordial_potato.png")));
        setTab(PotatoMain.tab);

        makeFood(20, 1.0f);

        addTranslation("en_us", "Primordial Potato");
        setRarity(Rarity.EPIC);

        new WaveShapedRecipe(this,
                    new String[]{
                            "SSS",
                            "S#S",
                            "SSS"
                    },
                PotatoMain.instance)
                .addIngredient('S', "potato_uses:primordial_potato_shard")
                .addIngredient('#', "minecraft:nether_star");

    }

}
