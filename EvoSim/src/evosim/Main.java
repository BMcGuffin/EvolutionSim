/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evosim;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bryanmcguffin
 * @version 5-10-17
 */
public class Main
{

    public static void addRandomOrganisms(Map map)
    {
        final int typesOfOrganisms = 3;
        Random rand = new Random();
        final int numberToAdd = rand.nextInt(EvoConstants.MAP_MAXIMUM_ENTITIES - 1) + 1;
        boolean placed = false;
        for (int i = 0; i < numberToAdd; i++)
        {
            int type = rand.nextInt(typesOfOrganisms);
            Organism o = null;
            switch (type)
            {
                case 0:
                    o = new Plant();
                    break;
                case 1:
                    o = new Carnivore();
                    break;
                case 2:
                    o = new Herbivore();
                    break;
            }
            while (!placed)
            {
                int newX = rand.nextInt(EvoConstants.MAP_SIZE);
                int newY = rand.nextInt(EvoConstants.MAP_SIZE);
                placed = map.addOrganismToTable(o, newX, newY);
            }
            placed = false;
        }
    }

    public static void takeTurn(Map map)
    {
        for (int i = 0; i < map.numberOfOrganisms(); i++)
        {
            Random r = new Random();
            ((Organism) (map.getOrganism(i))).grow();
            if (!((Organism) (map.getOrganism(i))).isAlive())
            {
                map.removeOrganismFromTable(map.getOrganism(i));
                i--;
            } else
            {
                if (map.getOrganism(i) instanceof Mobile)
                {
                    int moveDist = ((Mobile) ((Organism) (map.getOrganism(i)))).getSpeed();
                    int newX = r.nextInt(moveDist) * (int) Math.pow(-1, r.nextInt(2));
                    int newY = r.nextInt(moveDist) * (int) Math.pow(-1, r.nextInt(2));
                    ((Mobile) ((Organism) (map.getOrganism(i)))).move(newX, newY, map);
                }
            }

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Map map = new Map();
        final MapDisplay mpd = new MapDisplay(map);

        /* Make the JFrame visible */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                mpd.setVisible(true);
            }
        });
        try
        {
            sleep(1000);
        } catch (InterruptedException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        addRandomOrganisms(map);

        while (true)
        {
            takeTurn(map);
            try
            {
                sleep(500);
            } catch (InterruptedException ex)
            {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
