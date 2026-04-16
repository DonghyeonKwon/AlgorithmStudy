#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int sum = 0, a[5];
    for(int i = 0; i < 5; i++){
        cin >> a[i];
        sum += a[i];
    }

    sort(a, a + 5);
    cout << sum/5 << '\n' << a[2] << '\n';

    return 0;
}