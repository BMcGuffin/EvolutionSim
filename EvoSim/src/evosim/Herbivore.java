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
    public Herbivore(int health, int attack, int defense, int speed, double gRate, int belly, int lifespan)
    {
        super(health, attack, defense, speed, gRate, belly, lifespan);
    }
    
    /**Creates a new Herbivore offspring from two parents, this and the other.
     * 
     * @param other the herbivore to be "mated" with this one
     * @return a new herbivore with a mix of its parents' traits
     */
    public Herbivore reproduce(Herbivore other)
    {
         if (other instanceof Herbivore)
        {
            Herbivore ho = (Herbivore) other;
            int newHP = (this.hp + ho.getHP()) / 2;
            int newAtt = (this.at + ho.getAttack()) / 2;
            int newDef = (this.de + ho.getDefense()) / 2;
            int newSpd = (this.sp + ho.getSpeed()) / 2;
            double newGr = (this.growthRate + ho.getGrowthRate()) / 2;
            int newBl = (this.belly + ho.getBelly()) / 2;
            int newLife = (this.lifetime + ho.getLifetime()) / 2;
            return new Herbivore(newHP, newAtt, newDef, newSpd, newGr, newBl, newLife);
        }
        return null;
    }

    /**While the creature is still hungry and the plant can still be eaten,
     * take another bite.
     * 
     * @param plant 
     * @pre plant.isAlive() && this.isHungry()
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
