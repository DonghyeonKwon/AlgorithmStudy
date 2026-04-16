#include <iostream>
using namespace std;

int fun(int n){
    if(n == 0) return 1;
    else return (n * fun(n-1));
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