#include <bits/stdc++.h>
using namespace std;

int n, p[1001], dp[1001];

int main(int argc, char* argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    for(int i = 1; i <= n; i++) cin >> p[i];
    p[0] = 0;
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= i; j++){
            dp[i] = max(dp[i], dp[i-j] + p[j]);
        }
    }

    cout << dp[n] << '\n';

    return 0;
}