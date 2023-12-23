package A3_122090681;

import java.util.*;

public class A3_P2_122090681 {

    public static void quickSort(long[] sorta,int low,int high){
        int i,j;
        long temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = sorta[low];
 
        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=sorta[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=sorta[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = sorta[j];
                sorta[j] = sorta[i];
                sorta[i] = t;
            }
 
        }
        //最后将基准为与i和j相等位置的数字交换
         sorta[low] = sorta[i];
         sorta[i] = temp;
        //递归调用左半数组
        quickSort(sorta, low, j-1);
        //递归调用右半数组
        quickSort(sorta, j+1, high);
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[] a = new long[n + m];
      //  long[] b = new long[n + m];
      //  long[] sortb = new long[n + m];
        long min = Long.MAX_VALUE,sortmin;
        long reada = scanner.nextLong();
        a[0] = reada;
        for (int i = 1;i<n;i++){
            reada = scanner.nextLong();
            a[i] = reada;
            long k = a[i-1] - a[i];
            k = (k < 0)? -k : k;
            //System.out.println(k);
            if (min > k){
                min = k;
            }
        }
        long[] sorta = a;
        String oper;
       // quickSort(sorta, 0, n-1);
        sortmin = Long.MAX_VALUE;
        TreeSet<Long> tree = new TreeSet<>();
        for (int i = 0;i<n;i++){
            if (tree.contains(sorta[i])){
              //  System.out.println("eee");
                sortmin = 0;
                break;
            }else{
                tree.add(sorta[i]);
            }   
        }
        long newbook;
        Iterator<Long> it= tree.iterator();
        long fi = it.next(),ne;
        while (it.hasNext()) {
            ne = it.next();
            long k = ne - fi;
            if (sortmin > k){
                sortmin = k;
            }
            fi = ne;
        } 
        Boolean tt,ttt;
        for (int i = 0; i<m;i++){
            oper = scanner.next();
           // System.out.println(oper == "CLOSEST_ADJ_PRICE");
            if (oper.contains("A")){
                System.out.println(min);
            }
            if (oper.contains("B")){
                n++;
                newbook = scanner.nextLong();
                a[n-1] = newbook;
                long k = a[n-2] - a[n-1];
                k = (k < 0)? -k : k;
                if (min > k){
                    min = k;
                }      
                if (tree.contains(newbook)){
                   // System.out.println("fff");
                    sortmin = 0;
                }else{
                    tree.add(newbook);
                    long small,high;
                    tt = true;
                    ttt = true;
                    if (tree.lower(newbook)!= null){
                        small = tree.lower(newbook);
                    }else{
                        small = -999999999;
                        tt = false;
                    }
                    if (tree.higher(newbook)!= null){
                        high = tree.higher(newbook);
                    }else{
                        high = 999999999;
                        ttt = false;
                    }
                    long k1 = newbook - small, k2 = high - newbook;
                    if (sortmin > k1 && tt){
                        sortmin = k1;
                    } 
                    if (sortmin > k2 && ttt){
                        sortmin = k2;
                    } 
                }
            }
            if (oper.contains("CLOSEST_PRICE")){
                if (sortmin == 0){
                    System.out.println(sortmin);
                }else{
                  /*   if (tt){
                    Iterator<Long> it= tree.iterator();
                    long fi = it.next(),ne;
                    while (it.hasNext()) {
                        ne = it.next();
                        long k = ne - fi;
                        if (sortmin > k){
                            sortmin = k;
                        }
                        fi = ne;
                    }
                    tt = false;}*/
                    System.out.println(sortmin);
                }       
            }
        }
        scanner.close();
    }
}
