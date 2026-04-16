#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

ll n, k, arr[100000], lo = 0, hi = 0, ret = 0;

bool check(ll mid){
    ll sum = 0, cnt = 0;
    for(int i = 0; i < n; i++){
        sum += arr[i];
        if(sum >= mid){
            cnt++;
            sum = 0;
        }
    }

    return cnt >= k;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> k;
    for(int i = 0; i < n; i++){
        cin >> arr[i];
        hi += arr[i];
    }

    while(lo <= hi){
        ll mid = (hi + lo) / 2;
        //cout << lo << ' ' << hi << ' ' << ret << '\n';
        if(check(mid)){
            lo = mid + 1;
            ret = mid;
        }
        else{
            hi = mid - 1;
        }
    }

    cout << ret << '\n';

    return 0;
}