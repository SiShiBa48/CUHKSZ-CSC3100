package A1_122090681;

import java.util.*;
public class A1_P1_122090681{
    long counter = 0;
    public void quicksort(long[] a,int l, int r){
        if (l < r){
            int mid = l + (r - l)/2;
            quicksort(a, l, mid);
            quicksort(a, mid + 1, r);
            long[] sorted = new long[r - l +1];    
            int start = l;        
            int end = mid + 1;   
            int last = 0;         
            while (start <= mid && end <= r) {    
                if (a[start] <= a[end]) {
                    sorted[last++] = a[start++];    
                } else {
                    sorted[last++] = a[end++];      
                    counter = counter + mid - start + 1;    
                }                           
            }
            while (start <= mid){
                sorted[last++] = a[start++];
            }
            while (end <= r){        
                sorted[last++] = a[end++];
            }
            for (int i = 0; i < sorted.length; i++) {    
                a[l + i] = sorted[i];
            }
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        long k;
        for (int i=0;i<n;i++){
            k = scanner.nextLong();
            a[i] = k;
        }
        A1_P1_122090681 q = new A1_P1_122090681();
        q.quicksort(a,0,n-1);
        System.out.println(q.counter);
        scanner.close();
    }
}