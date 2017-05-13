/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evosim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;
import java.util.Vector;

/**
 *
 * @author bryanmcguffin
 */
public class Map extends Observable
{

    public Object[][] grid;
    
    private Vector<Organism> life;

    public Map()
    {
        life = new Vector<Organism>();
        grid = new Object[EvoConstants.MAP_SIZE][EvoConstants.MAP_SIZE];
        for (int i = 0; i < EvoConstants.MAP_SIZE; i++)
        {
            for (int j = 0; j < EvoConstants.MAP_SIZE; j++)
            {
                grid[i][j] = null;
            }
        }
    }

    private int getIndex(Organism o)
    {
        return life.indexOf(o);
    }
    
    public Organism getOrganism(int index)
    {
        return life.elementAt(index);
    }
    
    public int numberOfOrganisms()
    {
        return life.size();
    }

    public boolean addOrganismToTable(Organism o, int x, int y)
    {
        if (life.size() < (EvoConstants.MAP_SIZE * EvoConstants.MAP_SIZE) && 
                x >= 0 && y >= 0 && null != o && null == grid[x][y])
        {
            life.add(o);
            grid[x][y] = o;
            return o.setPosition(x, y);
        }
        return false;
    }

    public void removeOrganismFromTable(Organism o)
    {
        int index = life.indexOf(o);
        int x = o.getX();
        int y = o.getY();
        life.removeElementAt(index);
        
        grid[x][y] = null;
    }
    
    public void sparkUpdate()
    {
        setChanged();
        notifyObservers();
    }
    
    public void rearrange(Comparator c)
    {
        Collections.sort(life, c);
    }
}