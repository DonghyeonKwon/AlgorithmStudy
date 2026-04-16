#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, t;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    vector<int> v(n);
    for(int i = 0; i < n; i++) cin >> v[i];
    cin >> t;

    int start = 0;
    while(t > 0 && start < n){
        int maxIdx = start;
        for(int i = start; i <= min(n-1, start + t); i++){
            if(v[maxIdx] < v[i]) maxIdx = i;
        }
        for(int i = maxIdx; i > start; i--){
            swap(v[i], v[i-1]);
            t--;
        }
        start++;
    }
    for(int i = 0; i < n; i++){
        cout << v[i];
        if(i < n-1) cout << ' ';
        else cout << '\n';
    }

    return 0;
}