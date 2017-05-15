/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evosimSources;

import evosimApp.EvoConstants;
import evosimInterfaces.Organism;
import evosimInterfaces.Mobile;
import java.awt.Point;
import java.util.Random;

/**
 * Represents an animal. Creatures are living things that move and eat other
 * things. This is a superclass for different types of creatures, which are
 * separated based on what they eat.
 *
 * @author bryanmcguffin
 * @version 5-11-17
 * @see Organism
 * @see Mobile
 */
public class Creature implements Organism, Mobile
{

    /**
     * Creates a new creature from scratch. Initializers found in EvoConstants.
     */
    public Creature()
    {
        this.hp = EvoConstants.INIT_HEALTH;
        this.at = EvoConstants.INIT_ATTACK;
        this.de = EvoConstants.INIT_DEFENSE;
        this.sp = EvoConstants.INIT_SPEED;
        this.growthRate = EvoConstants.INIT_GROWTH_RATE;
        this.size = EvoConstants.INIT_SIZE;
        this.belly = EvoConstants.INIT_BELLY;
        this.fullness = EvoConstants.INIT_BELLY;
        this.age = 0;
        this.lifetime = EvoConstants.INIT_LIFESPAN;
        this.ID = EvoConstants.ID++;
        point = new Point(0, 0);
    }

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
    public Creature(int health, int attack, int defense, int speed, double gRate,
            int belly, int lifespan)
    {
        this.hp = health;
        this.at = attack;
        this.de = defense;
        this.sp = speed;
        this.size = 1;
        this.growthRate = gRate;
        this.belly = belly;
        this.fullness = belly;
        this.age = 0;
        this.lifetime = lifespan;
        this.ID = EvoConstants.ID++;
        point = new Point(0, 0);
    }

