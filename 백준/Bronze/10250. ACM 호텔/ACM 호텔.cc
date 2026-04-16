#include <iostream>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int t;
    cin >> t;
    while(t--){
        int h, w, n;
        cin >> h >> w >> n;

        int k = n / h;
        int a = n % h;
        if(a == 0) a = h;
        else k++;
        
        cout << a * 100 + k << '\n';
    }

    return 0;
}