#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, x;
    vector<int> v;
    cin >> n >> x;
    for(int i = 0; i < n; i++){
        int a;
        cin >> a;
        if(a < x) v.push_back(a);
    }

    for(int i : v)
        cout << i << ' ';
    cout << '\n';

    return 0;
}