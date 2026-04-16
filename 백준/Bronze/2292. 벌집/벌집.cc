#include <bits/stdc++.h>

using namespace std;

int main(int argc, char* argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    int max = 1;
    int ret = 1;
    int add = 6;
    cin >> n;

    while(1){
        if(n <= max) break;
        max += add;
        add += 6;
        ret ++;
    }

    cout << ret << '\n';

    return 0;
}