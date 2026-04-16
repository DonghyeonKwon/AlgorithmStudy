#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string ret = "", input;
    bool u = false, c1 = false, p = false, c2 = false;
    getline(cin, input);
    for(int i = 0; i < input.size(); i++){
        if(!u && input[i] == 'U') u = true;
        else if(u && !c1 && input[i] == 'C') c1 = true;
        else if(u && c1 && !p && input[i] == 'P') p = true;
        else if(u && c1 && p && !c2 && input[i] == 'C'){
            c2 = true;
            cout << "I love UCPC\n";
            return 0;
        }
    }

    cout << "I hate UCPC" << '\n';

    return 0;
}