#include <bits/stdc++.h>
using namespace std;
 
int n;
 
bool func(int x, int& st) {
    while (x) {
        int tmp = (1 << (x % 10));
        if (st & tmp)
            return false;
 
        st |= tmp;
        x /= 10;
    }
 
    return true;
}
 
int main() {
    cin >> n;
 
    for (int i = 1; i <= 13072 && i < n; ++i) {
        int used = 0;
 
        if (!func(i, used))
            continue;
        if (!func(n - i, used))
            continue;
 
        cout << n - i << " + " << i;
        return 0;
    }
 
    cout << -1;
}
