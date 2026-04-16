#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, a, b, round = 1;
    cin >> n >> a >> b;

    if(a > b) swap(a, b);
    int ret = -1;
    while(n > 0){
        if(a + 1 == b && a % 2 == 1) { ret = round; break; }

        if(a % 2 == 1) a = (a / 2) + 1;
        else a /= 2;

        if(b % 2 == 1) b = (b / 2) + 1;
        else b /= 2;

        if(n % 2 == 1) n = (n / 2) + 1;
        else n /= 2;

        round++;
    }

    cout << round << '\n';

    return 0;
}