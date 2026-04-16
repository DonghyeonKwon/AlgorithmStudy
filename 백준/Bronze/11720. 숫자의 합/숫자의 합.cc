#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, sum = 0;
    string s;

    cin >> n;
    cin >> s;

    for(int i = 0; i < n; i++){
        sum += s[i] - '0';
    }
    cout << sum << '\n';

    return 0;
}