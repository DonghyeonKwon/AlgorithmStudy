#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int a;
    cin >> a;

    for(int i = 0; i < (2*a) - 1; i++){
        int j;
        if(i < a){
            for(j = 0; j < a - i - 1; j++) cout << ' ';
            string s = "";
            for( ; j < a - 1; j++) s += '*';
            cout << s << '*' << s;
        }
        else{
            for(j = 0; j < i - a + 1; j++) cout << ' ';
            string s = "";
            for( ; j < a - 1; j++) s += '*';
            cout << s << '*' << s;
        }
        cout << '\n';
    }

    return 0;
}