public class ClassNameHere
{
   public static int max(int[] m)
   {
     int mmax=m[0];
     for(int i=1;i<m.length;i++)
       if(m[i]>mmax)
         mmax=m[i];
     return mmax;
   }
   public static void main(String[] args)
   {
      int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};      
      System.out.print(max(numbers));
   }
}
