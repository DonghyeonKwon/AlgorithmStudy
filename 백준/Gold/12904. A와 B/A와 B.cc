#include <bits/stdc++.h>
using namespace std;
string s, t;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> s >> t;
    while(s.size() != t.size()){
        char c = t.back();
        if(c == 'A'){
            t.pop_back();
        }
        else{
            t.pop_back();
            reverse(t.begin(), t.end());
        }
    }
    cout << (s == t ? 1 : 0) << '\n';

    return 0;
}