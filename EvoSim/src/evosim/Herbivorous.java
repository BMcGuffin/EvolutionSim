/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evosim;

/**Represents the traits common to herbivores, which eat plants but do not eat
 * other creatures.
 *
 * @author bryanmcguffin
 * @version 5-10-17
 */
public interface Herbivorous
{
    void eat(Plant plant);
}
