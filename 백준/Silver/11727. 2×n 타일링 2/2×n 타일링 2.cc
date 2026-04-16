#include <bits/stdc++.h>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int dp[1001];
    dp[1] = 1;
    dp[2] = 3;
    for(int i = 3; i <= 1000; i++){
        dp[i] = ((dp[i-2] * 2) + dp[i-1]) % 10007;
    }

    int a;
    cin >> a;
    cout << dp[a] << '\n';

    return 0;
}