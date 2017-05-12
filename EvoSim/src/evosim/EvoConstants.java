/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evosim;

/**This class holds constants for other classes.
 *
 * @author bryanmcguffin
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
    public static final int MAP_SIZE = 20;
    public static final int MAP_MAXIMUM_ENTITIES = MAP_SIZE*MAP_SIZE;
}
