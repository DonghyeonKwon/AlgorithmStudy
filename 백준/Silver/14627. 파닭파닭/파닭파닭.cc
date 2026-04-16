#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
ll s, c, lo, hi = 1000000001, sum = 0, ret = 0, a[1000001];

bool check(ll a[], ll mid){
    ll num = 0;
    for(int i = 0; i < s; i++){
        num += a[i]/mid;
    }
    return (c <= num);
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> s >> c;
    for(int i = 0; i < s; i++){
        cin >> a[i];
        sum += a[i];
    }

    lo = 1, hi = 1e9;
    while(lo <= hi){
        int mid = (hi + lo) / 2;
        if(check(a, mid)){
            lo = mid + 1;
            ret = mid;
        }
        else{
            hi = mid - 1;
        }
    }

    cout << sum - (ret * c) << '\n';

    return 0;
}