#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int t, n;
    string s;
    cin >> t;
    while(t){
        t--;
        cin >> n >> s;
        string ret = "";
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < n; j++){
                ret += s[i];
            }
        }
        cout << ret << '\n';
    }

    return 0;
}