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
 * Represents a creature that eats plants, but not other creatures.
 *
 * @author bryanmcguffin
 * @version 5-10-17
 * @see Creature
 * @see Herbivorous
 */
public class Herbivore extends Creature implements Herbivorous
{

    /**
     * Generates a new herbivore from scratch.
     *
     */
    public Herbivore()
    {
        super();
    }

    /**
     * Generates a new herbivore from existing parameters.
     *
     * @param health
     * @param attack
     * @param defense
     * @param speed
     * @param size
     * @param belly the amount of food the herbivore can store.
     * @param lifespan the amount of turns the creature can exist.
     */
    public Herbivore(int health, int attack, int defense, int speed, double gRate, int belly, int lifespan)
    {
        super(health, attack, defense, speed, gRate, belly, lifespan);
    }

    /**
     * Creates a new Herbivore offspring from two parents, this and the other.
     *
     * @param other the herbivore to be "mated" with this one
     * @return a new herbivore with a mix of its parents' traits
     */
    public Herbivore reproduce(Herbivore other)
    {
        if (other instanceof Herbivore)
        {
            Herbivore ho = (Herbivore) other;
            int newHP = (this.hp + ho.getHP()) / 2;
            int newAtt = (this.at + ho.getAttack()) / 2;
            int newDef = (this.de + ho.getDefense()) / 2;
            int newSpd = (this.sp + ho.getSpeed()) / 2;
            double newGr = (this.growthRate + ho.getGrowthRate()) / 2;
            int newBl = (this.belly + ho.getBelly()) / 2;
            int newLife = (this.lifetime + ho.getLifetime()) / 2;
            return new Herbivore(newHP, newAtt, newDef, newSpd, newGr, newBl, newLife);
        }
        return null;
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
     * @param map
     * @return
     */
    @Override
    public List<Point> findThreats()
    {
        List<Point> threats = new Vector<Point>();
        for (int i = 0; i < EvoConstants.MAP_SIZE; i++)
        {
            for (int j = 0; j < EvoConstants.MAP_SIZE; j++)
            {
                if (null != EvoConstants.MAP.grid[i][j] && point.distance(i, j) <= (3 * sp))
                {
                    if (EvoConstants.MAP.grid[i][j] instanceof Carnivore)
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
     * @param map
     * @return
     */
    @Override
    public List<Point> findFood()
    {
        List<Point> food = new Vector<Point>();
        for (int i = 0; i < EvoConstants.MAP_SIZE; i++)
        {
            for (int j = 0; j < EvoConstants.MAP_SIZE; j++)
            {
                if (null != EvoConstants.MAP.grid[i][j] && point.distance(i, j) <= (3 * sp))
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
    
    private void avoidPredators(List<Point> threats)
    {
        Point avgPredatorPosition = new Point(0,0);
        int numPredators = threats.size();
        for(int i = 0;i<numPredators;i++)
        {
            avgPredatorPosition.x += threats.get(i).x;
            avgPredatorPosition.y += threats.get(i).y;
        }
        avgPredatorPosition.x = avgPredatorPosition.x / numPredators;
        avgPredatorPosition.y = avgPredatorPosition.y / numPredators;
        
        awayFrom(avgPredatorPosition);
    }
    
    private void forage(List<Point> food)
    {
        Point foodPosition = food.get(0);     
        towards(foodPosition);
    }
    
    @Override 
    public void makeNextMove()
    {
        List<Point> threats = findThreats();
        List<Point> food = findFood();
        if(threats.size() > 0 && !isHungry())
        {
            avoidPredators(threats);
        }
        else if(food.size() > 0)
        {
            forage(food);
        }
        else
        {
            super.makeRandomMovement();
        }
    }
}
