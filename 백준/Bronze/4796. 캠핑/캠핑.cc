#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int cnt = 1;
    while(1){
        int a, b, c;
        cin >> a >> b >> c;
        if(a == 0 && b == 0 && c == 0) break;
        int t = c / b, k = c % b;
        if(k >= a) k = a;
        cout << "Case " << cnt++ << ": " << (a*t) + k << '\n';
    }

    return 0;
}