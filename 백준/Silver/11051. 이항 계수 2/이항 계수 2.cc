#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
int n, k;
ll dp[1001][1001];
const ll mod = 10007;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> k;
    dp[0][0] = 1;
    dp[1][0] = dp[1][1] = 1;
    for(int i = 2; i <= n; i++){
        for(int j = 0; j <= i; j++){
            if(j == 0 || j == i) dp[i][j] = 1;
            else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % mod;
        }
    }
   

    cout << dp[n][k] << '\n';

    return 0;
}