#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    string n;
    int b, ret = 0;
    cin >> n >> b;

    for(int i = 0; i < n.length(); i++){
        int a = n.length() - 1 - i;
        if(n[a] >= '0' && n[a] <= '9'){
            ret += (n[a] - '0') * pow(b, i);
        }
        else{
            ret += (n[a] - 'A' + 10) * pow(b, i);
        }
    }

    cout << ret << '\n';
    
    return 0;
}