#include <bits/stdc++.h>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    deque<int> dq;
    int n, a, b;
    cin >> n;
    while(n--){
        cin >> a;
        switch(a){
            case 1:
                cin >> b;
                dq.push_front(b);
                break;
            case 2:
                cin >> b;
                dq.push_back(b);
                break;
            case 3:
                if(!dq.empty()){
                    cout << dq.front() << '\n';
                    dq.pop_front();
                }
                else cout << -1 << '\n';
                break;
            case 4:
                if(!dq.empty()){
                    cout << dq.back() << '\n';
                    dq.pop_back();
                }
                else cout << -1 << '\n';
                break;
            case 5:
                cout << dq.size() << '\n';
                break;
            case 6:
                cout << dq.empty() << '\n';
                break;
            case 7:
                if(!dq.empty()){
                    cout << dq.front() << '\n';
                }
                else cout << -1 << '\n';
                break;
            case 8:
                if(!dq.empty()){
                    cout << dq.back() << '\n';
                }
                else cout << -1 << '\n';
                break;
        }
    }
}