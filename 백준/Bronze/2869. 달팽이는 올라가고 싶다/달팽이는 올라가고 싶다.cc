#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int a, s = 0, b, v, cnt = 1;

    cin >> a >> b >> v;
    s = a;
    if(v <= s) {
        cout << cnt << '\n';
        return 0;
    }
    v = v - a;
    a = a - b;
    cnt += (v/a);
    if(v%a > 0) cnt++;

    cout << cnt << '\n';

    return 0;
}