#include <bits/stdc++.h>
using namespace std;

string str;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    while(1){
        getline(cin, str);
        if(cin.eof()) break;
        cout << str << '\n';
    }

    return 0;
}