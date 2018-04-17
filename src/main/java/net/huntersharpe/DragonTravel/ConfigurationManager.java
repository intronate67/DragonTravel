package net.huntersharpe.DragonTravel;

import com.google.inject.Inject;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.spongepowered.api.config.ConfigDir;

import java.io.File;
import java.io.IOException;

public class ConfigurationManager {

    @Inject
    @ConfigDir(sharedRoot = false)
    private File configDir;

    private File homeConfig = new File(configDir + "home.conf");
    private ConfigurationLoader<CommentedConfigurationNode> homeConfigManager = HoconConfigurationLoader.builder()
            .setFile(homeConfig).build();
    private CommentedConfigurationNode homeNode;

    private File stationConfig = new File(configDir + "station.conf");
    private ConfigurationLoader<CommentedConfigurationNode> stationConfigManager = HoconConfigurationLoader.builder()
            .setFile(stationConfig).build();
    private CommentedConfigurationNode stationNode;

    private File flightConfig = new File(configDir + "flight.conf");
    private ConfigurationLoader<CommentedConfigurationNode> flightConfigManager = HoconConfigurationLoader.builder()
            .setFile(flightConfig).build();

    private CommentedConfigurationNode flightNode;


    void setupConfig(){
        if(!configDir.exists()){
            configDir.mkdir();
        }
        if(!homeConfig.exists()){
            try{
                homeConfig.createNewFile();
                homeNode = homeConfigManager.load();
                stationConfig.createNewFile();
                stationNode = stationConfigManager.load();
                flightConfig.createNewFile();
                flightNode = flightConfigManager.load();
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
        try{
            homeConfigManager.save(homeNode);
            stationConfigManager.save(stationNode);
            flightConfigManager.save(flightNode);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public CommentedConfigurationNode getHomeNode(){
        return homeNode;
    }

    public CommentedConfigurationNode getStationNode(){
        return stationNode;
    }

    public CommentedConfigurationNode getFlightNode(){
        return flightNode;
    }

}
