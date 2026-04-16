#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int t;
    cin >> t;
    while(t--){
        vector<int> v, res;
        int n;
        cin >> n;
        for(int i = 0; i < n; i++){
            int a;
            cin >> a;
            v.push_back(a);
        }

        sort(v.begin(), v.end());
        int idx = v.size() - 1;
        res.push_back(abs(v[idx] - v[idx - 1]));
        for(int i = idx; i > 1; i--){
            res.push_back(abs(v[i] - v[i-2]));
        }
        res.push_back(abs(v[1] - v[0]));
        sort(res.begin(), res.end());
        cout << res.back() << '\n';
    }

    return 0;
}