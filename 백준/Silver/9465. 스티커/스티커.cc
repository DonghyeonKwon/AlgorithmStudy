#include <bits/stdc++.h>
using namespace std;
int t, n;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> t;
    while(t--){
        cin >> n;
        int num[2][n], dp[2][n];
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < n; j++){
                cin >> num[i][j];
            }
        }

        dp[0][0] = num[0][0];
        dp[1][0] = num[1][0];
    

        for(int i = 1; i < n; i++){
            if(i > 1){
                dp[0][i] = num[0][i] + max(dp[1][i-1], dp[1][i-2]);
                dp[1][i] = num[1][i] + max(dp[0][i-2], dp[0][i-1]);
            }
            else{
                dp[0][i] = dp[1][i-1] + num[0][i];
                dp[1][i] = dp[0][i-1] + num[1][i];
            }
        }
        cout << max(dp[0][n-1], dp[1][n-1]) << '\n';
    }

    return 0;
}