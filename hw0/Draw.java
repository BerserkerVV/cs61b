public class Draw {
   public static void main(String[] args) {
      draw(10);
      
   }
   public static void draw(int N) {
      for (int i = 1;i <= N;i++){
         for (int j = 1;j <=i;j++){
            System.out.print("*");
         }
         System.out.println();
      }

   }
}