#include <bits/stdc++.h>
using namespace std;

int t, k, dp[10001], p[101], cnt[101];
vector<pair<int, int>> vp;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> t >> k;
    for(int i = 0; i < k; i++){
        cin >> p[i] >> cnt[i];
    }

    dp[0] = 1;
    for(int i = 0; i < k; i++){
        for(int j = t; j >= 1; j--){
            int sum = 0;
            for(int a = 0; a < cnt[i]; a++){
                sum += p[i];
                if(j - sum >= 0 && dp[j - sum] > 0) dp[j] += dp[j-sum];
            }
        }
    }

    cout << dp[t] << '\n';

    return 0;
}