#include <iostream>
#include <climits>
#include <algorithm>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, _mn = INT_MAX, _mx = 1;
    cin >> n;
    while(n--){
        int a;
        cin >> a;
        _mn = min(_mn, a);
        _mx = max(_mx, a);
    }
    cout << _mn * _mx << '\n';

    return 0;
}