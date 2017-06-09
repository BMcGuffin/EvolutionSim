/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evosimApp;

import evosimSources.Carnivore;
import evosimSources.Herbivore;
import evosimSources.Plant;
import evosimSources.Organism;
import evosimSources.Mobile;
import evosimComparators.SortByFastest;
import evosimSources.Carnivorous;
import evosimSources.Herbivorous;
import evosimSources.Creature;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Holds the logic that runs the main simulation and each of its turns. Sets up
 * the board and causes events to happen per turn.
 *
 * @author Bryan McGuffin
 * @version 5-15-17
 */
public class StandardSimLogic extends AppLogic
{

    /**
     * Generates a random number of random organisms and places them on the map.
     * Number of organisms generated is between 1 and the maximum number of
     * allowed entities, inclusive.
     *
     */
    @Override
    public void setup()
    {
        final int typesOfOrganisms = 3;
        Random rand = new Random();
        final int numberToAdd = rand.nextInt(EvoConstants.MAP_MAXIMUM_START_ENTITIES - 1) + 1;
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
     * For each organism, update its position and status. If the organism is
     * mobile, let it make its next move.
     *
     * @param forever if false, organisms age and die like normal; otherwise,
     * organisms do not age
     */
    @Override
    public void takeTurn(boolean forever)
    {
        EvoConstants.MAP.rearrange(new SortByFastest());
        for (int i = 0; i < EvoConstants.MAP.numberOfOrganisms(); i++)
        {
            Random r = new Random();
            ((Organism) (EvoConstants.MAP.getOrganism(i))).grow();
            if (!forever && !((Organism) (EvoConstants.MAP.getOrganism(i))).isAlive())
            {
                
                EvoConstants.debug("Organism "+ ((Organism) (EvoConstants.MAP
                        .getOrganism(i))).getID() + " died");
                EvoConstants.MAP.removeOrganismFromTable(EvoConstants.MAP.getOrganism(i));
                i--;
            }
            else
            {
                if (EvoConstants.MAP.getOrganism(i) instanceof Mobile)
                {
                    ((Mobile) (EvoConstants.MAP.getOrganism(i))).makeNextMove();
                }

                if (EvoConstants.MAP.getOrganism(i) instanceof Carnivorous)
                {
                    Creature c = ((Carnivorous) (EvoConstants.MAP.getOrganism(i))).targetCaught();
                    if (c != null)
                    {
                        c.damage(100);
                        ((Carnivorous) (EvoConstants.MAP.getOrganism(i))).eat(c);
                        EvoConstants.debug("Creature "+ c.getID() + " was eaten by organism "
                            + ((Organism) (EvoConstants.MAP.getOrganism(i))).getID());
                        EvoConstants.MAP.removeOrganismFromTable(c);
                    }

                }

                if (EvoConstants.MAP.getOrganism(i) instanceof Herbivorous)
                {
                    Plant p = ((Herbivorous) (EvoConstants.MAP.getOrganism(i))).foodReached();
                    if (p != null)
                    {
                        ((Herbivorous) (EvoConstants.MAP.getOrganism(i))).eat(p);
                        if (!p.isAlive())
                        {
                            EvoConstants.debug("Plant "+ p.getID() + " was eaten by organism "
                            + ((Organism) (EvoConstants.MAP.getOrganism(i))).getID());
                            EvoConstants.MAP.removeOrganismFromTable(p);
                        }
                    }
                }

            }
        }
        EvoConstants.MAP.sparkUpdate();
    }
}
