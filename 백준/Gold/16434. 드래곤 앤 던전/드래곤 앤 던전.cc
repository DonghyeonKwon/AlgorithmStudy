#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
ll n, ha, H = 0, mx = 0, t, a, h, damage = 0;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);cout.tie(NULL);

    cin >> n >> ha;
    for(int i = 0; i < n; i++){
        cin >> t >> a >> h;
        if(t == 1){
            damage = a * (ceil((double)h/ha)-1);
            if(H < damage){
                mx += damage - H;
                H = 0;
            }
            else H -= damage;

            // cout << mx << ' ' << H << '\n';
        }
        else{
            H = min(mx, H + h);
            ha += a;
            // cout << mx << ' ' << H << '\n';
        }
    }
    cout << mx + 1 << '\n';

    return 0;
}