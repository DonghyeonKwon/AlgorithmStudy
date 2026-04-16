#include <bits/stdc++.h>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int t;
    int dp[501][501] = {{ 0, },};
    cin >> t;

    for(int i = 1; i <= t; i++){
        for(int j = 1; j <= i; j++){
            cin >> dp[i][j];
        }
    }
    int _max = 0;
    for(int i = 1; i <= t; i++){
        for(int j = 1; j <= i; j++){
            if(j == 1){
                dp[i][j] += dp[i-1][j];
            }
            else if(i == j){
                dp[i][j] += dp[i-1][j-1];
            }
            else{
                dp[i][j] = max(dp[i-1][j-1] + dp[i][j], dp[i-1][j] + dp[i][j]);
            }

            _max = max(_max, dp[i][j]);
        }
    }


    
    cout << _max << '\n';

    return 0;
}