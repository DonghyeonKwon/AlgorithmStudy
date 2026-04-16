#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, cnt = 0, ret = 0;;
    string input;
    cin >> n;
    cin >> input;
    for(int i = 0; i < n; i++){
        if(input[i] == 'L') cnt++;
        else ret++;
        if(cnt == 2){
            cnt = 0;
            ret++;
        }
    }
    ret++;

    cout << ((n <= ret) ? n : ret) << '\n';    

    return 0;
}