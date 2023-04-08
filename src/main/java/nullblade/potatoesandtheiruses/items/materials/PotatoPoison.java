package nullblade.potatoesandtheiruses.items.materials;

import nullblade.potatoesandtheiruses.PotatoMain;
import org.waveapi.api.content.items.WaveItem;
import org.waveapi.api.content.items.models.SimpleToolModel;
import org.waveapi.api.content.items.recipes.WaveShapedRecipe;
import org.waveapi.api.file.texture.Texture;

public class PotatoPoison extends WaveItem {

    public static PotatoPoison instance;
    public PotatoPoison() {
        super("potato_poison", PotatoMain.instance);
        instance = this;
        setModel(new SimpleToolModel(new Texture("potato_uses/items/materials/potato_poison.png")));
        setTab(PotatoMain.tab);

        addTranslation("en_us", "Potato Poison");
    }

}
