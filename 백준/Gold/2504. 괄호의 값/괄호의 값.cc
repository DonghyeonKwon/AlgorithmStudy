#include <iostream>
#include <string>
#include <stack>
using namespace std;

string input;
stack<int> stk;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> input;
    int ret = 0, temp = 1;
    for(int i = 0; i < input.size(); i++){
        char c = input[i];
        if(c == '('){
            temp *= 2;
            stk.push('(');
        }
        else if(c == '['){
            temp *= 3;
            stk.push('[');
        }
        else if(c == ')'){
            if(stk.empty() || stk.top() != '('){
                ret = 0;
                break;
            }
            else if(input[i-1] == '('){
                ret += temp;
                temp /= 2;
                stk.pop();
            }
            else{
                temp /= 2;
                stk.pop();
            }
        }
        else if(c == ']'){
            if(stk.empty() || stk.top() != '['){
                ret = 0;
                break;
            }
            else if(input[i-1] == '['){
                ret += temp;
                temp /= 3;
                stk.pop();
            }
            else{
                temp /= 3;
                stk.pop();
            }
        }
    }
    
    if(stk.size() > 0) ret = 0;
    cout << ret << '\n';

    return 0;
}