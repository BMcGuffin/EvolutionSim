/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evosim;

import java.util.ArrayList;
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
    private Vector<Integer> xValue;
    private Vector<Integer> yValue;

    public Map()
    {
        life = new Vector<Organism>();
        xValue = new Vector<Integer>();
        yValue = new Vector<Integer>();
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

    public void updatePosition(Organism o, int x, int y)
    {

        int index = getIndex(o);
        xValue.setElementAt(x, index);
        yValue.setElementAt(y, index);
        setChanged();
        notifyObservers();
    }

    public int getXPosition(Organism o)
    {
        int index = getIndex(o);
        return xValue.elementAt(index);
    }

    public int getYPosition(Organism o)
    {
        int index = getIndex(o);
        return yValue.elementAt(index);
    }

    public boolean addOrganismToTable(Organism o, int x, int y)
    {
        if (life.size() < (EvoConstants.MAP_SIZE * EvoConstants.MAP_SIZE) && 
                x >= 0 && y >= 0 && null != o && null == grid[x][y])
        {
            life.add(o);
            xValue.add(x);
            yValue.add(y);
            grid[x][y] = o;
            setChanged();
            notifyObservers();
            return o.setPosition(x, y);
        }
        return false;
    }

    public void removeOrganismFromTable(Organism o)
    {
        int index = life.indexOf(o);
        int x = xValue.elementAt(index);
        int y = yValue.elementAt(index);
        life.removeElementAt(index);
        xValue.removeElementAt(index);
        yValue.removeElementAt(index);
        grid[x][y] = null;
        setChanged();
        notifyObservers();
    }

}
