#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, one_cnt = 0, two_cnt = 0;
vector<int> v;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for(int i = 0; i < n; i++){
        int input, cnt = 0;
        cin >> input;
        if(input > 0) one_cnt++;
        while(input > 1){
            if(input % 2 == 1){
                input -= 1;
                one_cnt++;
            }
            else{
                input /= 2;
                cnt++;
            }
        }
        if(two_cnt < cnt) two_cnt = cnt;
    }
    
    cout << two_cnt + one_cnt << '\n';

    return 0;
}