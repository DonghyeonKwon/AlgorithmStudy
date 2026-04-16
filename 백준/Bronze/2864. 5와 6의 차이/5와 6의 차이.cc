#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    string in[2], _mn0 = "", _mn1 = "", _mx0 = "", _mx1 = "";
    cin >> in[0] >> in[1];
    for(char c : in[0]){
        if(c == '5' || c == '6'){
            _mn0.push_back('5');
            _mx0.push_back('6');
        }
        else{
            _mn0.push_back(c);
            _mx0.push_back(c);
        }
    }
    for(char c : in[1]){
        if(c == '5' || c == '6'){
            _mn1.push_back('5');
            _mx1.push_back('6');
        }
        else{
            _mn1.push_back(c);
            _mx1.push_back(c);
        }
    }
    int a = stoi(_mn0), b = stoi(_mn1), c = stoi(_mx0), d = stoi(_mx1);
    cout << a + b << ' ' << c + d << '\n';

    return 0;
}