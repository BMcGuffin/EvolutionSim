/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evosim;

import evosimComparators.SortByFastest;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bryanmcguffin
 */
public class SimLogic
{

    /**
     * Generates a random number of random organisms and places them on the map.
     * Number of organisms generated is between 1 and the maximum number of
     * allowed entities, inclusive.
     *
     * @param map the map structure that holds the organisms.
     */
    private static void addRandomOrganisms()
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
                placed = EvoConstants.MAP.addOrganismToTable(o, newX, newY);
            }
            placed = false;
        }
        EvoConstants.MAP.sparkUpdate();
    }

    /**
     * For each organism, update its position and status. Check if the creature
     * is still alive. If no, remove it from the board. If yes, and the organism
     * is mobile, make a random movement.
     *
     * @param map The map structure that holds the organisms
     */
    private static void takeTurn(boolean forever)
    {
        EvoConstants.MAP.rearrange(new SortByFastest());
        for (int i = 0; i < EvoConstants.MAP.numberOfOrganisms(); i++)
        {
            Random r = new Random();
            ((Organism) (EvoConstants.MAP.getOrganism(i))).grow();
            if (!forever && !((Organism) (EvoConstants.MAP.getOrganism(i))).isAlive())
            {
                EvoConstants.MAP.removeOrganismFromTable(EvoConstants.MAP.getOrganism(i));
                i--;
            }
            else
            {
                if (EvoConstants.MAP.getOrganism(i) instanceof Mobile)
                {
                    ((Mobile) (EvoConstants.MAP.getOrganism(i))).makeNextMove();
                }
            }
        }
        EvoConstants.MAP.sparkUpdate();
    }

    /**
     * Runs the game. Sets up the board and performs turns.
     *
     * @param map the structure that will hold the organisms
     */
    public static void run(boolean forever)
    {
        //Reset global ID
        EvoConstants.ID = 1;
        //Set up board, add organisms
        addRandomOrganisms();

        try
        {
            sleep(2000);
        }
        catch (InterruptedException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Main loop
        while (true)
        {
            takeTurn(forever);
            try
            {
                sleep(1000);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
