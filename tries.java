import java.util.*;

public class tries {
    static class TrieNode {
        HashMap<Character, TrieNode> Map;
        boolean isEnd;

        public TrieNode() {
            Map = new HashMap<Character, TrieNode>();
            isEnd = false;
        }
    }

    // insert a word into a trie
    public static  void insert(TrieNode root, String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.Map.containsKey(c)) {
                cur.Map.put(c, new TrieNode());
            }
            cur = cur.Map.get(c);
        }
        cur.isEnd = true;
    }
    
    public static void insert_(TrieNode root,Character c){
        TrieNode cur = root;
        if(!cur.Map.containsKey(c)){
            cur.Map.put(c,new TrieNode());
        }
        cur = cur.Map.get(c);
        cur.isEnd = true;
    }

    // search for a word in a trie
        public static boolean search(TrieNode root, String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.Map.containsKey(c)) {
                return false;
            }
            cur = cur.Map.get(c);

        }
        return cur.isEnd;
    }
    
    // delete a word from a trie
    public static void delete(TrieNode root, String word){
        if(search(root,word)){
            TrieNode cur = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(cur.Map.get(c).Map.size() == 1){
                    cur.Map.remove(c);
                    return;
                }
                cur = cur.Map.get(c);
            }
            cur.isEnd = false;
        }
    }



    // given a list of strings, return the longest common prefix
    public static String prefix(ArrayList<String> list){
        TrieNode root = new TrieNode();
        for(String s : list){
            TrieNode cur = root;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(!cur.Map.containsKey(c)){
                    cur.Map.put(c,new TrieNode());
                }
                cur = cur.Map.get(c);
            }
            cur.isEnd = true;
        }
        TrieNode cur = root;
        String prefix = "";
        while(cur.Map.size() == 1){
            for(Map.Entry<Character,TrieNode> entry : cur.Map.entrySet()){
                prefix += entry.getKey();
                cur = entry.getValue();
            }
        }
        return prefix;
    }
    
    




    // 
    // given a 2d matrix of 0's and 1's, count the number of distinct rows
     public static int countDistinctRows(int[][] matrix){
        TrieNode root = new TrieNode();
        for(int i = 0; i < matrix.length; i++){
            TrieNode cur = root;
            for(int j = 0; j < matrix[0].length; j++){
                if(!cur.Map.containsKey(matrix[i][j])){
                    cur.Map.put(matrix[i][j],new TrieNode());
                }
                cur = cur.Map.get(matrix[i][j]);
            }
            cur.isEnd = true;
        }
        return countDistinctRows(root);
    }
    public static int countDistinctRows(TrieNode root){
        if(root.Map.size() == 0){
            return 1;
        }
        int count = 0;
        for(Map.Entry<Character,TrieNode> entry : root.Map.entrySet()){
            count += countDistinctRows(entry.getValue());
        }
        return count;
    }







    // given an array of integers, find the pair with maximum XOR using trie


    public static int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            Set<Integer> set = new HashSet<>();
            
            for (int num : nums) {
                set.add(num & mask);
            }
            
            int temp = max | (1 << i);
            
            for (int prefix : set) {
                if (set.contains(temp ^ prefix)) {
                    max = temp;
                    break;
                }
            }
        }
        
        return max;
    }


    // given an array, find the maximum XOR of any subarray using trieNode
    public static int findMaximumXOR_subarray(int[] nums) {
        int max = 0;
        int mask = 0;
        TrieNode root = new TrieNode();
        insert_(root,(char)0);
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            int temp = max | (1 << i);
            TrieNode cur = root;
            int prefix = 0;
            for(int num : nums){
                prefix ^= (num & mask);
                int temp2 = temp ^ prefix;
                int temp3 = 0;
                TrieNode cur2 = root;
                for(int j = 31; j >= 0; j--){
                    int bit = (temp2 >> j) & 1;
                    if(cur2.Map.containsKey((char)bit)){
                        temp3 |= (1 << j);
                        cur2 = cur2.Map.get((char)bit);
                    }else{
                        cur2 = cur2.Map.get((char)(1 - bit));
                    }
                }
                max = Math.max(max,temp3);
            }
        }
        return max;
        
    
    }

    
    


    public static void main(String[] args) {

        
        TrieNode root = new TrieNode();
        insert(root, "hello");
        insert(root, "world");
        System.out.println(search(root, "hello"));
        int [] nums = {4,3,2,7};
        // System.out.println(findMaximumXOR(nums));
        ArrayList<String> testList = new ArrayList<>();
        // testList.add("zebra");
        // testList.add("dog");
        // testList.add("duck");
        // testList.add("dove");
        
        testList.add("bert");
        testList.add("bearcat");

        System.out.println(prefix(testList));
       
    }

}
