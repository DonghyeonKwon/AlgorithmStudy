#include <bits/stdc++.h>
using namespace std;

const int dy[] = { 0, -1, 1, 0, 0 };
const int dx[] = { 0, 0, 0, 1, -1 };

struct shark{
    int r, c, s, d, z;
};

int R, C, M, mp[101][101] = {{0,},}, ret = 0;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> R >> C >> M;
    shark s[M+1];
    for(int i = 1; i <= M; i++){
        cin >> s[i].r >> s[i].c >> s[i].s >> s[i].d >> s[i].z;
        mp[s[i].r][s[i].c] = i;
    }

    for(int x = 1; x <= C; x++){
        for(int y = 1; y <= R; y++){
            if(mp[y][x] > 0){
                ret += s[mp[y][x]].z;
                s[mp[y][x]].z = 0;
                mp[y][x] = 0;
                break;
            }
        }
        int temp[101][101] = {{0,},};
        for(int i = 1; i <= M; i++){
            if(s[i].z == 0) continue;
            int nr = s[i].r + (s[i].s * dy[s[i].d]);
            int nc = s[i].c + (s[i].s * dx[s[i].d]);
            while(nr <= 0 || nc <= 0 || nr > R || nc > C){
                // cout << i << ' ' << nr << ' ' << nc <<'\n';
                if(nr <= 0){
                    nr = 1 + (abs(nr)+1);
                }
                else if(nc <= 0){
                    nc = 1 + (abs(nc)+1);
                }
                else if(nr > R){
                    nr = R - (nr - R);
                }
                else if(nc > C){
                    nc = C - (nc - C);
                }
                if(s[i].d == 1 || s[i].d == 3) s[i].d++;
                else if(s[i].d == 2 || s[i].d == 4) s[i].d--;
            }
            s[i].r = nr;
            s[i].c = nc;
            // for(int j = 0; j < s[i].s; j++){
            //     s[i].r += dy[s[i].d];
            //     s[i].c += dx[s[i].d];
            //     if(s[i].r <= 0 || s[i].c <= 0 || s[i].r > R || s[i].c > C){
            //         if(s[i].d == 1 || s[i].d == 3) s[i].d++;
            //         else if(s[i].d == 2 || s[i].d == 4) s[i].d--;
            //         int p = 2;
            //         while(p--){
            //             s[i].r += dy[s[i].d];
            //             s[i].c += dx[s[i].d];
            //         }
            //     }
            // }
            if(temp[s[i].r][s[i].c] > 0){
                int j = temp[s[i].r][s[i].c];
                if(s[j].z < s[i].z){
                    s[j].z = 0;
                    temp[s[i].r][s[i].c] = i;
                }
                else{
                    s[i].z = 0;
                }
            }
            else if (temp[s[i].r][s[i].c] == 0){
                temp[s[i].r][s[i].c] = i;
            }
        }
        swap(mp, temp);
        // for(int i = 1; i <= R; i++){
        //     for(int j = 1; j <= C; j++){
        //         mp[i][j] = temp[i][j];
        //     }
        // }
    }

    cout << ret << '\n';

    return 0;
}