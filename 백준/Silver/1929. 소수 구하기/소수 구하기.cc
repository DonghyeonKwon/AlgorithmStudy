#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int m, n;
    cin >> m >> n;
    bool a[1000001] = {false, };

    a[1] = true;
    for(int i = 2; i <= n; i++){
        if(a[i]) continue;
        for(int j = i*2; j <= n; j += i){
            a[j] = true;
        }
    }

    for(int i = m; i <= n; i++){
        if(!a[i]) cout << i << '\n';
    }

    return 0;
}