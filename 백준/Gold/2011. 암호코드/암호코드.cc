#include <iostream>
#include <string>
using namespace std;
typedef long long ll;

const ll mod = 1000000;
ll dp[5001];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string str;
    cin >> str;
    int len = str.size();
    str = " " + str;

    dp[0] = 1;
    for(int i = 1; i <= len; i++){
        int x = str[i] - '0';
        if(x > 0){
            dp[i] = (dp[i] + dp[i-1]) % mod;
        }
        if(i == 1 || str[i-1] == '0') continue;

        x = (str[i-1] - '0') * 10 + (str[i] - '0');
        if(10 <= x && x <= 26){
            dp[i] = (dp[i] + dp[i-2]) % mod;
        }
    }

    cout << dp[len] << '\n';

    return 0;
}