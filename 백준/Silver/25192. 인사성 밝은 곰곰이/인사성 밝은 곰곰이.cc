#include <iostream>
#include <string>
#include <map>
using namespace std;

map<string, bool> check;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, cnt = 0;
    cin >> n;
    while(n--){
        string str;
        cin >> str;
        if(str == "ENTER"){
            check.clear();
        }
        else{
            if(check[str]) continue;
            else {
                check[str] = true;
                cnt++;
            }
        }
    }
    cout << cnt << '\n';

    return 0;
}