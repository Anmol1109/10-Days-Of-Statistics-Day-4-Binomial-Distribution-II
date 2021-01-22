import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        double failP = sc.nextDouble() / 100;
        int batch = sc.nextInt();
        double oneOrNone = C(batch, 0) * Math.pow(1 - failP,batch) + C(batch,1) * Math.pow(1 - failP,batch - 1) * failP;
        double two = C(batch, 2) * Math.pow(1 - failP,batch - 2) * failP * failP;
        System.out.println(Math.round(1000 * (oneOrNone + two)) / 1000d);
        System.out.println(Math.round(1000 * (1 -oneOrNone)) / 1000d);
    }
    static long C(int n, int k){
        if(n > 60)
            throw new RuntimeException("N too large");
        if(k == 0)
            return 1;
        if(k > n/2)
            return C(n, n - k);
        return C(n,k - 1) * (n - k + 1) / k;
    }
}
