#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, k;
    cin >> n >> m >> k;

    ll dp[101][101];
    for(int i = 1; i <= 100; i++){
        dp[0][i] = dp[i][0] = 1;
    }
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m; j++){
            dp[i][j] = dp[i-1][j] + dp[i][j-1];
            if(dp[i][j] > 1000000000) dp[i][j] = 1000000000;
        }
    }

    if(dp[n][m] < k){
        cout << -1 << '\n';
        return 0;
    }

    int a_cnt = n;
    int z_cnt = m;
    string ret = "";
    for(int i = 0; i < n+m; i++){
        int as = dp[a_cnt - 1][z_cnt];
        if(a_cnt == 0){
            ret += 'z';
            z_cnt--;
        }
        else if(z_cnt == 0){
            ret += 'a';
            a_cnt--;
        }
        else if(k <= as){
            ret += 'a';
            a_cnt--;
        }
        else{
            k -= as;
            ret += 'z';
            z_cnt--;
        }
    }
    cout << ret << '\n';

    return 0;
}