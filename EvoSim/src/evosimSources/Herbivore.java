/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evosimSources;

import evosimApp.EvoConstants;
import evosimInterfaces.Carnivorous;
import evosimInterfaces.Herbivorous;
import evosimComparators.SortByClosest;
import java.awt.Point;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * Represents a creature that eats plants, but not other creatures.
 *
 * @author bryanmcguffin
 * @version 5-15-17
 * @see Creature
 * @see Herbivorous
 */
public class Herbivore extends Creature implements Herbivorous
{

    private Vector<Point> food;

    /**
     * Generates a new herbivore from scratch.
     *
     */
    public Herbivore()
    {
        super();
        food = new Vector<Point>();
    }

    /**
     * Generates a new herbivore from existing parameters.
     *
     * @param health
     * @param attack
     * @param defense
     * @param speed
     * @param gRate
     * @param belly the amount of food the herbivore can store.
     * @param lifespan the amount of turns the creature can exist.
     */
    public Herbivore(int health, int attack, int defense, int speed, double gRate, int belly, int lifespan)
    {
        super(health, attack, defense, speed, gRate, belly, lifespan);
        food = new Vector<Point>();
    }

    /**
     * Creates a new Herbivore offspring from two parents, this and the other.
     *
     * @param other the herbivore to be "mated" with this one
     * @return a new herbivore with a mix of its parents' traits
     */
    public Herbivore reproduce(Herbivore other)
    {
        int newHP = (this.hp + other.getHP()) / 2;
        int newAtt = (this.at + other.getAttack()) / 2;
        int newDef = (this.de + other.getDefense()) / 2;
        int newSpd = (this.sp + other.getSpeed()) / 2;
        double newGr = (this.growthRate + other.getGrowthRate()) / 2;
        int newBl = (this.belly + other.getBelly()) / 2;
        int newLife = (this.lifetime + other.getLifetime()) / 2;
        return new Herbivore(newHP, newAtt, newDef, newSpd, newGr, newBl, newLife);
    }

    /**
     * While the creature is still hungry and the plant can still be eaten, take
     * another bite.
     *
     * @param plant
     * @pre plant.isAlive() && this.isHungry()
     */
    @Override
    public void eat(Plant plant)
    {
        plant.damage(1);
        this.fullness++;
        if (plant.isAlive() && this.isHungry())
        {
            eat(plant);
        }
    }

    /**
     * Finds the locations of all carnivores within 3x the herbivore's speed
     * range.
     *
     * TODO rewrite this to match Carnivore.findPrey()
     *
     * @return a list of the locations of all nearby predators
     */
    @Override
    public List<Point> findThreats()
    {
        List<Point> threats = new Vector<Point>();
        for (int i = 0; i < EvoConstants.MAP_SIZE; i++)
        {
            for (int j = 0; j < EvoConstants.MAP_SIZE; j++)
            {
                if (null != EvoConstants.MAP.grid[i][j] && point.distance(i, j) <= (3 * sp)
                        && !(point.x == i && point.y == j))
                {
                    if (EvoConstants.MAP.grid[i][j] instanceof Carnivorous)
                    {
                        threats.add(new Point(i, j));
                    }
                }
            }
        }
        return threats;
    }

    /**
     * Finds the locations of all plants within 3x the herbivore's speed range.
     *
     * TODO rewrite this to match Carnivore.findPrey()
     *
     * @return a list of all nearby plants
     */
    @Override
    public List<Point> findFood()
    {
        List<Point> food = new Vector<Point>();
        for (int i = 0; i < EvoConstants.MAP_SIZE; i++)
        {
            for (int j = 0; j < EvoConstants.MAP_SIZE; j++)
            {
                if (null != EvoConstants.MAP.grid[i][j] && point.distance(i, j) <= (3 * sp)
                        && !(point.x == i && point.y == j))
                {
                    if (EvoConstants.MAP.grid[i][j] instanceof Plant)
                    {
                        food.add(new Point(i, j));
                    }
                }
            }
        }
        return food;
    }

    /**
     * Find the average location of all nearby predators, and move away from
     * that spot.
     *
     * TODO change for(;;) loop into for-each loop
     *
     * @param threats a list of the locations of nearby predators
     */
    private void avoidPredators(List<Point> threats)
    {
        Collections.sort(threats, new SortByClosest(this.point));
        Point avgPredatorPosition = new Point(0, 0);
        int numPredators = threats.size();
        for (int i = 0; i < numPredators; i++)
        {
            avgPredatorPosition.x += threats.get(i).x;
            avgPredatorPosition.y += threats.get(i).y;
        }
        avgPredatorPosition.x = avgPredatorPosition.x / numPredators;
        avgPredatorPosition.y = avgPredatorPosition.y / numPredators;

        awayFrom(avgPredatorPosition);
    }

    /**
     * Gets the location of the closest food item and navigates toward it.
     *
     * TODO rewrite this to have adjacency support. Use Carnivore.hunt() as
     * template
     *
     * @param food a list of locations of nearby plants
     */
    private void forage()
    {
        Collections.sort(food, new SortByClosest(this.point));
        Point foodPosition = food.get(0);
        towards(foodPosition);
    }

    /**
     * Evaluate next move to make based on relative positions of nearby
     * predators and food sources. If there are predators, run away from them.
     * Otherwise, if there is food nearby, move towards it. Otherwise, make a
     * random movement.
     *
     */
    @Override
    public void makeNextMove()
    {
        List<Point> threats = findThreats();
        food = new Vector<Point>(findFood());
        if (threats.size() > 0 && !isHungry())
        {
            avoidPredators(threats);
        }
        else if (food.size() > 0)
        {
            forage();
        }
        else
        {
            super.makeNextMove();
        }
    }

    @Override
    public Plant foodReached()
    {
        //Rearrange by distance to target, closest first
        Collections.sort(food, new SortByClosest(this.point));

        //If closest is adjacent to us, return that one. Else null
        if (food.size() > 0 && isAdjacent(food.get(0)))
        {
            Point plantPos = food.get(0);
            food.remove(0);
            return (Plant)(EvoConstants.MAP.grid[plantPos.x][plantPos.y]);
        }
        return null;
    }
}
