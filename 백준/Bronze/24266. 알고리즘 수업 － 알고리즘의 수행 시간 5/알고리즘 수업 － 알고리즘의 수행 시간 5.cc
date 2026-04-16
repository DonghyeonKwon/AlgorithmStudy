#include <bits/stdc++.h>
using namespace std;
long long cnt = 0;

int MenOfPassion(int a[], int n){
    int sum = 0;
    for(int i = 0; i < n; i++)
        for(int j = 0; j < n; j++)
            for(int k = 0 ; k < n; k++)
                cnt++;
    cout << cnt << '\n';
    return 3;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int a[500001],n;
    cin >> n;
    
    cout << MenOfPassion(a, n) << '\n';

    return 0;
}