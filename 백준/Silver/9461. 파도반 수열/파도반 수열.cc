#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    ll t, a, dp[101];
    dp[1] = dp[2] = dp[3] = 1;
    dp[4] = dp[5] = 2;

    for(int i = 6; i <= 100; i++){
        dp[i] = dp[i-1] + dp[i-5];
    }

    cin >> t;
    while(t--){
        cin >> a;
        cout << dp[a] << '\n';
    }

    return 0;
}