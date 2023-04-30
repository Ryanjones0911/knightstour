/* this class handles all actual logic pertaining to the knight object itself as well as
 * solving the tour. Basically anything to do with the knight is here. 
 */

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

    /* I wanted to give a theoretical user the option of setting their own starting position on the board,
     * so I overloaded the constructor to include that as an option. It's worth noting that for this implementation,
     * every knight object has it's own unique board. This seems counter-intuitive (why not just put new knights on 
     * the same board and clear previous knights) but it ended up being the simplest way to implement it for me.
     */
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

    /* Hoo boy. Alright. So essentially what we're doing here is exactly what you'd expect to do. We're basically
     * just trying all the space combinations until we either get to n total moves (where n is the number of available 
     * spaces) or we run out of possible moves (in which case a full tour is not possible). We do this with recursive
     * backtracking. This one is a bit of a doozy imo so we're going to break it down nearly line by line
     * 
     * 
     * I also didn't end up having enough time to figure out why it isn't printing out the value of the final space.
     * It gets there just fine, but it leaves it as a 0. Would have liked to fix that bug, but I'm out of time.
     */
    public boolean solve()
    {
        //this just sets the initial space as visited. Without it there won't be a space marked '1'
        board.setSpaceVisited(x, y, count);

        //from our starting position (given by the constructor), we iterate through all possible moves a knight can make 
        //(defined above)
        for(int i = 0; i < xMoves.length; i++)
        {
            //if we've made 25 legal moves (25 because this is a 5*5 board), we've solved the tour and can exit
            if(count == 25)
            {
                return true;
            }

            /*before we do anything we have to make sure that our potential next move is both within the bounds of the 
              board and has not already been visited by the knight. If these conditions are both met, we can do the following:
              
              1) increment the count variable. this is so we can keep track of how many total moves we've made

              2) update the x and y coordinates with the move we've made 
                 to reflect the space that we're currently sitting on

              3) render the new move to the board

              we then call this same function recursively and it'll keep running this way until we either reach
              the max possible number of moves (tour has been solved), or we run into an invalid move in which case we:

              1) set the board space back to 0

              2) decrement count as this was not a valid move

              3) return our x and y coordinates to their values before we made the invalid move

              this all has the effect of returning to the previous recursive call and trying a different move. If we never find a valid move
              then the whole thing returns false
            */
            else if ((x + xMoves[i] >= 0 && x + xMoves[i] < 5) && (y + yMoves[i] >=0 && y + yMoves[i] < 5) && !board.isSpaceVisited(x + xMoves[i], y + yMoves[i]))
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

            //I have it rendering every single move it tries just because I like watching it all scroll by, but that's
            //more of a personal preference.
            board.render();
        }
        return false;
    }
}