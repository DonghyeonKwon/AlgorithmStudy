#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    vector<int> v;
    cin >> n;
    for(int i = 0; i < n; i++){
        int a;
        cin >> a;
        v.push_back(a);
    }
    vector<int> ret(n, 0);
    int _mx = -1;
    for(int i = 0; i < n; i++){
        for(int j = i + 1; j < n; j++){
            if(v[i] < v[j]) break;
            ret[i]++;
        }
        if(_mx < ret[i]) _mx = ret[i];
    }

    cout << _mx << '\n';

    return 0;
}