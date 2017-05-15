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
 * @version 5-10-17
 */
public interface Carnivorous
{
    void eat(Creature creature);
    List<Point> findPrey();
}
