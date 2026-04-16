#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n;
    priority_queue<double, vector<double>, less<>> pq;
    vector<double> v;
    cin >> n;
    for(int i = 0; i < n; i++){
        double a;
        cin >> a;
        if(pq.size() == 7){
            pq.push(a);
            pq.pop();
        }
        else pq.push(a);
    }
    while(pq.size()){v.push_back(pq.top()); pq.pop();}
    reverse(v.begin(), v.end());
    for(double i : v){
        printf("%.3lf\n", i);
    }

    return 0;
}