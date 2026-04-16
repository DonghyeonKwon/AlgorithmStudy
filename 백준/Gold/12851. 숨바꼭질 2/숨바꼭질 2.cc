#include <bits/stdc++.h>

using namespace std;

int n, k;
int visited[100001];
int cnt[100001];

void go(int here){
    queue<int> q;
    q.push(here);
    visited[here] = 1;
    cnt[here] = 1;
    while(!q.empty()){
        int now = q.front();
        q.pop();
        for(int next : {now + 1, now - 1, now * 2}){
            if(0 <= next && next <= 100000){
                if(!visited[next]){
                    q.push(next);
                    visited[next] = visited[now] + 1;
                    cnt[next] += cnt[now];
                }else if(visited[next] == visited[now] + 1){
                    cnt[next] +=  cnt[now];
                }
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> k;

    go(n);

    cout << visited[k] - 1 << '\n' << cnt[k] << '\n';

    return 0;
}