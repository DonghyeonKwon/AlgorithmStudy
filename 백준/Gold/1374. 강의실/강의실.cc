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
    vector<pair<int, int>> cls(n+1);
    vector<int> room;
    for(int i = 0; i < n; i++){
        int a, b, c;
        cin >> a >> b >> c;
        cls[a] = {b, c};
    }

    sort(cls.begin() + 1, cls.end());
    
    priority_queue<int, vector<int>, greater<>> pq;
    pq.push(cls[1].second);
    for(int i = 2; i <= n; i++){
        if(pq.top() <= cls[i].first){
            pq.pop();
        }
        pq.push(cls[i].second);
    }

    cout << (int)pq.size() << '\n';

    return 0;
}