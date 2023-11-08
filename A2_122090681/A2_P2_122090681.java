package A2_122090681;

import java.util.*;
import java.lang.Math;

public class A2_P2_122090681 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextLong();
        for (long i = 0; i < t; ++i) {
            int n = scanner.nextInt();
            long dep, out;
            long[] a = new long[n + 1];
            for (int j = 0; j < n; ++j) {
                dep = scanner.nextLong();
                a[j] = dep;
            }
            A2_P2_122090681 q = new A2_P2_122090681();
            out = q.largestRectangleArea(a);
            System.out.println(out);
        }
        scanner.close();
    }

    public long larec(long[] arr, int size) {
        Stack<Integer> st = new Stack<Integer>();
        arr[size] = 0;
        long res = 0;
        for (int i = 0; i <= size; i++) {
            while ((!st.empty()) && (arr[st.peek()] >= arr[i])) {
                //System.out.println(st);
                int val = st.peek();
                st.pop();
               // System.out.println(st);
                long change = 0;
                if ((!st.empty())) {
                    change = arr[val] * (i - st.peek() - 1);
                }
                if (change > res) {
                    res = change;
                }
            }
            st.push(i);
        }
       // System.out.println(st);
        return res;
    }
    public long largestRectangleArea(long[] heights) {
        int n = heights.length;
        long[] le = new long[n];
        long[] ri = new long[n];
        Arrays.fill(ri, n);
        
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                ri[st.peek()] = i;
                st.pop();
            }
            le[i] = (st.isEmpty() ? -1 : st.peek());
            st.push(i);
        }
        
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (ri[i] - le[i] - 1) * heights[i]);
        }
        return ans;
    }

}