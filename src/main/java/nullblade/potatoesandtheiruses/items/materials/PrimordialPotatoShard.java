package nullblade.potatoesandtheiruses.items.materials;

import nullblade.potatoesandtheiruses.PotatoMain;
import org.waveapi.api.content.items.Rarity;
import org.waveapi.api.content.items.WaveItem;
import org.waveapi.api.content.items.models.SimpleItemModel;
import org.waveapi.api.file.texture.Texture;
import org.waveapi.api.misc.Text;
import org.waveapi.api.misc.TranslatedText;
import org.waveapi.api.world.inventory.ItemStack;

import java.util.Collections;
import java.util.List;

public class PrimordialPotatoShard extends WaveItem {

    public static PrimordialPotatoShard instance;
    public PrimordialPotatoShard() {
        super("primordial_potato_shard", PotatoMain.instance);
        instance = this;
        setModel(new SimpleItemModel(new Texture("potato_uses/items/materials/primordial_potato_shard.png")));
        setTab(PotatoMain.tab);
        setRarity(Rarity.UNCOMMON);
        makeFood(1, 1.0f);


        addTranslation("en_us", "Primordial Potato Shard");
        this.lore = new TranslatedText("primordial_potato_shard_lore0", PotatoMain.instance)
                .addTranslation("en_us", "§8Obtained from Potato Beacon.");
    }
    private final TranslatedText lore;
    public List<Text> addToolTip(ItemStack stack) {
        return Collections.singletonList(lore);
    }

}
