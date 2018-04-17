package net.huntersharpe.DragonTravel.handlers;

import com.flowpowered.math.vector.Vector3d;
import net.huntersharpe.DragonTravel.ConfigurationManager;
import net.huntersharpe.DragonTravel.types.Flight;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.ArrayList;
import java.util.List;

public class FlightHandler {

    private ConfigurationManager configManager;

    public FlightHandler(){
        configManager = new ConfigurationManager();
    }

    public boolean createFlight(String id, String displayName, Location<World> location){
        if(configManager.getFlightNode().getNode(id)!=null){
            CommentedConfigurationNode flightNode = configManager.getFlightNode().getNode(id);
            flightNode.getNode("world").setValue(location.getExtent().getName());
            flightNode.getNode("displayName").setValue(displayName);
            flightNode.getNode("waypoints", "1", "x").setValue(location.getPosition().getX());
            flightNode.getNode("waypoints", "1", "y").setValue(location.getPosition().getY());
            flightNode.getNode("waypoints", "1", "z").setValue(location.getPosition().getZ());
            return true;
        }else{
            return false;
        }
    }

    public Flight getFlight(String id){
        Flight flight;
        if(configManager.getFlightNode().getNode(id)!=null){
            CommentedConfigurationNode flightNode = configManager.getStationNode().getNode(id);
            String displayName = flightNode.getString("displayName");
            List<Vector3d> waypoints = new ArrayList<>();
            String world = flightNode.getNode("waypoints").getNode("1").getString("world");
            for(CommentedConfigurationNode node : flightNode.getNode("waypoints").getChildrenList()){
                double x = Double.parseDouble(node.getString("x"));
                double y = Double.parseDouble(node.getString("y"));
                double z = Double.parseDouble(node.getString("z"));
                Vector3d pos = new Vector3d(x, y, z);
                waypoints.add(pos);
            }
            flight = new Flight(id, displayName, world, waypoints);
        }else{
            flight = new Flight();
        }
        return flight;
    }

    public boolean deleteFlight(String id){
        if(configManager.getFlightNode().getNode(id)!=null){
            CommentedConfigurationNode flightNode = configManager.getFlightNode().getNode(id);
            configManager.getFlightNode().removeChild(flightNode);
            return true;
        }else{
            return false;
        }
    }

    public boolean addWaypoint(String id, Vector3d pos){
        if(configManager.getFlightNode().getNode(id)!=null){
            String waypointIndex = String.valueOf(configManager.getFlightNode().getNode(id, "waypoints")
                    .getChildrenList().size() + 1);
            configManager.getFlightNode().getNode(id, "waypoints", waypointIndex, "x").setValue(pos.getX());
            configManager.getFlightNode().getNode(id, "waypoints", waypointIndex, "y").setValue(pos.getY());
            configManager.getFlightNode().getNode(id, "waypoints", waypointIndex, "z").setValue(pos.getZ());
            return true;
        }else{
            return false;
        }
    }

    //Delete most recent waypoint
    public boolean deleteWaypoint(String id){
        if(configManager.getFlightNode().getNode(id)!=null){
            String waypointIndex = String.valueOf(configManager.getFlightNode().getNode(id, "waypoints")
                    .getChildrenList().size());
            configManager.getFlightNode().getNode(id, "waypoints").removeChild(waypointIndex);
            return true;
        }else{
            return false;
        }
    }

}
