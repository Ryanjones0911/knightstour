public class KnightsTour 
{
    public static void main(String[] args)
    {
       Knight knight = new Knight(2,2);

       //prints the resulting board, with the addition of the string below if a solution couldn't be found
       if(!knight.solve())
       {
        System.out.println("No tour possible");
       }
    }
}