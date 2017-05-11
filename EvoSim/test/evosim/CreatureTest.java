/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evosim;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author bryanmcguffin
 */
public class CreatureTest extends TestCase
{

    public CreatureTest(String testName)
    {
        super(testName);
    }

    public static Test suite()
    {
        TestSuite suite = new TestSuite(CreatureTest.class);
        return suite;
    }

    /**
     * Test of isMature method, of class Creature.
     */
    public void testIsMature()
    {
        System.out.println("isMature");
        Creature instance = new Creature();
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
        Creature instance = new Creature();
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
        Creature instance = new Creature();
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
     * Test of reproduce method, of class Creature.
     */
    public void testReproduce()
    {
        System.out.println("reproduce");
        Creature other = new Creature(10, 2, 4, 7, 6, 11, 20);
        Creature instance = new Creature(10, 20, 4, 9, 8, 11, 10);
        Creature expResult = new Creature(10, 11, 4, 8, 7, 11, 15);
        Creature result = instance.reproduce(other);
        assertEquals(expResult.getHP(), result.getHP());
        assertEquals(expResult.getAttack(), result.getAttack());
        assertEquals(expResult.getDefense(), result.getDefense());
        assertEquals(expResult.getSpeed(), result.getSpeed());
        assertEquals(expResult.getGrowthRate(), result.getGrowthRate());
        assertEquals(expResult.getBelly(), result.getBelly());
        assertEquals(expResult.getLifetime(), result.getLifetime());
    }

    /**
     * Test of move method, of class Creature.
     */
    public void testMove()
    {
        System.out.println("move");
        Map map = new Map();
        Creature instance = new Creature();
        assertTrue(map.addOrganismToTable(instance, 0, 0));
        assertEquals(instance, map.grid[0][0]);
        assertEquals(null, map.grid[5][5]);

        assertTrue(instance.move(5, 5, map));
        assertEquals(null, map.grid[0][0]);
        assertEquals(instance, map.grid[5][5]);

        Creature other = new Creature();
        assertTrue(map.addOrganismToTable(other, 0, 0));
        assertEquals(other, map.grid[0][0]);
        assertEquals(instance, map.grid[5][5]);

        assertFalse(instance.move(-5, -5, map));
        assertEquals(other, map.grid[0][0]);
        assertEquals(instance, map.grid[5][5]);

        assertFalse(instance.move(25, 25, map));
        assertEquals(other, map.grid[0][0]);
        assertEquals(instance, map.grid[5][5]);

        assertTrue(other.move(1, 1, map));
        assertEquals(other, map.grid[1][1]);
        assertEquals(instance, map.grid[5][5]);

        assertTrue(instance.move(-5, -5, map));
        assertEquals(other, map.grid[1][1]);
        assertEquals(instance, map.grid[0][0]);

    }

    /**
     * Test of jump method, of class Creature.
     */
    public void testJump()
    {
        Map map = new Map();
        Creature instance = new Creature();

        assertEquals(null, map.grid[0][0]);
        assertEquals(null, map.grid[5][5]);
        assertFalse(instance.move(5, 5, map));
        assertEquals(null, map.grid[0][0]);
        assertEquals(null, map.grid[5][5]);

        assertTrue(map.addOrganismToTable(instance, 0, 0));
        assertEquals(instance, map.grid[0][0]);
        assertEquals(null, map.grid[5][5]);

        assertTrue(instance.jump(5, 5, map));
        assertEquals(null, map.grid[0][0]);
        assertEquals(instance, map.grid[5][5]);

        Creature other = new Creature();
        assertTrue(map.addOrganismToTable(other, 0, 0));
        assertEquals(other, map.grid[0][0]);
        assertEquals(instance, map.grid[5][5]);

        assertTrue(instance.jump(2, 2, map));
        assertEquals(other, map.grid[0][0]);
        assertEquals(instance, map.grid[2][2]);

        assertFalse(instance.jump(25, 25, map));
        assertEquals(other, map.grid[0][0]);
        assertEquals(instance, map.grid[2][2]);

        assertTrue(other.jump(1, 1, map));
        assertEquals(other, map.grid[1][1]);
        assertEquals(instance, map.grid[2][2]);

        assertFalse(instance.jump(-5, -5, map));
        assertEquals(other, map.grid[1][1]);
        assertEquals(instance, map.grid[2][2]);
    }

    /**
     * Test of getAttack method, of class Creature.
     */
    public void testGetAttack()
    {
        System.out.println("getAttack");
        Creature instance = new Creature();
        int expResult = EvoConstants.INIT_ATTACK;
        int result = instance.getAttack();
        assertEquals(expResult, result);

        instance = new Creature(10, 11, 12, 13, 14, 15, 16);
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
        Creature instance = new Creature();
        int expResult = EvoConstants.INIT_DEFENSE;
        int result = instance.getDefense();
        assertEquals(expResult, result);

        instance = new Creature(10, 11, 12, 13, 14, 15, 16);
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
        Creature instance = new Creature();
        int expResult = EvoConstants.INIT_SPEED;
        int result = instance.getSpeed();
        assertEquals(expResult, result);

        instance = new Creature(10, 11, 12, 13, 14, 15, 16);
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
        Creature instance = new Creature();
        int expResult = EvoConstants.INIT_BELLY;
        int result = instance.getBelly();
        assertEquals(expResult, result);

        instance = new Creature(10, 11, 12, 13, 14, 15, 16);
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
        Creature instance = new Creature();
        int expResult = EvoConstants.INIT_LIFESPAN;
        int result = instance.getLifetime();
        assertEquals(expResult, result);

        instance = new Creature(10, 11, 12, 13, 14, 15, 16);
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
        Creature instance = new Creature();
        int expResult = EvoConstants.INIT_HEALTH;
        int result = instance.getHP();
        assertEquals(expResult, result);

        instance = new Creature(10, 11, 12, 13, 14, 15, 16);
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
        Creature instance = new Creature();
        double expResult = EvoConstants.INIT_GROWTH_RATE;
        double result = instance.getGrowthRate();
        assertEquals(expResult, result);

        instance = new Creature(10, 11, 12, 13, 14, 15, 16);
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
        Creature instance = new Creature();
        double expResult = EvoConstants.INIT_SIZE;
        double result = instance.getSize();
        assertEquals(expResult, result);

        instance = new Creature(10, 11, 12, 13, 14, 15, 16);
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
        Creature instance = new Creature();
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
        Creature instance = new Creature();
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

}
