package Players;

import Game.Board;

public class miniMax
{
    //return the index to play
   public static int Play(treePlayer tp, Board board, char myColor, char enemyColor)
   {
       float Max[]=max(tp,board, myColor,enemyColor,4);
        return (int)Max[1];
   }
   //max return the max value + index
    private static float [] max(treePlayer tp, Board board, char myColor, char enemyColor,int depth)
    {
        float toReturn[]=new float[2];
        if(board.hasEnd()|| depth==1)
        {
            toReturn[0]=tp.eval(board, myColor, enemyColor);
        }
        else
        {
            float arr[][]=new float[Board.BOARD_WIDTH][2];
            boolean check[]={false,false,false,false,false,false,false};
            for (int i = 0; i < Board.BOARD_WIDTH; i++)
            {
                Board copy=new Board(board);
                if(copy.insertToCol(i+1,myColor))
                {
                    arr[i] = min(tp, copy, myColor, enemyColor, depth - 1);
                    check[i]=true;
                }

            }
            int i=0;
            while(!check[i]) {   i++;  }
            float Max = arr[i][0];
            int maxIndex = i;

            for ( i = 0; i < Board.BOARD_WIDTH; i++)
            {
                if(check[i] && arr[i][0]>=Max)
                {
                    Max=arr[i][0];
                    maxIndex=i+1;
                }
            }
            toReturn[0]=Max;
            toReturn[1]=maxIndex;
        }
        return toReturn;

    }
    //min return the min value + index
    private static float [] min(treePlayer tp, Board board, char myColor, char enemyColor,int depth)
    {
        float toReturn[]=new float[2];
        if(board.hasEnd()|| depth==1)
        {
            toReturn[0]=tp.eval(board, myColor, enemyColor);
        }
        else
        {
            float arr[][]=new float[Board.BOARD_WIDTH][2];
            boolean check[]={false,false,false,false,false,false,false};
            for (int i = 0; i < Board.BOARD_WIDTH; i++)
            {
                Board copy=new Board(board);
                if(copy.insertToCol(i+1,enemyColor))
                {
                    arr[i] = max(tp, copy, myColor, enemyColor, depth - 1);
                    check[i]=true;
                }
            }
            int i=0;
            while(!check[i]) {   i++;  }
            float Min = arr[i][0];
            int minIndex = i;

            for ( i = 0; i < Board.BOARD_WIDTH; i++)
            {
                if(check[i] && arr[i][0]<Min)
                {
                    Min=arr[i][0];
                    minIndex=i+1;
                }
            }
            toReturn[0]=Min;
            toReturn[1]=minIndex;
        }
        return toReturn;
    }

}
