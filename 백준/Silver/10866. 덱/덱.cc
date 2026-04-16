#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    deque<int> dq;
    string input;
    int t, in;

    cin >> t;
    while(t--){
        cin >> input;
        if(input.substr(0, 4) == "push"){
            cin >> in;
            if(input[5] == 'b') dq.push_back(in);
            else dq.push_front(in);
            continue;
        }
        if(input.substr(0,3) == "pop"){
            if(dq.empty()){
                cout << -1 << '\n';
                continue;
            }
            if(input[4] == 'b') {
                cout << dq.back() << '\n';
                dq.pop_back();
            }
            else{
                cout << dq.front() << '\n';
                dq.pop_front();
            }
            continue;
        }
        if(input == "size"){
            cout << dq.size() << '\n';
            continue;
        }
        if(input == "empty"){
            cout << dq.empty() << '\n';
            continue;
        }
        if(input == "front"){
            cout << ((dq.empty() ? -1 : dq.front())) << '\n';
            continue;
        }
        if(input == "back"){
            cout << ((dq.empty() ? -1 : dq.back())) << '\n';
            continue;
        }
    }    

    return 0;
}