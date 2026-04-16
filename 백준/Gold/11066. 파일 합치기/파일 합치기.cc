#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int t;
    cin >> t;
    while(t--){
        int n;
        cin >> n;
        ll arr[501];
        ll sum[501];
        ll dp[501][501];
        sum[0] = 0;
        for(int i = 1; i <= n; i++){
            ll a;
            cin >> a;
            arr[i] = a;
            dp[i][i] = 0;
            sum[i] = sum[i-1] + a;
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; i + j <= n; j++){
                dp[j][i+j] = LONG_MAX;
               for(int k = j; k < i + j; k++){
                    dp[j][i + j] = min(dp[j][i+j], dp[j][k] + dp[k+1][i+j] + sum[i+j] - sum[j - 1]);
                }
            }
        }

        cout << dp[1][n] << '\n';   
    }

    return 0;
}