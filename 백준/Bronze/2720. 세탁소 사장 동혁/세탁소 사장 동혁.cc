#include <bits/stdc++.h>
using namespace std;

const int dx[] = {25, 10, 5, 1};

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int t, c, q, d, m, p;
    cin >> t;
    for(int i = 0; i < t; i++){
        cin >> c;
        q = d = m = p = 0;

        if(c/25){
            q += (c/25);
            c %= 25;
        }
        if(c/10){
            d += (c/10);
            c %= 10;
        }
        if(c/5){
            m += (c/5);
            c %= 5;
        }
        if(c/1){
            p = c;
        }

        cout << q << ' ' << d << ' ' << m << ' ' << p << '\n';
    }

    return 0;
}