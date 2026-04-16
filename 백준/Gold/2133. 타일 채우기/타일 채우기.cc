#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    if(n % 2 == 1) {
        cout << 0 << '\n';
        return 0;
    }
    long long dp[31];
    dp[0] = 1;
    dp[2] = 3;
    dp[4] = 11;
    for(int i = 6; i <= n; i += 2){
        long long sum = dp[i-2] * dp[2];
        for(int j = i- 4; j >= 0; j -= 2){
            sum += dp[j] * 2;
        }
        dp[i] = sum;
    }
    cout << dp[n] << '\n';

    return 0;
}