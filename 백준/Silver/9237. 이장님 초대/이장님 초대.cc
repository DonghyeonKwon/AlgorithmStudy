#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, cnt = 1, _mx = 0;
    vector<int> tree;
    cin >> n;
    for(int i = 0; i < n; i++){
        int a;
        cin >> a;
        tree.push_back(a);
    }
    sort(tree.begin(), tree.end(), greater<>());
    for(int it : tree){
        if(_mx < it + cnt) _mx = it + cnt;
        cnt++;
    }
    cout << _mx + 1 << '\n';

    return 0;
}