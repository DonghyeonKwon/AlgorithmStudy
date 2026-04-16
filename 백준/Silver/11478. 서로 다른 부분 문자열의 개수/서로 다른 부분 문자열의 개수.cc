#include <bits/stdc++.h>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int cnt = 0;
    string s;
    vector<string> v;

    cin >> s;

    int len_i = s.length();
    int len_j = s.length();

    for(int i = 1; i <= len_i; i++){
        for(int j = 0; j < len_j; j++){
            v.push_back(s.substr(j, i));
        }
        sort(v.begin(), v.end());
        v.erase(unique(v.begin(), v.end()), v.end());
        cnt += v.size();
        v.clear();
        len_j--;
    }

    cout << cnt << '\n';

    return 0;
}