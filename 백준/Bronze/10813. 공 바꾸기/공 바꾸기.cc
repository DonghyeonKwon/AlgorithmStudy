#include <bits/stdc++.h>
using namespace std;

int n, m, basket[101];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m;
    for(int i = 1; i <= n; i++){
        basket[i] = i;
    }
    for(int i = 0; i < m; i++){
        int a,b,c;
        cin >> a >> b;
        c = basket[a];
        basket[a] = basket[b];
        basket[b] = c;
    }

    for(int i = 1; i <= n; i++){
        cout << basket[i] << ' ';
    }
    cout << '\n';

    return 0;
}