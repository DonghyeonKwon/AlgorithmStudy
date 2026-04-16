#include <bits/stdc++.h>
using namespace std;

typedef unsigned long long ull;
ull n, m, arr[1000];
ull sum = 0;
priority_queue<ull, vector<ull>, greater<>> pq;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m;
    for(int i = 0; i < n; i++){
        cin >> arr[i];
        sum += (long long)arr[i];
        pq.push(arr[i]);
    }

    while(m--){
        ull a = pq.top();
        pq.pop();
        ull b = pq.top();
        pq.pop();
        sum += (a+b);
        pq.push(a+b);
        pq.push(a+b);
    }
    
    cout << sum << '\n';

    return 0;
}