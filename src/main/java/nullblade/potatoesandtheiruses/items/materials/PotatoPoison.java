package nullblade.potatoesandtheiruses.items.materials;

import nullblade.potatoesandtheiruses.PotatoMain;
import org.waveapi.api.content.items.WaveItem;
import org.waveapi.api.content.items.models.SimpleToolModel;
import org.waveapi.api.content.items.recipes.WaveShapedRecipe;
import org.waveapi.api.file.texture.Texture;
import org.waveapi.api.misc.Text;
import org.waveapi.api.misc.TranslatedText;
import org.waveapi.api.world.inventory.ItemStack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PotatoPoison extends WaveItem {

    public static PotatoPoison instance;

    public PotatoPoison() {
        super("potato_poison", PotatoMain.instance);
        instance = this;
        setModel(new SimpleToolModel(new Texture("potato_uses/items/materials/potato_poison.png")));
        setTab(PotatoMain.tab);

        addTranslation("en_us", "Potato Poison");

        this.lore = new TranslatedText("potato_poison_lore0", PotatoMain.instance)
                .addTranslation("en_us", "§8Obtained from poison splitter.");
    }
    private final TranslatedText lore;
    public List<Text> addToolTip(ItemStack stack) {
        return Collections.singletonList(lore);
    }

}
