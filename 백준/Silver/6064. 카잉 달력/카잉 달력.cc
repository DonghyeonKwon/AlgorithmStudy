#include <bits/stdc++.h>
using namespace std;

int t, m, n, x, y;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> t;
    while(t--){
        cin >> m >> n >> x >> y;
        int a = gcd(m,n), ret = x;
        int b = m * n / a;
        // cout << b << '\n';
        bool flag = true;
        while(ret <= b){
            int k = ret % n;
            if(k == 0) k = n;
            // cout << ret << ' ' << k << '\n'; 
            if(y == k){
                flag = false;
                break;
            }
            else {
                ret += m;
                // cout << ret <<'\n';
            }
        }
        if(flag) cout << -1 << '\n';
        else cout << ret << '\n';
    }

    return 0;
}