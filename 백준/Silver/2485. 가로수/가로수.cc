#include <bits/stdc++.h>
using namespace std;
int n;

int gcdNum(int a, int b){
    int r;
    if(a < b){
        swap(a,b);
    }
    while(b != 0){
        r = a % b;
        a = b;
        b = r;
    }
    return a;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    int a[n], _min;
    for(int i = 0; i < n; i++){
        cin >> a[i];
    }
    _min = a[1] - a[0];
    for(int i = 2; i < n; i++){
        _min = min(_min, gcdNum(a[i]- a[i-1], _min));
    }
    long long ret = 0;
    for(int i = 1; i < n; i++){
        ret += ((a[i] - a[i-1] - 1)/_min);
    }
    cout << ret << '\n';

    return 0;
}