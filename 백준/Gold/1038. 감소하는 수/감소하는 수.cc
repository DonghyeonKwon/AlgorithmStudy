#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
typedef long long ll;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    vector<ll> v;
    queue<ll> q;
    cin >> n;

    for(int i = 0; i <= 9; i++){
        v.push_back(i);
        q.push(i);
    }

    while(q.size()){
        ll num = q.front();
        ll last = num % 10;
        q.pop();
        for(int i = 0; i < last; i++){
            ll new_num = num * 10 + i;
            v.push_back(new_num);
            q.push(new_num);
        }
    }

    if(n >= v.size()) cout << -1 << '\n';
    else cout << v[n] << '\n';

    return 0;
}