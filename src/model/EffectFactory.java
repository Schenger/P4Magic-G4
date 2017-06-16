/**
 * MagicP4
 * IUT Lyon 1 - 2016
 */
package model;

import java.util.Random;

/**
 * Class EffectFactory
 *
 * @author hakkahi - IUT Lyon 1 - 2016
 *
 */
public class EffectFactory {

    /**
     * Returns a random effect chosen amongst the available effects listed
     *
     * @return an effect
     */
    /*QL7 : durée de vie des effets. Dans la version actuelle, les effets sont actifs en permanence, 
    ce qui peut poser problème dans certaines configuration. 
    Votre mission : modifier l'implémentation de sorte à ce que l'on puisse choisir, pour chaque effet, s'il est actif en permanence, 
    ou bien s'il disparaît de la case après avoir été activé un certain nombre de fois. (3 points)
    */
    public static Effect createEffect() {
        int min = 0;
        int max = 2;
        Random rand = new Random();
        //Tire un nombre aléatoire entre min et max compris
        int random = rand.nextInt(max - min + 1) + min;

        switch (random) {

            case 0:
                return new ChangeColorEffect();
            case 1:
                return new DisappearEffect();
            case 2:
                return new RandomTileSpawnEffect();
            
        }

        return null;

    }
    
}
