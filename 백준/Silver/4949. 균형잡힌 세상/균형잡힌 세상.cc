#include <bits/stdc++.h>

using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    string str;
    while(1){
        getline(cin, str);
        
        if(str.length() == 1 && str == ".") break;

        stack<char> s;
        for(int i = 0; i < str.length(); i++){
            char a = str[i];
            if(a == '(' || a == '['){
                s.push(a);
            }
            else if(a == ')'){
                if(s.empty()){
                    s.push(a);
                }
                else{
                    if(s.top() == '('){
                        s.pop();
                    }
                    else{
                        s.push(a);
                    }
                }
            }
            else if(a == ']'){
                if(s.empty()){
                    s.push(a);
                }
                else{
                    if(s.top() == '['){
                        s.pop();
                    }
                    else{
                        s.push(a);
                    }
                }
            }
        }
        if(s.empty()){
            cout << "yes\n";
        }
        else{
            cout << "no\n";
        }
    }

    return 0;
}