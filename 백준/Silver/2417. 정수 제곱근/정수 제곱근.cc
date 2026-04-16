#include <iostream>
#include <cmath>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	long long n;
	cin >> n;
	long long ret = sqrt(n);
	
	if ((ret * ret) < n) {
		ret++;
	}

	cout << ret << '\n';

	return 0;
}