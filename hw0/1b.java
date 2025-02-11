public class TriangleDrawer
{
   public static void drawTriangle(int N)
   {
     for(int row=1;row<=N;row++)
     {
       for(int col=1;col<=row;col++)
       {
         System.out.print('*');
       }
       System.out.println();
     }
   }
   public static void main(String[] args)
   {
      drawTriangle(10);
   }
}
