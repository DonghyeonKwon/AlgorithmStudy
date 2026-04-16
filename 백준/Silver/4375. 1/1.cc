#include <iostream>

using namespace std;

typedef long long ll;

int a;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	while(cin >> a) {
		if (cin.eof() == true) break;
		ll cnt = 1, ret = 1;
		while (true) {
			if (cnt % a == 0) {
				cout << ret << '\n';
				break;
			}
			else {
				cnt = (cnt * 10) + 1;
				cnt %= a;
				ret++;
			}
		}
	}

	return 0;
}