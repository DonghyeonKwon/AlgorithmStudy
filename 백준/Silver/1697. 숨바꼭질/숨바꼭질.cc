#include <bits/stdc++.h>
using namespace std;
int n, k, visited[100001] = {0, }, _mx = 987654321;
const int dx[] = {1, -1, 0};
int main(int argc, char** argv){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> k;
    visited[n] = 1;

    queue<int> q;
    q.push(n);
    while(q.size()){
        int x = q.front();
        if(x == k){
            _mx = min(_mx, visited[x]);
        }
        q.pop();
        for(int i = 0; i < 3; i++){
            int nx = x + dx[i];
            if(i == 2) nx *= 2;
            if(nx < 0 || nx > 100000) continue;
            if(visited[nx] != 0) continue;
            visited[nx] = visited[x] + 1;
            q.push(nx);
        }
    }

    cout << _mx - 1 << '\n';
    return 0;
}