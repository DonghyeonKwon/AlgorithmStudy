#include <bits/stdc++.h>
using namespace std;

int n, m, h, total_cnt = 0;
bool mp[31][11], flag;

void dfs(int y, int cnt){
    if(total_cnt == cnt){
        bool poss = true;
        for(int i = 1; i <= n; i++){
            int x = i;
            for(int j = 0; j < h; j++){
                int height = j;

                if(mp[height][x]) x++;
                else if(x > 1 && mp[height][x-1]) x--;

            }
            if(x != i) {
                poss = false;
                break;
            } 
        }
        if(poss){
            flag = true;
        }
        return;
    }

    for(int i = y; i < h; i++){
        for(int j = 1; j < n; j++){
            if(!mp[i][j-1] && !mp[i][j] && !mp[i][j+1]){
                mp[i][j] = true;
                dfs(i, cnt+1);
                mp[i][j] = false;
            }
        }
    }
    return;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m >> h;

    fill(&mp[0][0], &mp[0][0] + (31*11), false);

    for(int i = 0; i < m; i++){
        int y, x;
        cin >> y >> x;
        mp[y-1][x] = true;
    }
    
    for(int i = 0; i <= 3; i++){
        total_cnt = i;
        dfs(0, 0);
        if(flag) {
            cout << total_cnt << '\n';
            return 0;
        }
    }

    cout << -1 << '\n';
    return 0;
}