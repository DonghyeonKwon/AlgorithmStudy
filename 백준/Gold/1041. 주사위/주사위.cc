#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
ll n, c3, c2, c1, sum = 0;
vector<ll> v;

ll counting1(){
    vector<ll> temp = v;
    sort(temp.begin(), temp.end());
    return temp[0];
}

ll counting2(){
    ll ret = 101;
    for(int i = 0; i < 5; i++){
        for(int j = i+1; j < 6; j++){
            if(i + j == 5) continue;
            // cout << v[i] + v[j] << '\n';
            if(ret > v[i] + v[j]) ret = v[i] + v[j]; 
        }
    }
    return ret;
}

ll counting3(){
    ll ret = 151;
    for(int i = 0; i < 4; i++){
        for(int j = i + 1; j < 5; j++){
            for(int k = j + 1; k < 6; k++){
                if(i + j == 5 || j + k == 5 || i+k == 5) continue;
                // cout << v[i] + v[j] + v[k] << '\n';
                if(ret > v[i] + v[j] + v[k]) ret = v[i] + v[j] + v[k];
            }
        }
    }
    
    return ret;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    for(int i = 0; i < 6; i++){
        ll input;
        cin >> input;
        v.push_back(input);
    }
    //n == 1일 때 가장 큰 수인 면 뺴고 다 노출 됨.
    if(n == 1){
        sort(v.begin(), v.end());
        for(int i = 0; i < 5; i++) sum += v[i];
        cout << sum << '\n';
        return 0;
    }
    //n >= 2 일 때
    //노출된 면의 개수가 1-3일떄의 최솟값만 계산
    c1 = counting1(); 
    c2 = counting2();
    c3 = counting3();

    // cout << c1 << ' ' << c2 << ' ' << c3 << '\n';

    cout << c3 * 4 + c2 * (4 * ((n-1) + (n-2))) + c1 * (n-2) * (n-2) + c1 * 4 * (n-2) * (n-1) << '\n';

    return 0;
}