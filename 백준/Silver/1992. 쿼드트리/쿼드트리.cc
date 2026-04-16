#include <bits/stdc++.h>

using namespace std;

int n;
vector<string> v;

string go(int size, int y, int x){
    if(size == 1) {
        return string(1, v[y][x]);
    }

    string ret = "";
    char b = v[y][x];

    for(int i = y; i < y + size; i++){
        for(int j = x; j < x + size; j++){
            if(b != v[i][j]){
                ret = "(";
                ret += go(size/2, y, x);
                ret += go(size/2, y, x + size / 2);
                ret += go(size/2, y + size / 2, x);
                ret += go(size/2, y + size / 2, x + size / 2);
                return (ret + ")");
            }
        }
    }
    
    return string(1, v[y][x]);
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    for(int i = 0; i < n; i++){
        string s;
        cin >> s;
        v.push_back(s);
    }

    string res = go(n, 0, 0);
    cout << res << '\n';

    return 0;
}