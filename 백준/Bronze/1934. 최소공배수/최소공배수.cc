#include <bits/stdc++.h>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int t, a, b, temp;
    cin >> t;
    while(t){
        t--;
        cin >> a >> b;
        if(a > b){
            temp = a;
            a = b;
            b = temp;
        }
        int i = 1;
        while((b*i)%a != 0){
            i++;
        }
        cout << b*i << '\n';
    }

    return 0;
}