#include <iostream>
#include <algorithm>

using namespace std;
int n, m, l, r, j;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;
	l = 1;
	int ret = 0;
	cin >> j;
	for (int i = 0; i < j; i++) {
		r = l + m - 1;
		int a;
		cin >> a;
		if (l <= a && r >= a) continue;
		else {
			if (a < l) {
				ret += (l - a);
				l = a;
			}
			else {
				l += (a - r);
				ret += (a - r);
			}
		}
	}
	cout << ret << '\n';
	
	return 0;
}