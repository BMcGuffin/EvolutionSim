/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evosimInterfaces;

import evosimSources.Creature;
import java.awt.Point;
import java.util.List;

/**Represents traits common to carnivores. Carnivores eat other creatures.
 *
 * @author bryanmcguffin
 * @version 5-15-17
 */
public interface Carnivorous
{
    /**Eat the creature in question, replenishing this organism's hunger.
     * 
     * @param creature the animal to be eaten
     */
    void eat(Creature creature);
    
    /**Get a list of all nearby organisms that could be eaten if caught.
     * 
     * @return A list of point locations of nearby prey
     */
    List<Point> findPrey();
}
