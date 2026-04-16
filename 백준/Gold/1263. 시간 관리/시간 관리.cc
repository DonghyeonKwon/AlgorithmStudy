#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n;
bool flag = false;
vector<pair<int, int>> vp;

bool comp(pair<int, int> a, pair<int, int> b){
    if(a.second == b.second) return (a.first < b.first);
    return (a.second < b.second);
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    vp.resize(n, pair<int,int>());
    for(int i = 0; i < n; i++) cin >> vp[i].first >> vp[i].second;
    sort(vp.begin(), vp.end(), comp);

    int sum = 0, ans = 987654321;
    for(int i = 0; i < n; i++){
        sum += vp[i].first;
        if(sum > vp[i].second){
            flag = true;
            break;
        }
        ans = min(ans, vp[i].second - sum);
    }
    if(flag) cout << -1 << '\n';
    else{
        cout << ans << '\n';
    }

    return 0;
}