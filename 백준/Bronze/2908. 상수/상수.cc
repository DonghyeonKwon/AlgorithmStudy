#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cin.tie(NULL);

    string a, b;
    int an, bn;
    cin >> a >> b;
    
    reverse(a.begin(), a.end());
    reverse(b.begin(), b.end());

    an = stoi(a);
    bn = stoi(b);

    cout << ((an < bn) ? bn : an) << '\n';

    return 0;
}