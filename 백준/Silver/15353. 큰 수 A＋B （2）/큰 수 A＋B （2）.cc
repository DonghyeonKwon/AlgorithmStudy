#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    string a, b, ret;
    cin >> a >> b;

    // vector<int> as = makeV(a), bs = makeV(b), ret;
    int sum = 0;
    while(a.size() || b.size() || sum){
        if(a.size()){
            sum += a.back() - '0';
            a.pop_back();
        }
        if(b.size()){
            sum += b.back() - '0';
            b.pop_back();
        }
        ret += sum % 10 + '0';
        sum /= 10;
    }
    reverse(ret.begin(), ret.end());
    cout << ret << '\n';

    return 0;
}