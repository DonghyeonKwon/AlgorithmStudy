#include <bits/stdc++.h>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int a, b, c, d, e, f;
    cin >> a >> b >> c >> d >> e >> f;

    //ax + by = c;
    //dx + ey = f;
    int x, y;
    for(x = -999; x <= 999; x++){
        for(y = -999; y <= 999; y++){
            if((a*x + b*y == c)&&(d*x + e*y == f)) {
                cout << x << ' ' << y << '\n';
            }
        }
    }

    return 0;
}