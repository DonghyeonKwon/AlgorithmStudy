#include <bits/stdc++.h>
using namespace std;

int t, n, m, in;

bool check(int a[], int in){
    int i = 0, j = n - 1;
    while(i <= j){
        int mid = (i+j)/2;
        if(a[mid] == in) return true;
        else if(a[mid] < in){
            i = mid + 1;
        }
        else if(a[mid] > in){
            j = mid - 1;
        }
    }
    return false;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> t;
    while(t--){
        cin >> n;
        int a[n];
        for(int i = 0; i < n; i++){
            cin >> a[i];
        }
        sort(a, a+n);
        cin >> m;
        for(int i = 0; i < m; i++){
            cin >> in;
            if(check(a, in)) cout << 1 << '\n';
            else cout << 0 << '\n';
        }
    }

    return 0;
}