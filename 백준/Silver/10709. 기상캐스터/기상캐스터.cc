#include <bits/stdc++.h>

using namespace std;

int h, w;
char adj;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> h >> w;

    for(int i = 0; i < h; i++){
        int cnt = -1;
        for(int j = 0; j < w; j++){
            cin >> adj;
            if(adj == '.'){
                if(cnt == -1){
                    cout << cnt << " ";
                }
                else{
                    cnt++;
                    cout << cnt << " ";
                }
            }
            else{
                cnt = 0;
                cout << cnt << " ";
            }
        }
        cout << '\n';
    }
    cout << '\n';

    

    return 0;
}