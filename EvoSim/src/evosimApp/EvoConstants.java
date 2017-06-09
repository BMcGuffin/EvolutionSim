/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evosimApp;

import evosimSources.Map;

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
    public static final int INIT_HEALTH = 5;
    public static final int INIT_ATTACK = 5;
    public static final int INIT_DEFENSE = 5;
    public static final int INIT_SPEED = 5;
    public static final double INIT_SIZE = 1.0;
    public static final int INIT_BELLY = 5;
    public static final int INIT_LIFESPAN = 5;
    public static final double INIT_GROWTH_RATE = 0.05;

    //Level caps
    public static final int CAP_HEALTH = 1000;
    public static final int CAP_ATTACK = 100;
    public static final int CAP_DEFENSE = 100;
    public static final int CAP_SPEED = 100;
    public static final double CAP_CREATURE_SIZE = 1000;
    public static final int CAP_BELLY = 500;
    public static final int CAP_LIFESPAN = 200;
    public static final double CAP_PLANT_SIZE = 5000;
    public static final double CAP_GROWTH_RATE = 0.5;

    //Map stuff
    //The map object itself, assigned in main() at runtime
    public static Map MAP;
    
    public static final int MAP_SIZE = 20;
    public static final int MAP_MAXIMUM_START_ENTITIES = (int)(MAP_SIZE * MAP_SIZE * 0.1);
    public static final int MAP_MAXIMUM_FINAL_ENTITIES = (int)(MAP_SIZE * MAP_SIZE * 0.9);

    //The global unique ID number. Each organism has one; upon assignment, this
    //is incremented.
    public static int ID = 1;
    
    //Debug
    //Whether or not to display debug statements, assigned true or false based on
    //command line arguments
    public static boolean debug;
    
    /**Displays debug statements in code only if user has opted to view them at
     * runtime.
     * 
     * @param str the string message to print to standard out
     */
    public static void debug(String str)
    {
        if(debug)
        {
            System.out.println(str);
        }
    }
    
    public static final int turnDelay = 1000;
    
}
