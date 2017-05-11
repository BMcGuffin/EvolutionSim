/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evosim;

import java.util.Comparator;
import java.util.Random;

/**
 * Represents a simple comparator that decides the outcome of a battle between
 * two creatures.
 *
 * @author bryanmcguffin
 * @version 5-10-17
 * @see Comparator
 */
public class SimpleBattleDecider implements Comparator
{

    /**
     * Barebones simulation of a fight to the death between two creatures.
     *
     * @param o1 The first creature
     * @param o2 The second creature
     * @return 1 if the first creature wins, -1 if the second creature wins, 0
     * if there is a tie OR both passed objects are not creatures
     */
    @Override
    public int compare(Object o1, Object o2)
    {
        Random r = new Random();
        if (o1 instanceof Creature && o2 instanceof Creature)
        {
            Creature c1, c2;
            if (((Creature) o1).getSpeed() > ((Creature) o2).getSpeed())
            {
                c1 = (Creature) o1;
                c2 = (Creature) o2;
                if (c1.getAttack() > (c2.getDefense()))
                {
                    return 1;
                }
                else if (c1.getAttack() < (c2.getDefense()))
                {
                    return -1;
                }
                return 0;
            }
            else if (((Creature) o1).getSpeed() < ((Creature) o2).getSpeed())
            {
                c1 = (Creature) o2;
                c2 = (Creature) o1;
                if (c1.getAttack() > (c2.getDefense()))
                {
                    return -1;
                }
                else if (c1.getAttack() < (c2.getDefense()))
                {
                    return 1;
                }
                return 0;
            }
            else if (r.nextInt() % 2 == 0)
            {
                c1 = (Creature) o1;
                c2 = (Creature) o2;
                if (c1.getAttack() > (c2.getDefense()))
                {
                    return 1;
                }
                else if (c1.getAttack() < (c2.getDefense()))
                {
                    return -1;
                }
                return 0;
            }
            else
            {
                c1 = (Creature) o2;
                c2 = (Creature) o1;
                if (c1.getAttack() > (c2.getDefense()))
                {
                    return -1;
                }
                else if (c1.getAttack() < (c2.getDefense()))
                {
                    return 1;
                }
                return 0;
            }
        }
        return 0;
    }

}
