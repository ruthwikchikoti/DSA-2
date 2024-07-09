public class mod {
    
    //given an array of integers A and another number N,return A%N
    public static int mod(int[] A, int N) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            result = (result + A[i]) % N;
        }
        return result;
    }
}
