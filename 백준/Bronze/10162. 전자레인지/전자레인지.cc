#include <bits/stdc++.h>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int t, a[3] = {300, 60, 10}, b[3];
    cin >> t;

    if(t % 10 > 0){
        cout << -1 << '\n';
        return 0;
    }

    for(int i = 0; i < 3; i++){
        b[i] = t / a[i];
        t %= a[i];
    }
        
    cout << b[0] << ' ' << b[1] << ' ' << b[2] << '\n';

    return 0;
}