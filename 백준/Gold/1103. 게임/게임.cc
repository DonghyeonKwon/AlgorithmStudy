#include <bits/stdc++.h>
using namespace std;

int n, m, dp[51][51];
char a[51][51];
bool check[51][51];
string s;
const int dy[] = {1, 0, -1, 0};
const int dx[] = {0, 1, 0, -1};

bool in(int y, int x){
    return ( 1 <= y && y <= n && 1 <= x && x <= m );
}

int down(int y, int x){
    if(!in(y,x) || a[y][x] == 'H') return 0;
    if(check[y][x]){
        cout << -1 << '\n';
        exit(0);
    }
    
    int &ret = dp[y][x];
    if(ret) return ret;

    check[y][x] = 1;
    int value = a[y][x] - '0';
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i] * value;
        int nx = x + dx[i] * value;
        ret = max(ret, down(ny,nx)+1);
    }
    check[y][x] = 0;

    return ret;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m;
    for(int i = 1; i <= n; i++){
        cin >> s;
        for(int j = 1; j <= m; j++){
            a[i][j] = s[j-1];
        }
    }

    cout << down(1,1) << '\n';

    return 0;
}