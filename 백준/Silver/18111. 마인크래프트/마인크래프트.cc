#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, m, b;

bool cmp(pair<int, int> a, pair<int, int> b){
    if(a.first == b.first){
        return a.second > b.second;
    }
    else return a.first < b.first;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> m >> b;
    vector<vector<int>> v(n, vector<int>(m));
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> v[i][j];
            b += v[i][j];
        }
    }

    vector<pair<int, int>> vp;
    int h = 0;
    while(b >= 0){
        vector<vector<int>> tmp(n, vector<int>(m, h));

        int time = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(tmp[i][j] < v[i][j]){
                    time += (2 * (v[i][j] - tmp[i][j]));
                }
                else if(tmp[i][j] > v[i][j]){
                    time += tmp[i][j] - v[i][j];
                }
            }
        }
        
        vp.push_back({time, h});

        h++;
        b -= (n * m);
    }

    sort(vp.begin(), vp.end(), cmp);

    cout << vp.front().first << ' ' << vp.front().second << '\n';

    return 0;
}