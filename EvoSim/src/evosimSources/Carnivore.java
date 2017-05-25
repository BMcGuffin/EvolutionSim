/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evosimSources;

import evosimApp.EvoConstants;
import evosimComparators.*;
import java.awt.Point;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * Represents a creature that eats other creatures. It cannot eat plants.
 *
 * @author bryanmcguffin
 * @version 5-15-17
 * @see Creature
 * @see Carnivorous
 */
public class Carnivore extends Creature implements Carnivorous
{
    
     List<Point> prey;
     
    /**
     * Generates a new Carnivore from scratch.
     *
     */
    public Carnivore()
    {
        super();
        prey = new Vector<Point>();
    }

    /**
     * Generates a new Carnivore from existing parameters.
     *
     * @param health
     * @param attack
     * @param defense
     * @param speed
     * @param gRate
     * @param belly the amount of food the carnivore can consume.
     * @param lifespan the amount of turns the creature can exist.
     */
    public Carnivore(int health, int attack, int defense, int speed, double gRate, int belly, int lifespan)
    {
        super(health, attack, defense, speed, gRate, belly, lifespan);
        prey = new Vector<Point>();
    }

    /**
     * Creates a new carnivore offspring from two parents, this and the other.
     *
     * @param other the carnivore to be "mated" with this one
     * @return a new carnivore with a mix of its parents' traits
     */
    public Carnivore reproduce(Carnivore other)
    {
        int newHP = (this.hp + other.getHP()) / 2;
        int newAtt = (this.at + other.getAttack()) / 2;
        int newDef = (this.de + other.getDefense()) / 2;
        int newSpd = (this.sp + other.getSpeed()) / 2;
        double newGr = (this.growthRate + other.getGrowthRate()) / 2;
        int newBl = (this.belly + other.getBelly()) / 2;
        int newLife = (this.lifetime + other.getLifetime()) / 2;
        return new Carnivore(newHP, newAtt, newDef, newSpd, newGr, newBl, newLife);

    }

    /**
     * Feeds the carnivore based on the body size of the other creature.
     *
     * @param creature the prey to be consumed.
     */
    @Override
    public void eat(Creature creature)
    {
        this.fullness += (int) creature.getSize();
        if (!this.isHungry())
        {
            this.fullness = this.getBelly();
        }
    }

    /**
     * Finds the locations of all herbivores within 3x the carnivore's speed
     * range.
     *
     * @return a list of point locations of all possible food locations
     */
    @Override
    public List<Point> findPrey()
    {
        int foodRangeFactor = 3;
        List<Point> prey = new Vector<Point>();
        EvoConstants.debug("\nCarnivore " + getID() + " is finding prey");
        EvoConstants.debug("Centered at position " + getX() + ", " + getY());
        for (int i = 0; i < EvoConstants.MAP_SIZE; i++)
        {
            for (int j = 0; j < EvoConstants.MAP_SIZE; j++)
            {
                if (null != EvoConstants.MAP.grid[i][j] && point.distance(i, j)
                        <= (foodRangeFactor * sp) && !(point.x == i && point.y == j))
                {
                    EvoConstants.debug("Square " + i + ", " + j + " has an organism.");
                    if (EvoConstants.MAP.grid[i][j] instanceof Herbivorous)
                    {
                        EvoConstants.debug("It's prey! added it to the list.");
                        prey.add(new Point(i, j));
                    }
                }
            }
        }
        return prey;
    }

    /**
     * Gets the closest point that has prey, and chases it or attacks it
     * depending on how close the creature is to it.
     *
     * @param prey a list of points representing all nearby grid squares that
     * have herbivores
     */
    private void hunt()
    {
        //Debug info
        EvoConstants.debug("\nCarnivore " + getID() + " (" + point.x + ", " + point.y + ") is on the hunt!");
        EvoConstants.debug("Potential targets at:");
        for (int i = 0; i < prey.size(); i++)
        {
            EvoConstants.debug("" + prey.get(i).x + ", " + prey.get(i).y + " (dist = " + this.point.distance(prey.get(i)) + ")");
        }

        //Rearrange by distance to target, closest first
        Collections.sort(prey, new SortByClosest(this.point));

        //More Debug
        EvoConstants.debug("\nOrdered by distance, they are at:");
        for (int i = 0; i < prey.size(); i++)
        {
            EvoConstants.debug("" + prey.get(i).x + ", " + prey.get(i).y + " (dist = " + this.point.distance(prey.get(i)) + ")");
        }

        //Target is the closest thing
        Point foodPosition = prey.get(0);

        EvoConstants.debug("Closest prey is at " + foodPosition.x + ", " + foodPosition.y + "\n");

        //if we're not next to it, chase it
        if (!isAdjacent(foodPosition))
        {
            towards(foodPosition);
        }
    }

    /**
     * Calculates the carnivore's next move. If there is any nearby prey, chase
     * it and kill it. If not, make a random movement.
     *
     */
    @Override
    public void makeNextMove()
    {

        prey = new Vector<Point>(findPrey());

        if (prey.size() > 0)
        {
            hunt();
        }
        else
        {
            super.makeNextMove();
        }
    }

    @Override
    public Creature targetCaught()
    {
        //Rearrange by distance to target, closest first
        Collections.sort(prey, new SortByClosest(this.point));
        
        //If closest is adjacent to us, return that one. Else null
        if(prey.size() > 0 && isAdjacent(prey.get(0)))
        {
            Point preyPos = prey.get(0);
            prey.remove(0);
            return (Creature)(EvoConstants.MAP.grid[preyPos.x][preyPos.y]);
        }
        return null;
    }
}
