#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int A, B, C;
int e[101];
int ret = 0;

int main() {
	//ios_base::sync_with_stdio(false);
	//cout.tie(NULL);
	//cin.tie(NULL);

	cin >> A >> B >> C;

	for (int i = 0; i < 3; i++) {
		int a, b;
		cin >> a >> b;
		for (int j = a; j < b; j++) {
			e[j]++;
		}
	}

	for (int i = 1; i < 100; i++) {
		if (e[i]) {
			if (e[i] == 1) ret += A;
			else if (e[i] == 2) ret += B * 2;
			else if (e[i] == 3) ret += C * 3;
		}
	}

	cout << ret;

	return 0;
}