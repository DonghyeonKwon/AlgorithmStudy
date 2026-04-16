#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    ll x, y, z, ret = -1;
    cin >> x >> y;
    z = y * 100 / x;
    int lo = 1, hi = 1e9;
    while(lo <= hi){
        int mid = (hi+lo) / 2;
        int k = floor((double)(y+mid)/(x+mid)*100);
        if(k > z){
            ret = mid;
            hi = mid - 1;
        }
        else{
            lo = mid + 1;
        }
    }
    cout << ret << '\n';

    return 0;
}