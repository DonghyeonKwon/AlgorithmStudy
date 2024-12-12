#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int t, a[10001], dp[10001];

    cin >> t;
    for(int i = 1; i <= t; i++){
        cin >> a[i];
    }

    dp[0] = a[0] = 0;
    dp[1] = a[1];
    dp[2] = a[1] + a[2];
    for(int i = 3; i <= t; i++){
        dp[i] = max(dp[i-3] + a[i-1] + a[i], max(dp[i-2] + a[i], dp[i-1]));
    }

    cout << dp[t] << '\n';

    return 0;
}