public class addAbs {

     // given an array of +ve numbers Add the abs diff to the array if not present in the array using gcd or very optimal soluiton
    public static int gcd(int a, int b){
        if(b == 0)
            return a;
        return gcd(b, a%b);
    }
    public static int[] add_abs_gcd(int[] A){
     // using gcd multiple of gcd we have to add
     // divide max element by gcd
        // if not present add it to the array
        int max = 0;
        for(int i=0;i<A.length;i++){
            max = Math.max(max, A[i]);
        
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        int[] res = add_abs_gcd(A);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}