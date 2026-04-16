#include <bits/stdc++.h>
using namespace std;

const int INF = 987654321;
struct A{
 int p, f, s, v, c;
}a[16];
int mp, mf, ms, mv, n, _min = INF;
map<int, vector<vector<int>>> mpv;

void go(){
    for(int i = 1; i < (1 << n); i++){
        int cost = 0, sump = 0, sumf = 0, sums = 0, sumv = 0;
        vector<int> v;
        for(int j = 0; j < n; j++){
            if(i & (1 << j)){
                sump += a[j].p;
                sumf += a[j].f;
                sums += a[j].s;
                sumv += a[j].v;
                cost += a[j].c;
                v.push_back(j+1);
            }
        }
        // cout << cost << '\n';
        if(sump >= mp && sumf >= mf && sums >= ms && sumv >= mv){
            if(_min >= cost){
                _min = cost;
                mpv[cost].push_back(v);
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(); cout.tie();

    cin >> n;
    cin >> mp >> mf >> ms >> mv;

    for(int i = 0; i < n; i++){
        cin >> a[i].p >> a[i].f >> a[i].s >> a[i].v >> a[i].c;
    }

    go();

    if(_min != INF){
        cout << _min << '\n';
        sort(mpv[_min].begin(), mpv[_min].end());
        for(int i : mpv[_min][0])
            cout << i << ' ';
        cout << '\n';
    }
    else{
        cout << -1 << '\n';
    }
    

    return 0;
}