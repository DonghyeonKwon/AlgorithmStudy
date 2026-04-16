#include <bits/stdc++.h>
using namespace std;
int n, a[11], op[4], _min = 1000000001, _max = -1000000001;

void dfs(int ret, int idx, int oper){
    if(oper == 0) ret += a[idx+1];
    else if(oper == 1) ret -= a[idx+1];
    else if(oper == 2) ret *= a[idx+1];
    else if(oper == 3) ret /= a[idx+1];
    idx++;

    if(idx == n-1){
        _min = min(ret, _min);
        _max = max(ret, _max);
        return;
    }

    for(int i = 0; i < 4; i++){
        if(op[i] > 0){
            op[i]--;
            dfs(ret, idx, i);
            op[i]++;
        }
    }
}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    for(int i = 0; i < n; i++)
        cin >> a[i];
    for(int i = 0; i < 4; i++)
        cin >> op[i];

    dfs(0, -1, 0);

    cout << _max << '\n' << _min << '\n';

    return 0;
}