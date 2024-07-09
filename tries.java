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
    
    




    // 
    // given a 2d matrix of 0's and 1's, count the number of distinct rows
    // public static 






    // given an array of integers, find the pair with maximum XOR using trie


    // public static int findMaximumXOR(int[] nums) {
    //     int max = 0;
    //     int mask = 0;
        
    //     for (int i = 31; i >= 0; i--) {
    //         mask |= (1 << i);
    //         Set<Integer> set = new HashSet<>();
            
    //         for (int num : nums) {
    //             set.add(num & mask);
    //         }
            
    //         int temp = max | (1 << i);
            
    //         for (int prefix : set) {
    //             if (set.contains(temp ^ prefix)) {
    //                 max = temp;
    //                 break;
    //             }
    //         }
    //     }
        
    //     return max;
    // }


    // given an array, find the maximum XOR of any subarray using trieNode
    // public static int findMaximumXOR_subarray(int[] nums) {
        
    
    // }

    
    


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
