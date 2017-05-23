/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evosimComparators;

import evosimInterfaces.Organism;
import java.util.Comparator;

/**
 * Sorting mechanism that sorts organisms by their position on the map.
 *
 * @author bryanmcguffin
 * @version 5-14-17
 */
public class SortByPosition implements Comparator
{

    /**Decides which organism occurs earlier on the grid. Prioritizes column over
     * row.
     *
     * @param o1 the first organism
     * @param o2 the second organism
     * @return -1 if the first organism has the earlier position, 1 if the
     * second does, 0 if they have the same position or they aren't both
     * organisms
     */
    @Override
    public int compare(Object o1, Object o2)
    {
        if (o1 instanceof Organism && o2 instanceof Organism)
        {
            //o1 has an earlier column: o1 wins
            if (((Organism) o1).getX() < ((Organism) o2).getX())
            {
                return -1;
            }

            //o2 has an earlier column: o2 wins
            else if (((Organism) o1).getX() > ((Organism) o2).getX())
            {
                return 1;
            }

            //o1 and o2 have the same column
            else
            {
                //o1 has an earlier row: o1 wins
                if (((Organism) o1).getY() < ((Organism) o2).getY())
                {
                    return -1;
                }

                //o2 has an earlier row: o2 wins
                else if (((Organism) o1).getY() > ((Organism) o2).getY())
                {
                    return 1;
                }

                //o1 and o2 have the same row: tie
                else
                {
                    return 0;
                }
            }
        }

        //They aren't both organisms: comparison is impossible
        return 0;
    }

}
