#include <bits/stdc++.h>

using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int t, n;

    cin >> t;

    for(int i = 0; i < t; i++){
        cin >> n;
        long long sum = 1;

        map<string, int> mp;
        vector<string> v;
        string name, b;
        
        for(int j = 0; j < n; j++){
            cin >> name >> b;
            mp[b]++;
            v.push_back(b);
        }

        sort(v.begin(), v.end());
        v.erase(unique(v.begin(), v.end()), v.end());

        for(string s : v){
            sum *= (long long)(mp[s] + 1);
        }

        sum--;

        cout << sum << '\n';
    }

    return 0;
}