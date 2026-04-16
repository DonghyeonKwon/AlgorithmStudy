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
    sort(a, a+n, greater());
    int _max = 0;
    for(int i = 0; i < n; i++){
        if(_max < a[i] * (i+1)){
            _max = a[i] * (i+1);
        }
    }
    cout << _max << '\n';

    return 0;
}