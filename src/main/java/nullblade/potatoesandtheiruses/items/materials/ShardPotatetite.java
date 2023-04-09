package nullblade.potatoesandtheiruses.items.materials;

import nullblade.potatoesandtheiruses.PotatoMain;
import org.waveapi.api.content.items.WaveItem;
import org.waveapi.api.content.items.models.SimpleItemModel;
import org.waveapi.api.content.items.models.SimpleToolModel;
import org.waveapi.api.content.items.recipes.WaveShapedRecipe;
import org.waveapi.api.file.texture.Texture;
import org.waveapi.api.misc.Text;
import org.waveapi.api.misc.TranslatedText;
import org.waveapi.api.world.inventory.ItemStack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShardPotatetite extends WaveItem {

    public static ShardPotatetite instance;
    public ShardPotatetite() {
        super("potatetite_shard", PotatoMain.instance);
        instance = this;
        setModel(new SimpleItemModel(new Texture("potato_uses/items/materials/potatetite_shard.png")));
        setTab(PotatoMain.tab);

        addTranslation("en_us", "Potatetite Shard");
        this.lore = new TranslatedText("potatetite_shard_lore0", PotatoMain.instance)
                .addTranslation("en_us", "§8Obtained from self breaking block.");
    }
    private final TranslatedText lore;
    public List<Text> addToolTip(ItemStack stack) {
        return Collections.singletonList(lore);
    }

}
