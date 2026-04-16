#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

int r, c, k, rcnt = 3, ccnt = 3;
vector<vector<int>> mp(100, vector<int>(100, 0));
map<int, int> tmp;

bool cmp(pair<int, int> a, pair<int, int> b){
    if(a.second == b.second){
        return (a.first < b.first);
    }
    return (a.second < b.second);
}

void print(){
    for(int i = 0; i < rcnt; i++){
        for(int j = 0; j < ccnt; j++){
            cout << mp[i][j] << ' ';
        }
        cout << '\n';
    }
    cout << '\n';
}

void rCal(){
    int cnt = 0;
    for(int i = 0; i < rcnt; i++){
        tmp.clear();
        for(int j = 0; j < ccnt; j++){
            if(mp[i][j] == 0) continue;
            if(tmp[mp[i][j]] == 0) tmp[mp[i][j]] = 1;
            else tmp[mp[i][j]]++;
            // cout << mp[i][j] << " : " << tmp[mp[i][j]] << '\n';
        }
        vector<pair<int, int>> vp;
        for(const auto it : tmp){
            // cout << it.first << ' ' << it.second << '\n';
            vp.push_back({it.first, it.second});
        }
        int n = ((int)vp.size() * 2) <= 100 ? (int)vp.size() * 2 : 100;
        if(cnt < n) cnt = n;

        sort(vp.begin(), vp.end(), cmp);
        int k = 0;
        for(int j = 0; j < ccnt; j++) mp[i][j] = 0;
        for(pair<int, int> it : vp){
            mp[i][k++] = it.first;
            mp[i][k++] = it.second;
            if(k >= 100) break;
        }
    }
    ccnt = cnt;
    // cout << "rCal() : " << ccnt << '\n';
}

void cCal(){
    int cnt = 0;
    for(int i = 0; i < ccnt; i++){
        tmp.clear();
        for(int j = 0; j < rcnt; j++){
            if(mp[j][i] == 0) continue;

            if(tmp[mp[j][i]] == 0) tmp[mp[j][i]] = 1;
            else tmp[mp[j][i]]++;
        }
        
        vector<pair<int, int>> vp;
        for(const auto it : tmp){
            // cout << it.first << ' ' << it.second << '\n';
            vp.push_back({it.first, it.second});
        }
        int n = ((int)vp.size() * 2) < 100 ? (int)vp.size() * 2 : 100;
        if(cnt < n) cnt = n;

        sort(vp.begin(), vp.end(), cmp);
        int k = 0;
        for(int j = 0; j < rcnt; j++) mp[j][i] = 0;
        for(pair<int, int> it : vp){
            mp[k++][i] = it.first;
            mp[k++][i] = it.second;
            if(k >= 100) break;
        }
    }
    rcnt = cnt;
    // cout << "cCal() : " << rcnt << '\n';
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> r >> c >> k;
    r -= 1;
    c -= 1;
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
            cin >> mp[i][j];
        }
    }

    int cnt = 0;
    while(1){
        if(cnt > 100){
            cout << -1 << '\n';
            break;
        }
        if(mp[r][c] == k){
            cout << cnt << '\n';
            break;
        }
        // cout << cnt << '\n';
        // print();
        if(rcnt >= ccnt){
            rCal();
        }
        else if (rcnt < ccnt){
            cCal();
        }

        cnt++;
    }
    // cout << cnt << '\n';
    // print();

    return 0;
}