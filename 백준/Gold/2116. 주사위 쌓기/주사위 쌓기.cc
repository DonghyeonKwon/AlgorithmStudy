#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, _mx = -1;
vector<vector<int>> v;

int check_idx(int i){
    if(i == 0) return 5;
    else if(i == 1) return 3;
    else if(i == 2) return 4;
    else if(i == 3) return 1;
    else if(i == 4) return 2;
    else if(i == 5) return 0;
}

void go(int idx, int sum, int up_num){
    if(idx == v.size()){
        if(_mx < sum) _mx = sum;
        return;
    }
    int i = 0;

    for(; i < 6; i++){
        if(v[idx][i] == up_num) break;
    }

    int mx = 0, up_num_idx = check_idx(i);
    for(int j = 0; j < 6; j++){
        if(i == j || up_num_idx == j) continue;
        if(mx < v[idx][j]) mx = v[idx][j];
    }
    
    go(idx+1, sum + mx, v[idx][up_num_idx]);
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    v.resize(n, vector<int>(6, 0));
    for(int i = 0; i < n; i++){
        for(int j = 0; j < 6; j++){
            cin >> v[i][j];
        }
    }

    for(int i = 0; i < 6; i++){
        int mx = 0, up_num_idx = check_idx(i);
        for(int j = 0; j < 6; j++){
            if(j == i || j == up_num_idx) continue;
            if(mx < v[0][j]) mx = v[0][j];
        }
        go(1, mx, v[0][up_num_idx]);
    }

    cout << _mx << '\n';

    return 0;
}