/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evosimSources;

import evosimSources.Creature;
import evosimApp.EvoConstants;
import evosimSources.Map;
import java.awt.Point;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Bryan McGuffin
 */
public class CreatureTest extends TestCase
{

    public CreatureTest(String testName)
    {
        super(testName);
    }

    /**
     * Test of isMature method, of class Creature.
     */
    public void testIsMature()
    {
        System.out.println("isMature");
        Creature instance = new CreatureImpl();
        boolean expResult = false;
        boolean result = instance.isMature();
        assertEquals(expResult, result);
        assertFalse(instance.age / instance.getLifetime() > 0.5);
        instance.grow();
        instance.grow();
        instance.grow();
        instance.grow();
        expResult = true;
        assertTrue(instance.age / (double) instance.getLifetime() > 0.5);
        result = instance.isMature();
        assertEquals(expResult, result);
    }

    /**
     * Test of isAlive method, of class Creature.
     */
    public void testIsAlive()
    {
        System.out.println("isAlive");
        Creature instance = new CreatureImpl();
        boolean result = instance.isAlive();
        assertTrue(result);
        assertEquals(5, instance.fullness);
        instance.grow();
        assertEquals(4, instance.fullness);
        instance.grow();
        assertEquals(3, instance.fullness);
        instance.grow();
        assertEquals(2, instance.fullness);
        instance.grow();
        assertEquals(1, instance.fullness);
        instance.grow();
        assertEquals(0, instance.fullness);
        assertFalse(instance.isAlive());
    }

    /**
     * Test of grow method, of class Creature.
     */
    public void testGrow()
    {
        System.out.println("grow");
        Creature instance = new CreatureImpl();
        double expected = EvoConstants.INIT_SIZE;
        assertEquals(expected, instance.getSize());
        instance.grow();
        expected += EvoConstants.INIT_SIZE * EvoConstants.INIT_GROWTH_RATE;
        assertEquals(expected, instance.getSize());
        //This just tests the growth curve
        /*
         for (int i = 0; instance.getSize() < EvoConstants.CAP_CREATURE_SIZE; i++)
         {
         instance.grow();
         System.out.println("Age: " + instance.age + "\tSize: "
         + instance.size + "\tFullness: " + instance.fullness);

         }*/
    }

