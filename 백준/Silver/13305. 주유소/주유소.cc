#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int n;
int km[100000], node[100001];
bool flag = true;
ll ret = 0;

ll counting(int s, int e){
    ll sum = (ll)km[e] - (ll)km[s-1];
    return sum;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    for(int i = 0; i < n-1; i++) {
        cin >> km[i];
        if(i > 0) km[i] += km[i-1];
    }
    for(int i = 0; i < n; i++) {
        cin >> node[i];
        if(flag && node[i] != 1) flag = false;
    }

    if(flag){
        cout << km[n-2] << '\n';
        return 0;
    }

    int e = 0, s = 0;
    while(e < n-1){
        if(node[s] <= node[e + 1]){
            e++;
        }
        else{
            ll a = (e == 0) ? km[e] : counting(s, e);
            ret += (a * (ll)node[s]);
            // cout << s << ' ' << e << ' ' << ret << '\n';
            e++;
            s = e;
        }
    }
    if(s < n-1){
        ll a = km[e-1] - km[s-1];
        ret += (a * (ll)node[s]);
        // cout << s << ' ' << e << ' ' << ret << '\n';
    }

    cout << ret << '\n';

    return 0;
}