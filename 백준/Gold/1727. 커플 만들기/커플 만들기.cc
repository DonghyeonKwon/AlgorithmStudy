#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;
    vector<int> man(n), woman(m);
    vector<vector<int>> dp(n+1, vector<int>(m+1, 0));
    for(int i = 0; i < n; i++) cin >> man[i];
    for(int i = 0; i < m; i++) cin >> woman[i];
    sort(man.begin(), man.end());
    sort(woman.begin(), woman.end());
    
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m; j++){
            if(i == j){
                dp[i][j] = dp[i-1][j-1] + abs(man[i-1] - woman[j-1]);
            }
            else if(i > j){
                dp[i][j] = min(dp[i-1][j], dp[i-1][j-1] + abs(man[i-1] - woman[j-1]));
            }
            else if(i < j){
                dp[i][j] = min(dp[i][j-1], dp[i-1][j-1] + abs(man[i-1] - woman[j-1]));
            }
        }
    }

    cout << dp[n][m] << '\n';

    return 0;
}