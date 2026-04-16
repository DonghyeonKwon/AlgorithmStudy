#include <bits/stdc++.h>

using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int t, n;
    cin >> t;
    for(int i = 0; i < t; i++){
        cin >> n;
        int a = 5;
        int cnt = 0;
        while(a <= n){
            int b = n / a;
            cnt += b;
            a *= 5;
        }
        cout << cnt << '\n';
    }

    return 0;
}