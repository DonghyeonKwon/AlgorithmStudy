#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
typedef long long ll;
ll n, g, k, lo = 0, hi = 10e9;
vector<pair<ll, pair<ll, ll>>> it;

bool check(ll mid){
    ll sum = 0;
    vector<ll> sums;
    for(int i = 0; i < it.size(); i++){
        ll tmp = it[i].first * max((ll)1, mid - it[i].second.first);
        sum += tmp;
        if(it[i].second.second == 1){
            sums.push_back(tmp);
        }
    }

    sort(sums.begin(), sums.end(), greater<ll>());
    for(int i = 0; i < min(k, (ll)sums.size()); i++) sum -= sums[i];

    return sum <= g;
}

bool comp(pair<ll, ll> a, pair<ll, ll> b){
    return (a.second > b.second);
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> g >> k;
    for(int i = 0; i < n; i++){
        ll s, l, o;
        cin >> s >> l >> o;
        it.push_back({s, {l, o}});
    }

    ll ret = 0;
    while(lo <= hi){
        ll mid = (hi + lo) / 2;
        if(check(mid)){
            lo = mid + 1;
            ret = mid;
        }
        else{
            hi = mid - 1;
        }
    }
    cout << ret << '\n';

    return 0;
}