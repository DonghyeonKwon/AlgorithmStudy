#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

typedef long long ll;
ll n, sum = 0;
vector<pair<ll, ll>> X;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for(int i = 0; i < n; i++){
        ll a, b;
        cin >> a >> b;
        X.push_back({a, b});
        sum += b;
    }
    sort(X.begin(), X.end());

    ll cur = 0;
    for(int i = 0; i < n; i++){
        cur += X[i].second;
        if(cur >= (sum + 1) /2){
            cout << X[i].first << '\n';
            break;
        }
    }

    return 0;
}