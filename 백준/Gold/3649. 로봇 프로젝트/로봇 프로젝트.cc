#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

typedef long long ll;

ll x, n;

bool comp(pair<ll, ll> a, pair<ll, ll> b){
    return (abs(a.first - a.second) > abs(b.first - b.second));
}

int main(){
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    while(cin >> x >> n){
        x *= 10000000;
        vector<ll> block(n, 0);
        vector<pair<ll, ll>> vp;
        for(int i = 0; i < n; i++){
            cin >> block[i];
        }
        sort(block.begin(), block.end());

        ll lo = 0, hi = n - 1;
        while(lo < hi){
            ll sum = block[lo] + block[hi];
            if(sum < x){
                lo++;
            }
            else if(sum > x){
                hi--;
            }
            else{
                vp.push_back({block[lo], block[hi]});
                lo++;
                hi--;
            }
        }

        if(vp.size() == 0){
            cout << "danger\n";
           
        }
        else{
            if(vp.size() > 1) sort(vp.begin(), vp.end(), comp);
            cout << "yes " << vp.front().first << ' ' << vp.front().second << '\n';
        }
    }

    return 0;
}