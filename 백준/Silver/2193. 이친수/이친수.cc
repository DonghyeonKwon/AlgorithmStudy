#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    long long a, dp[91][2];

    dp[1][0] = 0;
    dp[1][1] = 1;

    for(int i = 2; i <= 90; i++){
        dp[i][0] = dp[i-1][0] + dp[i-1][1];
        dp[i][1] = dp[i-1][0];
    }

    cin >> a;
    cout << dp[a][0] + dp[a][1] << '\n';

    return 0;
}