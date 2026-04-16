#include <bits/stdc++.h>
using namespace std;

int t, n, m;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> t;
    while(t--){
        cin >> n >> m;
        int a[n], b[m];
        for(int i = 0; i < n; i++) cin >> a[i];
        for(int i = 0; i < m; i++) {
            cin >> b[i];
        }
        sort(a, a + n);
        sort(b, b + m);

        int sum = 0;
        for(int i = 0; i < n; i++){
            auto pos = lower_bound(b, b+m, a[i]);
            sum += (int)(pos - b);
        }
        cout << sum << '\n';
    }

    return 0;
}