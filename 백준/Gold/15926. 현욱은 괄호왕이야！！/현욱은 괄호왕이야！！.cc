#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    string str;
    int ret = 0, n;
    cin >> n;
    cin >> str;
    stack<int> s;
    s.push(-1);
    for(int i = 0; i < n; i++){
        if(str[i] == '(') s.push(i);
        else if (str[i] == ')'){
            s.pop();
            if(!s.empty()){
                ret = max(ret, i - s.top());
            }
            else{
                s.push(i);
            }
        }
    }
    cout << ret << '\n';
    return 0;
}