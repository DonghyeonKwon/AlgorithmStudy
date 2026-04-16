#include <iostream>
#include <vector>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<int> v;
    v.push_back(1);
    int k = 2;
    while(v.back() <= 2000){
        v.push_back(v.back() + k);
        k++;
    }

    int n;
    cin >> n;
    while(n--){
        int a;
        bool flag = false;
        cin >> a;

        for(int i = 0; i < v.size(); i++){
            int sum = v[i];
            for(int j = 0; j < v.size(); j++){
                sum += v[j];
                for(int k = 0; k < v.size(); k++){
                    sum += v[k];
                    if(sum == a){
                        flag = true;
                        break;
                    }
                    sum -= v[k];
                }
                sum -= v[j];
                if(flag) break;
            }
            sum -= v[i];
            if(flag) break;
        }

        if(flag) cout << 1 << '\n';
        else cout << 0 << '\n';
    }

    return 0;
}