/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evosimSources;

import evosimApp.EvoConstants;
import evosimComparators.SortByClosest;
import java.awt.Point;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * Represents a subtype of plant that is carnivorous. Carnivorous plants still
 * cannot move, but they can eat other organisms.
 *
 * @author Bryan McGuffin
 * @version 5-14-17
 * @see Plant
 * @see Carnivorous
 */
public class CarnivorousPlant extends Plant implements Carnivorous
{

    List<Point> prey;

    /**
     * Generates a new CarnivorousPlant from scratch.
     *
     */
    public CarnivorousPlant()
    {
        super();
        fullness = EvoConstants.INIT_BELLY;
        belly = EvoConstants.INIT_BELLY;
        prey = new Vector<Point>();
    }

    /**
     * Increases the age of the plant. If it is not hungry, allows the plant to
     * grow in size as well.
     *
     */
    @Override
    public void grow()
    {
        age++;
        if (!this.isHungry())
        {
            super.grow();
            age--;
        }
        if (fullness > 0)
        {
            fullness--;
        }
    }

    /**
     * Consumes a creature and replenishes fullness.
     *
     * @param creature the prey to be eaten
     */
    @Override
    public void eat(Creature creature)
    {
        this.fullness += creature.getSize();
        if (!this.isHungry())
        {
            this.fullness = this.belly;
        }
    }

    /**
     * Checks to see if the plant is still hungry.
     *
     * @return true if the plant has room left in its belly.
     */
    public boolean isHungry()
    {
        return fullness < belly;
    }

    private int fullness;
    private int belly;

    /**
     * If there are organisms on squares adjacent to this, return them in random
     * order
     *
     * @return nearby prey creatures
     */
    @Override
    public List<Point> findPrey()
    {
        Vector<Point> prey = new Vector<Point>();
        int i = (getX()-1);
        int j = (getY()-1);
        if (i >= 0 && j >= 0 && i < EvoConstants.MAP_SIZE && j < EvoConstants.MAP_SIZE 
                &&EvoConstants.MAP.grid[i][j] instanceof Creature)
        {
            prey.add(new Point(i,j));
        }
        
        i = (getX()+1);
        j = (getY()-1);
        if (i >= 0 && j >= 0 && i < EvoConstants.MAP_SIZE && j < EvoConstants.MAP_SIZE 
                &&EvoConstants.MAP.grid[i][j] instanceof Creature)
        {
            prey.add(new Point(i,j));
        }
        
        i = (getX()-1);
        j = (getY()+1);
        if (i >= 0 && j >= 0 && i < EvoConstants.MAP_SIZE && j < EvoConstants.MAP_SIZE 
                &&EvoConstants.MAP.grid[i][j] instanceof Creature)
        {
            prey.add(new Point(i,j));
        }
        
        i = (getX()+1);
        j = (getY()+1);
        if (i >= 0 && j >= 0 && i < EvoConstants.MAP_SIZE && j < EvoConstants.MAP_SIZE 
                &&EvoConstants.MAP.grid[i][j] instanceof Creature)
        {
            prey.add(new Point(i,j));
        }
        
        Collections.shuffle(prey);
        
        return prey;
    }

    /**
     * Get all adjacent prey creatures and return one.
     * 
     * @return one of the adjacent prey creatures, or null if there are no
     * nearby prey items.
     */
    @Override
    public Creature targetCaught()
    {
        prey = new Vector<Point>(findPrey());

        //If closest is adjacent to us, return that one. Else null
        {
            if (prey.size() > 0 && isHungry())
            {
                Point preyPos = prey.get(0);
                prey.remove(0);
                return (Creature) (EvoConstants.MAP.grid[preyPos.x][preyPos.y]);
            }
        }
        return null;
    }

}
