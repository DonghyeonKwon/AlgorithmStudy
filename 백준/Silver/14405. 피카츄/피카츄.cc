#include <bits/stdc++.h>
using namespace std;

const string ds[] = {"pi", "ka", "chu"};
string str;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> str;
    bool flag = false;

    for(int i = 0; i < str.length();){
        char c = str[i];
        if(c == 'p'){
            if(str.substr(i,2) != ds[0]){
                flag = true;
                break;
            }
            i += 2;
        }
        else if(c == 'k'){
            if(str.substr(i,2) != ds[1]){
                flag = true;
                break;
            }
            i += 2;
        }
        else if(c == 'c'){
            if(str.substr(i,3) != ds[2]){
                flag = true;
                break;
            }
            i += 3;
        }
        else{
            flag = true;
            break;
        }
    }
    if(flag){
        cout << "NO\n";
    }
    else{
        cout << "YES\n";
    }

    return 0;
}