/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evosim;

/**Represents a subtype of plant that is carnivorous. Carnivorous plants still
 * cannot move, but they can eat other organisms.
 *
 * @author bryanmcguffin
 * @version 5-10-17
 * @see Plant
 * @see Carnivorous
 */
public class CarnivorousPlant extends Plant implements Carnivorous
{
    @Override
    public void eat(Creature creature)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
