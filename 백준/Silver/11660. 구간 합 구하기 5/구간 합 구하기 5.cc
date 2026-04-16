#include <iostream>
using namespace std;

int n, m, x_1, x_2, y_1, y_2, dp[1025][1025];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m;
    for(int i = 0; i <= n; i++) dp[i][0] = dp[0][i] = 0;
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= n; j++){
            cin >> dp[i][j];
            dp[i][j] += (dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1]);
        }
    }

    for(int i = 0; i < m; i++){
        cin >> x_1 >> y_1 >> x_2 >> y_2;
        int sum = dp[x_2][y_2];
        sum -= dp[x_1 -1][y_2];
        sum -= dp[x_2][y_1 - 1];
        sum += dp[x_1 - 1][y_1 - 1];

        cout << sum << '\n';
    }

    return 0;
}