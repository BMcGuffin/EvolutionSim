/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evosim;

/**Represents a creature that eats other creatures. It cannot eat plants.
 *
 * @author bryanmcguffin
 * @version 5-10-17
 * @see Creature
 * @see Carnivorous
 */
public class Carnivore extends Creature implements Carnivorous
{

    public Carnivore(int health, int attack, int defense, int speed, int size, int belly, int lifespan)
    {
        super(health, attack, defense, speed, size, belly, lifespan);
    }
    
    
    public Carnivore reproduce(Herbivore other)
    {
        return (Carnivore) super.reproduce(other);
    }

    @Override
    public void eat(Creature creature)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