    /**
     * Test of getAttack method, of class Creature.
     */
    public void testGetAttack()
    {
        System.out.println("getAttack");
        Creature instance = new CreatureImpl();
        int expResult = EvoConstants.INIT_ATTACK;
        int result = instance.getAttack();
        assertEquals(expResult, result);

        instance = new CreatureImpl(10, 11, 12, 13, 14, 15, 16);
        expResult = 11;
        result = instance.getAttack();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDefense method, of class Creature.
     */
    public void testGetDefense()
    {
        System.out.println("getDefense");
        Creature instance = new CreatureImpl();
        int expResult = EvoConstants.INIT_DEFENSE;
        int result = instance.getDefense();
        assertEquals(expResult, result);

        instance = new CreatureImpl(10, 11, 12, 13, 14, 15, 16);
        expResult = 12;
        result = instance.getDefense();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSpeed method, of class Creature.
     */
    public void testGetSpeed()
    {
        System.out.println("getSpeed");
        Creature instance = new CreatureImpl();
        int expResult = EvoConstants.INIT_SPEED;
        int result = instance.getSpeed();
        assertEquals(expResult, result);

        instance = new CreatureImpl(10, 11, 12, 13, 14, 15, 16);
        expResult = 13;
        result = instance.getSpeed();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBelly method, of class Creature.
     */
    public void testGetBelly()
    {
        System.out.println("getBelly");
        Creature instance = new CreatureImpl();
        int expResult = EvoConstants.INIT_BELLY;
        int result = instance.getBelly();
        assertEquals(expResult, result);

        instance = new CreatureImpl(10, 11, 12, 13, 14, 15, 16);
        expResult = 15;
        result = instance.getBelly();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLifetime method, of class Creature.
     */
    public void testGetLifetime()
    {
        System.out.println("getLifetime");
        Creature instance = new CreatureImpl();
        int expResult = EvoConstants.INIT_LIFESPAN;
        int result = instance.getLifetime();
        assertEquals(expResult, result);

        instance = new CreatureImpl(10, 11, 12, 13, 14, 15, 16);
        expResult = 16;
        result = instance.getLifetime();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHP method, of class Creature.
     */
    public void testGetHP()
    {
        System.out.println("getHP");
        Creature instance = new CreatureImpl();
        int expResult = EvoConstants.INIT_HEALTH;
        int result = instance.getHP();
        assertEquals(expResult, result);

        instance = new CreatureImpl(10, 11, 12, 13, 14, 15, 16);
        expResult = 10;
        result = instance.getHP();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGrowthRate method, of class Creature.
     */
    public void testGetGrowthRate()
    {
        System.out.println("getGrowthRate");
        Creature instance = new CreatureImpl();
        double expResult = EvoConstants.INIT_GROWTH_RATE;
        double result = instance.getGrowthRate();
        assertEquals(expResult, result);

        instance = new CreatureImpl(10, 11, 12, 13, 14, 15, 16);
        expResult = 14;
        result = instance.getGrowthRate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSize method, of class Creature.
     */
    public void testGetSize()
    {
        System.out.println("getSize");
        Creature instance = new CreatureImpl();
        double expResult = EvoConstants.INIT_SIZE;
        double result = instance.getSize();
        assertEquals(expResult, result);

        instance = new CreatureImpl(10, 11, 12, 13, 14, 15, 16);
        expResult = EvoConstants.INIT_SIZE;
        result = instance.getSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of isHungry method, of class Creature.
     */
    public void testIsHungry()
    {
        System.out.println("isHungry");
        Creature instance = new CreatureImpl();
        boolean result = instance.isHungry();
        assertFalse(result);
        instance.grow();
        result = instance.isHungry();
        assertTrue(result);
    }

    /**
     * Test of damage method, of class Creature.
     */
    public void testDamage()
    {
        System.out.println("damage");
        int amount = 0;
        Creature instance = new CreatureImpl();
        int start = instance.getHP();
        instance.damage(amount);
        int end = instance.getHP();
        assertTrue(start - end == amount);

        start = instance.getHP();
        amount = 5;
        instance.damage(amount);
        end = instance.getHP();
        assertTrue(start - end == amount);

        start = instance.getHP();
        amount = start + 5;
        instance.damage(amount);
        end = instance.getHP();
        assertEquals(0, end);
    }

    /**
     * Test of setPosition method, of class Creature.
     */
    public void testSetPosition()
    {
        System.out.println("setPosition");
        int x = 5;
        int y = 7;
        Creature instance = new CreatureImpl();
        assertEquals(0, instance.getX());
        assertEquals(0, instance.getY());
        boolean result = instance.setPosition(x, y);
        assertTrue(result);
        assertEquals(5, instance.getX());
        assertEquals(7, instance.getY());
    }

    /**
     * Test of getX method, of class Creature.
     */
    public void testGetX()
    {
        System.out.println("getX");
        Creature instance = new CreatureImpl();
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);
        instance.setPosition(1, 0);
        expResult = 1;
        result = instance.getX();
        assertEquals(expResult, result);
    }

    /**
     * Test of getY method, of class Creature.
     */
    public void testGetY()
    {
        System.out.println("getY");
        Creature instance = new CreatureImpl();
        int expResult = 0;
        int result = instance.getY();
        assertEquals(expResult, result);
        instance.setPosition(1, 4);
        expResult = 4;
        result = instance.getY();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAge method, of class Creature.
     */
    public void testGetAge()
    {
        System.out.println("getAge");
        Creature instance = new CreatureImpl();
        int expResult = 0;
        int result = instance.getAge();
        assertEquals(expResult, result);
    }

    /**
     * Test of getID method, of class Creature.
     */
    public void testGetID()
    {
        System.out.println("getID");
        long oldID = EvoConstants.ID;
        Creature instance = new CreatureImpl();
        long expResult = EvoConstants.ID;
        long result = instance.getID();
        assertEquals(expResult, result + 1);
        assertEquals(oldID, result);
    }

    /**
     * Test of makeRandomMovement method, of class Creature.
     */
    public void testMakeRandomMovement()
    {
        System.out.println("makeRandomMovement");
        Creature instance = new CreatureImpl();
        EvoConstants.MAP = new Map(EvoConstants.MAP_SIZE);
        assertFalse(EvoConstants.MAP.removeOrganismFromTable(instance));
        instance = new CreatureImpl();
        assertTrue(EvoConstants.MAP.addOrganismToTable(instance, 1, 1));
        instance.makeRandomMovement();
        assertTrue(Math.abs(instance.getX() - 1) < instance.getSpeed());
        assertTrue(Math.abs(instance.getY() - 1) < instance.getSpeed());

        assertTrue(EvoConstants.MAP.removeOrganismFromTable(instance));
    }

    /**
     * Test of makeNextMove method, of class Creature.
     */
    public void testMakeNextMove()
    {
        System.out.println("makeNextMove");
        Creature instance = new CreatureImpl();
        instance.makeNextMove();
        //Very little happens in this method
    }

    /**
     * Test of towards method, of class Creature.
     */
    public void testTowards()
    {
        System.out.println("towards");
        int targetX = 4;
        int targetY = 5;

        int startX = 1;
        int startY = 1;
        Point p = new Point(targetX, targetY);
        Creature instance = new CreatureImpl();
        EvoConstants.MAP = new Map(EvoConstants.MAP_SIZE);
        EvoConstants.MAP.addOrganismToTable(instance, startX, startY);
        assertEquals(startX, instance.getX());
        assertEquals(startY, instance.getY());

        instance.towards(p);
        assertTrue(Math.abs(instance.getX() - targetX) <= instance.getSpeed());
        assertTrue(Math.abs(instance.getY() - targetY) <= instance.getSpeed());

        instance.towards(p);
        assertTrue(Math.abs(instance.getX() - targetX) <= instance.getSpeed());
        assertTrue(Math.abs(instance.getY() - targetY) <= instance.getSpeed());

        instance.towards(p);
        assertTrue(Math.abs(instance.getX() - targetX) <= instance.getSpeed());
        assertTrue(Math.abs(instance.getY() - targetY) <= instance.getSpeed());

        instance.towards(p);
        assertTrue(Math.abs(instance.getX() - targetX) <= instance.getSpeed());
        assertTrue(Math.abs(instance.getY() - targetY) <= instance.getSpeed());

    }

    /**
     * Test of awayFrom method, of class Creature.
     */
    public void testAwayFrom()
    {
        System.out.println("awayFrom");
        int targetX = 0;
        int targetY = 0;

        int startX = 1;
        int startY = 1;
        Point p = new Point(targetX, targetY);
        Creature instance = new CreatureImpl();
        EvoConstants.MAP = new Map(EvoConstants.MAP_SIZE);
        EvoConstants.MAP.addOrganismToTable(instance, startX, startY);
        assertEquals(startX, instance.getX());
        assertEquals(startY, instance.getY());

        instance.awayFrom(p);
        assertTrue(Math.abs(instance.getX() - targetX) > 0);
        assertTrue(Math.abs(instance.getY() - targetY) > 0);

        instance.awayFrom(p);
        assertTrue(Math.abs(instance.getX() - targetX) > 0);
        assertTrue(Math.abs(instance.getY() - targetY) > 0);

        instance.awayFrom(p);
        assertTrue(Math.abs(instance.getX() - targetX) > 0);
        assertTrue(Math.abs(instance.getY() - targetY) > 0);

        instance.awayFrom(p);
        assertTrue(Math.abs(instance.getX() - targetX) > 0);
        assertTrue(Math.abs(instance.getY() - targetY) > 0);

    }

    /**
     * Test of isAdjacent method, of class Creature.
     */
    public void testIsAdjacent()
    {
        System.out.println("isAdjacent");
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 1);
        Creature instance = new CreatureImpl();
        EvoConstants.MAP = new Map(EvoConstants.MAP_SIZE);
        EvoConstants.MAP.addOrganismToTable(instance, 2, 2);
        boolean result = instance.isAdjacent(p1);
        assertFalse(result);
        result = instance.isAdjacent(p2);
        assertTrue(result);
    }

    /**
     * Test of move method, of class Creature.
     */
    public void testMove()
    {
        System.out.println("move");
        int x = EvoConstants.INIT_SPEED;
        int y = EvoConstants.INIT_SPEED;
        Creature instance = new CreatureImpl();
        EvoConstants.MAP = new Map(EvoConstants.MAP_SIZE);
        EvoConstants.MAP.addOrganismToTable(instance, 0, 0);
        //Fill the entire board with creatures, so no movement spots are available
        for (int i = 1; i < EvoConstants.MAP_SIZE; i++)
        {
            for (int j = 0; j < EvoConstants.MAP_SIZE; j++)
            {
                EvoConstants.MAP.addOrganismToTable(new CreatureImpl(), i, j);
            }
        }
        boolean result = instance.move(x, y);
        assertFalse(result);
        EvoConstants.MAP.removeOrganismFromTable((Organism) (EvoConstants.MAP.grid[x][y]));
        assertEquals(null, EvoConstants.MAP.grid[x][y]);
        result = instance.move(1, 1);
        assertFalse(result);
        result = instance.move(x, y);
        assertTrue(result);
    }

    /**
     * Test of jump method, of class Creature.
     */
    public void testJump()
    {
        System.out.println("jump");
        int x = 4;
        int y = EvoConstants.INIT_SPEED + 1;
        Creature instance = new CreatureImpl();
        EvoConstants.MAP = new Map(EvoConstants.MAP_SIZE);
        EvoConstants.MAP.addOrganismToTable(instance, 0, 0);
        //Fill the entire board with creatures, so no movement spots are available
        for (int i = 1; i < EvoConstants.MAP_SIZE; i++)
        {
            for (int j = 0; j < EvoConstants.MAP_SIZE; j++)
            {
                EvoConstants.MAP.addOrganismToTable(new CreatureImpl(), i, j);
            }
        }
        boolean result = instance.jump(x, y);
        assertFalse(result);
        EvoConstants.MAP.removeOrganismFromTable((Organism) (EvoConstants.MAP.grid[x][y]));
        assertEquals(null, EvoConstants.MAP.grid[x][y]);
        result = instance.jump(1, 1);
        assertFalse(result);
        result = instance.jump(x, y);
        assertTrue(result);
    }

    /**
     * This is just a wrapper for the creature abstract class, to make sure
     * its methods function properly
     * 
     */
    public class CreatureImpl extends Creature
    {
        public CreatureImpl(int hp, int at, int de, int sp, double size, int belly, int lifetime)
        {
            super(hp, at, de, sp, size, belly, lifetime);
            
        }
        
        public CreatureImpl()
        {
            super();
            
        }

        @Override
        public void attemptReproduce()
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };

}
