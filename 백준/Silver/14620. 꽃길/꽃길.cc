#include <bits/stdc++.h>
using namespace std;

int n, mp[11][11], minS = 3001;
bool check[11][11];
vector<pair<int, int>> vp;

const int dy[] = {0, 1, 0, -1};
const int dx[] = {1, 0, -1, 0};

bool checking(int y, int x){
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 1 || nx < 1 || ny > n || nx > n) return false;
        if(check[ny][nx]) return false;
    }
    return true;
}

void pushing(int y, int x){
    check[y][x] = true;
    vp.push_back({y,x});
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        check[ny][nx] = true;
        vp.push_back({ny, nx});
    }
}

void popping(){
    int a, b;

    for(int i = 0; i < 5; i++){
        tie(a,b) = vp.back();
        check[a][b] = false;
        vp.pop_back();
    }
}

void search(int y, int x, int cnt){
    if(cnt == 3){
        int sum = 0;
        for(pair<int, int> i : vp){
            sum += mp[i.first][i.second];
        }
        minS = min(sum, minS);
        return;
    }

    for(int i = y; i <= n; i++){
        for(int j = x; j <= n; j++){
            if(checking(i,j)){
                pushing(i,j);
                search(1,1, cnt+1);
                popping();
            }
        }
    }
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

    fill(&check[0][0], &check[0][0] + (11 * 11), false);
    search(1, 1, 0);

    cout << minS << '\n';

    return 0;
}