#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

bool num[1000001];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    ll _mn, _mx, sum = 0;
    cin >> _mn >> _mx;

    fill(num, num + 1000001, false);
    for(ll i = 2; i*i <= _mx; i++){
        ll n = _mn / (i * i);

        if(_mn % (i * i)) n++;

        while(n * i * i <= _mx){
            num[n * i * i - _mn] = true;
            n++;
        }
    }
    for(int i = 0; i <= _mx - _mn; i++){
        if(!num[i]) sum++;
    }
    cout << sum << '\n';

    return 0;
}