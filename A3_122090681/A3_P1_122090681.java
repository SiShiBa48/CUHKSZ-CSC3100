package A3_122090681;

import java.util.*;

public class A3_P1_122090681{
    public static class treenode{
        int value = 0;
        treenode child[] = new treenode[500];
        Long path[] = new Long[500];
    }
    static long ans = 0;
    public static void dfs(treenode root,long counter,LinkedHashSet<Integer> visited,boolean[] c){
        /*Stack<treenode> stack = new Stack<>();
        long count = 0;
        stack.push(root);
        while (!stack.empty()){
            treenode t = stack.pop();

        }
        return 0;*/
        
        if (root == null){
            return;
        }
        if(visited.contains(root.value)){
            return;
        }
        if (c[root.value-1]){
         //   System.out.print(root.value);
         //   System.out.println(counter);
            ans = ans + counter;
        }
        visited.add(root.value);
        int j = 0;
        while (root.child[j]!= null){
            if(!visited.contains(root.child[j].value)){
                dfs(root.child[j],counter + root.path[j],visited,c);
            }
            j++;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean c[] = new boolean[n];
        for (int i =0;i<n;i++){
            int k = scanner.nextInt();
           // System.out.println("eeee");
            if (k == 1){
                c[i] = true;
            }else{
                c[i] = false;
            }
        }
        treenode a[] = new treenode[n];
        for (int i=0; i<n; i++){
            a[i] = new treenode();
        }
        a[0].value = 1;
        for (int i = 1;i< n;i++){
            int qp = scanner.nextInt();
            //System.out.println("ffff");
            long wp = scanner.nextLong();
            a[i].value = i+1;
            qp = qp - 1;
            int j = 0;
            while (a[qp].child[j] != null){
                j++;
            }
            a[qp].child[j] = a[i];
            a[qp].path[j] = wp;
            a[i].child[0] = a[qp];
            a[i].path[0] = wp;
        }
     /*    for (int i=0; i<n; i++){
            System.out.print(a[i].value);
            int j = 0;
            while (a[i].child[j] != null){
                System.out.print(a[i].child[j].value);
                j++;
            }
            System.out.println();
        }  */
        for (int i =0;i<n;i++){
            if (c[i]){
                LinkedHashSet<Integer> visit = new LinkedHashSet<>();
                dfs(a[i],0,visit,c);
            }
        }
        System.out.println(ans/2);
        scanner.close();
    }
}