/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evosim;

/**
 * Represents an animal. Creatures are living things that move and eat other
 * things. This is a superclass for different types of creatures, which are
 * separated based on what they eat.
 *
 * @author bryanmcguffin
 * @version 5-10-17
 * @see Organism
 * @see Mobile
 */
public class Creature implements Organism, Mobile
{

    /**
     * Creates a new creature from existing parameters.
     *
     * @param health
     * @param attack
     * @param defense
     * @param speed
     * @param size
     * @param belly the amount of food the creature can eat before it's full
     * @param lifespan the amount of turns the creature can live
     */
    public Creature(int health, int attack, int defense, int speed, int size,
            int belly, int lifespan)
    {
        this.hp = health;
        this.at = attack;
        this.de = defense;
        this.sp = speed;
        this.size = size;
        this.belly = belly;
        this.fullness = belly;
        this.age = 0;
        this.lifetime = lifespan;

    }

    /**
     * Checks if the creature is an "adult" or just a child.
     *
     * @return true if the creature's age is more than 50% of its lifespan.
     */
    @Override
    public boolean isMature()
    {
        return (double) age / lifetime > 0.5;
    }

    /**
     * Checks if the creature meets the requirements to stay alive.
     *
     * @return true if the creature is not too old, hungry, or weak.
     */
    @Override
    public boolean isAlive()
    {
        return age <= lifetime && fullness > 0 && hp > 0;
    }

    /**
     * Grows the creature by incrementing its age.
     *
     */
    @Override
    public void grow()
    {
        age++;
    }

    /**
     * Generates a new creature from two parents.
     *
     * @param other the other creature to mate with this one.
     * @return a new creature with traits that are the average of its parents,
     * OR null if both parents are not creatures.
     */
    @Override
    public Organism reproduce(Organism other)
    {
        if (other instanceof Creature)
        {
            Creature co = (Creature) other;
            int newHP = (this.hp + co.getHP()) / 2;
            int newAtt = (this.at + co.getAttack()) / 2;
            int newDef = (this.at + co.getDefense()) / 2;
            int newSpd = (this.at + co.getSpeed()) / 2;
            int newSz = (this.at + co.getSize()) / 2;
            int newBl = (this.at + co.getBelly()) / 2;
            int newLife = (this.at + co.getLifetime()) / 2;
            return new Creature(newHP, newAtt, newDef, newSpd, newSz, newBl, newLife);
        }
        return null;
    }

    /**Move the creature some distance away from its present location.
     * Checks to make sure that the intended destination exists, and is within
     * the creature's range of motion, and is not blocked by some entity.
     * 
     * @param x Number of spaces away in the x direction to move.
     * @param y Number of spaces away in the y direction to move.
     * @param grid 2D grid that makes up the world.
     */
    @Override
    public void move(int x, int y, Object[][] grid)
    {
        if (currentX + x < grid.length && currentY + y < grid[currentX + x].length)
        {
            if (x <= sp && y <= sp && grid[currentX + x][currentY + y] == null)
            {
                grid[currentX + x][currentY + y] = this;
                grid[currentX][currentY] = null;
                currentX = currentX + x;
                currentY = currentY + y;
            }
        }
    }

    /**
     * 
     * @return the creature's attack stat.
     */
    public int getAttack()
    {
        return at;
    }

    /**
     * 
     * @return the creature's defense stat.
     */
    public int getDefense()
    {
        return de;
    }

    /**
     * 
     * @return the creature's speed stat.
     */
    public int getSpeed()
    {
        return sp;
    }

    /**
     * 
     * @return the creature's stomach capacity.
     */
    public int getBelly()
    {
        return belly;
    }

    /**
     * 
     * @return the creature's lifespan.
     */
    public int getLifetime()
    {
        return lifetime;
    }

    /**
     * 
     * @return the creature's health.
     */
    public int getHP()
    {
        return hp;
    }

    /**
     * 
     * @return the creature's size.
     */
    public int getSize()
    {
        return size;
    }

    private int hp;
    private int at;
    private int de;
    private int sp;
    private int size;
    private final int belly;
    private int fullness;
    private final int lifetime;
    private int age;

    private int currentX;
    private int currentY;

    @Override
    public void damage(int amount)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
