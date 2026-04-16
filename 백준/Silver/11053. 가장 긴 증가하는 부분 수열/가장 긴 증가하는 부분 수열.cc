#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, len = 0, b;
    cin >> n;
    int a[n];
    fill(a, a+n, -1);
    for(int i = 0; i < n; i++){
        cin >> b;
        auto lower = lower_bound(a, a + len, b);
        if(*lower == -1) len++;
        *lower = b;
    }
    cout << len << '\n';

    return 0;
}