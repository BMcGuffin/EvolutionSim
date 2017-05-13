/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evosim;

/**
 * Represents a plant. Plants do not eat other organisms, and do not move. They
 * can bloom and spread.
 *
 * @author bryanmcguffin
 * @version 5-10-17
 * @see Organism
 */
public class Plant implements Organism
{

    /**
     * Creates a new plant from scratch. Initializers found in EvoConstants.
     */
    public Plant()
    {
        blooming = false;
        grown = false;
        age = 0;
        size = EvoConstants.INIT_SIZE;
        this.lifetime = EvoConstants.INIT_LIFESPAN;
        this.growthRate = EvoConstants.INIT_GROWTH_RATE;
        alreadySet = false;
        this.ID = EvoConstants.ID++;
    }

    /**
     * Creates a new plant from the given parameters.
     *
     * @param lifespan the amount of turns the plant can live.
     * @param gRate the percentage that the plant can increase in size per turn.
     */
    public Plant(int lifespan, double gRate)
    {
        blooming = false;
        grown = false;
        age = 0;
        size = EvoConstants.INIT_SIZE;
        this.lifetime = lifespan;
        this.growthRate = gRate;
        alreadySet = false;
        this.ID = EvoConstants.ID++;
    }

    /**
     * Checks if the plant is mature enough to reproduce.
     *
     * @return true if the plant is grown.
     */
    @Override
    public boolean isMature()
    {
        return grown;
    }

    /**
     * Increments the age and size of the plant. If age and size are high
     * enough, plant should be capable of reproduction.
     *
     */
    @Override
    public void grow()
    {
        age++;
        size += size * growthRate;
        if (age > 3 && size >= 2)
            grown = true;
    }
    
    /**
     * Decreases the size of the plant by a given amount.
     *
     * @param amount the amount to shrink the plant.
     */
    @Override
    public void damage(int amount)
    {
        size -= amount;
        if (size < 0)
        {
            size = 0;
        }
    }

    /**
     * Checks to see if the plant meets the requirements to stay alive.
     *
     * @return true if the plant has nit exceeded its lifetime and it has a size
     * greater than 0.
     */
    @Override
    public boolean isAlive()
    {
        return age <= lifetime && size > 0;
    }

    @Override
    public Plant reproduce(Organism other)
    {
        if (other instanceof Plant)
        {
            Plant po = (Plant) other;
            double newGr = (this.growthRate + po.getGrowthRate()) / 2;
            int newLife = (this.lifetime + po.getLifetime()) / 2;
            return new Plant(newLife, newGr);
        }
        return null;
    }

    /**
     *
     * @return the plant's rate of growth
     */
    public double getGrowthRate()
    {
        return growthRate;
    }

    /**
     *
     * @return the plant's lifespan
     */
    public int getLifetime()
    {
        return lifetime;
    }
    
    public double getSize()
    {
        return size;
    }

    protected boolean blooming;
    protected boolean grown;
    protected int age;
    protected double size;
    protected int lifetime;
    protected double growthRate;
    private final long ID;
    
    private boolean alreadySet;
    private int currentX = -1;
    private int currentY = -1;

    /**Sets the coordinate position of the plant once. Subsequent attempts to
     * change the position will fail.
     * 
     * @param x the new x-coordinate
     * @param y the new y-coordinate
     * @return true if the position was set. False if this is not the first time
     * this function has been called.
     * @pre nothing is already in the position indicated, and the position is
     * within bounds of the grid.
     */
    @Override
    public boolean setPosition(int x, int y)
    {
        if(!alreadySet)
        {
            currentX = x;
            currentY = y;
            return true;
        }
        return false;
    }

    @Override
    public int getX()
    {
        return currentX;
    }

    @Override
    public int getY()
    {
        return currentY;
    }

    @Override
    public int getAge()
    {
        return this.age;
    }

    @Override
    public long getID()
    {
        return ID;
    }
}
