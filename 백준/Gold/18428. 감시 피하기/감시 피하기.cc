#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n;
char mp[6][6];
vector<pair<int, int>> teacher, x;

void check(){
    // for(int i = 0; i < n; i++){
    //     for(int j = 0; j < n; j++){
    //         cout << mp[i][j] << ' ';
    //     }
    //     cout << '\n';
    // }
    // cout << '\n';

    for(int i = 0; i < teacher.size(); i++){
        int a = teacher[i].first, b = teacher[i].second;
        for(int i = a-1; i >= 0; i--){
            if(mp[i][b] == 'O') break;
            if(mp[i][b] == 'S') return;
        }
        for(int i = a + 1; i < n; i++){
            if(mp[i][b] == 'O') break;
            if(mp[i][b] == 'S') return;
        }
        for(int i = b - 1; i >= 0; i--){
            if(mp[a][i] == 'O') break;
            if(mp[a][i] == 'S') return;
        }
        for(int i = b + 1; i < n; i++){
            if(mp[a][i] == 'O') break;
            if(mp[a][i] == 'S') return;
        }
    }

    cout << "YES\n";
    exit(0);
}

void go(int idx, int cnt){
    if(cnt == 3){
        check();
        return;
    }

    for(int i = idx; i < x.size(); i++){
        int a = x[i].first, b = x[i].second;
        mp[a][b] = 'O';
        go(i+1, cnt+1);
        mp[a][b] = 'X';
    }
    return;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> mp[i][j];
            if(mp[i][j] == 'X') x.push_back({i,j});
            if(mp[i][j] == 'T') teacher.push_back({i, j});
        }
    }

    go(0, 0);
    cout << "NO\n";

    return 0;
}