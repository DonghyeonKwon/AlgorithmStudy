#include <bits/stdc++.h>
using namespace std;

int n, m;
int chickenS[101];
vector<vector<int>> chickenList;
vector<pair<int, int>> home, chicken;

void go(int s, vector<int> q){
    if(q.size() == m){
        chickenList.push_back(q);
        return;
    }

    for(int i = s + 1; i < chicken.size(); i++){
        q.push_back(i);
        go(i, q);
        q.pop_back();
    }
    return;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m;

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            int a;
            cin >> a;
            if(a == 1)
                home.push_back({i,j});
            else if(a == 2)
                chicken.push_back({i,j});
        }
    }
    
    vector<int> q;
    go(-1, q);


    int ret = 987654321;
    for(auto it : chickenList){
        int i = it[0];
        int j = it[1];
        int k = it[2];
        int sum_min = 0;
        for(auto h : home){
            int min_n = 987654321;
            for(int ch : it){
                int _dist = abs(h.first - chicken[ch].first) + abs(h.second - chicken[ch].second);
                min_n = min(min_n, _dist);
            }
            sum_min += min_n;
        }
        ret = min(ret, sum_min);
    }

    cout << ret << '\n';

    return 0;
}