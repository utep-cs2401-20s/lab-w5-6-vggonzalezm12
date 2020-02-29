public class SnakeGame
{
    private boolean [][] game;
    private int [] headPosition;
    private static int exhaustiveChecks;
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
        resetCounters();

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
                exhaustiveChecks++;
                int hold = neighbors(row,col);
                if(board [row][col])
                {
                    tailPosition[2]++;// length
                    if (hold == 1 && row != headPosition[0] && col!= headPosition[1])
                    {

                        tailPosition[0]= row;
                        tailPosition[1] = col;
                        exhaustiveChecks--;

                    }
                }
            }
        }

        return tailPosition; // return and array of length [3] 1) tail position -- x,y 3) tailLength

    }


    public int[] findTailRecursive()
    {

        // reset counter
        resetCounters();

        int [] tailPosition = new int [3];
        // Find the Head position

        for (int row = 0; row < game.length; row++) // rows
        {
            for (int col = 0; col < game[row].length; col++) // columns
            {
                if (row == headPosition[0] && col == headPosition[1])
                {
                    // start looking for the snake (true ones)
                    tailPosition = findTailRecursive(headPosition,headPosition);
                }
            }

        }
        // NEIGHBORS AND MAKE SURE THE NEIGHBOR IS NOT THE ONE WE CAME FROM
        return tailPosition;
    }

    private int[] findTailRecursive (int [] currentPosition, int [] previousPosition)
    {

        int snakeLength = 1;
        int [] tailPosition = new int [3];

        /* char right = game[row][col + 1];
        char left = game[row][col - 1];
        char up = game[row - 1][col];
        char down = game [row + 1][col]; */

        int row = currentPosition[0];
        int col = currentPosition[1];
        int prevRow = previousPosition[0];
        int prevCol = previousPosition[1];

        int [] newPosition = new int[2];

        //base case
        if( neighbors(row, col) == 1)
        {
            if (headPosition [0] != row && headPosition [1] != col)
            {
                tailPosition[0]= row;
                tailPosition[1] = col;
                tailPosition[2] = snakeLength;
            }
        }

        if ((row != prevRow) || (col+1 != prevCol))
        {
            if (game[row][col+1])
            {
                recursiveChecks++;
                snakeLength++;
                newPosition[0] = row;
                newPosition[1] = col+1;
                return findTailRecursive(newPosition, currentPosition);
            }

        }

       if ((row != prevRow || col -1!= prevCol))
        {
            if (game[row][col-1])
            {
                recursiveChecks++;
                snakeLength++;
                newPosition[0] = row;
                newPosition[1] = col - 1;
                return findTailRecursive(newPosition, currentPosition);
            }

        }

        if ((row - 1 != prevRow || col != prevCol))
        {
            if (game[row-1][col])
            {
                recursiveChecks++;
                snakeLength++;
                newPosition[0] = row-1;
                newPosition[1] = col;
                return findTailRecursive(newPosition, currentPosition);
            }

        }

        if((row +1 != prevRow || col != prevCol))
        {
            if (game[row+1][col])
            {
                recursiveChecks++;
                snakeLength++;
                newPosition[0] = row+1;
                newPosition[1] = col;
                return findTailRecursive(newPosition, currentPosition);
            }

        }
       return tailPosition;
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

    private void resetCounters()
    {
        exhaustiveChecks = 0;
        recursiveChecks = 0;

    }

    private int getRecursiveChecks()
    {
        return this.recursiveChecks;
    }

    private int getExhaustiveChecks()
    {
        return this.exhaustiveChecks;
    }
}