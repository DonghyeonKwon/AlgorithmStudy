#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int t, n;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> t;
    while(t--){
        cin >> n;
        vector<int> v(5, 0);
        
        v[0] = n / 60;
        n %= 60;
        if(n <= 35){
            if(n % 10 > 5){
                v[1] = n/10 + 1;
                v[4] = 10 - n % 10;
            }
            else{
                v[1] = n/10;
                v[3] = n%10;
            }
        }
        else{
            v[0]++;
            if(n % 10 >= 5){
                v[2] = 6 - (n / 10 + 1);
                v[4] = 10 - n % 10;
            }
            else{
                v[2] = 6 - n / 10;
                v[3] = n % 10;
            }
        }

        for(int i = 0; i < 5; i++){
            cout << v[i];
            if(i == 4) cout << '\n';
            else cout << ' ';
        }
    }

    return 0;
}