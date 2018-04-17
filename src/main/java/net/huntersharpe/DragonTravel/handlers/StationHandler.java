package net.huntersharpe.DragonTravel.handlers;

import net.huntersharpe.DragonTravel.ConfigurationManager;
import net.huntersharpe.DragonTravel.types.Station;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

public class StationHandler {
    //add station dragon
    private ConfigurationManager configManager;

    public StationHandler(){
        configManager = new ConfigurationManager();
    }

    public boolean creationStation(String id, String displayName, Location<World> location){
        if(configManager.getStationNode().getNode(id)!=null){
            return false;
        }else{
            CommentedConfigurationNode stationNode = configManager.getStationNode().getNode(id);
            stationNode.getNode(displayName).setValue(displayName);
            stationNode.getNode("x").setValue(location.getPosition().getX());
            stationNode.getNode("y").setValue(location.getPosition().getY());
            stationNode.getNode("z").setValue(location.getPosition().getZ());
            stationNode.getNode("world").setValue(location.getExtent().getName());
            return true;
        }
    }

    public Station getStation(String id){
        Station station;
        if(configManager.getStationNode().getNode(id)!=null){
            CommentedConfigurationNode stationNode = configManager.getStationNode().getNode(id);
            String displayName = stationNode.getString("displayName");
            double x = Double.parseDouble(stationNode.getString("x"));
            double y = Double.parseDouble(stationNode.getString("y"));
            double z = Double.parseDouble(stationNode.getString("z"));
            World world = Sponge.getServer().getWorld(stationNode.getString("world")).get();
            Location<World> location = new Location<>(world, x, y, z);
            station = new Station(id, displayName, location);
        }else{
            station = new Station();
        }
        return station;
    }

    public boolean deleteStation(String id){
        if(configManager.getStationNode().getNode(id)!=null){
            CommentedConfigurationNode stationNode = configManager.getStationNode().getNode(id);
            configManager.getStationNode().removeChild(stationNode);
            return true;
        }else{
            return false;
        }
    }
}
