#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, sum = 0;
    cin >> n;
    pair<int, int> p[n];
    for(int i = 0; i < n; i++){
        cin >> p[i].first >> p[i].second;
    }
    sort(p, p + n);
    priority_queue<int, vector<int>, greater<>> pq;
    for(int i = 0; i < n; i++){
        sum += p[i].second;
        pq.push(p[i].second);
        if(pq.size() > p[i].first){
            sum -= pq.top();
            pq.pop();
        }
    }

    cout << sum << '\n';

    return 0;
}