#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, len = 0, input;
    cin >> n;
    int a[n];
    memset(a, 0, sizeof(a));
    for(int i = 0; i < n; i++){
        cin >> input;
        auto pos = lower_bound(a, a+len, input);
        if(*pos == 0) len++;
        *pos = input;
    }
    cout << len << '\n';

    return 0;
}