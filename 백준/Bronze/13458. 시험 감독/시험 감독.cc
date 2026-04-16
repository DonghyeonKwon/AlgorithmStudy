#include <bits/stdc++.h>

using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int a, b, c;

    cin >> a;

    int arr[1000001];

    for(int i = 0; i < a; i++){
        cin >> arr[i];
    }

    cin >> b >> c;
    long long sum = 0;

    sum += a;

    for(int i = 0; i < a; i++){
        arr[i] -= b;
        if(arr[i] > 0){
            if(arr[i] % c == 0){
                int n = arr[i] / c;
                sum += n;
            }
            else{
                double n = (double) arr[i] / c + 0.5;
                n = round(n);
                sum += n;
            }
        }
    }

    cout << sum << '\n';

    return 0;
}