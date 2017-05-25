/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evosimSources;

import java.awt.Point;

/**Represents the traits common to organisms that can move around the world
 * and are not rooted in place.
 *
 * @author bryanmcguffin
 * @version 5-15-17
 */
public interface Mobile
{
    /**Calculate the next move to make.
     * 
     */
    void makeNextMove();
    
    /**Navigate towards the given point.
     * 
     * @param p The target point to move towards.
     */
    void towards(Point p);
    
    /**Navigate in the opposite direction of the given point.
     * 
     * @param p The target point to avoid.
     */
    void awayFrom(Point p);
    
    /**Displace this object by a given vector. Fails if the intended destination
     * is not empty.
     * 
     * @param x the X-component of the intended displacement vector
     * @param y the y-component of the intended displacement vector
     * @return true if this object was able to be displaced; false if the movement
     * failed
     */
    boolean move(int x, int y);
    
    /**Move this object directly to a coordinate point. Fails if the intended
     * destination is not empty.
     * 
     * @param x the X-coordinate to move to
     * @param y the Y-coordinate to move to
     * @return true if the object was able to be moved; false otherwise
     */
    boolean jump(int x, int y);
    
    /**Check if this object's location is directly adjacent to the given point.
     * Diagonals don't count; only straight grid adjacency.
     * 
     * @param p the point to be checked against
     * @return whether this object's location is next to the target point
     */
    boolean isAdjacent(Point p);
    
    /**Return the one-turn movement range of the object.
     * 
     * @return the object's speed
     */
    int getSpeed();
}
