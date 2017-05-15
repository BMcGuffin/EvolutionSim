/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evosimComparators;

import evosimInterfaces.Organism;
import java.util.Comparator;

/**
 * Sorting mechanism that sorts organisms based on their size.
 *
 * @author bryanmcguffin
 */
public class SortByLargest implements Comparator
{

    /**
     * Decides which organism is bigger: o1 or o2.
     *
     * @param o1 the first organism
     * @param o2 the second organism
     * @return -1 if o1 is bigger, 1 if o2 is bigger, 0 if a tie or both are not
     * organisms
     */
    @Override
    public int compare(Object o1, Object o2)
    {
        if (o1 instanceof Organism && o2 instanceof Organism)
        {
            //o1 is bigger: o1 wins
            if (((Organism) o1).getSize() > ((Organism) o2).getSize())
            {
                return -1;
            }

            //o2 is bigger: o2 wins
            else if (((Organism) o1).getSize() < ((Organism) o2).getSize())
            {
                return 1;
            }

            //o1 and o2 have the same size: tie
            else
            {
                return 0;
            }
        }

        //They aren't both organisms: comparison is impossible
        return 0;
    }
}
