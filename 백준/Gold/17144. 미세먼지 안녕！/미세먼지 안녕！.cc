#include <bits/stdc++.h>
using namespace std;

int dy1[] = {0, -1, 0, 1};
int dx1[] = {1, 0, -1, 0};
int dy2[] = {0, 1, 0, -1};
int dx2[] = {1, 0, -1, 0};

int r, c, t, k=0;
int mp[50][50];
vector<pair<int,int>> vp1, vp2;

vector<pair<int,int>> pushingYX(int sy, int sx, int dy[], int dx[]){
    vector<pair<int, int>> temp;
    int cnt = 0;
    int y = sy;
    int x = sx;
    while(true){
        int ny = y + dy[cnt];
        int nx = x + dx[cnt];
        if(ny < 0 || nx < 0 || ny >= r || nx >= c) {
            cnt++;
            ny = y + dy[cnt];
            nx = x + dx[cnt];
        }
        if(ny == sy && nx == sx) break;
        y = ny;
        x = nx;
        temp.push_back({ny,nx});
    }
    return temp;
}

void go(vector<pair<int, int>> &v){
    int a = 0;
    for(int i = v.size() - 1; i > 0; i--){
        mp[v[i].first][v[i].second] = mp[v[i-1].first][v[i-1].second];
    }
    mp[v[0].first][v[0].second] = 0;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> r >> c >> t;
    bool flag = true;
    for(int i = 0; i < r; i++){
        for(int j = 0; j < c; j++){
            cin >> mp[i][j];
            if(mp[i][j] == -1){
                if(flag){
                    vp1 = pushingYX(i,j,dy1,dx1);
                    flag = false;
                }
                else{
                    vp2 = pushingYX(i,j,dy2,dx2);
                }
            }
        }
    }
    // cout << '\n';

    while(t){
        t--;
        //확산
        int temp[50][50] = {{0,}};
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                int cnt = 0;
                if(mp[i][j] >= 5){
                    int a = mp[i][j]/5;
                    for(int k = 0; k < 4; k++){
                        int ny = i + dy1[k];
                        int nx = j + dx1[k];
                        if(ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
                        if(mp[ny][nx] == -1) continue;
                        temp[ny][nx] += a;
                        cnt++;
                    }
                    temp[i][j] += (mp[i][j] - (a * cnt));
                }
                else temp[i][j] += mp[i][j];
            }
        }
        swap(mp, temp);

        //청정
        go(vp1);
        go(vp2);

        // for(int i = 0; i < r; i++){
        //     for(int j = 0; j < c; j++){
        //         cout << mp[i][j] << ' ';
        //     }
        //     cout << '\n';
        // }
        // cout << '\n';

        //청정기
        
        // for(int i = 0; i < r; i++){
        //     for(int j = 0; j < c; j++){
        //         cout << mp[i][j] << ' ';
        //     }
        //     cout << '\n';
        // }
        // cout << '\n';
    }

    int sum = 0;
    for(int i = 0 ; i < r; i++){
        for(int j = 0; j < c; j++){
            sum += mp[i][j];
        }
    }
    sum += 2;
    cout << sum << '\n';

    return 0;
}