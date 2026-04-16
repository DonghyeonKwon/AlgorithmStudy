#include <bits/stdc++.h>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, cnt = 0;
    cin >> n;
    n = 1000 - n;

    if(n/500 != 0){
        cnt += n/500;
        n %= 500;
    }
    if(n/100 != 0){
        cnt += n/100;
        n %= 100;
    }
    if(n/50 != 0){
        cnt += n/50;
        n %= 50;
    }
    if(n/10 != 0){
        cnt += n/10;
        n %= 10;
    }
    if(n/5 != 0){
        cnt += n/5;
        n %= 5;
    }
    if(n/1 != 0){
        cnt += n;
    }
    cout << cnt << '\n';

    return 0;
}