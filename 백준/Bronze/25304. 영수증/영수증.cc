#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int x, n, a, b;
    cin >> x;
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> a >> b;
        x -= (a * b);
    }
    if(x == 0) cout << "Yes\n";
    else cout << "No\n";

    return 0;
}