#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    int dp[1001];

    cin >> n;
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    for(int i = 3; i <= n; i++){
        dp[i] = min(dp[i-1] + 1, dp[i-3] + 1);
    }
    if(dp[n] % 2 == 1) cout << "SK\n";
    else cout << "CY\n";

    return 0;
}