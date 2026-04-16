#include <bits/stdc++.h>
using namespace std;
int n;
vector<int> s;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    for(int i = 0; i < n; i++){
        int a;
        cin >> a;
        s.push_back(a);
    }
    sort(s.begin(), s.end());
    cout << s[(s.size() - 1) / 2] << '\n';

    return 0;
}