#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int a, b, c;
    cin >> a >> b >> c;

    int sum = a + b + c;
    if(sum == 180){
        if(a == b && b == c) cout << "Equilateral\n";
        else if(a == b || b == c || c == a) cout << "Isosceles\n";
        else cout << "Scalene\n";
    }
    else {
        cout << "Error\n";
    }

    return 0;
}