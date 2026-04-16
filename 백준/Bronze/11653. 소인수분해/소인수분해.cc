#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    int n, i = 2;
    cin >> n;
    if(n == 1) return 0;
    while(n){
        if(n % i == 0){
            cout << i << '\n';
            n /= i;
            if(n == 1) break;
        }
        else i++;
    }
    return 0;
}