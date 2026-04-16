#include <bits/stdc++.h>
using namespace std;

int a[26] = { 0, };

int main(){
    ios_base::sync_with_stdio(false);
    cout.tie(NULL); cin.tie(NULL);

    string s;
    cin >> s;
    for(int i = 0; i < s.size(); i++){
        if(a[s[i] - 'a'] == 0){
            a[s[i] - 'a'] = i+1;
        }
    }

    for(int i : a){
        cout << i-1 << ' ';
    }
    cout << '\n';

    return 0;
}