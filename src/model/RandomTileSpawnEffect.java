package model;



import java.util.Random;

/**
 *
 * @author Admin
 * 
 * This effect spawn a tile of a random color into a randm column
 */
public class RandomTileSpawnEffect extends Effect{

    @Override
    public void playEffect(int line, int column, Game game) {
        Random rand = new Random();
        int height = game.getBoard().getHeight();
        int spawnColumn = Math.abs(rand.nextInt()) % game.getBoard().getWidth();
        int j = height-1;
        while (game.getBoard().getTileIJ(j, spawnColumn).getStatus() != -1 && j > 0) {
            j--;
        }
        game.getBoard().getTileIJ(j, spawnColumn).setStatus((Math.abs(rand.nextInt())%game.getNbPlayer())+1);
            
        
    }
}
