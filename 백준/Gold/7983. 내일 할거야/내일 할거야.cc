#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp(pair<int,int> a, pair<int, int> b){
    return (a.second > b.second);
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    vector<pair<int, int>> vp(n, {0,0});
    for(int i = 0; i < n; i++){
        cin >> vp[i].first >> vp[i].second;
    }
    sort(vp.begin(), vp.end(), cmp);

    int now = vp[0].second - vp[0].first;
    for(int i = 1; i < n; i++){
        int d = vp[i].first, t = vp[i].second;
        if(now >= t){
            now = t - d;
        }
        else{
            now = now - d;
        }
    }

    cout << now << '\n';

    return 0;
}