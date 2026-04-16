#include <bits/stdc++.h>
using namespace std;

int n, a[11], oper[4], _min = 1000000000, _max = -1000000000; 

void dfs(int ret, int idx, int op){
    if(op == 0) ret += a[idx];
    else if(op == 1) ret -= a[idx];
    else if(op == 2) ret *= a[idx];
    else if(op == 3) ret /= a[idx];

    if(idx == n-1){
        _min = min(ret, _min);
        _max = max(ret, _max);
        return;
    }

    for(int i = 0; i < 4; i++){
        if(oper[i] > 0){
            oper[i]--;
            dfs(ret, idx+1, i);
            oper[i]++;
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> a[i];
    }
    for(int i = 0; i < 4; i++){
        cin >> oper[i];
    }

    dfs(a[0], 0, -1);
    cout << _max << '\n' << _min << '\n';

    return 0;
}