package net.huntersharpe.DragonTravel.types;

import com.flowpowered.math.vector.Vector3d;

import java.util.List;

public class Flight {

    private String id;
    private String displayName;
    private String world;
    private List<Vector3d> waypoints;

    public Flight(String id, String displayName, String world, List<Vector3d> waypoints){
        this.id = id;
        this.displayName = displayName;
        this.world = world;
        this.waypoints = waypoints;
    }

    public Flight(){
        this.id = "null";
        this.displayName = "null";
        this.world = "null";
        this.waypoints = null;
    }

    public String getId(){
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getWorld() {
        return world;
    }

    public List<Vector3d> getWaypoints() {
        return waypoints;
    }

    public void addWaypoint(Vector3d location){
        waypoints.add(location);
    }

    public void setStart(Vector3d startLocation){
        waypoints.set(0, startLocation);
    }
}
