#include <bits/stdc++.h>
using namespace std;

const int dy[] = {0, 1, 1, -1};
const int dx[] = {1, -1, 0, 1};

int main(){
    ios_base::sync_with_stdio(false);
    cout.tie(NULL); cin.tie(NULL);

    int n, cnt = 1, i = 1, j = 1, s = 0;
    cin >> n;

    while(n != cnt){
        int a = s%4;
        switch(a){
            case 0:
                s++;
                i += dy[a];
                j += dx[a];
                cnt++;
                break;
            case 1:
                s++;
                while(n != cnt && j != 1){
                    i += dy[a];
                    j += dx[a];
                    cnt++;
                }
                break;
            case 2:
                s++;
                i += dy[a];
                j += dx[a];
                cnt++;
                break;
            case 3:
                s++;
                while(n != cnt && i != 1){
                    i += dy[a];
                    j += dx[a];
                    cnt++;
                }
                break;
        }
    }
    cout << i << '/' << j << '\n';

    return 0;
}