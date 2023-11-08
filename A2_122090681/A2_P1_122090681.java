package A2_122090681;

import java.util.*;

public class A2_P1_122090681 {
    static class player {
        int p, h, index;
        boolean d;
    }
    public static void quickSort2(player[] ans,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = ans[low].index;
        player ch;
        ch = ans[low];
        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=ans[j].index&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=ans[i].index&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                player chang;
                chang = ans[i];
                ans[i] = ans[j];
                ans[j] = chang;
            }
 
        }
        //最后将基准为与i和j相等位置的数字交换
         ans[low] = ans[i];
         ans[i] = ch;
        //递归调用左半数组
        quickSort2(ans, low, j-1);
        //递归调用右半数组
        quickSort2(ans, j+1, high);
    }

    public static void quickSort(player[] play,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = play[low].p;
        player ch;
        ch = play[low];
        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=play[j].p&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=play[i].p&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                player chang;
                chang = play[i];
                play[i] = play[j];
                play[j] = chang;
            }
 
        }
        //最后将基准为与i和j相等位置的数字交换
         play[low] = play[i];
         play[i] = ch;
        //递归调用左半数组
        quickSort(play, low, j-1);
        //递归调用右半数组
        quickSort(play, j+1, high);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        player[] ans = new player[n];
        int cont = 0;
        char te;
        player[] play = new player[n];
       // System.out.println(play);
        for (int i = 0; i < n; i++) {
            play[i] = new player();
            play[i].p = scanner.nextInt();
            play[i].h = scanner.nextInt();
            te = scanner.next().charAt(0);
         //   System.out.println(play[i].h);
            if (te == 'U') {
                play[i].d = true;
            } else {
                play[i].d = false;
            }
            play[i].index = i;
        }
        quickSort(play, 0, n-1);
         /*  for (int i =0;i<n;i++){
             System.out.println(play[i].p);
             System.out.println(play[i].h);
             System.out.println(play[i].d);
        }*/
        Stack<player> pool = new Stack<player>();
        for (int i = 0; i < n; i++) {
            if (play[i].d) {
                pool.push(play[i]);
             //  System.out.println(play[i].h);
                continue;
                
            }
            while (!pool.empty() && play[i].h >= pool.peek().h) {
                /*if (pool.peek().h < play[i].h) {
                    play[i].h = play[i].h - 1;
                    pool.pop();
                } else if (pool.peek().h == play[i].h) {
                    play[i].h = 0;
                    pool.pop();
                } else if (pool.peek().h > play[i].h) {
                    play[i].h = 0;
                    pool.peek().h--;
                }*/
               play[i].h -= play[i].h == pool.peek().h ? pool.peek().h : 1;
               // System.out.println(play[i].h);
               pool.pop();
            }
            if (pool.empty() && play[i].h > 0) {
               //System.out.println(play[i].h);
                ans[cont] = play[i];
                cont++;
            }else if (play[i].h > 0) {
                pool.peek().h--;
            }
        }
        while (!pool.empty()) {
            ans[cont] = pool.pop();
            cont++;
        }
     
        quickSort2(ans, 0, cont-1);
        /*for (int i = 0; i <cont; i++) {
            System.out.println(ans[i].index);
            System.out.println(ans[i].h);
        }  */
        for (int i = 0; i <cont; i++) {
            System.out.println(ans[i].h);
        }
        scanner.close();
    }
}
