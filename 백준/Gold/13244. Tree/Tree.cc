#include <bits/stdc++.h>
using namespace std;

int t, n, e, a, b, cnt;
bool flag, visited[1001];
vector<int> v[1001];

void initV(){
    vector<int> temp[1001];
    swap(v, temp);
}

void checkingTree(int here, int prev){
    if(v[here].size() == 0) return;
    if(flag) return;

    for(int i : v[here]){
        if(flag) return;
        if(i != prev && visited[i]) {
            flag = true;
            break;
        }
        if(i == prev) continue;
        visited[i] = true;
        cnt++;
        checkingTree(i, here);
    }
    return;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> t;
    for(int i = 0; i < t; i++){
        fill(visited, visited + 1001, false);
        cnt = 1;
        flag = false;
        initV();
        cin >> n;
        cin >> e;
        for(int j = 0; j < e; j++){
            cin >> a >> b;
            v[a].push_back(b);
            v[b].push_back(a);
        }
        if(e != n-1) {
            cout << "graph\n"; 
            continue;
        }
        visited[1] = true;
        checkingTree(1, 0);
        if(flag || cnt != n){
            cout << "graph\n";
        }
        else{
            cout << "tree\n";
        }
    }
    

    return 0;
}
