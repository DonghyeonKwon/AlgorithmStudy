#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int tc;
	cin >> tc;
	while (tc--) {
		int n, k;
		cin >> n >> k;
		vector<int> v(n);
		for (int i = 0; i < n; i++) cin >> v[i];
		sort(v.begin(), v.end());

		int l = 0, r = n - 1;
		int minMax = 987654321;
		int cnt = 0;
		while (l < r) {
			int le = v[l];
			int ri = v[r];
			if (le + ri < k) {
				l++;
			}
			else if (le + ri == k) {
				l++;
				r--;
			}
			else {
				r--;
			}

			if (abs(k - (le + ri)) < minMax) {
				minMax = abs(k - (le + ri));
				cnt = 1;
			}
			else if (abs(k - (le + ri)) == minMax) {
				cnt++;
			}
		}

		cout << cnt << '\n';

	}

	return 0;
}