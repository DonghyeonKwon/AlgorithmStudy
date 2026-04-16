#include <bits/stdc++.h>
using namespace std;
int n, cnt0 = 0, cnt1 = 0;
char mp[100][100], mp2[100][100];
bool visited[100][100];

const int dy[] = { 0, -1, 0, 1 };
const int dx[] = { -1, 0, 1, 0 };

void bfs(int y, int x, char c, char arr[100][100]){
    queue<pair<int,int>> q;
    q.push({y,x});
    visited[y][x] = true;
    while(q.size()){
        tie(y, x) = q.front();
        q.pop();
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
            if(visited[ny][nx]) continue;
            if(arr[ny][nx] != c) continue;
            visited[ny][nx] = true;
            q.push({ny, nx});
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    //n 입력
    cin >> n;
    //mp 입력
    for(int i = 0; i < n; i++){
        string s;
        cin >> s;
        for(int j = 0; j < n; j++){
            mp[i][j] = mp2[i][j] = s[j];
            //적록색약 화면 R과 G를 R로 통일
            if(s[j] == 'G') mp2[i][j] = 'R';
        }
    }
    //일반인이 봤을 때
    memset(visited, false, sizeof(visited));
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(!visited[i][j]){
                bfs(i,j, mp[i][j], mp);
                cnt0++;
            }
        }
    }
    //적록색약이 봤을 때
    memset(visited, false, sizeof(visited));
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(!visited[i][j]){
                bfs(i,j, mp2[i][j], mp2);
                cnt1++;
            }
        }
    }

    cout << cnt0 << ' ' << cnt1 << '\n';

    return 0;
}