#include <bits/stdc++.h>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n;
    cin >> n;
    int a[n];
    for(int i = 0; i < n; i++){
        cin >> a[i];
    }

    sort(a, a+n);

    int sum = 0, ret = 0;
    for(int i = 0; i < n; i++){
        sum += a[i];
        ret += sum;
    }

    cout << ret << '\n';

    return 0;
}