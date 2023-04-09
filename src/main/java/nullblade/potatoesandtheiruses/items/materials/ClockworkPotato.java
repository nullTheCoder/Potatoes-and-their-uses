package nullblade.potatoesandtheiruses.items.materials;

import nullblade.potatoesandtheiruses.PotatoMain;
import org.waveapi.api.content.items.WaveItem;
import org.waveapi.api.content.items.models.SimpleItemModel;
import org.waveapi.api.content.items.models.SimpleToolModel;
import org.waveapi.api.content.items.recipes.WaveShapedRecipe;
import org.waveapi.api.file.texture.Texture;

public class ClockworkPotato extends WaveItem {
    public ClockworkPotato() {
        super("clockwork_potato", PotatoMain.instance);
        setModel(new SimpleItemModel(new Texture("potato_uses/items/materials/clockwork_potato.png")));
        setTab(PotatoMain.tab);

        addTranslation("en_us", "Clockwork Potato");

        new WaveShapedRecipe(this,
                    new String[]{
                            "G..",
                            "P#P",
                            "..G"
                    },
                PotatoMain.instance)
                .addIngredient('G', "potato_uses:potatetite_gem")
                .addIngredient('P', "potato_uses:potatetite_gear")
                .addIngredient('#', "minecraft:baked_potato")
                .addIngredient('.', "minecraft:redstone");
    }

}
