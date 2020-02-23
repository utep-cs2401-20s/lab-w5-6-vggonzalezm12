public class SnakeGame
{
    private boolean [][] game;
    private int [] headPosition;
    private static int exhaustiveCheck;
    private static int recursiveChecks;


    public SnakeGame()
    {
        game = new boolean [1][1];
    }
    public SnakeGame(boolean [][] b, int x, int y)
    {
        headPosition = new int [2];
        headPosition [0] = x;
        headPosition [1] = y;
    }

    public int[]findTailExhaustive(boolean [][] board)
    {
        // need to look at the current position (0,0) then neighbors if it is part of the snake,if it is not move to the next cell
        // not to be the head (1 neighbor)
        // if it has 2 or more move the next cell
        // return tail (x,y)
        // counter to count the true cell
        int [] tailPosition;
        int tailLength = 0;
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j< board[i].length; j++)
            {
                int hold = neighbors(i,j);
                if(board [i][j] == true)
                {
                    tailLength++;
                    if (hold == 1 && i != headPosition[0] && j!= headPosition[1])
                    {
                        tailPosition = new int [i, j, tailLength];
                        return tailPosition; // return and array of length [3] 1) tail position -- x,y 3) tailLength
                    }
                }
            }
        }

    }

    public int neighbors( int row, int col)
    {
        int countSnake = 0;

        // current: up, down, left, right

        // up
        if (( row -1 >= 0) && (game[row - 1][col]) == true)
            countSnake++;
        // down
        if ((row +1 > game[row].length) && (game[row+1][col]) == true)
            countSnake++;
        //left
        if ((col -1 >= 0) && (game[row][col -1]) == true)
            countSnake++;
        // right
        if ((col < game.length) && (game[row][col + 1]) == true)
            countSnake++;

        return countSnake;
    }
}