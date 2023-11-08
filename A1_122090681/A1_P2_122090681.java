package A1_122090681;
import java.util.*;
public class A1_P2_122090681 {
    public long[] compute(long a,long b,long n,long m){
        if (n == 1){
            long[] re = {a,b,1,0};
            return re;
        }
        if (n % 2 ==0){
            long[] com,re = new long[4];
            com = compute(a,b,n/2,m);
            re[0] = ((com[0]*com[0])%m+(com[1]*com[2])%m)%m;
            re[1] = ((com[0]*com[1])%m+(com[1]*com[3])%m)%m;
            re[2] = ((com[0]*com[2])%m+(com[3]*com[2])%m)%m;
            re[3] = ((com[3]*com[3])%m+(com[1]*com[2])%m)%m;
            return re;
        }else{
            long[] com,re = new long[4];
            com = compute(a,b,n/2,m);
            re[0] = ((com[0]*com[0])%m+(com[1]*com[2])%m)%m;
            re[1] = ((com[0]*com[1])%m+(com[1]*com[3])%m)%m;
            re[2] = ((com[0]*com[2])%m+(com[3]*com[2])%m)%m;
            re[3] = ((com[3]*com[3])%m+(com[1]*com[2])%m)%m;
            long [] re1 = new long[4];
            re1[0] = re[0];
            re1[1] = re[1];
            re1[2] = re[2];
            re1[3] = re[3];
            re[0] = ((re1[0]*a)%m+(re1[1])%m)%m;
            re[1] = ((re1[0]*b)%m)%m;
            re[2] = ((re1[2]*a)%m+(re1[3])%m)%m;
            re[3] = ((re1[2]*b)%m)%m;
            return re;
        }
    }
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong(),a = scanner.nextLong(),b = scanner.nextLong(),f0 = scanner.nextLong(),f1 = scanner.nextLong(),m = scanner.nextLong();
        A1_P2_122090681 fun = new A1_P2_122090681();
        long[] ma = new long[4];
        long ans;
        ma = fun.compute(a,b,n-1,m);
        ans = (ma[0]*f1+ma[1]*f0)%m;
        System.out.println(ans);
        scanner.close();
    }
}
