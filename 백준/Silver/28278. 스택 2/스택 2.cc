#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    stack<int> stk;
    int n;
    cin >> n;
    while(n--){
        int a;
        cin >> a;
        switch(a){
            case 1:
                int b;
                cin >> b;
                stk.push(b);
                break;
            case 2:
                if(stk.empty()) cout << -1 << '\n';
                else{
                    cout << stk.top() << '\n';
                    stk.pop();
                }
                break;
            case 3:
                cout << stk.size() << '\n';
                break;
            case 4:
                cout << stk.empty() << '\n';
                break;
            case 5:
                if(stk.empty()) cout << -1 << '\n';
                else{
                    cout << stk.top() << '\n'; 
                }
                break;
        }
    }

    return 0;
}