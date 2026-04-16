#include <bits/stdc++.h>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    int n;
    cin >> n;
    if(n == 1){ cout << 0 << '\n'; return 0; }
    int lx = 10001, ly = 10001, hx = -10001, hy = -10001;
    for(int i = 0; i < n; i++){
        int a, b;
        cin >> a >> b;
        lx = min(lx, a);
        ly = min(ly, b);
        hx = max(hx, a);
        hy = max(hy, b);
    }
    // cout << hy << ' ' << ly << ' '<< hx << ' ' << lx << '\n';
    cout << (hy - ly) * (hx - lx) << '\n';
    return 0;
}