#include <bits/stdc++.h>
using namespace std;
#define MAX_N 60000000001
#define MAX_M 10001
typedef long long ll;
ll n, m, a[MAX_M], lo = 0, hi = MAX_N, ret, mid, temp;

bool check(ll mid){
    temp = m;
    // cout << temp << '\n';
    for(ll i = 0; i < m; i++) {
        // cout << mid / a[i] << '\n';
        temp += (mid / a[i]);
    }
    // cout << temp << '\n';
    return (n <= temp);
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m;
    for(ll i = 0; i < m; i++){
        cin >> a[i];
    }
    if(n <= m){
        cout << n << '\n';
        return 0;
    }

    while(lo <= hi){
        mid = (hi + lo) / 2;
        // cout << mid << '\n';
        if(check(mid)){
            hi = mid - 1;
            ret = mid;
            // cout << ret << '\n';
        }
        else lo = mid + 1;
    }
    // cout << ret << '\n';
    temp = m;
    for(ll i = 0; i < m; i++) temp += ((ret-1)/a[i]);
    for(ll i = 0; i < m; i++){
        if(ret % a[i] == 0) temp++;
        if(temp == n){
            cout << i + 1 << '\n';
            return 0;
        }
    }

    return 0;
}