/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evosim;

/**Represents the traits common to organisms that can move around the world
 * and are not rooted in place.
 *
 * @author bryanmcguffin
 * @version 5-10-17
 */
public interface Mobile
{
    void move(int x, int y, Object[][] grid);
    void jump(int x, int y, Object[][] grid);
}
