public class Knight
{
    private int[] xMoves = {-2, -1, 1, 2, -2, -1, 1, 2};
    private int[] yMoves = {-1, -2, -2, -1, 1, 2, 2, 1};
    private int x;
    private int y;
    private int count = 1;
    Board board;

    public Knight()
    {
        this.x = 0; //starting x
        this.y = 0; //starting y
        this.board = new Board();
    }

    public Knight(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.board = new Board();
    }
    public boolean solve()
    {
        board.render();
        for(int i = 0; i < xMoves.length; i++)
        {
            int newX = x + xMoves[i];
            int newY = y + yMoves[i];
            board.setSpaceVisited(x, y, count);

            if(count == 64)
            {
                return true;
            }

            else if ((newX >= 0 && newX < 8) && (newY >=0 && newY < 8) && !board.isSpaceVisited(newX, newY))
            {
                x += xMoves[i];
                y += yMoves[i];
                count++;
                board.setSpaceVisited(x, y, count);
                if(solve())
                {
                    return true;
                }
                else
                {
                    x -= xMoves[i];
                    y -= yMoves[i];
                    count--;
                    board.setSpaceUnvisited(x, y);
                }
            }
            board.render();
        }
        return false;
    }
}