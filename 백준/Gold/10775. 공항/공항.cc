#include <bits/stdc++.h>
using namespace std;

int g, p, cnt = 0;
int num[100001];

int find(int n){
    if(n == num[n]) return n;
    return num[n] = find(num[n]);
}

void uni(int a, int b){
    a = find(num[a]);
    b = find(num[b]);
    
    if(a > b){
        swap(a,b);
    }
    num[b] = a;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> g;
    cin >> p;
    for(int i = 0; i <= g; i++) num[i] = i;
    for(int i = 1; i <= p; i++){
        int a;
        cin >> a;
        a = find(a);

        if(a == 0) break;

        cnt++;
        uni(a, a-1);
    }

    cout << cnt << '\n';

    return 0;
}