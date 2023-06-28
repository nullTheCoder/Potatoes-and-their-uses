package nullblade.potatoesandtheiruses;

import nullblade.potatoesandtheiruses.items.block.*;
import nullblade.potatoesandtheiruses.items.food.BucketOfConcrete;
import nullblade.potatoesandtheiruses.items.food.BucketOfVoidConcrete;
import nullblade.potatoesandtheiruses.items.food.EdibleBucket;
import nullblade.potatoesandtheiruses.items.fun.Blok;
import nullblade.potatoesandtheiruses.items.materials.*;
import nullblade.potatoesandtheiruses.items.tools.*;
import org.waveapi.api.Logger;
import org.waveapi.api.WaveMod;
import org.waveapi.api.items.WaveTab;

public class PotatoMain extends WaveMod {

    public static PotatoMain instance;
    public static Logger LOGGER;

    public static WaveTab tab;
    public PotatoMain() {
        super();
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
        new VoidPotato();
        new PrimordialPotatoShard();
        new PrimordialPotato();

        new PotatetiteBlock();
        new SelfBreakingBlock();
        new SelfBreakingPlacer();
        new PoisonSplitter();
        new Poisoner();
        new EnderBlock();
        new VoidPotatoMiner();
        new VoidPotatoSieve();
        new PotatoBeacon();

        new PotatoBeaconProbe();
        new WarpCore();
        new TeleportStick();
        new AdvancedTeleportStick();
        new PrimordialTeleportStick();
        new SwordOfHealing();
        new PotatetiteDagger();
        new PrimordialPotatetiteDagger();

        new EdibleBucket();
        new BucketOfConcrete();
        new BucketOfVoidConcrete();

        new Blok();

    }
}
