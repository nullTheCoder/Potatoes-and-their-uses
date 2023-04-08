package nullblade.potatoesandtheiruses.items.materials;

import nullblade.potatoesandtheiruses.PotatoMain;
import org.waveapi.api.content.items.WaveItem;
import org.waveapi.api.content.items.models.SimpleToolModel;
import org.waveapi.api.content.items.recipes.WaveShapedRecipe;
import org.waveapi.api.file.texture.Texture;

public class ShardPotatetite extends WaveItem {

    public static ShardPotatetite instance;
    public ShardPotatetite() {
        super("potatetite_shard", PotatoMain.instance);
        instance = this;
        setModel(new SimpleToolModel(new Texture("potato_uses/items/materials/potatetite_shard.png")));
        setTab(PotatoMain.tab);

        addTranslation("en_us", "Potatetite Shard");
    }

}
