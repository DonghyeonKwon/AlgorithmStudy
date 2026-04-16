#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    pair<int, int> p[46];
    cin >> n;

    p[0] = {1, 0};
    for(int i = 1; i <= n; i++){
        p[i] = {p[i-1].second, p[i-1].second + p[i-1].first};
    }

    cout << p[n].first << ' ' << p[n].second << '\n';

    return 0;
}