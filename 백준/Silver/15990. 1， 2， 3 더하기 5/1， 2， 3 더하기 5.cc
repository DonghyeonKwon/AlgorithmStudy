#include <bits/stdc++.h>
using namespace std;

const int mod = 1000000009;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n;
    cin >> n;
    int dp[100001][4];
    dp[1][1] = 1;
    dp[2][2] = 1;
    dp[3][1] = 1;
    dp[3][2] = 1;
    dp[3][3] = 1;
    for(int i = 4; i <= 100000; i++){
        if(i-1 > 0) dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % mod;
        if(i-2 > 0) dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % mod;
        if(i-3 > 0) dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % mod;
    }

    while(n--){
        int a;
        cin >> a;
        cout << ((dp[a][1] + dp[a][2]) % mod + dp[a][3]) % mod << '\n';
    }

    return 0;
}