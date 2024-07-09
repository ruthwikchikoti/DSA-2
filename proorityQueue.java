import java.util.*;
public class proorityQueue {
    
    // given an array, find the k smallest elements.

           public static  int[] k_smallest(int[] A,int k){
            int[] ans = new int[k];
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i=0;i<A.length;i++){
                pq.add(A[i]);

            }

            for(int i=0;i<k;i++){
                ans[i] = pq.poll();
            }
            return ans;
        }
    
        // given a K-sorted array, sort the array
        public static int[] sorted(int[] A,int k){
            int[] ans = new int[A.length];
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i=0;i<=k;i++){
                pq.add(A[i]);
            }
            int index = 0;
            for(int i=k+1;i<A.length;i++){
                ans[index] = pq.poll();
                pq.add(A[i]);
                index++;
            }
            while(pq.size() > 0){
                ans[index] = pq.poll();
                index++;
            }
            return ans;
        }

        // sort any array
        public static int[] sort(int[] A){
            int[] ans = new int[A.length];
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i=0;i<A.length;i++){
                pq.add(A[i]);
            }
            int index = 0;
            while(pq.size() > 0){
                ans[index] = pq.poll();
                index++;
            }
            return ans;
        }

        // median of a Stream of integers
        public int[] median(int[] A) {
            

        

        public static void main(String[] args) {
            int A[] = {7,2,9,1,10,3,5,8,12,50};
            int k = 5;
            int [] result = k_smallest(A, k);
            for(int i=0;i<result.length;i++){
                System.out.print(result[i]+" ");
            }
        }
    }
    


