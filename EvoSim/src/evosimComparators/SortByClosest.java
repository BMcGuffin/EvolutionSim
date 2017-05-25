/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evosimComparators;

import evosimSources.Organism;
import java.awt.Point;
import java.util.Comparator;

/**
 * Represents a comparator that sorts two objects by their relative distances
 * from some point.
 *
 * @author bryanmcguffin
 * @version 5-15-17
 */
public class SortByClosest implements Comparator
{
    private Point self;
    
    /**Constructs the comparator and gives it a point to check against.
     * 
     * @param p the point to run the comparisons against.
     */
    public SortByClosest(Point p)
    {
        self = p;
    }

    /**
     * Decides which organism is closer to the given point: o1 or o2.
     *
     * @param o1 the first organism
     * @param o2 the second organism
     * @return -1 if o1 is closer, 1 if o2 is closer, 0 if a tie or both are not
     * organisms
     */
    @Override
    public int compare(Object o1, Object o2)
    {
        if (o1 instanceof Organism && o2 instanceof Organism)
        {
            Point p1 = new Point(((Organism) o1).getX(),((Organism) o1).getY());
            Point p2 = new Point(((Organism) o2).getX(),((Organism) o2).getY());
            
            //o1 is closer: o1 wins
            if (self.distance(p1) < self.distance(p2))
            {
                return -1;
            }

            //o2 is closer: o2 wins
            else if (self.distance(p1) > self.distance(p2))
            {
                return 1;
            }

            //o1 and o2 have the same size: tie
            else
            {
                return 0;
            }
        }
        
        //This supports native point comparison too!
        else if (o1 instanceof Point && o2 instanceof Point)
        {

            //o1 is closer: o1 wins
            if (self.distance((Point)o1) < self.distance((Point)o2))
            {
                return -1;
            }

            //o2 is closer: o2 wins
            else if (self.distance((Point)o1) > self.distance((Point)o2))
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
