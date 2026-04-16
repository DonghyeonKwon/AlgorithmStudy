#include <bits/stdc++.h>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    bool a[1000001] = {false,};
    a[1] = true;
    for(int i = 2; i <= 1000000; i++){
        if(a[i]) continue;
        for(int j = i * 2; j <= 1000000; j+=i){
            a[j] = true;
        }
    }

    int t;
    cin >> t;
    while(t--){
        int n, cnt = 0;
        cin >> n;
        if(n == 4){
            cout << 1 << '\n';
            continue;
        }
        for(int i = 3; i <= n/2; i++){
            if(!a[i] && !a[n-i]) cnt++;
        }

        cout << cnt << '\n';
    }

    return 0;
}