import java.util.*;


public class temp
{
    @SuppressWarnings("removal")
    public static void main (String[] args) {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Integer arr[] = new Integer[n];
        for(int i = 0; i < n; i++) {
            arr[i] = new Integer(scn.nextInt());
        }
        
        System.out.println("Before sorting: ");
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        
        Comparator<Integer> cmp = (num1, num2) ->
        {
            // while(num1 >  0 && num2 > 0){
            //     int sumofdigitsof_num1 = 0;
            //     int sumofdigitsof_num2 = 0;
            //     while(num1 > 0){
            //         sumofdigitsof_num1 += num1 % 10;
            //         num1 /= 10;
            //     }
            //     while(num2 > 0){
            //         sumofdigitsof_num2 += num2 % 10;
            //         num2 /= 10;
            //     }
            //     if(sumofdigitsof_num1 > sumofdigitsof_num2){
            //         return 1;
            //     }
            //      if(sumofdigitsof_num1 < sumofdigitsof_num2){
            //         return -1;
            //     }
            //     if (sumofdigitsof_num1 == sumofdigitsof_num2) {
            //         if(num1 < num2){
            //             return -1;
            //         }
            //         if(num1 > num2){
            //             return 1;
                    
            //     }
            //     return 0;
            // }
            // };
            // return 0;
    
            if(num1 > num2){
                return -1;
            }
            if(num1 < num2){
                return 1;
            }
            return 0;
        };
        
        Arrays.sort(arr, cmp); 
        
        
        System.out.println();
        System.out.println("After sorting: ");
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
