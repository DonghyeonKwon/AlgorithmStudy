#include <bits/stdc++.h>
using namespace std;

int n, a = 1;
stack<int> s;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    int stu[n];

    for(int i = 0; i < n; i++){
        cin >> stu[i];
    }

    for(int i = 0; i < n; i++){
        while(!s.empty() && s.top() == a){
            s.pop();
            a++;
        }
        if(a == stu[i]){
            a++;
        }
        else s.push(stu[i]);
    }
    while(!s.empty() && s.top() == a){
        s.pop();
        a++;
    }

    if(s.empty()) cout << "Nice\n";
    else cout << "Sad\n"; 

    return 0;
}