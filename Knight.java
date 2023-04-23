import java.util.Scanner;

public class Knight
{
    private int[] xMoves = {-2, -1, 1, 2, -2, -1, 1, 2};
    private int[] yMoves = {-1, -2, -2, -1, 1, 2, 2, 1};
    private int x;
    private int y;
    private int count = 1;
    Scanner nextKey = new Scanner(System.in);
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
        board.setSpaceVisited(x, y, count);
        for(int i = 0; i < xMoves.length; i++)
        {
            if(count == 16)
            {
                return true;
            }

            else if ((x + xMoves[i] >= 0 && x + xMoves[i] < 4) && (y + yMoves[i] >=0 && y + yMoves[i] < 4) && !board.isSpaceVisited(x + xMoves[i], y + yMoves[i]))
            {
                count++;
                x += xMoves[i];
                y += yMoves[i];
                board.setSpaceVisited(x, y, count);
                if(solve())
                {
                    return true;
                }
                else
                {
                    board.setSpaceUnvisited(x, y);
                    count--;
                    x -= xMoves[i];
                    y -= yMoves[i];
                }
            }
            board.render();
            //nextKey.nextLine();
        }
        return false;
    }
}