/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evosimApp;

import evosimComparators.SortByFastest;
import evosimSources.Carnivore;
import evosimSources.Carnivorous;
import evosimSources.Creature;
import evosimSources.Herbivore;
import evosimSources.Herbivorous;
import evosimSources.Mobile;
import evosimSources.Organism;
import evosimSources.Plant;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan McGuffin
 */
public class PlantGrowthTestLogic extends AppLogic
{
    @Override
    public void setup()
    {
        Random rand = new Random();
        final int numberToAdd = rand.nextInt((int) ((EvoConstants.MAP_MAXIMUM_ENTITIES - 1) * 0.8)) + 1;
        boolean placed = false;
        for (int i = 0; i < numberToAdd; i++)
        {
            Organism p = new Plant();
            while (!placed)
            {
                int newX = rand.nextInt(EvoConstants.MAP_SIZE);
                int newY = rand.nextInt(EvoConstants.MAP_SIZE);
                placed = EvoConstants.MAP.addOrganismToTable(p, newX, newY);
            }
            placed = false;
        }
        EvoConstants.MAP.sparkUpdate();
    }

    @Override
    public void takeTurn(boolean runForever)
    {
        EvoConstants.MAP.rearrange(null);
        for (int i = 0; i < EvoConstants.MAP.numberOfOrganisms(); i++)
        {
            ((Organism) (EvoConstants.MAP.getOrganism(i))).grow();
            if (!runForever && !((Organism) (EvoConstants.MAP.getOrganism(i))).isAlive())
            {
                EvoConstants.debug("Organism " + ((Organism) (EvoConstants.MAP
                        .getOrganism(i))).getID() + " died");
                EvoConstants.MAP.removeOrganismFromTable(EvoConstants.MAP.getOrganism(i));
                i--;
            }
        }
        EvoConstants.MAP.sparkUpdate();
    }

}
