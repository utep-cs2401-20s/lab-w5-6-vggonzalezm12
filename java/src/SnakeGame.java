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

        // RESET THE COUNTER
        exhaustiveCheck = 0;

        // need to look at the current position (0,0) then neighbors if it is part of the snake,if it is not move to the next cell
        // not to be the head (1 neighbor)
        // if it has 2 or more move the next cell
        // return tail (x,y)
        // counter to count the true cell
        int [] tailPosition = new int [3];
        int tailLength = 0;
        for(int row = 0; row < board.length; row++)
        {
            for(int col = 0; col< board[row].length; col++)
            {
                // INCREMENT EXHAUSTIVE CHECKS AND REST WHEN FOUND IT
                exhaustiveCheck++;
                int hold = neighbors(row,col);
                if(board [row][col] == true)
                {
                    tailPosition[2]++;
                    if (hold == 1 && row != headPosition[0] && col!= headPosition[1])
                    {

                        tailPosition[0]= row;
                        tailPosition[1] = col;
                        exhaustiveCheck--;

                    }
                }
            }
        }

        return tailPosition; // return and array of length [3] 1) tail position -- x,y 3) tailLength

    }


    public int[] findTailRecursive()
    {

        // RESET THE COUNTER
        recursiveChecks= 0;

        // Find the Head position

        for (int row = 0; row < game.length; row++) // rows
        {
            for (int col = 0; col < game[row].length; col++) // columns
            {
                if (row == headPosition[0] && col == headPosition[1])
                {
                    // start looking for the snake (true ones)
                    int [] currentPosition = new int [2];
                    currentPosition[0]= headPosition[0];
                    currentPosition [1] = headPosition [1];
                }
            }

        }
        // NEIGHBORS AND MAKE SURE THE NEIGHBOR IS NOT THE ONE WE CAME FROM
        //

    }

    private int[] findTailRecursive (int[] currentPosition, int[] previousPosition)
    {

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