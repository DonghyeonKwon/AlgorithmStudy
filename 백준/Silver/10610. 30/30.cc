#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    string input;
    int _max = -1;
    cin >> input;
    sort(input.begin(), input.end(), greater<>());

    if(input.back() != '0'){
        cout << -1 << '\n';
        return 0;
    }
    
    long long sum = 0;
    for(char a : input){
        sum += a - '0';
    }
    if(sum % 3 == 0){
        cout << input << '\n';
    }
    else{
        cout << -1 << '\n';
    }

    return 0;
}