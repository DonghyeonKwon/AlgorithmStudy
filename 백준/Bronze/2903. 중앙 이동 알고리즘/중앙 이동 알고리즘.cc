#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, a = 2;
    cin >> n;
    for(int i = 1; i <= n; i++){
        a += a-1;
    }

    cout << a*a << '\n';
    
    return 0;
}