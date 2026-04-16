#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, k;
    cin >> n >> k;
    vector<int> v(k+1, 0);
    v[0] = 0;
    for(int i = 1; i <= k; i++) v[i] = v[i-1] + i;

    if(v[k] > n){
        cout << -1 << '\n';
        return 0;
    }

    int a = (n - v[k]) % k;
    if(a != 0) a = 1;
    cout << (v[k] - v[k-1] - v[1]) + a << '\n';

    return 0;
}