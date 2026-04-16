#include <bits/stdc++.h>

using namespace std;

int n, m, max_com = -1;
vector<int> v[10001];
vector<int> sp;
bool visited[10001];

int go(int here){
    int ret = 1;
    visited[here] = true;
    if(v[here].size() == 0) return ret;
    for(int there : v[here]){
        if(visited[there]) continue;
        ret += go(there);
    }
    return ret;
}


int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m;

    for(int i = 0; i < m; i++){
        int a, b;
        cin >> a >> b;
        v[b].push_back(a);
    }

    for(int i = 1; i <= n; i++){
        memset(visited, 0, sizeof(visited));
        int ret = go(i);

        if(max_com < ret){
            sp.clear();
            max_com = ret;
            sp.push_back(i);
        }
        else if(max_com == ret){
            sp.push_back(i);
        }
    }

    for(int i : sp){
        cout << i << " ";
    }
    cout << '\n';

    return 0;
}