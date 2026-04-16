#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
ll n;
vector<ll> v;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    ll t;
    cin >> t;
    while(t--){
        cin >> n;
        v.clear();
        for(ll i = 0; i < n; i++){
            ll a;
            cin >> a;
            v.push_back(a);
        }
        ll sum = 0, _mx = 0;
        for(ll i = n-1; i >= 0; i--){
            if(_mx < v[i]) _mx = v[i];
            else{
                sum += (_mx - v[i]);
            }
        }
        cout << sum << '\n';
    }

    return 0;
}