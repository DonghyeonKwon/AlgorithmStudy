#include <bits/stdc++.h>
using namespace std;

int n;

bool check(int a){
    int temp = a, buf[3], k = 100;
    for(int i = 0; i < 3; i++){
        buf[i] = temp / k;
        temp %= k;
        k /= 10;
    }
    return ((buf[1] - buf[0]) == (buf[2] - buf[1]));
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;

    if(n < 111 && n >= 100){
        cout << 99 << '\n';
        return 0;
    }
    else if(n <= 99){
        cout << n << '\n';
        return 0;
    }
    else if(n == 1000){
        n = 999;
    }

    int cnt = 99;
    for(int i = 111; i <= n; i++){
        if(check(i)) cnt++;
    }
    cout << cnt << '\n';

    return 0;
}