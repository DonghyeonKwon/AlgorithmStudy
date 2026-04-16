#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    vector<int> v(n), ret(n, 0);
    for(int i = 0; i < n; i++){
        cin >> v[i];
    }

    for(int i = 0; i < n; i++){
        double max_a = -9999999999;
        for(int j = i + 1; j < n; j++){
            double a = (double)(v[j] - v[i]) / (j - i);
            if(a > max_a){
                ret[i]++;
                ret[j]++;
                max_a = a;
            }
        }
    }

    int _mx = -1;
    for(int a : ret) if(_mx < a) _mx = a;
    
    cout << _mx << '\n';

    return 0;
}