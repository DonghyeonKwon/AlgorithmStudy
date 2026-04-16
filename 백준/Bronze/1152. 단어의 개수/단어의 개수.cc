#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    string s;
    getline(cin, s);

    int cnt = 1;
    if(s.front() == ' ') cnt--;
    if(s.back() == ' ') cnt--;

    for(int i = 0; i < s.length(); i++){
        if(s[i] == ' ') cnt++;
    }

    cout << cnt << '\n';

    return 0;
}