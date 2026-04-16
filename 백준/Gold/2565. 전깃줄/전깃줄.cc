#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, len = 0; 
    cin >> n;
    pair<int, int> p[n];
    int lis[n];
    for(int i = 0; i < n; i++) cin >> p[i].first >> p[i].second;
    fill(lis, lis + n, -1);
    sort(p, p + n);
    for(int i = 0; i < n; i++){
        auto it = lower_bound(lis, lis + len, p[i].second);
        if(*it == -1) len++;
        *it = p[i].second;
    }
    cout << n - len << '\n';

    return 0;
}