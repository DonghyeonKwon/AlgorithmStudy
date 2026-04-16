#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, m, cnt = 0;
    string s[10000];
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        cin >> s[i];
    }
    sort(s, s + n);
    for(int i = 0; i < m; i++){
        string str;
        cin >> str;
        if(binary_search(s, s+n, str)) cnt++;
    }
    cout << cnt << '\n';
    return 0;
}