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

    /**Generates a new herbivore from scratch.
     * 
     */
    public Herbivore()
    {
        super();
    }
    
    /**Generates a new herbivore from existing parameters.
     * 
     * @param health
     * @param attack
     * @param defense
     * @param speed
     * @param size
     * @param belly the amount of food the herbivore can store.
     * @param lifespan the amount of turns the creature can exist.
     */
    public Herbivore(int health, int attack, int defense, int speed, int size, int belly, int lifespan)
    {
        super(health, attack, defense, speed, size, belly, lifespan);
    }
    
    /**Creates a new Herbivore offspring from two parents, this and the other.
     * 
     * @param other the herbivore to be "mated" with this one
     * @return a new herbivore with a mix of its parents' traits
     */
    public Herbivore reproduce(Herbivore other)
    {
        return (Herbivore) super.reproduce(other);
    }

    /**While the creature is still hungry and the plant can still be eaten,
     * take another bite.
     * 
     * @param plant 
     */
    @Override
    public void eat(Plant plant)
    {
        plant.damage(1);
        this.fullness++;
        if(plant.isAlive() && this.isHungry())
            eat(plant);
    }
    
}
