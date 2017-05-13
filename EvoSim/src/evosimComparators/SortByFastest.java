/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evosimComparators;

import evosim.Mobile;
import evosim.Organism;
import java.util.Comparator;

/**Sorting mechanism that sorts organisms depending on their speed.
 *
 * @author bryanmcguffin
 */
public class SortByFastest implements Comparator
{

    /**Decides which organism is faster: o1 or o2.
     * 
     * @param o1 the first organism
     * @param o2 the second organism
     * @return 1 if o1 is faster, -1 if o2 is faster, 0 if a tie or both are not 
     * organisms
     */
    @Override
    public int compare(Object o1, Object o2)
    {
        if(o1 instanceof Organism && o2 instanceof Organism)
        {
            //o1 is mobile and o2 is not: o1 wins
            if(o1 instanceof Mobile && !(o2 instanceof Mobile))
            {
                return 1;
            }
            
            //o2 is mobile and o1 is not: o2 wins
            else if(o2 instanceof Mobile && !(o1 instanceof Mobile))
            {
                return -1;
            }
            
            //neither are mobile: tie
            else if(!(o1 instanceof Mobile) && !(o2 instanceof Mobile))
            {
                return 0;
            }
            
            //both are mobile
            else
            {
                //o1 is faster: o1 wins
                if(((Mobile)o1).getSpeed() > ((Mobile)o2).getSpeed())
                {
                    return 1;
                }
                
                //o2 is faster: o2 wins
                else if(((Mobile)o1).getSpeed() < ((Mobile)o2).getSpeed())
                {
                    return -1;
                }
                
                //o1 and o2 have the same speed: tie
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
