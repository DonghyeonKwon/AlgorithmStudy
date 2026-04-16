#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    deque<pair<int, int>> dq;
    int n,a;
    cin >> n;
    bool flag = false;
    for(int i = 1; i <= n; i++){
        cin >> a;
        if(i == 1 && a > 0) flag = true;
        dq.push_back({i, a});
    }
    
    int b;
    cout << dq.front().first << ' ';
    b = dq.front().second;
    if(b > 0) flag = true;
    else flag =false;
    dq.pop_front();

    for(int i = 2; i <= n; i++){
         if(flag){
            b--;
            while(b--){
                dq.push_back(dq.front());
                dq.pop_front();
            }
        }
        else{
            b++;
            while(b++){
                dq.push_front(dq.back());
                dq.pop_back();
            }
        }

        if(flag){
            cout << dq.front().first << ' ';
            b = dq.front().second;
            dq.pop_front();
            if(b < 0) flag = false;
        }
        else{
            cout << dq.back().first << ' ';
            b = dq.back().second;
            dq.pop_back();
            if(b > 0) flag = true;
        }
    }
    cout << '\n';
    return 0;
}