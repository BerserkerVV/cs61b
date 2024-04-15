public class PosSum {
  public static void windowPosSum(int[] a, int n) {
    int sum = 0;
    for (int i = 0;i < a.length; i++){
      if (a[n] <= 0) {
        continue;
      }
        for (int x = i;x <= i + n;){
        a[x] += a[x+1];
        } 

      }


  }

888
  public static void main(String[] args) {
    int[] a = {1, 2, -3, 4, 5, 4};
    int n = 3;
    windowPosSum(a, n);

    // Should print 4, 8, -3, 13, 9, 4
    System.out.println(java.util.Arrays.toString(a));
  }
}