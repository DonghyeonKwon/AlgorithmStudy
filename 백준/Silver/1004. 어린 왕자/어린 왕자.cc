#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int t;
    cin >> t;
    while(t--){
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        int n, cnt = 0;
        cin >> n;
        while(n--){
            int a, b, r;
            cin >> a >> b >> r;

            if((x1 - a) * (x1 - a) + (y1 - b) * (y1 - b) < r * r){
                if((x2 - a) * (x2 - a) + (y2 - b) * (y2 - b) > r * r){
                    cnt++;
                }
            }

            if((x1 - a) * (x1 - a) + (y1 - b) * (y1 - b) > r * r){
                if((x2 - a) * (x2 - a) + (y2 - b) * (y2 - b) < r * r){
                    cnt++;
                }
            }
        }
        cout << cnt << '\n';
    }

    return 0;
}