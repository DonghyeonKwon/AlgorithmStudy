#include <bits/stdc++.h>
using namespace std;

int t, a[301], dp[301];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> t;
    for(int i = 1; i <= t; i++){
        cin >> a[i];
    }

    dp[1] = a[1];
    dp[2] = a[1] + a[2];
    dp[3] = max(a[1] + a[3], a[2] + a[3]);

    for(int i = 4; i <= t; i++){
        dp[i] = max(dp[i-2] + a[i], dp[i-3] + a[i-1] + a[i]);
    }

    cout << dp[t] << '\n';

    return 0;
}