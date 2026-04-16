#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, k;
    vector<int> a, v;
    cin >> n >> k;
    for(int i = 0; i < n; i++){
        int input;
        cin >> input;
        a.push_back(input);
    }

    sort(a.begin(), a.end());

    for(int i = 1; i < n; i++){
        v.push_back(a[i] - a[i-1]);
    }
    
    sort(v.begin(), v.end());

    long long sum = 0;
    for(int i = 0; i < n - k; i++){
        sum += (long long)v[i];
    }

    cout << sum << '\n';

    return 0;
}