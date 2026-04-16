#include <bits/stdc++.h>
using namespace std;

int n, m, mp[4][4], _max = -1;

int main(){
    ios_base::sync_with_stdio(false);
    cout.tie(NULL); cin.tie(NULL);

    scanf("%d %d", &n, &m);
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            scanf("%1d", &mp[i][j]);
        }
    }

    for(int s = 0; s < (1 << (n*m)); s++){
        int sum = 0;
        for(int i = 0; i < n; i++){
            int ret = 0;
            for(int j = 0; j < m; j++){
                int a = i * m + j;
                if((s & (1 << a)) == 0) {
                    ret = (ret * 10) + mp[i][j];
                }
                else{
                    sum += ret;
                    ret = 0;
                }
            }
            sum += ret;
        }
        for(int j = 0; j < m; j++){
            int ret = 0;
            for(int i = 0; i < n; i++){
                int  a = i * m + j;
                if((s & (1 << a)) != 0) {
                    ret = (ret * 10) + mp[i][j];
                }
                else{
                    sum += ret;
                    ret = 0;
                }
            }
            sum += ret;
        }
        _max = max(_max, sum);
    }

    cout << _max << '\n';

    return 0;
}