#include <bits/stdc++.h>
using namespace std;

int n, a, sum = 0, _max = -1001;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    for(int i = 1; i <= n; i++){
        cin >> a;
        sum += a;
        _max = max(_max, sum);
        if(sum < 0) sum = 0;
    }

    cout << _max << '\n';

    return 0;
}