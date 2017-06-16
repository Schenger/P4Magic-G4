package model;

import model.Board;
import model.Game;
import model.RowEffect;
import model.Utils;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author p1607618
 */
public class RowEffectTest {
     static Game aGame;
     
        public RowEffectTest() {
        }
     
        @BeforeClass
        public static void setUpClass() {
     
        }
     
        @AfterClass
        public static void tearDownClass() {
        }
     
        @Before
        public void setUp() {
     
            // Création d'un jeu vide
            aGame = new Game();
            Board b = new Board(10, 10);
            aGame.setBoard(b);
     
        }
     
        @After
        public void tearDown() {
        }
     
        /**
         * Test du bon fonctionnement du jeu, en dehors de l'effet Résultats
         * attendus après le coup : - un pion de plus sur le plateau - le tour de
         * jeu est passé - l'effet a bien été appliqué
         */
        @Test
        public void testRowEffectNormalGame() {
     
            // On pré-remplit le plateau pour les besoins de la simulation 
            Utils.simulateAGame(aGame);
     
            // Effet fixé sur une case (qui n'est pas encore remplie)
            int height = aGame.getBoard().getHeight();
            // height-3 correspond à la première case vide dans la colonne O, vu que l'on a déjà joué deux coups dans cette colonne
            aGame.getBoard().getTileIJ(height - 3, 0).setEffect(new RowEffect());
     
            // Récupération de l'ID du joueur avant que le coup soit joué 
            int id_player = aGame.getCurrentPlayer().getId();
     
            // Récupération du nombre de pions présents 
            int nb_tokens_before = aGame.getBoard().getTotalTilesCount();
     
            // Coup joué sur une case ne contenant pas l'effet 
            aGame.playMove(1);
     
            // Récupération du nombre de pions après le coup 
            int nb_tokens_after = aGame.getBoard().getTotalTilesCount();
     
            // Vérifications :
            // - l'effet est bien appliqué sur la case 
            // - le tour de jeu a bien changé
            // - il y a bien un pion de plus sur le plateau
            assertTrue("Doit être d'effet row", aGame.getBoard().getTileIJ(height - 3, 0).getEffect() instanceof RowEffect);
            assertTrue(aGame.getCurrentPlayer().getId() != id_player);
            assertEquals(nb_tokens_before + 1, nb_tokens_after);
        }
     
        /**
         * Test de RowEffect sur grille vide 
         * Vérification de l'état de la
         * tuile après application de l'effet 
         * Résultats attendus : la grille doit compter 10 pions
         */
        @Test
        public void testRowEffectEmptyGame() {
     
            // Effet fixé sur une case 
            int height = aGame.getBoard().getHeight();
            aGame.getBoard().getTileIJ(height - 1, 0).setEffect(new RowEffect());
     
            // Récupération de l'ID du joueur courant 
            int id_player = aGame.getCurrentPlayer().getId();
     
            // Coup joué sur la case de l'effet 
            aGame.playMove(0);
     
            // Vérifications 
            // - le nombre de pions sur le plateau est de 10
            // - l'effet est bien appliqué sur la case 
            // - le tour de jeu a bien changé
            assertEquals(10, aGame.getBoard().getTilesCountPlayer1());
            assertEquals(10, aGame.getBoard().getTotalTilesCount());
            assertTrue("Doit être d'effet row", aGame.getBoard().getTileIJ(height - 1, 0).getEffect() instanceof RowEffect);
            assertTrue(aGame.getCurrentPlayer().getId() != id_player);
     
        }
     
        /**
         * Test de RowEffect sur grille pré-remplie 
         * Vérification de l'état de
         * la tuile après application de l'effet 
         * Résultat attendu : La grille doit contenir 10 pions du joueur courant de plus
         * l'effet doit être sur la case 
         * et le tour doit être passé
         */
        @Test
        public void testRowEffectFilledGame() {
     
            // On pré-remplit le plateau pour les besoins de la simulation 
            Utils.simulateAGame(aGame);
     
            // Effet fixé sur une case (qui n'est pas encore remplie)
            int height = aGame.getBoard().getHeight();
            // height-3 correspond à la première case vide dans la colonne O, vu que l'on a déjà joué deux coups dans cette colonne
            aGame.getBoard().getTileIJ(height - 3, 0).setEffect(new RowEffect());
     
            // Récupération de l'ID du joueur avant que le coup soit joué 
            int id_player = aGame.getCurrentPlayer().getId();
     
            // Récuperation du nombre de pions 
            int tile = aGame.getBoard().getTotalTilesCount();
            
            // Coup joué sur cette case 
            aGame.playMove(0);
     
            // Vérifications :
            // - le nombre de pions est incrementer de 10
            // - l'effet est bien appliqué sur la case 
            // - le tour de jeu a bien changé
            assertEquals(tile + 10, aGame.getBoard().getTotalTilesCount());
            assertTrue("Doit être d'effet row", aGame.getBoard().getTileIJ(height - 3, 0).getEffect() instanceof RowEffect);
            assertTrue(aGame.getCurrentPlayer().getId() != id_player);
     
        }
     
    }
