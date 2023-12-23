package A4_122090681;

import java.util.*;

public class A4_P1_122090681{
    public static class index{
        int x =0,y =0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(),n = scanner.nextInt();
        char map[][] = new char[m][n];
        int cost[][] = new int[m][n];
        boolean visit[][] = new boolean[m][n];
        int ix=0,iy=0,jx=0,jy=0;
        for (int i = 0; i<m;i++){
            String s = scanner.next();
            for (int j = 0;j<n;j++){
                map[i][j] = s.charAt(j);
                if (map[i][j]=='i'){
                    ix = i;
                    iy = j;
                }
                if (map[i][j]=='j'){
                    jx = i;
                    jy = j;
                }
                cost[i][j] = Integer.MAX_VALUE;
                visit[i][j] = false;
            }
        }
        Queue<index> q = new LinkedList<index>();
        index k = new index();
        k.x = ix;
        k.y = iy;
        q.add(k);
        cost[ix][iy] = 0;
        visit[ix][iy] = true;
        while (!q.isEmpty()){
            index look = q.poll();
            for (int w = 0;w<4;w++){
                int x = look.x,y= look.y;
                if (w == 0) x = look.x-1;
                if (w == 1) x = look.x+1;
                if (w == 2) y = look.y-1;
                if (w == 3) y = look.y+1;
                if (x>=0 && x<m && y>=0 && y<n){
                    index app = new index();
                    app.x = x;
                    app.y = y;
                  //  visit[x][y] = true;
                    if (map[look.x][look.y]=='w' && w == 0){
                        if (cost[look.x][look.y] < cost[x][y]){
                            cost[x][y] = cost[look.x][look.y];
                            q.add(app);
                        }
                    } else
                    if (map[look.x][look.y]=='s' && w == 1){
                        if (cost[look.x][look.y] < cost[x][y]){
                            cost[x][y] = cost[look.x][look.y];
                            q.add(app);
                        }
                    } else
                    if (map[look.x][look.y]=='a' && w == 2){
                        if (cost[look.x][look.y] < cost[x][y]){
                            cost[x][y] = cost[look.x][look.y];
                            q.add(app);
                        }
                    } else
                    if (map[look.x][look.y]=='d' && w == 3){
                        if (cost[look.x][look.y] < cost[x][y]){
                            cost[x][y] = cost[look.x][look.y];
                            q.add(app);
                        }
                    } else{
                        if (cost[look.x][look.y]+1 < cost[x][y]){
                            cost[x][y] = cost[look.x][look.y]+1;
                            q.add(app);
                        }
                    }
                }
            }

        }
        System.out.println(cost[jx][jy]-1);
        scanner.close();
    }
}