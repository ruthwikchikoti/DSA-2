package BackTracking;
import java.util.*;

import greedy.activities;
public class problems {
    // generate all n digits numbers using the given array and backtracking 
    public static void generateNumbers(ArrayList<ArrayList<Integer>> ans,int N,ArrayList<Integer> list,int index){
        if(list.size()==N){
            ans.add(new ArrayList<>(list));
                        return;
        }
        list.add(1);
        generateNumbers(ans, N, list, index);
        list.remove(list.size()-1);
        list.add(2);
        generateNumbers(ans, N, list, index);
        list.remove(list.size()-1);
    }

   
        public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            Collections.sort(A);
            generateSubsets(ans, A, list, 0);
            return ans;
        }
        public void generateSubsets(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> A, ArrayList<Integer> list, int index){
            ans.add(new ArrayList<>(list));
            for(int i=index;i<A.size();i++){
                list.add(A.get(i));
                generateSubsets(ans, A, list, i+1);
                list.remove(list.size()-1);
            }
        }
    
    
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        generateNumbers(ans, 2, list, 0);
        System.out.println(ans);
    }   
        
}


