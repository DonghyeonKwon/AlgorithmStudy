#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    int a, b, cnt = 1;
    cin >> a >> b;
    for(int i = 1; i <= a; i++){
        if(a % i == 0){
            if(b == cnt) {
                cout << i << '\n';
                return 0;
            }
            else cnt++;
        }
    }
    cout << 0 << '\n';
    return 0;
}