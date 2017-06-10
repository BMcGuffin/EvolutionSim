/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evosimApp;

import evosimSources.Map;
import java.util.Properties;

/**
 * This class holds constants for other classes. These values should be
 * considered universal, global variables and (except where noted) do not change
 * during runtime. Altering these variables is likely to significantly alter
 * performance and should be considered carefully.
 *
 * @author Bryan McGuffin
 * @version 5-15-17
 */
public final class EvoConstants
{

    //Initializer values for creatures
    public static int INIT_HEALTH;
    public static int INIT_ATTACK;
    public static int INIT_DEFENSE;
    public static int INIT_SPEED;
    public static double INIT_SIZE;
    public static int INIT_BELLY;
    public static int INIT_LIFESPAN;
    public static double INIT_GROWTH_RATE;

    //Level caps
    public static int CAP_HEALTH;
    public static int CAP_ATTACK;
    public static int CAP_DEFENSE;
    public static int CAP_SPEED;
    public static double CAP_CREATURE_SIZE;
    public static int CAP_BELLY;
    public static int CAP_LIFESPAN;
    public static double CAP_PLANT_SIZE;
    public static double CAP_GROWTH_RATE;

    //Map stuff
    //The map object itself, assigned in main() at runtime
    public static Map MAP;

    public static int MAP_SIZE;
    public static int MAP_MAXIMUM_START_ENTITIES;
    public static int MAP_MAXIMUM_FINAL_ENTITIES;

    //The global unique ID number. Each organism has one; upon assignment, this
    //is incremented.
    public static int ID = 1;

    //Debug
    //Whether or not to display debug statements, assigned true or false based on
    //command line arguments
    public static boolean debug;
    
    public static boolean FOREVER;

    /**
     * Displays debug statements in code only if user has opted to view them at
     * runtime.
     *
     * @param str the string message to print to standard out
     */
    public static void debug(String str)
    {
        if (debug)
        {
            System.out.println(str);
        }
    }

    /**
     * Load global constants from properties file.
     *
     * @param p the properties object which holds data from the properties file
     */
    public static void loadConstants(Properties p)
    {
        TURN_DELAY = Integer.parseInt(p.getProperty("turn_delay_in_ms"));
        
        MAP_SIZE = Integer.parseInt(p.getProperty("map_size"));
        MAP_MAXIMUM_START_ENTITIES = (int) (MAP_SIZE * MAP_SIZE * 0.1);
        MAP_MAXIMUM_FINAL_ENTITIES = (int) (MAP_SIZE * MAP_SIZE * 0.9);
        
        INIT_HEALTH = Integer.parseInt(p.getProperty("init_health"));
        INIT_ATTACK = Integer.parseInt(p.getProperty("init_attack"));
        INIT_DEFENSE = Integer.parseInt(p.getProperty("init_defense"));
        INIT_SPEED = Integer.parseInt(p.getProperty("init_speed"));
        INIT_SIZE = Double.parseDouble(p.getProperty("init_size"));
        INIT_BELLY = Integer.parseInt(p.getProperty("init_belly_size"));
        INIT_LIFESPAN = Integer.parseInt(p.getProperty("init_lifespan"));
        INIT_GROWTH_RATE = Double.parseDouble(p.getProperty("init_growth_rate"));
        
        CAP_HEALTH = Integer.parseInt(p.getProperty("cap_health"));
        CAP_ATTACK = Integer.parseInt(p.getProperty("cap_attack"));
        CAP_DEFENSE = Integer.parseInt(p.getProperty("cap_defense"));
        CAP_SPEED = Integer.parseInt(p.getProperty("cap_speed"));
        CAP_CREATURE_SIZE = Double.parseDouble(p.getProperty("cap_size"));
        CAP_PLANT_SIZE = Double.parseDouble(p.getProperty("cap_plant_size"));
        CAP_BELLY = Integer.parseInt(p.getProperty("cap_belly_size"));
        CAP_LIFESPAN = Integer.parseInt(p.getProperty("cap_lifespan"));
        CAP_GROWTH_RATE = Double.parseDouble(p.getProperty("cap_growth_rate"));
        
        FOREVER = (Integer.parseInt(p.getProperty("forever"))) != 0;
    }
    public static int TURN_DELAY;
}
