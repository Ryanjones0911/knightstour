public class KnightsTour 
{
    public static void main(String[] args)
    {
       Knight knight = new Knight();

       if(!knight.solve())
       {
        System.out.println("No tour possible");
       }


    }
}