#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9 + 1;
int main(){
    ios_base::sync_with_stdio(false);
    cout.tie(NULL); cin.tie(NULL);

    int n, len = 0, k;
    cin >> n;
    int a[n];
    pair<int, int> p[n];
    stack<pair<int, int>> s;
    fill(a, a+n, INF);
    for(int i = 0; i < n; i++){
        cin >> k;
        auto lowerNum = lower_bound(a, a + len, k);
        int pos = (int)(lower_bound(a, a + len, k) - a);
        if(*lowerNum == INF) len++;
        *lowerNum = k;
        p[i].first = pos;
        p[i].second = k;
    }
    cout << len << '\n';
    for(int i = n - 1; i >= 0; i--){
        if(p[i].first == len - 1){
            s.push(p[i]);
            len--;
        }
    }
    while(s.size()){
        cout << s.top().second << ' ';
        s.pop();
    }
    cout << '\n';
    return 0;
}