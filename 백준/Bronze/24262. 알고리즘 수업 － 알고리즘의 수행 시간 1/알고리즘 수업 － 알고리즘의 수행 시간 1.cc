#include <bits/stdc++.h>
using namespace std;
int cnt = 0;

int MenOfPassion(int a[], int n){
    int i = n/2;
    cnt++;
    cout << cnt << '\n';
    return a[i];
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int a[500001],n;
    cin >> n;
    
    cout << MenOfPassion(a, n) << '\n';

    return 0;
}