#include <bits/stdc++.h>

using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int k;
    cin >> k;

    vector<int> v;
    for(int i = 0; i < k; i++){
        int a;
        cin >> a;

        if(a != 0)
            v.push_back(a);
        else
            v.pop_back();
    }

    int sum = 0;
    for(int i = 0; i < v.size(); i++)
        sum += v[i];

    cout << sum << '\n';

    return 0;
}