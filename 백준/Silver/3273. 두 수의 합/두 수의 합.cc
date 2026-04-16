#include <bits/stdc++.h>
using namespace std;

int n, k, cnt = 0;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    int a[n];
    for(int i = 0; i < n; i++){
        cin >> a[i];
    }
    cin >> k;
    sort(a, a + n);
    int i = 0, j = n-1;
    while(i < j){
        if(a[i] + a[j] == k) {cnt++; i++; j--;}
        else if(a[i] + a[j] > k) j--;
        else if(a[i] + a[j] < k) i++;
    }
    cout << cnt << '\n';

    return 0;
}