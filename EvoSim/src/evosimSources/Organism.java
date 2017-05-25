/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evosimSources;

/**Represents a living organism. Organisms can grow and reproduce.
 *
 * @author bryanmcguffin
 * @version 5-15-17
 */
public interface Organism
{
    /**Checks if the organism is mature.
     * 
     * @return whether the organism meets the requirements to be an "adult"
     */
    boolean isMature();
    
    /**Checks if the organism is still alive.
     * 
     * @return whether the organism meets the requirements to be alive
     */
    boolean isAlive();
    
    /**Set the organism's point location to the given coordinates.
     * 
     * @param x the x-coordinate to set the organism at
     * @param y the y-coordinate to set the organism at
     * @return true if the organism's position was successfully set
     */
    boolean setPosition(int x, int y);
    
    /**Get the organism's current x-position.
     * 
     * @return the X component of the current point location
     */
    int getX();
    
    /**Get the organism's current y-position.
     * 
     * @return the Y component of the current point location
     */
    int getY();
    
    /**Gets the age of the creature in number of turns since creation.
     * 
     * @return the age of the organism
     */
    int getAge();
    
    /**Gets the size of the organism in some sort of units.
     * 
     * @return the size of the organism
     */
    double getSize();
    
    /**Gets the global unique ID number assigned to this organism.
     * 
     * @return the organism's ID
     */
    long getID();
    
    /**Increase the age of this organism, and any other traits associated with
     * it aging. This may include an increase in size, an increase in hunger, etc.
     * 
     */
    void grow();
    
    /**Cause the organism to take a given amount of damage.
     * 
     * @param amount the amount of damage points to do to the organism
     */
    void damage(int amount);   
}
