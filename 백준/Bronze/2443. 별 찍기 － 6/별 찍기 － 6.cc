#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, k = 0;
    cin >> n;
    for(int i = n; i >= 1; i--){
        for(int j = 0; j < k; j++) cout << ' ';
        for(int j = 0; j < 2 * n - 2 * k - 1; j++) cout << '*';
        k++;
        cout << '\n';
    }

    return 0;
}