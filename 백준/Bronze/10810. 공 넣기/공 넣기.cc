#include <bits/stdc++.h>
using namespace std;

int n, m, basket[101] = {0, };

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m;
    for(int i = 0; i < m; i++){
        int a,b,c;
        cin >> a >> b >> c;
        while(b != a){
            basket[a] = c;
            a++;
        }
        basket[b] = c;
    }

    for(int i = 1; i <= n; i++){
        cout << basket[i] << ' ';
    }
    cout << '\n';

    return 0;
}