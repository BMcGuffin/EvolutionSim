/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evosimInterfaces;

import java.awt.Point;

/**Represents the traits common to organisms that can move around the world
 * and are not rooted in place.
 *
 * @author bryanmcguffin
 * @version 5-11-17
 */
public interface Mobile
{
    void makeNextMove();
    void towards(Point p);
    void awayFrom(Point p);
    boolean move(int x, int y);
    boolean jump(int x, int y);
    boolean isAdjacent(Point p);
    int getSpeed();
}
