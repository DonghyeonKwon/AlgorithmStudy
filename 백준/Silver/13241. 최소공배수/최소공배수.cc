#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    ll a, b, ret;
    cin >> a >> b;

    ret = (a*b) / gcd(a,b);
    cout << ret << '\n';

    return 0;
}