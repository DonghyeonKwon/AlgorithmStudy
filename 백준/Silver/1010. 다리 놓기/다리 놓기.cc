#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int dp[16][31] = {{0,},};
    
    for(int i = 0; i <= 15; i++){
        for(int j = 1; j <= 30; j++){
            if(i == 0){
                dp[i][j] = 1;
            }
            else if(i <= j){
                dp[i][j] = dp[i-1][j-1] * j / i;
            }
        }
    }

    int t, a, b;
    cin >> t;
    while(t--){
        cin >> a >> b;
        if(b/2 < a) a = b - a;
        cout << dp[a][b] << '\n';
    }

    return 0;
}