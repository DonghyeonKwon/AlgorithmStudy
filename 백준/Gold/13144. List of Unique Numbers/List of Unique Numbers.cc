#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, hi = 0, lo = 0;
    cin >> n;
    int a[n+1], cnt[100001] = { 0, };
    for(int i = 0; i < n; i++){
        cin >> a[i];
    }
    ll ret = 0;
    while(hi < n){
        if(!cnt[a[hi]]){
            cnt[a[hi++]]++;
        }
        else{
            ret += (hi - lo);
            // cout << ret << '\n';
            cnt[a[lo++]]--;
        }
    }

    ret += (long long)(hi - lo)*(hi - lo + 1)/2;
    cout << ret << '\n';

    return 0;
}