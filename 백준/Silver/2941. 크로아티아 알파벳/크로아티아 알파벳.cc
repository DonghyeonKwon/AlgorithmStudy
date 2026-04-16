#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cout.tie(NULL); cin.tie(NULL);

    string s;
    cin >> s;
    int cnt = 0;

    for(int i = 0; i < s.length(); i++){
        if(s[i] == 'c'){
            if(s[i+1] == '=' || s[i+1] == '-'){
                cnt++;
                i++;
                continue;
            }
            cnt++;

        }
        else if(s[i] == 'd'){
            if(s[i+1] == '-'){
                cnt++;
                i++;
                continue;
            }
            else if(s[i+1] == 'z' && s[i+2] == '='){
                cnt++;
                i++;
                i++;
                continue;
            }
            cnt++;
        }
        else if (s[i] == 'z'){
            if(s[i+1] == '='){
                cnt++;
                i++;
                continue;
            }
            cnt++;
        }
        else if (s[i] == 'l' || s[i] == 'n'){
            if(s[i+1] == 'j'){
                cnt++;
                i++;
                continue;
            }
            cnt++;
        }
        else if(s[i] == 's'){
            if(s[i+1] == '='){
                cnt++;
                i++;
                continue;
            }
            cnt++;
        }
        else{
            cnt++;
        }
    }

    cout << cnt << '\n';

    return 0;
}