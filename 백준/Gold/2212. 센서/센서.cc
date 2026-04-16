#include <bits/stdc++.h>
using namespace std;

int n, k, ret = 0;
vector<int> v, s;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> k;
    for(int i = 0; i < n; i++){
        int a;
        cin >> a;
        v.push_back(a);
    }
    sort(v.begin(), v.end());
    for(int i = 0; i < n-1; i++){
        if(v[i+1] == v[i]) continue;
        s.push_back(v[i+1] - v[i]);
    }
    sort(s.begin(), s.end());
    for(int i = 0; i < (int)s.size() + 1 - k; i++){
        ret += s[i];
    }
    cout << ret << '\n';

    return 0;
}