#include <bits/stdc++.h>
using namespace std;
int n, mp[20][20], ret = 0;
int visited[20][20];
int eat_cnt = 0, sm = 2;
int sy, sx;
vector<pair<int, pair<int,int>>> vp;

const int dy[] = { 0, 1, 0, -1 };
const int dx[] = { 1, 0, -1, 0 };

void go(){
    vp.clear();
    int y = sy;
    int x = sx;
    fill(&visited[0][0], &visited[0][0] + (20 * 20), 0);
    visited[y][x] = 1;
    queue<pair<int, int>> q;
    q.push({y,x});

    while(q.size()){
        tie(y,x) = q.front();
        q.pop();
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
            if(visited[ny][nx] > 0) continue;
            if(sm < mp[ny][nx]) continue;
            visited[ny][nx] = visited[y][x] + 1;
            if(mp[ny][nx] > 0 && mp[ny][nx] < sm) vp.push_back({visited[ny][nx], {ny,nx}});
            q.push({ny,nx});
        }
    }
}

void eat(){
    // for(int i = 0; i < n; i++){
    //     for(int j = 0; j < n; j++){
    //         cout << visited[i][j] << ' ';
    //     } cout << '\n';
    // }cout << '\n';
    mp[sy][sx] = 0;
    pair<int, pair<int,int>> pos = vp[0];
    ret += pos.first - 1;
    tie(sy, sx) = pos.second;
    eat_cnt++;
    mp[sy][sx] = 9;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> mp[i][j];
            if(mp[i][j] == 9) {sy = i; sx = j;}
        }
    }
    
    while(1){
        go();
        if(vp.size() == 0) break;
        if(vp.size() > 1)sort(vp.begin(), vp.end());
        eat();
        if(eat_cnt == sm){
            sm++;
            eat_cnt = 0;
        }
    }
    
    cout << ret << '\n';

    return 0;
}