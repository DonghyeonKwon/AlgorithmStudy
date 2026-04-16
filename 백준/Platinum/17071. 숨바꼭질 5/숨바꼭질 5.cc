#include <bits/stdc++.h>

using namespace std;

const int max_n = 500000;
int n, k, ok, turn = 1;
int visited[2][500001];

void go(int here){
    queue<int> q;
    q.push(here);
    visited[0][here] = 1;

    while(!q.empty()){
        k += turn;
        if(k > max_n)break;
        if(visited[turn%2][k]){
            ok = 1;
            break;
        }
        int qSize = q.size();
        for(int i = 0; i < qSize; i++){
            int now = q.front();
            q.pop();
            for(int next : {now + 1, now - 1, now * 2}){
                if(next < 0 || next > max_n || visited[turn % 2][next]) continue;
                visited[turn%2][next] = visited[(turn + 1) % 2][now] + 1;
                if(next == k){
                    ok = 1;
                    break;
                }
                q.push(next);
            }
            if(ok) break;
        }
        if(ok) break;
        turn++;
    }

    if(ok) cout << turn << '\n';
    else cout << -1 << '\n'; 
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> k;
    if(n == k) {
        cout << 0 << '\n';
        return 0;
    }

    go(n);

    return 0;
}