#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

ll n, k, a, b, ret = 0;
vector<pair<ll, ll>> vp;
vector<ll> bag;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> k;

    for(int i = 0; i < n; i++){
        cin >> a >> b;
        vp.push_back({a, b});
    }

    for(int i = 0; i < k; i++){
        cin >> a;
        bag.push_back(a);
    }

    sort(vp.begin(), vp.end());
    sort(bag.begin(), bag.end());
    priority_queue<ll> pq;

    int j = 0;
    for(int i = 0; i < k; i++){
        while(j < n && vp[j].first <= bag[i]) pq.push(vp[j++].second);
        if(pq.size()){
            ret += pq.top();
            pq.pop();
        }
    }
    cout << ret << '\n';
    return 0;
}