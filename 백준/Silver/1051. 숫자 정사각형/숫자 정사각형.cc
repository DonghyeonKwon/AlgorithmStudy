#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, m;

bool check(int y, int x, int r){
    y += r;
    x += r;
    return (y < n && x < m);
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> m;
    vector<vector<char>> v(n, vector<char>(m));

    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> v[i][j];
        }
    }

    int ret = 0;
    int len = 0;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            int r = len;
            while(check(i, j, r)){
                // cout << v[i][j] << ' ' << v[i+r][j] << ' ' << v[i][j+r] << ' ' << v[i+r][j+r] << '\n';
                if(v[i][j] == v[i + r][j] && v[i+r][j] == v[i][j+r] && v[i][j + r] == v[i + r][j + r]){
                    if(ret < (r+1) * (r+1)){
                        ret = (r+1) * (r+1);
                        // cout << ret << '\n';
                        len = r;
                    }
                }
                r++;
            }
        }
    }

    cout << ret << '\n';

    return 0;
}