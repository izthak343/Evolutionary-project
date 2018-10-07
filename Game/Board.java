package Game;

public class Board
{
    public static final int BOARD_WIDTH = 7;
    public static final int BOARD_HEIGHT = 6;
    public static final char X_BOARD = 'X';
    public static final char O_BOARD = 'O';
    public static final char EMPTY_BOARD = '_';
    private char  board[][];
    private char winer;

    /*init board*/
    public Board()
    {
        board = new char[BOARD_HEIGHT][BOARD_WIDTH];
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                board[i][j]=EMPTY_BOARD;
            }
        }
        winer='_';
    }
    public Board(Board b)
    {
        board = new char[BOARD_HEIGHT][BOARD_WIDTH];
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                board[i][j]=b.getBoard()[i][j];
            }
        }
    }

    public void setBoard(char[][] board)
    {
        this.board = board;
    }

    public char[][] getBoard()
    {
        return board;
    }
    public void setBoard(int i,int j,char player) {
        this.board[i][j] = player;
    }
    public void print() {
        for (int i = BOARD_HEIGHT-1; i >= 0 ; i--) {
            for (int j = 0; j <BOARD_WIDTH ; j++) {
                 System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public boolean insertToCol(int col,char color)
    {
        if ( col < 1 ||col > BOARD_WIDTH || (color!=X_BOARD && color!=O_BOARD) )
            return false;
        for(int i=0;i<BOARD_HEIGHT;i++)
        {
            if(board[i][col-1]==EMPTY_BOARD)
            {
                board[i][col-1]=color;
                return true;
            }
        }
        return false;
    }
    public char getWiner()
    {
        return winer;
    }
    public boolean checkWin() {
        //check row
        for (int i = BOARD_HEIGHT - 1; i >= 0; i--) {
            for (int j = BOARD_WIDTH - 4; j >= 0; j--) {
                if (board[i][j] != EMPTY_BOARD && board[i][j] == board[i][j + 1]
                        && board[i][j] == board[i][j + 2]
                        && board[i][j] == board[i][j + 3]) {
                    winer=board[i][j];
                    return true;
                }
            }
        }
        //check column

        for (int i = BOARD_HEIGHT - 4; i >= 0; i--) {
            for (int j = BOARD_WIDTH - 1; j >= 0; j--) {
                if (board[i][j] != EMPTY_BOARD && board[i][j] == board[i + 1][j]
                        && board[i][j] == board[i + 2][j]
                        && board[i][j] == board[i + 3][j]) {
                    winer=board[i][j];
                    return true;
                }
            }
        }
        //check right diagonal
        for (int i = BOARD_HEIGHT - 4; i >= 0; i--) {
            for (int j = BOARD_WIDTH - 4; j >= 0; j--) {
                if (board[i][j] != EMPTY_BOARD && board[i][j] == board[i + 1][j + 1]
                        && board[i][j] == board[i + 2][j + 2]
                        && board[i][j] == board[i + 3][j + 3]) {
                    winer=board[i][j];
                    return true;
                }
            }
        }
        //check left diagonal
        for (int i = BOARD_HEIGHT - 4; i >= 0; i--) {
            for (int j = BOARD_WIDTH-1; j >= BOARD_WIDTH - 4; j--) {
                if (board[i][j] != EMPTY_BOARD && board[i][j] == board[i + 1][j - 1]
                        && board[i][j] == board[i + 2][j - 2]
                        && board[i][j] == board[i + 3][j - 3]) {
                    winer=board[i][j];
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkDraw()
    {
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                if(board[i][j]==EMPTY_BOARD)
                    return false;
            }
        }
        return true;
    }
    public boolean hasEnd()
    {
        if(checkWin() || checkDraw())
            return true;
        return false;
    }

}
