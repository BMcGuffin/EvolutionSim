/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evosimSources;

import evosimApp.EvoConstants;
import evosimInterfaces.Organism;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;
import java.util.Vector;

/**
 * Represents the 2D map of the world, upon which organisms reside and move around.
 * Compatible with any organism or object. Keeps a list of all current organisms
 * on the board. Observable; when the position of organisms is updated, this can
 * notify observers which draw the board or reveal statistics. The notify call is
 * abstracted to its own public method so that it can be called at regular intervals
 * by other functions.
 *
 * @author bryanmcguffin
 * @version 5-16-17
 * @see EvoConstants
 */
public class Map extends Observable
{

    public Object[][] grid;
    private int mapSize;
    
    private Vector<Organism> life;

    /**Creates a new blank N x N map. The size of the map depends on the constant
     * defined in EvoConstants. All values of the grid are initialized to null.
     * 
     */
    public Map(int size)
    {
        mapSize = size;
        life = new Vector<Organism>();
        grid = new Object[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++)
        {
            for (int j = 0; j < mapSize; j++)
            {
                grid[i][j] = null;
            }
        }
    }

    /**Returns the index of a particular organism in the list of organisms.
     * 
     * @param o the organism to search for
     * @return the index of the organism
     * @deprecated after 5-15-17. This was never properly implemented, I think.
     */
    private int getIndex(Organism o)
    {
        return life.indexOf(o);
    }
    
    /**Finds the organism at the given index in the list of organisms.
     * 
     * @param index the index of the organism to get
     * @return the organism at position (index)
     */
    public Organism getOrganism(int index)
    {
        return life.elementAt(index);
    }
    
    /**Gets the number of organisms that currently exist on the board.
     * 
     * @return the size of the list of organisms
     */
    public int numberOfOrganisms()
    {
        return life.size();
    }

    /**Add an organism to the table at the given position. Fails if the given
     * position was not null.
     * 
     * @param o the organism to add to the board
     * @param x the x-coordinate at which to add the organism
     * @param y the y-coordinate at which to add the organism
     * @return true if the creature was added to the table successfully; false
     * if the intended position was invalid or occupied
     */
    public boolean addOrganismToTable(Organism o, int x, int y)
    {
        if (life.size() < (mapSize * mapSize) && 
                x >= 0 && y >= 0 && null != o && null == grid[x][y])
        {
            life.add(o);
            grid[x][y] = o;
            return o.setPosition(x, y);
        }
        return false;
    }

    /**Removes an organism from the board and from the list of organisms.
     * 
     * @param o the organism to remove
     * @return true if the orgnism was in the table, and now it is removed,
     * false if the organism was not in the table
     */
    public boolean removeOrganismFromTable(Organism o)
    {
        int index = life.indexOf(o);
        if(index != -1)
        {
        int x = o.getX();
        int y = o.getY();
        life.removeElementAt(index);
        
        grid[x][y] = null;
        return true;
        }
        return false;
    }
    
    /**Cause the board to notify its observers and cause an update.
     * 
     */
    public void sparkUpdate()
    {
        setChanged();
        notifyObservers();
    }
    
    /**Rearrange the list of organisms based on some comparator's compare()
     * method. 
     * 
     * @param c the custom comparator to use for the sort
     */
    public void rearrange(Comparator c)
    {
        Collections.sort(life, c);
    }
}