public class Find{
	public static int forMax(int[] m){
		int num = m[0];
		for (int i = 1; i < m.length;i++){
			if (num < m[i]){
				num = m[i];
			}

		}
		return num;
	}
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};     
       System.out.println(forMax(numbers));      
    }	
}