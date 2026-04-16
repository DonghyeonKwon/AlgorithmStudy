#include <bits/stdc++.h>
using namespace std;

int n, k, cnt = 0;
string str;
priority_queue<int, vector<int>, greater<>> h, p;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> k;
    cin >> str;
    for(int i = 0; i < n; i++){
        if(str[i] == 'H') h.push(i);
        else p.push(i);
    }

    while(p.size() && h.size()){
        int person = p.top();
        // cout << person << ' ' << h.top() << '\n';
        if(h.top() < person - k) {h.pop(); continue;}
        if(person - k <= h.top() && h.top() <= person + k){
            p.pop();
            h.pop();
            cnt++;
            continue;
        }
        if(person + k < h.top()) {p.pop(); continue;}
    }
    cout << cnt << '\n';

    return 0;
}