#include <bits/stdc++.h>

using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, cnt = 0;
    int i = 666;
    string target;
    cin >> n;

    while(true){
        target = to_string(i);
        for(int j = 0; j < target.length()-2; j++){
            if(target[j] == '6' && target[j+1] == '6' && target[j+2] == '6'){
                cnt++;
                break;
            }
        }
        if(n == cnt){
            cout << target << '\n';
            break;
        }
        i++;
    }

    return 0;
}