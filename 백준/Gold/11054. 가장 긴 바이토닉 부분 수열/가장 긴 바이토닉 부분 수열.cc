#include <bits/stdc++.h>
using namespace std;

int n, a[1001], len = 0;

stack<pair<int, int>> posList;
int dp[1001], rdp[1001];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    for(int i = 0; i < n; i++) cin >> a[i];
    for(int i = 0; i < n; i++){
        dp[i] = 1;
        for(int j = 0; j <= i; j++){
            if(a[j] < a[i] && dp[i] < dp[j]+1){
                dp[i] = dp[j] + 1;
            }
        }
    }
    for(int i = n-1; i >= 0; i--){
        rdp[i] = 1;
        for(int j = n-1; j >= i; j--){
            if(a[j] < a[i] && rdp[i] < rdp[j] + 1){
                rdp[i] = rdp[j] +1;
            }
        }
    }

    int ret = 0;
    for(int i = 0; i < n; i++){
        ret = max(ret, dp[i] + rdp[i] - 1);
    }

    cout << ret << '\n';

    return 0;
}