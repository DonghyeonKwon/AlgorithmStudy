#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, dasom, ret = 0;
    priority_queue<int> pq;
    cin >> n;
    cin >> dasom;
    if(n == 1){cout << 0 << '\n'; return 0;}
    for(int i = 1; i < n; i++){
        int a;
        cin >> a;
        pq.push(a);
    }
    while(pq.top() >= dasom){
        int a = pq.top();
        pq.pop();
        a--;
        ret++;
        dasom++;
        pq.push(a);
    }
    cout << ret << '\n';

    return 0;
}