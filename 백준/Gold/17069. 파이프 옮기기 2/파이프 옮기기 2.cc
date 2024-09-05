#include <bits/stdc++.h>
using namespace std;

int n;
long long mp[33][33], dp[33][33][3];

bool check(int y, int x, int d){
    if(d == 0 || d == 2){
        if(mp[y][x] == 0) return true;
    }else if(d == 1){
        if(mp[y][x] == 0 && mp[y][x-1] == 0 && mp[y-1][x] == 0) return true;
    }
    return false;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n; 
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= n; j++){
            cin >> mp[i][j];
        }
    }

    dp[1][2][0] = 1;
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= n; j++){
            if(check(i, j+1, 0)) dp[i][j+1][0] += dp[i][j][0];
            if(check(i+1, j+1, 1)) dp[i+1][j+1][1] += dp[i][j][0];

            if(check(i+1, j, 2)) dp[i+1][j][2] += dp[i][j][2];
            if(check(i+1, j+1, 1)) dp[i+1][j+1][1] += dp[i][j][2];

            if(check(i, j+1, 0)) dp[i][j+1][0] += dp[i][j][1];
            if(check(i+1, j, 2)) dp[i+1][j][2] += dp[i][j][1];
            if(check(i+1, j+1, 1)) dp[i+1][j+1][1] += dp[i][j][1];
        }
    }

    long cnt = dp[n][n][0];
    cnt += dp[n][n][1];
    cnt += dp[n][n][2];
    cout << cnt << '\n';

    return 0;
}