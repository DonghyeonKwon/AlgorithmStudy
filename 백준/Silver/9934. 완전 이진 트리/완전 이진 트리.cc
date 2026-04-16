#include <bits/stdc++.h>
using namespace std;

int k;
vector<int> v;
vector<int> v2[11];

void solve(int s, int e, int l){
    if(l > k) return;
    v2[l].push_back(v[(e+s)/2]);
    solve(s,(e+s)/2, l+1);
    solve((e+s)/2 + 1, e, l+1);
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    cin >> k;
    for(int i = 0; i < (1<<k) - 1; i++){
        int a;
        cin >> a;
        v.push_back(a);
    }
    
    solve(0, (1 << k) -1, 1);

    for(int i = 1; i <= k; i++){
        for(int j : v2[i]){
            cout << j << ' ';
        }
        cout << '\n';
    }

    return 0;
}