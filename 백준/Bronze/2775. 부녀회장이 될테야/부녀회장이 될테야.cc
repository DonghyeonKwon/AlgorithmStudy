#include <bits/stdc++.h>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int mp[15][15] {{0,}}, t, a, b;
    for(int i = 0; i < 15; i++){
        mp[i][0] = 0;
        for(int j = 1; j < 15; j++){
            if(i == 0) mp[i][j] = j;
            else{
                mp[i][j] = mp[i][j-1] + mp[i-1][j];
            }
        }
    }

    cin >> t;
    while(t--){
        cin >> a >> b;
        cout << mp[a][b] << '\n';
    }

    return 0;
}