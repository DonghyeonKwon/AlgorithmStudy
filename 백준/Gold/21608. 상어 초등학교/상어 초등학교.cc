#include <iostream>
#include <vector>
using namespace std;

vector<vector<int>> vv(401, vector<int>());
vector<vector<int>> seat(400, vector<int>(400, 0));
int n;

const int scr[] = {0, 1, 10, 100, 1000};
const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, -1, 0, 1};

void find_favorite(int idx){
    int v[n][n];
    int f[n][n];
    int _max = -1, mr = 0, mc = 0, cnt = 0, fcnt = 0;

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(seat[i][j] != 0) continue;
            cnt = 0;
            fcnt = 0;
            for(int d = 0; d < 4; d++){
                int ny = i + dy[d];
                int nx = j + dx[d];
                if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;

                if(seat[ny][nx] == 0) cnt++;

                for(int k = 0; k < 4; k++) if(seat[ny][nx] == vv[idx][k]) fcnt++;
            }

            v[i][j] = cnt;
            f[i][j] = fcnt;

            if(_max < fcnt){
                _max = fcnt; mr = i; mc = j;
            }
            else if(_max == fcnt){
                if(v[i][j] > v[mr][mc]){
                    mr = i; mc = j;
                }
                else if(v[i][j] == v[mr][mc]){
                    if(i < mr){
                        mr = i; mc = j;
                    }
                    else if(i == mr){
                        if(j < mc){
                            mr = i; mc = j;
                        }
                    }
                }
            }
        }
    }
    seat[mr][mc] = idx;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for(int i = 1; i <= n*n; i++){
        int a;
        cin >> a;
        for(int j = 0; j < 4; j++){
            int b;
            cin >> b;
            vv[a].push_back(b);
        }
        find_favorite(a);
    }

    int ret = 0;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            int value = seat[i][j];
            int cnt = 0;

            for(int d = 0; d < 4; d++){
                int ny = i + dy[d];
                int nx = j + dx[d];
                if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;

                for(int k = 0; k < 4; k++){
                    if(seat[ny][nx] == vv[value][k]){
                        cnt++;
                        break;
                    }
                }
            }

            ret += scr[cnt];
        }
    }
    cout << ret << '\n';

    return 0;
}