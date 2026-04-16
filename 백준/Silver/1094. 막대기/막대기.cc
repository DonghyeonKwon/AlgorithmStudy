#include <iostream>

using namespace std;

int x, cnt = 1;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> x;
	
	while (x != 1) {
		if (x & 1) cnt++;
		x /= 2;
	}
	cout << cnt << '\n';

	return 0;
}