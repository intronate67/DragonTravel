package net.huntersharpe.DragonTravel;


import co.aikar.commands.SpongeCommandManager;
import com.google.common.eventbus.Subscribe;
import net.huntersharpe.DragonTravel.handlers.DTCommandHandler;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.plugin.Plugin;


@Plugin(id="dragontravel", name="DragonTravelCommand",version="1.0-SNAPSHOT")
public class DragonTravel{

    private ConfigurationManager configManager;

    @Subscribe
    public void onGameInitEvent(GameInitializationEvent e){
        configManager = new ConfigurationManager();
        configManager.setupConfig();
        SpongeCommandManager manager = new SpongeCommandManager(Sponge.getPluginManager().getPlugin("DragonTravel")
                .get());
        manager.registerCommand(new DTCommandHandler());
    }

    private CommandSpec dtCmd = CommandSpec.builder().permission("dragontravel.dt").build();
}
