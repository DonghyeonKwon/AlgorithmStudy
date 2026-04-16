#include <bits/stdc++.h>
using namespace std;

string s, bomb, r = "";
stack<char> stk;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> s;
    cin >> bomb;
    for(char i : s){
        stk.push(i);
        if(stk.size() >= bomb.size() && stk.top() == bomb.back()){
            string temp = "";
            for(char j : bomb){
                temp += stk.top();
                stk.pop();
            }
            reverse(temp.begin(), temp.end());
            if(temp != bomb){
                for(char j : temp){
                    stk.push(j);
                }
            }
        }
    }
    if(stk.size() == 0){
        cout << "FRULA\n";
    }
    else{
        while(stk.size()){
            r += stk.top();
            stk.pop();
        }
        reverse(r.begin(), r.end());
        cout << r << '\n';
    }

    return 0;
}