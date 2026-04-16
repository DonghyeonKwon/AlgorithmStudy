#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n = 0, a;
    for(int i = 0; i < 28; i++){
        cin >> a;
        n |= (1 << (a-1));
    }

    for(int i = 0; i < 30; i++){
        if(!(n & (1 << i))) cout << i+1 << '\n';
    }

    return 0;
}