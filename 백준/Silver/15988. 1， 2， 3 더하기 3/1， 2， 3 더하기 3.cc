#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<long long> dp(1000001, 0);
    dp[1] = 1LL;
    dp[2] = 2LL;
    dp[3] = 4LL;
    for(int i = 4; i <= 1000000; i++){
        dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % (long long)1000000009;
    }

    int t;
    cin >> t;
    while(t--){
        int n;
        cin >> n;
        cout << dp[n] << '\n';
    }

    return 0;
}