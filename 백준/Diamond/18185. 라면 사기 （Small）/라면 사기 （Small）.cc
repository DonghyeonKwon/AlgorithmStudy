#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, sum = 0;
    cin >> n;
    int arr[n + 2];
    arr[n] = 0;
    arr[n+1] = 0;
    for(int i = 0; i < n; i++) cin >> arr[i];
    for(int i = 0; i < n; i++){
        if(arr[i+1] > arr[i+2]){
            int a = min(arr[i], arr[i+1] - arr[i+2]);
            sum += a*5;
            arr[i] -= a;
            arr[i+1] -= a;
            a = min(arr[i], min(arr[i+1], arr[i+2]));
            sum += a*7;
            arr[i] -= a;
            arr[i+1] -= a;
            arr[i+2] -= a;
        }
        else{
            int a = min(arr[i], min(arr[i+1], arr[i+2]));
            sum += a*7;
            arr[i] -= a;
            arr[i+1] -= a;
            arr[i+2] -= a;

            a = min(arr[i], arr[i+1]);
            sum += a*5;
            arr[i] -= a;
            arr[i+1] -= a;
        }
        sum += arr[i] * 3;
        arr[i] = 0;
    }

    cout << sum << '\n';

    return 0;
}