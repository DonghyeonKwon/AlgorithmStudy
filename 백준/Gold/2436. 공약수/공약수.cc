#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;
typedef long long ll;

int getGCD(int a, int b){
    if(b == 0) return a;
    return getGCD(b, a%b);
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    ll g, l, rA, rB;
    cin >> g >> l;

    ll div = l / g;
    for(int i = 1; i <= sqrt(div); i++){
        if(div % i == 0){
            ll a = i, b = div / i;

            if(getGCD(a,b) == 1){
                rA = a;
                rB = b;
            }
        }
    }
    cout << g * rA << ' ' << g * rB << '\n';

    return 0;
}