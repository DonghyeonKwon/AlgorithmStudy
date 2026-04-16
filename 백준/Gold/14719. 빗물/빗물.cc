#include <iostream>
#include <vector>

using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;
    vector<int> v(m);
    for(int i = 0; i < m; i++){
        cin >> v[i];
    }

    int sum = 0;
    for(int i = 1; i < v.size() - 1; i++){
        int l = 0, r = 0;
        for(int j = 0; j < i; j++) if(l < v[j]) l = v[j];
        for(int j = m - 1; j > i; j--) if(r < v[j]) r = v[j];
        sum += max(0, min(r, l) - v[i]);
    }
    cout << sum << '\n';

    return 0;
}