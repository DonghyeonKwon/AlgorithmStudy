#include <iostream>
#include <vector>
#include <string>
#include <queue>
#include <tuple>
#include <algorithm>
using namespace std;

int t, ret = 0, n, m;
vector<vector<char>> mp;
vector<vector<bool>> visited;
string key;
vector<bool> bkey;

const int dy[] = { -1, 0, 1, 0 };
const int dx[] = { 0, -1, 0, 1 };


void print(){
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cout << visited[i][j] << ' ';
        }
        cout << '\n';
    }
    cout << '\n';
}

void bfs(int y, int x){
    queue<pair<int, int>> q;
    q.push({y,x});
    visited[y][x] = true;

    while(q.size()){
        tie(y, x) = q.front();
        q.pop();

        // print();
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if(visited[ny][nx]) continue;
            if(mp[ny][nx] == '*') continue;

            if('a' <= mp[ny][nx] && mp[ny][nx] <= 'z'){
                int idx = mp[ny][nx] - 'a';
                if(!bkey[idx]){
                    bkey[idx] = true;
                    key += mp[ny][nx];
                }
                mp[ny][nx] = '.';
            }
            else if('A' <= mp[ny][nx] && mp[ny][nx] <= 'Z'){
                int idx = mp[ny][nx] - 'A';
                if(bkey[idx]){
                    mp[ny][nx] = '.';
                }
            }

            if(mp[ny][nx] == '.'){
                visited[ny][nx] = true;
                q.push({ny, nx});
            }
            else if(mp[ny][nx] == '$'){
                visited[ny][nx] = true;
                mp[ny][nx] = '.';
                ret++;
                q.push({ny, nx});
            }
        }
    }
}

void go(){
    int k = 0;
    while(1){
        k = key.size();
        // cout << key << '\n';

        visited.clear();
        visited.resize(n, vector<bool>(m, false));

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0 || i == n-1 || j == m-1) {
                    if(mp[i][j] == '*') continue;
                    if(!visited[i][j]){
                        if(mp[i][j] == '.'){
                            bfs(i, j);
                        }
                        else if('a' <= mp[i][j] && mp[i][j] <= 'z'){
                            int idx = mp[i][j] - 'a';
                            if(!bkey[idx]){
                                bkey[idx] = true;
                                key += mp[i][j];
                            }
                            mp[i][j] = '.';
                            bfs(i,j);
                        }
                        else if('A' <= mp[i][j] && mp[i][j] <= 'Z'){
                            int idx = mp[i][j] - 'A';
                            if(bkey[idx]){
                                mp[i][j] = '.';
                                bfs(i, j);
                            }
                        }
                        else if(mp[i][j] == '$'){
                            ret++;
                            mp[i][j] = '.';
                            bfs(i, j);
                        }
                    }
                }
            }
        }
        // cout << k << ' ' << key.size() << '\n';
        // cout << key << '\n';

        if(k == key.size()) break;
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> t;
    while(t--){
        cin >> n >> m;

        mp.clear();
        visited.clear();
        bkey.clear();

        mp.resize(n, vector<char>(m));
        visited.resize(n, vector<bool>(m, false));
        bkey.resize(26, false);
        ret = 0;
        key = "";

        // for(int i = 0; i < 26; i++) cout << bkey[i] << ' ';
        // cout << '\n';

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                cin >> mp[i][j];
            }
        }
        cin >> key;
        if(key != "0") for(char a : key) bkey[a - 'a'] = true;
        else key = "";

        go();

        cout << ret << '\n';

    }

    return 0;
}