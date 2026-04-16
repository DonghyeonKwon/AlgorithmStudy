#include <bits/stdc++.h>
using namespace std;

int n, arr[100001];
vector<int> v[100001];
bool visited[100001] = {false, };

void dfs(int here){
    if(visited[here]) return;

    visited[here] = true;
    for(int there : v[here]){
        if(visited[there]) continue;
        arr[there] = here;
        dfs(there);
    }
    return;
}

void bfs(int here){
    queue<int> q;
    q.push(here);

    while(q.size()){
        int x = q.front();
        q.pop();
        visited[x] = true;
        for(int there : v[x]){
            if(visited[there]) continue;
            arr[there] = x;
            q.push(there);
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    for(int i = 0; i < n - 1; i++){
        int a, b;
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }

    // dfs(1);
    bfs(1);

    for(int i = 2; i <= n; i++){
        cout << arr[i] << '\n';
    }

    return 0;
}