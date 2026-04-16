#include <bits/stdc++.h>
using namespace std;

int _x1, _y1, _x2, _y2, _r1, _r2;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int t;
    cin >> t;
    while(t--){
        cin >> _x1 >> _y1 >> _r1 >> _x2 >> _y2 >> _r2;
        if(_x1 == _x2 && _y1 == _y2 && _r1 == _r2){
            cout << -1 << '\n';
            continue;
        }
        //원점간의 거리
        int d = ((_x1 - _x2) * (_x1 - _x2)) + ((_y1 - _y2) * (_y1 - _y2));
        int _c1 = (_r1 - _r2) * (_r1 - _r2);
        int _c2 = (_r1 + _r2) * (_r1 + _r2);
        if(_c1 == d || _c2 == d) cout << 1 << '\n';
        else if(_c1 < d && d < _c2) cout << 2 << '\n';
        else cout << 0 << '\n';
    }

    return 0;
}