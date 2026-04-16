#include <bits/stdc++.h>
using namespace std;

int n, m;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m;

    if(n == 1) cout << 1 << '\n';
    else if(n == 2) cout << min(4, (m+1) / 2) << '\n';
    else if(m < 7) cout << min(4, m) << '\n';
    else cout << m - 2 << '\n';

    return 0;
}