#include <bits/stdc++.h>
using namespace std;

int n, m, cnt = 0;
vector<int> v[1001];
bool visited[1001];

void dfs(int here){
    visited[here] = true;
    for(int i : v[here]){
        if(visited[i]) continue;
        dfs(i);
    }
    return;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m;
    for(int i = 0; i < m; i++){
        int a, b;
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }
    memset(visited, false, sizeof(visited));
    
    for(int i = 1; i <= n; i++){
        if(!visited[i]){
            dfs(i);
            cnt++;
        }
    }

    cout << cnt << '\n';

    return 0;
}