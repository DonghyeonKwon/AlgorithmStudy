#include <iostream>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int num[8];

    for(int i = 0; i < 8; i++) cin >> num[i];
    
    int ret = num[0] - num[1];
    if(ret == 1){
        for(int i = 1; i < 7; i++){
            if(ret != num[i] - num[i+1]) ret = -100;
        }
    }
    else if(ret == -1){
        for(int i = 1; i < 7; i++){
            if(ret != num[i] - num[i+1]) ret = - 100;
        }   
    }
    else{
        ret = -100;
    }

    if(ret == -1) cout << "ascending" << '\n';
    else if(ret == 1) cout << "descending" << '\n';
    else cout << "mixed" << '\n';

    return 0;
}