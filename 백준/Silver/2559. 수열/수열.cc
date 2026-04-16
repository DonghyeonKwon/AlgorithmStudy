#include <iostream>
#include <algorithm>

using namespace std;

int temp, n, k, a[100001];

int main() {
	ios_base::sync_with_stdio(false);
	cout.tie(NULL);
	cin.tie(NULL);

	cin >> n >> k;
	for (int i = 1; i <= n; i++) {
		cin >> temp;
		a[i] = a[i - 1] + temp;
	}

	int ret = -10000001;
	
	for (int i = k; i <= n; i++) {
		ret = max(ret, a[i] - a[i-k]);
	}

	cout << ret << '\n';

	return 0;
}