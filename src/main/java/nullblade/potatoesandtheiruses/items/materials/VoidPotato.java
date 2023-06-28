package nullblade.potatoesandtheiruses.items.materials;

import nullblade.potatoesandtheiruses.PotatoMain;
import org.waveapi.api.file.texture.Texture;
import org.waveapi.api.items.Rarity;
import org.waveapi.api.items.WaveItem;
import org.waveapi.api.items.models.SimpleItemModel;
import org.waveapi.api.items.recipes.WaveShapedRecipe;

public class VoidPotato extends WaveItem {
    public static WaveItem instance;

    public VoidPotato() {
        super("void_potato", PotatoMain.instance);
        instance = this;
        setModel(new SimpleItemModel(new Texture("potato_uses/items/materials/void_potato.png")));
        setTab(PotatoMain.tab);

        makeFood(1, 1.0f);

        addTranslation("en_us", "Void Potato");
        setRarity(Rarity.UNCOMMON);

    }

}
