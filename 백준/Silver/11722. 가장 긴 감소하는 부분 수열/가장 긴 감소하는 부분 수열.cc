#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    vector<int> arr(n), dp(n);

    for(int i = 0 ; i < n; i++) cin >> arr[i];

    int ret = 0;
    for(int i = 0; i < n; i++){
        dp[i] = 1;
        for(int j = 0; j < i; j++){
            if(arr[i] < arr[j]){
                dp[i] = max(dp[i], dp[j] + 1); 
            }
        }
        ret = max(ret, dp[i]);
    }

    cout << ret << '\n';

    return 0;
}