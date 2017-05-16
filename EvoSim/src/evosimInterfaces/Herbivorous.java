/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evosimInterfaces;

import evosimSources.Plant;
import java.awt.Point;
import java.util.List;

/**Represents the traits common to herbivores, which eat plants but do not eat
 * other creatures.
 *
 * @author bryanmcguffin
 * @version 5-15-17
 */
public interface Herbivorous
{
    /**Eat the given plant, damaging it by some amount and restoring some 
     * amount of fullness.
     * 
     * @param plant the plant to be eaten
     */
    void eat(Plant plant);
    
    /**Find the locations of all nearby predators.
     * 
     * @return a list of the locations of all carnivores within a certain range
     */
    List<Point> findThreats();
    
    /**Find the locations of all nearby food sources.
     * 
     * @return a list of the locations of all plants within a certain range
     */
    List<Point> findFood();
}
