public class Board 
{
    private int[][] board;

    public Board()
    {
        this.board = new int[4][4];
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board.length; j++)
            {
                board[i][j] = 0;
            }
        }
    }

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