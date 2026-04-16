#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, x, y, d, g;
vector<vector<int>> mp(101, vector<int>(101, 0));

const int dy[] = {0,-1,0,1};
const int dx[] = {1,0,-1,0};

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> x >> y >> d >> g;
        mp[y][x]++;
        int cnt = 0;
        vector<int> v;
        while(cnt <= g){
            if(cnt == 0){
                y = y + dy[d];
                x = x + dx[d];
                mp[y][x]++;
                v.push_back(d);
            }
            else{
                int j = v.size() - 1;
                for(; j >= 0; j--){
                    int nd = (v[j] + 1) % 4;
                    y = y + dy[nd];
                    x = x + dx[nd];
                    mp[y][x]++;
                    v.push_back(nd);
                }
            }
            cnt++;
        }
    }
    int ret = 0;
    for(int i = 0; i < 100; i++){
        for(int j = 0; j < 100; j++){
            if(mp[i][j] > 0 && mp[i+1][j] > 0 && mp[i][j+1] > 0 && mp[i+1][j+1] > 0) ret++;
        }
    }
    cout << ret << '\n';

    return 0;
}