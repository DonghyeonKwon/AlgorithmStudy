#include <bits/stdc++.h>
using namespace std;

int dp[1001][1001];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string fir, sec;
    cin >> fir >> sec;
    memset(dp, 0, sizeof(dp));
    for(int i = 1; i <= fir.size(); i++){
        for(int j = 1; j <= sec.size(); j++){
            if(fir[i-1] == sec[j-1]){
                dp[i][j] = dp[i-1][j-1] + 1;
            }
            else{
                dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
            }
        }
    }
    cout << dp[fir.size()][sec.size()] << '\n';

    return 0;
}