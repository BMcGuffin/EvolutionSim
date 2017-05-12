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
        System.out.println("what");
        try
        {
            sleep(1000);
        }
        catch (InterruptedException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        map.addOrganismToTable(new Carnivore(), 4, 5);
        map.addOrganismToTable(new Carnivore(), 1, 1);
        map.addOrganismToTable(new Carnivore(), 8, 3);
        map.addOrganismToTable(new Carnivore(), 6, 4);
        map.addOrganismToTable(new Carnivore(), 9, 2);
        map.addOrganismToTable(new Carnivore(), 2, 6);
        map.addOrganismToTable(new Carnivore(), 5, 8);
        map.addOrganismToTable(new Carnivore(), 3, 9);

        map.addOrganismToTable(new Herbivore(), 18, 9);
        map.addOrganismToTable(new Herbivore(), 8, 19);
        map.addOrganismToTable(new Herbivore(), 18, 19);
        map.addOrganismToTable(new Herbivore(), 8, 9);
        map.addOrganismToTable(new Herbivore(), 6, 6);
        try
        {
            sleep(1000);
        }
        catch (InterruptedException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        map.addOrganismToTable(new Plant(), 7, 7);
        map.addOrganismToTable(new Plant(), 1, 2);
        map.addOrganismToTable(new Plant(), 4, 4);
        map.addOrganismToTable(new Plant(), 17, 17);

        while (true)
        {
            for (int i = 0; i < map.numberOfOrganisms(); i++)
            {
                Random r = new Random();

                if (map.getOrganism(i) instanceof Mobile)
                {
                    int moveDist = ((Mobile) ((Organism) (map.getOrganism(i)))).getSpeed();
                    int newX = r.nextInt(moveDist) * (int) Math.pow(-1, r.nextInt(2));
                    int newY = r.nextInt(moveDist) * (int) Math.pow(-1, r.nextInt(2));
                    ((Mobile) ((Organism) (map.getOrganism(i)))).move(newX, newY, map);

                }

            }
            try
            {
                sleep(800);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
