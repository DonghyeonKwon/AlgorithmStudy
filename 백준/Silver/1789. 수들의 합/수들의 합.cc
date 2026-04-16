#include <bits/stdc++.h>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    long long s, sum = 0, num = 1;
    int cnt = 0;
    cin >> s;
    while(1){
        sum += num;
        cnt++;
        if(sum > s) {
            cnt--;
            break;
        }
        num++;
    }
    cout << cnt << '\n';

    return 0;
}