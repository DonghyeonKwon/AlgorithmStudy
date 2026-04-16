#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n;
    cin >> n;
    while(n){
        n--;
        string s;
        cin >> s;
        cout << s.front() << s.back() << '\n';
    }

    return 0;
}