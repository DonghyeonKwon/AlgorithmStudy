#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

bool is_prime(ll a){
    if(a <= 1) return false;
    else if(a <= 3) return true;
    else if(a % 2 == 0 || a % 3 == 0) return false;
    for(int i = 2; i <= sqrt(a); i++){
        if(a % i == 0) return false;
    }
    return true;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    ll t;
    cin >> t;
    vector<ll> v;
    for(int i = 0; i < t; i++){
        ll a;
        cin >> a;
        while(!is_prime(a)){
            a++;
        }
        cout << a << '\n';
    }

    return 0;
}