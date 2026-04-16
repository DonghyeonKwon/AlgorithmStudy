#include <iostream>
#include <algorithm>

using namespace std;

int n, m;
int a[15000];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;
	cin >> m;

	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}
	
	int cnt = 0;

	//if (m > 200000) cout << 0 << "\n";
	//else {
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] + a[j] == m) cnt++;
			}
		}
		cout << cnt << "\n";
	//}

	return 0;
}