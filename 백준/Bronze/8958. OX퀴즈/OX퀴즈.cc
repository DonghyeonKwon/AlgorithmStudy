#include <iostream>
#include <string>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int t;
    cin >> t;
    while(t--){
        string str;
        cin >> str;
        int ret = 0, value = 0;
        for(char c : str){
            if(c == 'O'){
                value++;
                ret += value;
            }else{
                value = 0;
            }
        }
        cout << ret << '\n';
    }

    return 0;
}