#include <bits/stdc++.h>
using namespace std;
string input, ret = "";
int cnt = 0;
vector<int> v;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> input;
    for(char c : input){
        if(c == 'X'){
            cnt++;
        }
        else if(cnt > 0 && c == '.'){
            v.push_back(cnt);
            cnt = 0;
        }
    }
    if(cnt > 0){
        v.push_back(cnt);
        cnt = 0;
    }

    int idx = 0;
    for(int i = 0; i < input.size(); i++){
        if(input[i] == '.') ret += '.';
        else{
            int a = v[idx++];
            if(a % 2 == 1){
                cout << -1 << '\n';
                return 0;
            }
            else{
                int b = a / 4;
                while(b--) ret += "AAAA";
                if(a % 4 != 0) ret += "BB";
                i += a - 1;
            }
        }
    }
    cout << ret << '\n';

    return 0;
}