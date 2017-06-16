package model;



import java.util.Random;

/**
 *
 * @author Admin
 * 
 * This effect delete a random row in the board
 */
public class RandomRowEffect  extends Effect {

    @Override
    public void playEffect(int line, int column, Game game) {
        Random rand = new Random();
        int height = game.getBoard().getHeight();
        int width = game.getBoard().getWidth();
        for (int i = 0; i < width; i++) {
            if (i != column) {
                int j = height-1;
                while (game.getBoard().getTileIJ(j, i).getStatus() != -1 && j > 0) {
                    j--;
                }
                game.getBoard().getTileIJ(j, i).setStatus((Math.abs(rand.nextInt())%game.getNbPlayer())+1);
            }
        }
    }
}