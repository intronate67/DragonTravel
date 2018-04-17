package net.huntersharpe.DragonTravel.handlers;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.PreCommand;
import co.aikar.commands.annotation.Subcommand;
import co.aikar.commands.annotation.Syntax;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

@CommandAlias("dt|dragontravel")
public class DTCommandHandler extends BaseCommand{

    private boolean isPlayer = false;

    private StationHandler stationHandler = new StationHandler();
    private FlightHandler flightHandler = new FlightHandler();

    @PreCommand
    public void onPreCommand(CommandSource src){
        if(!(src instanceof Player)){
            isPlayer = true;
        }
    }

    @Subcommand("create")
    @Syntax("<station|flight> <station/flight_name>")
    public void onCreateCommand(){

    }

    @Subcommand("create station")
    @Syntax("<station_name>")
    public void onCreateStationCommand(String id, String displayName, Player player){
        if(stationHandler.creationStation(id, displayName, player.getLocation())){
            player.sendMessage(Text.of("Station ", displayName, " created successfully!"));
        }else{
            player.sendMessage(Text.of("Station creation failed!"));
        }
    }

    @Subcommand("create flight")
    @Syntax("<station_name>")
    public void onCreateFlightCommand(){

    }

    @Subcommand("set")
    @Syntax("<station|flight|home> [station/flight_name]")
    public void onSetCommand(){

    }

    @Subcommand("set station")
    @Syntax("<station_name>")
    public void onSetStationCommand(){

    }

    @Subcommand("set flight")
    @Syntax("<flight_name>")
    public void onSetFlightCommand(){

    }

    @Subcommand("set home")
    public void onSetHomeCommand(){

    }

    @Subcommand("del")
    @Syntax("<station|flight|home> [station/flight_name]")
    public void onDeleteCommand(){

    }

    @Subcommand("del station")
    @Syntax("<station_name>")
    public void onDeleteStationCommand(){

    }

    @Subcommand("del flight")
    @Syntax("<flight_name>")
    public void onDeleteFlightCommand(){

    }

    @Subcommand("del home")
    public void onDeleteHomeCommand(){

    }

}
