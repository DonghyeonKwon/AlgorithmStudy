#include <bits/stdc++.h>
using namespace std;

int n, k, sum = 0;
priority_queue<int, vector<int>, greater<>> pq;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> k;
    if(n <= k){
        cout << 0 << '\n';
        return 0;
    }

    int bottle = n;
    int liter = 1;

    while(true){
        if(bottle % 2 == 1){
            bottle--;
            pq.push(liter);
        }
        if(bottle % 2 == 0){
            bottle /= 2;
            liter *= 2;
        }
        if(bottle <= 1) break;
        if(bottle + pq.size() <= k){
            cout << 0 << '\n';
            return 0;
        }
    }
    if(bottle == 1) pq.push(liter);

    while(pq.size() > k){
        int first = pq.top();
        pq.pop();
        if(pq.top() == first){
            pq.pop();
            pq.push(first*2);
        } 
        else{
            sum += first;
            pq.push(first*2);
        }
    }


    cout << sum << '\n';

    return 0;
}