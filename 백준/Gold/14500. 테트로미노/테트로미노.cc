#include <bits/stdc++.h>
using namespace std;

const int dy[] = {0, 1, 0, -1};
const int dx[] = {1, 0, -1, 0};
int n, m, _mx = 0;
int arr[500][500];
bool visited[500][500];

void dfs(int y, int x, int cnt, int sum){
    if(cnt == 4){
        if(_mx < sum) _mx = sum;
        return;
    }

    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
        if(visited[ny][nx]) continue;
        visited[ny][nx] = true;
        dfs(ny,nx, cnt+1, sum + arr[ny][nx]);
        visited[ny][nx] = false;
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> arr[i][j];
            visited[i][j] = false;
        }
    }

    for(int y = 0; y < n; y++){
        for(int x = 0; x < m; x++){
            if(visited[y][x] == 0){
                visited[y][x] = true;
                dfs(y, x, 1, arr[y][x]);
                visited[y][x] = false;
            }
        }
    }
     for(int y = 0; y < n; y++){
        for(int x = 0; x < m; x++){
            int sum = arr[y][x];
            int cnt = 1;
            int _mn = 1001;
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                cnt++;
                sum += arr[ny][nx];
                if(_mn > arr[ny][nx]) _mn = arr[ny][nx];
            }
            if(cnt < 4) continue;
            if(cnt == 4) {if(_mx < sum) _mx = sum;}
            else if(cnt == 5){
                sum -= _mn;
                if(_mx < sum) _mx = sum;
            }
        }
    }
    cout << _mx << '\n';

    return 0;
}