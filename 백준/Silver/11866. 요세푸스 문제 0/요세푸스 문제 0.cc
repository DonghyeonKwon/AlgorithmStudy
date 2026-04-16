#include <bits/stdc++.h>
using namespace std;

int n, k;
queue<int> q;


int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> k;

    for(int i = 1; i <= n; i++){
        q.push(i);
    }
    
    cout << "<";
    for(int i = 1; i <= n; i++){
        int a = k-1;
        while(a--){
            q.push(q.front());
            q.pop();
        }
        cout << q.front();
        q.pop();
        if(i < n) cout << ", ";
    }
    cout << ">\n";

    return 0;
}