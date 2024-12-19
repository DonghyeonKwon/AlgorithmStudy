#include <bits/stdc++.h>
using namespace std;
const int INF = 987654321;
int n, k;
int a[101], cost[10001];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> k;
    for(int i = 1; i <= n; i++) cin >> a[i];

    fill(cost, cost + 10001, INF);
    cost[0] = 0;
   
    for(int i = 1; i <= n; i++){
        if(a[i] > k) continue;
        for(int j = a[i]; j <= k; j++){
            cost[j] = min(cost[j], cost[j - a[i]] + 1);
        }
    }

    cout << ((cost[k] == INF) ? -1 : cost[k]) << '\n';

    return 0;
}