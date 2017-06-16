package model;



/**
 *
 * @author Admin
 * 
 * This effect fall a line of tiles
 * 
 */
public class RowEffect extends Effect {

    @Override
    public void playEffect(int line, int column, Game game) {
        int height = game.getBoard().getHeight();
        int width = game.getBoard().getWidth();
        int player = game.getCurrentPlayer().getId();
        for (int i = 0; i < width; i++) {
            if (i != column) {
                int j = height-1;
                while (game.getBoard().getTileIJ(j, i).getStatus() != -1 && j > 0) {
                    j--;
                }
                game.getBoard().getTileIJ(j, i).setStatus(player);
            }
        }
    }
}
