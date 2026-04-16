#include <bits/stdc++.h>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, m;
    cin >> n >> m;
    string a[n];
    vector<string> v;
    for(int i = 0; i < n; i++){
        cin >> a[i];
    }
    sort(a, a+n);
    for(int i = 0; i < m; i++){
        string s;
        cin >> s;
        if(binary_search(a, a + n, s)) v.push_back(s);
    }
    sort(v.begin(), v.end());
    cout << v.size() << '\n';
    for(string i : v){
        cout << i << '\n';
    }

    return 0;
}