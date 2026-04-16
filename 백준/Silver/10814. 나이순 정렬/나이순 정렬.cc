#include <bits/stdc++.h>
using namespace std;

bool comp(pair<int, int> a, pair<int, int> b){
    if(a.first == b.first){
        return (a.second < b.second);
    }
    return (a.first < b.first);
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    string s[100000];
    vector<pair<int, int>> vp;
    int n, i, a;
    cin >> n;
    for(i = 0; i < n; i++){
        cin >> a >> s[i];
        vp.push_back({a, i});
    }
    sort(vp.begin(), vp.end(), comp);
    for(auto i : vp){
        cout << i.first << ' ' << s[i.second] << '\n';
    }

    return 0;
}