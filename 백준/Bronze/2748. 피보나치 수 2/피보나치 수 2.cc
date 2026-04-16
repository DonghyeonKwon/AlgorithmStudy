#include <iostream>

using namespace std;

typedef long long ll;

ll dp[90];

ll fibo(ll idx) {
	if (idx == 0 || idx == 1) return idx;
	ll &ret = dp[idx];
	if (ret) return ret;
	return ret = fibo(idx - 1) + fibo(idx - 2);
}

int main() {
	ll n, a[90];

	cin >> n;
	cout << fibo(n) << '\n';
}