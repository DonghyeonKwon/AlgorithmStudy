#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int a, b, c, n;
    cin >> a >> b >> c >> n;
    
    for(int i = n; i <= 100; i++){
        if(a*i + b > c*i){
            cout << 0 << '\n';
            return 0;
        }
    }

    cout << 1 << '\n';

    return 0;
}