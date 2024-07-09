import java.util.Arrays;
public class Heaps {
    
        class heap{
            int[] arr;
            int size;

            heap(int n ){
                arr = new int[n];
                size = n;
            }
        }

        // delete and return the mininum element
        int delete(heap H){
            int ans = H.arr[0];
            swap(H, 0, H.size-1);
            H.size--;
            int i = 0;
            while(i < H.size){
                int minindex = i;
                int l = 2*i + 1;
                int r = 2*i + 2;
                if( H.arr[r] < H.arr[minindex] && r < H.size){
                    minindex = r;
                }
                if( H.arr[l] < H.arr[minindex]  && l < H.size){
                    minindex = l;
                }
                if(minindex == i){
                    break;
                }
                swap(H, i, minindex);
                i = minindex;
                
                
            }
            return ans;
        }

        void swap(heap H, int i, int j){
            int temp = H.arr[i];
            H.arr[i] = H.arr[j];
            H.arr[j] = temp;
        }

        
        void swap(int[] arr, int i, int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        // insert in a heap
        void insert(heap H,int x){
            int size = H.size+1;
            int[] newArr = new int[size];
            for(int i = 0; i < H.size; i++){
                newArr[i] = H.arr[i];
            }
            newArr[H.size] = x;

            int i = size-1;

            while(i >= 0){
                int parent = (i-1)/2;
                if(newArr[parent] > x){
                    swap(newArr, i, parent);
                    i = parent;
                }else{
                    break;
                }      
            }
            H.arr = newArr;
        }

        public static void main(String[] args) {
            Heaps h = new Heaps();
            heap H = h.new heap(9);
            H.arr[0] = -1;
            H.arr[1] = 2;
            H.arr[2] = 1;
            H.arr[3] = 3;
            H.arr[4] = 5;
            H.arr[5] = 6;
            H.arr[6] = 4;
            H.arr[7] = 7;
            H.arr[8] = 4;

            // System.out.println(h.delete(H));
            // for(int i = 0; i < H.size; i++){
            //     System.out.print(H.arr[i] +" ");
            // }
            // testcases for insert
            h.insert(H, 0);
            System.out.println();
            for(int i = 0; i < H.size; i++){
                 System.out.print(H.arr[i] +" ");
             }



          
        }
        }





    


