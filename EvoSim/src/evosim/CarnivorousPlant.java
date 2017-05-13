/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evosim;

import java.awt.Point;
import java.util.List;
import java.util.Vector;

/**
 * Represents a subtype of plant that is carnivorous. Carnivorous plants still
 * cannot move, but they can eat other organisms.
 *
 * @author bryanmcguffin
 * @version 5-10-17
 * @see Plant
 * @see Carnivorous
 */
public class CarnivorousPlant extends Plant implements Carnivorous
{

    /**Generates a new CarnivorousPlant from scratch.
     * 
     */
    public CarnivorousPlant()
    {
        super();
        fullness = EvoConstants.INIT_BELLY;
        belly = EvoConstants.INIT_BELLY;
    }

    /**Increases the age of the plant. If it is not hungry, allows the plant to
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
        if(fullness > 0)
            fullness--;
    }

    /**Consumes a creature and replenishes fullness.
     * 
     * @param creature the prey to be eaten
     */
    @Override
    public void eat(Creature creature)
    {
        this.fullness += creature.getSize();
        if(!this.isHungry())
            this.fullness = this.belly;
    }

    /**Checks to see if the plant is still hungry.
     * 
     * @return true if the plant has room left in its belly.
     */
    public boolean isHungry()
    {
        return fullness < belly;
    }

    private int fullness;
    private int belly;

    /**This organism can't seek out prey so this is useless
     * 
     * @param map
     * @return 
     */
    @Override
    public List<Point> findPrey()
    {
        return new Vector<Point>();
    }

}
