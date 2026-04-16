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
        int a, b;
        cin >> a >> b;
        while(a <= b){
            swap(basket[a], basket[b]);
            a++; b--;
        }
    }

    for(int i = 1; i <= n; i++){
        cout << basket[i] << ' ';
    }
    cout << '\n';

    return 0;
}