/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evosim;

/**Represents a living organism. Organisms can grow and reproduce.
 *
 * @author bryanmcguffin
 * @version 5-10-17
 */
public interface Organism
{
    boolean isMature();
    boolean isAlive();
    boolean setPosition(int x, int y);
    int getX();
    int getY();
    int getAge();
    Organism reproduce(Organism other);
    void grow();
    void damage(int amount);   
}
