#include <bits/stdc++.h>
using namespace std;

const int mod = 9901;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    int dp[n+1];
    dp[0] = 1;
    dp[1] = 3;
    for(int i = 2; i <= n; i++){
        dp[i] = ((dp[i-1] * 2) % mod + dp[i-2]) % mod;
    }
    cout << dp[n] << '\n';

    return 0;
}