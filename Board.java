/* this is a helper class that creates a chessboard of n * n size for use with the Knight class.
 * handles all board-related operations, such as clearing a space and marking a space as visited
 */

public class Board 
{
    private int[][] board;

    public Board()
    {
        this.board = new int[5][5];
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board.length; j++)
            {
                board[i][j] = 0;
            }
        }
    }

    //There's probably a more elegant way to render out the board, but this
    //approach works well enough. 
    public void render()
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board.length; j++)
            {
                System.out.print("[ " + board[i][j] + " ] ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void setSpaceVisited(int x, int y, int count)
    {
        board[y][x] = count;
    }

    //when you backtrack from an invalid move, it's necessary to set the previously visited
    //space back to unvisited. I thought it best to make this it's own method, rather than
    //cram it into setSpaceVisited
    public void setSpaceUnvisited(int x, int y)
    {
        board[y][x] = 0;
    }

    public boolean isSpaceVisited(int x, int y)
    {
        if(board[y][x] != 0)
        {
            return true;
        }
        return false;
    } 
}