import java.util.HashMap;
import java.util.Map;

public class ModularArithmeticMagic {
    // given two numbers n and m (n >0) find the count of numbers A > 0 such that N%A = M % A
    public static int count_of_numbers(int n, int m){
        int count = 0;
      
        for(int i = 1; i*i <= n; i++){
            if((n-m)%i==0){
                count++;
            }
    }
    return count+1;
    

}
//given an array,and number m  find the pair and count the numbers such that A[i] +A[j] % m ==0 ,(i,j) and (j,i) are same
public static int count_of_pairs_optimized(int[] arr, int m) {
    int count = 0;
    int n = arr.length;

    
    return count;
}
// given an array of size n return true if exists  a subarray with sum divisible by n sum[l-r]%n ==0
    public static boolean is_subarray_divisible_by_n(int[] arr, int n){
        
    }
    public static void main(String[] args) {
        System.out.println(count_of_numbers(10, 4));
    }
}


