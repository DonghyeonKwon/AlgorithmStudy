#include <bits/stdc++.h>
using namespace std;
long long cnt = 0;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    long long n;
    cin >> n;
    
    if(n < 3) cout << 0 << '\n';
    else cout << (n * (n-1) * (n-2)) / 6 << '\n';
    cout << 3 << '\n';

    return 0;
}