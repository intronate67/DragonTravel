package net.huntersharpe.DragonTravel.types;

import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

public class Station {

    private String id;
    private String displayName;
    private Location<World> location;

    public Station(String id, String displayName, Location<World> location){
        this.id = id;
        this.displayName = displayName;
        this.location = location;
    }

    public Station(){
        this.id = "null";
        this.displayName = "null";
        location = null;
    }

    public String getId(){
        return id;
    }

    public String getDisplayName(){
        return displayName;
    }

    public Location<World> getLocation(){
        return location;
    }

    public void setLocation(Location<World> newLocation){
        location = newLocation;
    }

}
