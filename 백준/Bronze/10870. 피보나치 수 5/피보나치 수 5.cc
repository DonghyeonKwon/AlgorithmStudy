#include <iostream>
using namespace std;

int fun(int n){
    if(n == 0) return 0;
    else if(n == 1) return 1;
    else return(fun(n-1) + fun(n-2));
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    cout << fun(n) << '\n';

    return 0;
}