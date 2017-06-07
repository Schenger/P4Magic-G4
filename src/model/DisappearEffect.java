/**
 * MagicP4
 * IUT Lyon 1 - 2016
 */
package model;

/**
 *
 * @author hakkahi / acordier - IUT Lyon 1 - 2016
 */
public class DisappearEffect extends Effect {

    /**
     * TODO
     */
    @Override
    public void playEffect(int line, int column, Game game) {
        int tile_id = game.getBoard().getTileIJ(line, column).getStatus();
        int player1_id = game.getPlayer1().getId();
        int player2_id = game.getPlayer2().getId();
        
        if (tile_id == player1_id){
            tile_id = -1;
        }else if (tile_id ==player2_id){
            tile_id =-1;
        }
        game.getBoard().getTileIJ(line, column).setStatus(tile_id);

    }

}
