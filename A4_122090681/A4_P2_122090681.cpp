#include <iostream>
#include <cstdio>
#include <cstring>
#include <queue>
#include <algorithm>
using namespace std;
typedef long long ll;
const int N = 1e5+5, M = 5e5+5;

struct edge{
    int to, next;
}e[M];

queue <int> q1;
priority_queue <int> q2;

int cnt, head[N];
bool vis[N], vis2[N];

struct A{
    int u, v;
}a[M];

bool cmp(A a, A b){
    if(a.u > b.u) return 1;
    if(a.u == b.u && a.v > b.v) return 1;
    return 0;
}

void addedge(int u, int v){
    e[++cnt].to = v;
    e[cnt].next = head[u];
    head[u] = cnt; 
}

int main(){
  //  freopen("sample2.in", "r", stdin);
  //  freopen("ans.txt", "w", stdout);
    int n, m, k, s;
    scanf("%d%d%d%d", &n, &m, &k, &s);
    for(int i = 1; i <= m; i++){
        int u, v;
        scanf("%d%d", &a[i].u, &a[i].v);
        if(a[i].u > a[i].v) swap(a[i].u, a[i].v);
    }
    sort(a + 1, a + m + 1, cmp);
    for(int i = 1; i <= m; i++){
        addedge(a[i].u, a[i].v), addedge(a[i].v, a[i].u);
    }
    int m0 = m;
    for(int u = 1; u <= n; u++){
        memset(vis, false, sizeof(vis));
        memset(vis2, false, sizeof(vis2));
        for(int i = head[u]; i; i = e[i].next){
            int v = e[i].to;
            if(vis2[v]) continue;
            if(vis[v]){
                a[++m].u = v / k; a[m].v = v;
            }
            vis[v] = true;
            vis2[v] = true;
            ll tmp = v;
            tmp *= k;
            if(tmp <= n) vis[tmp] = true;
        }
    }
    for(int i = m0 + 1; i <= m; i++)
        addedge(a[i].u, a[i].v), addedge(a[i].v, a[i].u);

    memset(vis, false, sizeof(vis));
    vis[s] = true;
    q1.push(s);
    while(!q1.empty()){
        int u = q1.front();
        q1.pop();
        printf("%d ", u);
        for(int i = head[u]; i; i = e[i].next){
            int v = e[i].to;
            if(!vis[v]){
                q2.push(-v);
                vis[v] = true;
            }
        }

        while(!q2.empty()){
            int v = -q2.top();
            q2.pop();
            q1.push(v);
        }
    }
    putchar('\n');
    return 0;
}