public class Finde {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        int num = m[0];
        int i = 1;
        while (i < m.length){
            if(num < m[i]){
                num = m[i];
            }
            i++;
        }
        return num;
    }

    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};      
       System.out.println(max(numbers)); // 输出 22
    }
}
