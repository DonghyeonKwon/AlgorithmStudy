#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    vector<pair<int, int>> vp(n, pair<int, int>());
    for(int i = 0; i < n; i++){
        cin >> vp[i].first >> vp[i].second;
    }
    sort(vp.begin(), vp.end());
    priority_queue<int, vector<int>, greater<>> pq;

    pq.push(vp[0].second);
    for(int i = 1; i < n; i++){
        if(pq.top() <= vp[i].first) pq.pop();
        pq.push(vp[i].second);
    }
    cout << (int)pq.size() << '\n';

    return 0;
}