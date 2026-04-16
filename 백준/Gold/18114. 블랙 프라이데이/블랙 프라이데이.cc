#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
typedef long long ll;

ll n, c;
vector<ll> v;
bool flag = false;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> c;
    for(int i = 0; i < n; i++){
        ll a;
        cin >> a;
        v.push_back(a);
        if(a == c) flag = true;
    }

    if(!flag){
        sort(v.begin(), v.end());
        
        for(int i = 0; i < n -2; i++){
            int s = i + 1, e = n-1;
            while(v[i] < c && s < e){
                if(v[i] + v[s] + v[e] == c){
                    flag = true;
                    break;
                }
                
                if(v[i] + v[s] + v[e] > c) e--;
                else s++;
            }
            if(flag) break;
        }

        if(!flag){
            for(int i = 0; i < n -1; i++) {
                for(int j = i + 1; j < n; j++) {
                    if(v[i] + v[j] == c) {
                        flag = true; break;
                    }
                }
                if(flag) break;
            }
        }
    }

    if(flag) cout << 1 << '\n';
    else cout << 0 << '\n';

    return 0;
}