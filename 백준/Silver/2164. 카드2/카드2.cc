#include <bits/stdc++.h>

using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    queue<int> q;

    for(int i = 1; i <= n; i++)
        q.push(i);

    bool c = true;
    while(q.size() != 1){

        if(c){
            c = false;
            q.pop();
        }
        else{
            c = true;
            int a = q.front();
            q.pop();
            q.push(a);
        }
    }

    cout << q.front() << '\n';

    return 0;
}