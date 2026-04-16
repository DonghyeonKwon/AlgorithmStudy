#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    ll sum = 0, n;
    vector<ll> v;
    cin >> n;
    for(ll i = 0; i < n; i++){
        ll input;
        cin >> input;
        v.push_back(input);
    }

    sort(v.begin(), v.end(), greater<>());
    for(int i = 0; i < n; i++){
        if(v[i] - i <= 0) break;
        sum += (v[i] - i);
    }
    cout << sum << '\n';

    return 0;
}