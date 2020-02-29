

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


///////findTailRecursive////////

    public class SnakeGameTester{
    @Test
    public void findTailRecursive() // Test if it finds the tail and doesnt return the head since both of them have 1 neighbor.
                                        // it is expected to return the position of the tail correctly and its length of 6 and position of (0,2)
    {

        boolean [][] board = new boolean[][] {
                {false, false, true, false},
                {false, false, true, false},
                {true, true, true, false},
                {true, false, false, false}};
        int[] expected = new int[] {3,0,6};
        SnakeGame test1= new SnakeGame(board, 0, 2);

        assertArrayEquals(expected, test1.findTailRecursive());
    }
        public void findTailRecursive2() // Test if it finds the tail and doesnt count any other true element that is not part of the snake
        {                               // it is expected to run properly and just count the true elements that form part of the snake with a size of 6 and tail position at (3,4)

            boolean [][] board = new boolean[][] {
                    {true, false, true, false},
                    {false, false, true, false},
                    {true, true, true, false},
                    {true, false, false, false}};
            int[] expected = new int[] {3,4,6};
            SnakeGame test2= new SnakeGame(board, 3, 4);

            assertArrayEquals(expected, test2.findTailRecursive());
        }

        public void findTailRecursive3()
        {
            // test the array with just one element true, to se if the head can be as well the tail, and length will be 1.
            boolean [][] board = new boolean[][] { // this test is expected to fail, since in the conditions of the method the tail must have one neighbor but it can not be the head
                    {false, false, false, false},
                    {false, false, false, false},
                    {false, false, false, true},
                    {false, false, false, false}};
            int[] expected = new int[] {2,3,1};
            SnakeGame test3= new SnakeGame(board, 2, 3);

            assertArrayEquals(expected, test3.findTailRecursive());
        }


        public void findTailRecursive4()
        {                                   // Test if the allocation of the head position is bigger than the length of the array
                                            // test will fail since it reports that the position of tHe head is out of bounds
            boolean [][] board = new boolean[][] { //
                    {false, false, false, false, true, true,},
                    {false, false, false, false, true, false},
                    {false, false, false, false, true, false},
                    {false, false, false, false, true, false},
                    {false, false, false, false, true, false},
                    {false, false, false, false, true, false},
                    {false, false, false, true, true, false},
                    {false, false, false, true, true, false}};
            int[] expected = new int[] {0,4,10};
            SnakeGame test4= new SnakeGame(board, 0, 4);

            assertArrayEquals(expected, test4.findTailRecursive());

        }

        public void findTailRecursive5()
        {                            // Test if the allocation of the head position is bigger than the length of the array
            // test will fail since it reports that the position of tHe head is out of bounds
            boolean[][] board = new boolean[][]{
                    {false, false, false, false, true, true,},
                    {false, false, false, false, true, false},
                    {false, false, false, false, true, false},
                    {false, false, false, false, true, false},
                    {false, false, false, false, true, false},
                    {false, false, false, false, true, false},
                    {false, false, false, true, true, false},
                    {false, false, false, true, true, false}};
            int[] expected = new int[]{0, 4, 10};
            SnakeGame test5 = new SnakeGame(board, 0, 4);

            assertArrayEquals(expected, test5.findTailRecursive());

        }
        public void findTailRecursive6() // Test if the method will be able to find the tail if it is right next to the head.
        {                                  // test will fail since the method neighbors will be looking for the tail which only has one neighbor and this will no bbe the case since there are no elements with only one neighbors and it will create an infinity loop

            boolean [][] board = new boolean[][] {
                        {true, true, true, true, true, false},
                        {true, false, false, false, true, false},
                        {true, false, false, false, true, false},
                        {true, false, false, false, true, false},
                        {true, false, false, false, true, false},
                        {true, false, false, false, true, false},
                        {true, false, false, false, true, false},
                        {true, true, true, true, true, false}};
            int[] expected = new int[] {0,4,22};
            SnakeGame test6= new SnakeGame(board, 0, 4);

            assertArrayEquals(expected, test6.findTailExhaustive(board));
        }







        ///////findTailExhaustive////////

        public void findTailExhaustive() // test that it returns the correct size of the length only counting the true elements that form part of the snake
        {                                  // the expected outcome is 5 since the siz of the snake is 5 without any other true element and a tail position in the (4,4) index


            boolean [][] board = new boolean[][] {
                    {false, false, true, false},
                    {true, false, true, false},
                    {false, false, true, false},
                    {true, false, true, true}};
            int[] expected = new int[] {3,0,5};
            SnakeGame test1= new SnakeGame(board, 0, 2);

            assertArrayEquals(expected, test1.findTailExhaustive(board));
        }



        public void findTailExhaustive2() // This test will make sure that even though it finds the tail in the first check it still keeps counting the length of thee snake
        {                                  // the expected outcome of the size should be 19, and return the tail at the position (0,0)

            boolean [][] board = new boolean[][] {
                    {true, false, false, false, true, false},
                    {true, false, false, false, true, false},
                    {true, false, false, false, true, false},
                    {true, false, false, false, true, false},
                    {true, false, false, false, true, false},
                    {true, false, false, false, true, false},
                    {true, false, false, false, true, false},
                    {true, true, true, true, true, false}};
            int[] expected = new int[] {0,4,19};
            SnakeGame test2= new SnakeGame(board, 0, 4);

            assertArrayEquals(expected, test2.findTailExhaustive(board));
        }


        public void findTailExhaustive3() // Test if the method will be able to find the tail if it is right next to the head.
        {                                  // test will fail since the method neighbors will be looking for the tail which only has one neighbor and this will no bbe the case since there are no elements with only one neighbors and it will create an infinity loop

            boolean [][] board = new boolean[][] {
                    {true, true, true, true, true, false},
                    {true, false, false, false, true, false},
                    {true, false, false, false, true, false},
                    {true, false, false, false, true, false},
                    {true, false, false, false, true, false},
                    {true, false, false, false, true, false},
                    {true, false, false, false, true, false},
                    {true, true, true, true, true, false}};
            int[] expected = new int[] {0,4,22};
            SnakeGame test3= new SnakeGame(board, 0, 4);

            assertArrayEquals(expected, test3.findTailExhaustive(board));
        }

        public void findTailExhaustive4() // Test if the allocation of the head position is bigger than the length of the array
        {                                  // test will fail since it reports that the position of the head is out of bounds

            boolean[][] board = new boolean[][]{
                    {true, false, false, false, true, true},
                    {true, false, false, false, true, false},
                    {true, false, false, false, true, false},
                    {true, false, false, false, true, false},
                    {true, false, false, false, true, false},
                    {true, false, false, false, true, false},
                    {true, false, false, false, true, false},
                    {true, true, true, true, true, false}};
            int[] expected = new int[]{0, 6 , 22};
            SnakeGame test4 = new SnakeGame(board, 0, 6);

            assertArrayEquals(expected, test4.findTailExhaustive(board));

        }


        public void findTailExhaustive5() // Test if tail and size measure can be found with only one element true in the array
        {                                  // test fails because the tail position can not be the same as the head position

            boolean[][] board = new boolean[][]{
                    {false, false, false, false, false, true},
                    {false, false, false, false, false, false},
                    {false, false, false, false, false, false},
                    {false, false, false, false, false, false},
                    {false, false, false, false, false, false},
                    {false, false, false, false, false, false},
                    {false, false, false, false, false, false},
                    {false, false, true, false, false, false}};
            int[] expected = new int[]{7, 2 , 1};
            SnakeGame test5 = new SnakeGame(board, 7, 2);

            assertArrayEquals(expected, test5.findTailExhaustive(board));

        }
    }