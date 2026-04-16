#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, l, r, x;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> l >> r >> x;
    vector<int> v(n);
    for(int i = 0; i < n; i++){
        cin >> v[i];
    }
    int cnt = 0;
    for(int i = 1; i < (1 << n); i++){
        //문제 한개 이하 거르기
        int j = 1;
        bool flag = false;
        while(j <= i){
            if(j == i){
                flag = true;
                break;
            }
            j *= 2;
        }
        if(flag) continue;

        int _mx = -1, _mn = 1000001, sum = 0;
        for(int j = 0; j < n; j++){
            if((i & (1 << j)) > 0){
                sum += v[j];
                if(_mx < v[j]) _mx = v[j];
                if(_mn > v[j]) _mn = v[j];
            }
        }

        if((l <= sum && sum <= r) && (x <= (_mx - _mn))) cnt++;
    }

    cout << cnt << '\n';

    return 0;
}