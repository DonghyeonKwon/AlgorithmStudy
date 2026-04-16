#include <bits/stdc++.h>
using namespace std;

const int INF = INT_MAX;

int n, a, b, dp[501][501];
pair<int, int> vp[501];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    for(int i = 1; i <= n; i++){
        cin >> vp[i].first >> vp[i].second;
        dp[i][i] = 0;
    }

    for(int i = 1; i < n; i++){
        for(int j = 1; j+i <= n; j++){
            dp[j][i+j] = INF;
            for(int mid = j; mid <= i+j; mid++){
                dp[j][i+j] = min(dp[j][i+j], dp[j][mid] + dp[mid+1][i+j] + vp[j].first * vp[mid].second * vp[i+j].second);
            }
        }
    }

    cout << dp[1][n] << '\n';

    return 0;
}