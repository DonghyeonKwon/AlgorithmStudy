#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, a, _max = -1000000, _min = 1000000;
    cin >> n;
    while(n){
        n--;
        cin >> a;
        _max = max(a, _max);
        _min = min(a, _min);
    }
    cout << _min << ' ' << _max << '\n';

    return 0;
}