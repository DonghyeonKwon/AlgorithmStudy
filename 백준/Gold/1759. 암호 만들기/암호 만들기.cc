#include <bits/stdc++.h>
using namespace std;

int l, c;
vector<char> v;
bool flag = false;

bool check(char c){
    return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
}

void go(int idx, string ret){
    if(ret.size() == l){
        int cnt = 0, cnt2 = 0;
        for(char c : ret){
            if(check(c)) cnt++;
            else cnt2++;
        }
        if(cnt == 0 || cnt2 < 2) return;
        cout << ret << '\n';
        return;
    }
    

    string temp = ret;
    for(int i = idx; i < c; i++){
        ret += v[i];
        go(i + 1, ret);
        ret = temp;
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> l >> c;
    for(int i = 0; i < c; i++){
        char a;
        cin >> a;
        v.push_back(a);
    }
    sort(v.begin(), v.end());

    go(0, "");

    return 0;
}