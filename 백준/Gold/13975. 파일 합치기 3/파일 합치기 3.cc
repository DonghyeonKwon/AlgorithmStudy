#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;
typedef long long ll;

ll t, k;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> t;
    while(t--){
        cin >> k;
        priority_queue<ll, vector<ll>, greater<ll>> pq;
        for(ll i = 0; i < k; i++){
            ll a;
            cin >> a;
            pq.push(a);
        }

        ll sum = 0;
        while(pq.size() > 1){
            ll a =  pq.top();
            pq.pop();

            ll b = pq.top();
            pq.pop();

            sum += (a + b);
            pq.push(a + b);
        }
        
        cout << sum << '\n';
    }

    return 0;
}