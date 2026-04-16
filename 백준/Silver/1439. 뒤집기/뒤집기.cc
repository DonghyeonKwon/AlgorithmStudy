#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int ret = 0;
    string s;
    char _prev = s[0];
    cin >> s;
    for(char a : s){
        if(a != _prev){
            ret++;
            _prev = a;
        }
    }
    cout << ret/2 << '\n';

    return 0;
}