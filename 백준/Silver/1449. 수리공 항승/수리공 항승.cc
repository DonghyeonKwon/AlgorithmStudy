#include <bits/stdc++.h>
using namespace std;

int n, l, a[1001], e, cnt;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> l;
    for(int i = 0; i < n; i++){
        cin >> a[i];
    }
    sort(a, a + n);

    e = a[0] - 1 + l;
    cnt = 1;
    for(int i = 1; i < n; i++){
        if(e >= a[i]) continue;
        e = a[i] - 1 + l;
        cnt++;
    }
    cout << cnt << '\n';

    return 0;
}