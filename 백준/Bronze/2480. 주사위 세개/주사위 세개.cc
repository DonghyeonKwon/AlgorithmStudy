#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int a, b, c;
    cin >> a >> b >> c;

    if(a == b && b == c && c == a){
        cout << 10000 + a * 1000 << '\n';
    }
    else if(a != b && b != c && c != a){
        int temp = 0;
        temp = max(a, b);
        temp = max(temp, c);
        cout << 100 * temp << '\n';
    }
    else{
        if(a == b){
            cout << 1000 + 100 * a << '\n';
        }
        else if(b == c){
            cout << 1000 + 100 * b << '\n';
        }
        else if(a == c){
            cout << 1000 + 100 * a << '\n';
        }
    }

    return 0;
}