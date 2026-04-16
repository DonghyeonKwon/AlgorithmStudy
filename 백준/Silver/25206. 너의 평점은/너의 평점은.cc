#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    double a, a_su = 0.000000, sum = 0.000000;
    string ob, s;

    for(int i = 0; i < 20; i++){
        cin >> ob >> a >> s;
        if(s == "P") {
            // a_su += a;
        }   
        else if(s == "A+"){
            a_su += a;
            sum += (a * 4.5);
        }
        else if(s == "A0"){
            a_su += a;
            sum += (a * 4.0);
        }
        else if(s == "B+"){
            a_su += a;
            sum += (a * 3.5);
        }
        else if(s == "B0"){
            a_su += a;
            sum += (a * 3.0);
        }
        else if(s == "C+"){
            a_su += a;
            sum += (a * 2.5);
        }
        else if(s == "C0"){
            a_su += a;
            sum += (a * 2.0);
        }
        else if(s == "D+"){
            a_su += a;
            sum += (a * 1.5);
        }
        else if(s == "D0"){
            a_su += a;
            sum += (a * 1.0);
        }
        else if(s == "F"){
            a_su += a;
            sum += (a * 0.0);
        }
        // cout << sum << ' ' << a_su << '\n';
    }

    // cout << sum << ' ' << a_su << '\n';
    printf("%.6lf\n", sum/a_su);

    return 0;
}