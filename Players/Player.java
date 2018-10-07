package Players;

import Game.Board;

public interface Player {
    public int play(Board board, char myColor, char enemyColor);

}
