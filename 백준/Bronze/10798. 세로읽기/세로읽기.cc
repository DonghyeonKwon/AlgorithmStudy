#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    string in;
    string ret[15] = { "", };

    for(int i = 0; i < 5; i++){
        cin >> in;
        for(int j = 0; j < in.length(); j++){
            ret[j].push_back(in[j]);
        }
    }


    for(string s : ret){
        cout << s;
    }
    cout << '\n';

    return 0;
}