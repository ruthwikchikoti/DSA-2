import java.util.*;
public class test {
    //prime number
    // TC : O(sqrt(n))
    public static boolean isprime(int n){
        if(n <= 1){
            return false;
        }
        for(int i = 2; i < n/2; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    // optimize the code of prime number
    // TC : O(sqrt(n))
        public static boolean isPrime2(int n){
               if(n <= 1 || n % 2 == 0 && n != 2)
                  return false;
              for(int i = 3; i * i <= n; i += 2)
                  if(n % i == 0)
                      return false;
              return true;
          }

    
    // via boolean 
          
        
        public static boolean[] isPrime(int n){
        boolean[] ans = new boolean[n+1];
        Arrays.fill(ans, true);
        ans[0] = false;
        ans[1] = false;
        for(int i =2;i*i<=n;i++){
            if(ans[i]){
                for(int j = i*i;j<=n;j+=i){
                    ans[j] = false;
                }
            }
        }
        return ans;
    }

    // given an number return its prime factors
    // TC : square root of n
    public static ArrayList<Integer> primefactors(int n){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 2;i*i<=n;i++){
            while(n % i ==0){
                ans.add(i);
                n = n/i;
            }
        }
        if(n > 1)
            ans.add(n);
        return ans;
    }    
    
    // given n quires , we get a range in [2,n] return the prime factors
    public static ArrayList<Integer> q_primefacors(ArrayList<Integer> a){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0;i<a.size();i++){
            ans.addAll(primefactors(a.get(i)));
        }
        return ans;
    }


    // word break problem
    public String[] wordBreak(String A, String[] B) {
        
        HashSet<String> set = new HashSet<>();
        for(String s : B){
            set.add(s);
        }
        ArrayList<String> ans = new ArrayList<>();
        wordBreakans(A, set, "", ans);
        return ans.toArray(new String[ans.size()]);

    }
    public void wordBreakans(String A, HashSet<String> set, String ans, ArrayList<String> res){

        for(int i = )
    }


    public static void main(String[] args) {

        System.out.println(primefactors(99));
    

    }
}
