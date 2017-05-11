/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evosim;

/**Represents a creature that eats plants, but not other creatures.
 *
 * @author bryanmcguffin
 * @version 5-10-17
 * @see Creature
 * @see Herbivorous
 */
public class Herbivore extends Creature implements Herbivorous
{

    public Herbivore(int health, int attack, int defense, int speed, int size, int belly, int lifespan)
    {
        super(health, attack, defense, speed, size, belly, lifespan);
    }
    
    
    public Herbivore reproduce(Herbivore other)
    {
        return (Herbivore) super.reproduce(other);
    }

    @Override
    public void eat(Plant plant)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
