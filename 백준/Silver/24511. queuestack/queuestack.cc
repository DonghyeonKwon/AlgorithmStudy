#include <bits/stdc++.h>
using namespace std;

int n, m;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    bool queuestack[n];
    deque<int> dq;
    for(int i = 0; i < n; i++){
        int a;
        cin >> a;
        if(a == 1) queuestack[i] = true;
        else queuestack[i] = false;
    }
    for(int i = 0; i < n; i++){
        int a;
        cin >> a;
        if(queuestack[i]) continue;
        dq.push_front(a);
    }
    
    cin >> m;
    while(m--){
        int a;
        cin >> a;
        dq.push_back(a);
        cout << dq.front() << ' ';
        dq.pop_front();
    }
    cout << '\n';


    return 0;
}