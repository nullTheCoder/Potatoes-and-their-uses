package nullblade.potatoesandtheiruses;

import nullblade.potatoesandtheiruses.items.block.PoisonSplitter;
import nullblade.potatoesandtheiruses.items.block.Poisoner;
import nullblade.potatoesandtheiruses.items.block.SelfBreakingBlock;
import nullblade.potatoesandtheiruses.items.block.SelfBreakingPlacer;
import nullblade.potatoesandtheiruses.items.food.BucketOfConcrete;
import nullblade.potatoesandtheiruses.items.food.EdibleBucket;
import nullblade.potatoesandtheiruses.items.fun.Blok;
import nullblade.potatoesandtheiruses.items.materials.*;
import nullblade.potatoesandtheiruses.items.tools.AdvancedTeleportStick;
import nullblade.potatoesandtheiruses.items.tools.SwordOfHealing;
import nullblade.potatoesandtheiruses.items.tools.TeleportStick;
import nullblade.potatoesandtheiruses.items.tools.WarpCore;
import org.waveapi.api.Logger;
import org.waveapi.api.WaveMod;
import org.waveapi.api.content.items.WaveTab;

public class PotatoMain extends WaveMod {

    public static PotatoMain instance;
    public static Logger LOGGER;

    public static WaveTab tab;
    public PotatoMain() {
        super("potato_uses", "0.1");
        instance = this;
    }

    @Override
    public void init() {
        LOGGER = new Logger(this);
        LOGGER.log("Getting ready to farm potatoes!");

        tab = new WaveTab("main", "potato_uses/items/materials/potatetite.png", this)
                .addTranslation("en_us", "Potatoes (and their uses!)");


        new Potatetite();
        new GemPotatetite();
        new ShardPotatetite();
        new PotatoPoison();
        new PotatetiteGear();
        new ClockworkPotato();
        new EnderClockworkPotato();
        new ReinforcedStick();
        new PoisonEssence();
        new MagicalLens();

        new SelfBreakingBlock();
        new SelfBreakingPlacer();
        new PoisonSplitter();
        new Poisoner();

        new WarpCore();
        new TeleportStick();
        new AdvancedTeleportStick();
        new SwordOfHealing();

        new EdibleBucket();
        new BucketOfConcrete();

        new Blok();

    }
}
