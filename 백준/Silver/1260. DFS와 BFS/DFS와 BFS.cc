#include <bits/stdc++.h>
using namespace std;

int n, v, s;
vector<int> arr[1001];
bool visited[1001];

void dfs(int here){
    if(visited[here]){
        return;
    }

    cout << here << ' ';
    visited[here] = true;
    sort(arr[here].begin(), arr[here].end());
    for(int there : arr[here]){
        dfs(there);
    }
    return;
}

void bfs(int here){
    queue<int> q;
    q.push(here);
    visited[here] = true;
    while(q.size()){
        int x = q.front();
        cout << x << ' ';
        q.pop();
        sort(arr[x].begin(), arr[x].end());
        for(int there : arr[x]){
            if(visited[there]) continue;
            visited[there] = true;
            q.push(there);
        }
    }
}

int main(int argc, char** argv){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> v >> s;
    for(int i = 0; i < v; i++){
        int a = 0, b = 0;
        cin >> a >> b;
        arr[a].push_back(b);
        arr[b].push_back(a);
    }

    memset(visited, false, sizeof(visited));
    dfs(s);
    cout << '\n';
    memset(visited, false, sizeof(visited));
    bfs(s);
    cout << '\n';

    return 0;
}