#include <bits/stdc++.h>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int x[1001] = {0, }, y[1001] = {0, };
    vector<pair<int,int>> vp;
    for(int i = 0; i < 3; i++){
        int a, b;
        cin >> a >> b;
        vp.push_back({a,b});
        x[a]++;
        y[b]++;
    }
    int nx, ny;
    for(pair<int,int> p : vp){
        if(x[p.first] == 1){
            nx = p.first;
        }
        if(y[p.second] == 1){
            ny = p.second;
        }
    }
    cout << nx << " " << ny << '\n';
    return 0;
}