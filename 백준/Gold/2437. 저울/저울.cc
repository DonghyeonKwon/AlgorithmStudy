#include <bits/stdc++.h>
using namespace std;
vector<int> v;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n;
    cin >> n;
    for(int i = 0; i < n; i++){
        int a;
        cin >> a;
        v.push_back(a);
    }

    sort(v.begin(), v.end());

    int ret = 1;
    for(int i = 0; i < v.size(); i++){
        if(ret < v[i]) break;
        ret += v[i];
    }
    cout << ret << '\n';

    return 0;
}