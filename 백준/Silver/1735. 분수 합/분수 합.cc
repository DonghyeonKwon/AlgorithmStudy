#include <bits/stdc++.h>
using namespace std;

int gcd(int a, int b){
    int r;
    while(a != 0){
        r = b % a;
        b = a;
        a = r;
    }
    return b;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int a[2], b[2];
    for(int i = 0; i < 2; i++){
        cin >> a[i] >> b[i];
    }
    
    int m = b[0] * b[1];
    int j = a[0] * b[1] + a[1] * b[0];
    int c = gcd(m, j);

    m /= c;
    j /= c;

    cout << j << ' ' << m << '\n';

    return 0;
}