    /**
     * Checks if the creature is an "adult" or just a child.
     *
     * @return true if the creature's age is more than 50% of its lifespan.
     */
    @Override
    public boolean isMature()
    {
        return (double) age / (double) lifetime > 0.5;
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
     * Grows the creature by incrementing its age. Increases its size according
     * to its growth rate. Decreases its fullness.
     *
     */
    @Override
    public void grow()
    {
        if (isAlive())
        {
            age++;
            size += size * growthRate;
            fullness--;
            if (fullness < 0)
            {
                fullness = 0;
            }
        }
    }

    /**
     * Generates a new creature from two parents.
     *
     * @param other the other creature to mate with this one.
     * @return a new creature with traits that are the average of its parents,
     * OR null if both parents are not creatures.
     */
    @Override
    public Creature reproduce(Organism other)
    {
        if (other instanceof Creature)
        {
            Creature co = (Creature) other;
            int newHP = (this.hp + co.getHP()) / 2;
            int newAtt = (this.at + co.getAttack()) / 2;
            int newDef = (this.de + co.getDefense()) / 2;
            int newSpd = (this.sp + co.getSpeed()) / 2;
            double newGr = (this.growthRate + co.getGrowthRate()) / 2;
            int newBl = (this.belly + co.getBelly()) / 2;
            int newLife = (this.lifetime + co.getLifetime()) / 2;
            return new Creature(newHP, newAtt, newDef, newSpd, newGr, newBl, newLife);
        }
        return null;
    }

    /**
     * Move the creature some distance away from its present location. Checks to
     * make sure that the intended destination exists, and is within the
     * creature's range of motion, and is not blocked by some entity.
     *
     * @param x Number of spaces away in the x direction to move.
     * @param y Number of spaces away in the y direction to move.
     * @param grid 2D grid that makes up the world.
     */
    @Override
    public boolean move(int x, int y)
    {
        int finalX, finalY;
        if (point.x >= 0 && point.y >= 0 && Math.abs(x) <= sp && Math.abs(y) <= sp)
        {
            EvoConstants.debug("Valid move...");
            if (point.x + x >= EvoConstants.MAP.grid.length)
            {
                finalX = EvoConstants.MAP.grid.length - 1;
            }
            else if (point.x + x < 0)
            {
                finalX = 0;
            }
            else
            {
                finalX = point.x + x;
            }
            if (point.y + y >= EvoConstants.MAP.grid[finalX].length)
            {
                finalY = EvoConstants.MAP.grid[finalX].length - 1;
            }
            else if (point.y + y < 0)
            {
                finalY = 0;
            }
            else
            {
                finalY = point.y + y;
            }

            EvoConstants.debug("Trying to move to (" + finalX + ", " + finalY + ")");
            if (null == EvoConstants.MAP.grid[finalX][finalY])
            {
                EvoConstants.MAP.grid[finalX][finalY] = this;
                EvoConstants.MAP.grid[point.x][point.y] = null;
                point.move(finalX, finalY);
                EvoConstants.debug("MOVEMENT SUCCESS!");
                EvoConstants.debug("Creature " + ID + " is now at (" + point.x + ", " + point.y + ")");
                return true;
            }
            EvoConstants.debug("That spot is full!");
        }
        EvoConstants.debug("MOVEMENT FAILURE");
        EvoConstants.debug("Creature " + ID + " is still at (" + point.x + ", " + point.y + ")");
        return false;
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
     * @return the creature's rate of growth.
     */
    public double getGrowthRate()
    {
        return growthRate;
    }

    /**
     *
     * @return the creature's size.
     */
    public double getSize()
    {
        return size;
    }

    /**
     * Check to see if the creature is still hungry.
     *
     * @return true if the creature has room left in its belly.
     */
    public boolean isHungry()
    {
        return fullness < belly;
    }

    protected int hp;
    protected int at;
    protected int de;
    protected int sp;
    protected double size;
    protected final int belly;
    protected int fullness;
    protected final int lifetime;
    protected int age;
    protected double growthRate;
    private final long ID;

    protected Point point;

    /**
     * Decreases the creature's health by a given amount. Minimum is 0.
     *
     * @param amount the amount of health to take from the creature.
     */
    @Override
    public void damage(int amount)
    {
        this.hp -= amount;
        if (this.hp < 0)
        {
            this.hp = 0;
        }
    }

    /**
     * Moves the creature to some absolute location on the grid. Different from
     * move() in that move() adds the x/y params to the creature's present
     * location while jump() just sets them right out. Useful for setting a
     * creature to a position on a board if it wasn't already there.
     *
     * @param x the x position to set the creature to
     * @param y the y position to set the creature to
     * @param grid the grid of objects that represents the map
     */
    @Override
    public boolean jump(int x, int y)
    {
        EvoConstants.debug("Creature" + ID + " tried to jump!");
        if (x >= 0 && y >= 0 && x < EvoConstants.MAP.grid.length && y < EvoConstants.MAP.grid[x].length)
        {
            if (x <= sp && y <= sp && EvoConstants.MAP.grid[x][y] == null)
            {
                EvoConstants.MAP.grid[x][y] = this;
                if (point.x >= 0 && point.y >= 0)
                {
                    EvoConstants.MAP.grid[point.x][point.y] = null;
                }
                point.move(x, y);
                return true;
            }
        }
        return false;
    }

    /**
     * Sets the position of the creature directly to the values presented. Does
     * not clear the current grid position or work with it at all.
     *
     * @param x the new x-coordinate
     * @param y the new y-coordinate
     * @return true always
     * @pre the coordinates provided are not out of bounds, and there is nothing
     * in the grid at that position already.
     */
    @Override
    public boolean setPosition(int x, int y)
    {
        point.move(x, y);
        return true;
    }

    @Override
    public int getX()
    {
        return point.x;
    }

    @Override
    public int getY()
    {
        return point.y;
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

    /**
     * Displace the organism by some random amount within its movement range.
     *
     * @param o a mobile organism on the map
     * @param map the 2D map structure that holds the organisms
     */
    protected void makeRandomMovement()
    {
        Random r = new Random();

        int moveDist = getSpeed();
        int newX = r.nextInt(moveDist) * (int) Math.pow(-1, r.nextInt(2));
        int newY = r.nextInt(moveDist) * (int) Math.pow(-1, r.nextInt(2));
        move(newX, newY);
        EvoConstants.debug("Creature" + ID + " made a random movement!");
    }

    @Override
    public void makeNextMove()
    {
        makeRandomMovement();
    }

    @Override
    public void towards(Point p)
    {
        if (!isAdjacent(p))
        {
            EvoConstants.debug("Creature " + ID + " is moving towards something!");
            EvoConstants.debug("Creature is at (" + point.x + ", " + point.y + ")");
            EvoConstants.debug("The destination is at (" + p.x + ", " + p.y + ")");
            int deltaX = p.x - point.x;
            int deltaY = p.y - point.y;
            EvoConstants.debug("Distance in X direction is " + deltaX);
            EvoConstants.debug("Distance in Y direction is " + deltaY);
            EvoConstants.debug("Max movement range is " + sp);
            if (Math.abs(deltaX) > sp)
            {
                if (deltaX < 0)
                {
                    deltaX = sp * -1;
                }
                else
                {
                    deltaX = sp;
                }
            }
            if (Math.abs(deltaY) > sp)
            {
                if (deltaY < 0)
                {
                    deltaY = sp * -1;
                }
                else
                {
                    deltaY = sp;
                }
            }
            EvoConstants.debug("Adjusted Delta X is " + deltaX);
            EvoConstants.debug("Adjusted Delta Y is " + deltaY);
            int intendedX = point.x+deltaX;
            int intendedY = point.y+deltaY;
            if (intendedX < EvoConstants.MAP_SIZE && intendedY < EvoConstants.MAP_SIZE 
                    && EvoConstants.MAP.grid[intendedX][intendedY]!= null)
            {
                EvoConstants.debug("But this would land us on an object!");
                Random r = new Random();
                if (r.nextBoolean())
                {
                    deltaX -= 1;
                }
                else
                {
                    deltaY -= 1;
                }
                EvoConstants.debug("Final Delta X is " + deltaX);
                EvoConstants.debug("Final Delta Y is " + deltaY);
            }

            move(deltaX, deltaY);
        }
    }

    @Override
    public void awayFrom(Point p)
    {
        EvoConstants.debug("Creature " + ID + " is moving away from something!");
        int deltaX = point.x - p.x;
        int deltaY = point.y - p.y;
        if (Math.abs(deltaX) > sp)
        {
            if (deltaX < 0)
            {
                deltaX = sp * -1;
            }
            else
            {
                deltaX = sp;
            }
        }
        if (Math.abs(deltaY) > sp)
        {
            if (deltaY < 0)
            {
                deltaY = sp * -1;
            }
            else
            {
                deltaY = sp;
            }
        }
        move(deltaX, deltaY);
    }

    @Override
    public boolean isAdjacent(Point p)
    {
        if (this.point.x == p.x && this.point.y == (p.y + 1))
        {
            return true;
        }
        if (this.point.x == p.x && this.point.y == (p.y - 1))
        {
            return true;
        }
        if (this.point.x == (p.x + 1) && this.point.y == p.y)
        {
            return true;
        }
        if (this.point.x == (p.x - 1) && this.point.y == p.y)
        {
            return true;
        }
        return false;
    }
}
