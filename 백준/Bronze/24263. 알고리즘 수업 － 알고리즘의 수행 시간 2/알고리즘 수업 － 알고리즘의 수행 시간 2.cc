#include <bits/stdc++.h>
using namespace std;
int cnt = 0;

int MenOfPassion(int a[], int n){
    int sum = 0;
    for(; cnt < n; cnt++)
        sum += a[cnt];
    cout << cnt << '\n';
    return n/cnt;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int a[500001],n;
    cin >> n;
    
    cout << MenOfPassion(a, n) << '\n';

    return 0;
}