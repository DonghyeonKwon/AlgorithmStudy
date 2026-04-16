#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, ret = 0;
vector<vector<char>> mp;
const int dy[] = {1, 0};
const int dx[] = {0, 1};

bool check(int yy, int xx){
    return ((0 <= yy && yy < n) && (0 <= xx && xx < n));
}

void go(){
    int cnt = 0;
    for(int i = 0; i < n; i++){
        cnt = 1;
        for(int j = 1; j < n; j++){
            if(mp[i][j] == mp[i][j-1]){
                cnt++;
            }
            else{
                ret = max(ret, cnt);
                cnt = 1;
            }
        }
        ret = max(ret, cnt);
    }

    for(int i = 0; i < n; i++){
        cnt = 1;
        for(int j = 1; j < n; j++){
            if(mp[j][i] == mp[j-1][i]){
                cnt++;
            }
            else{
                ret = max(ret, cnt);
                cnt = 1;
            }
        }
        ret = max(ret, cnt);
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin >> n;
    mp.resize(n, vector<char>(n));
    for(int i = 0; i < n; i++) for(int j = 0; j < n; j++) cin >> mp[i][j];

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            for(int d = 0; d < 2; d++){
                int ny = i + dy[d];
                int nx = j + dx[d];
                if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                if(mp[i][j] == mp[ny][nx]) continue;
                swap(mp[i][j], mp[ny][nx]);
                go();
                swap(mp[i][j], mp[ny][nx]);
            }
        }
    }

    cout << ret << '\n';

    return 0;
}