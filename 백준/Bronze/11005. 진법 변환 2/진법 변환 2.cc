#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, b;
    cin >> n >> b;
    string ret = "";

    while(n != 0){
        int a = n % b;
        if(a < 10){
            ret += '0' + a;
        }
        else{
            ret += a - 10 + 'A';
        }
        n /= b;
    }
    reverse(ret.begin(), ret.end());
    cout << ret << '\n';

    return 0;
}