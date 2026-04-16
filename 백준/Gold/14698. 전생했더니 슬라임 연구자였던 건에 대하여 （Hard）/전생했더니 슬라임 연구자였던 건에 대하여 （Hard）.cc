#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;
typedef long long ll;

const ll mod = 1000000007;
ll t, n, ret = 1;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> t;
    while(t--){
        cin >> n;
        priority_queue<ll, vector<ll>, greater<ll>> pq;
        for(ll i = 0; i < n; i++){
            ll a;
            cin >> a;
            pq.push(a);
        }
        
        if(pq.size() == 1){
            cout << 1 << '\n';
            continue;
        }
        ret = 1;
        while(!(pq.size() == 1)){
            ll a = pq.top(); pq.pop();
            ll b = pq.top(); pq.pop();
            ret *= (((a % mod) * (b % mod)) % mod);
            pq.push(a * b);
            ret %= mod;
        }

        cout << ret << '\n';
    }

    return 0;
}