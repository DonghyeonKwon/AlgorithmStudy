#include <bits/stdc++.h>
using namespace std;

vector<int> v1, v2;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, a;
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> a;
        v1.push_back(a);
        v2.push_back(a);
    }

    sort(v1.begin(),v1.end());
    v1.erase(unique(v1.begin(), v1.end()), v1.end());

    for(int i = 0; i < n; i++){
        cout << lower_bound(v1.begin(),v1.end(),v2[i]) - v1.begin()<< ' ';
    }
    cout << '\n';

    return 0;
}