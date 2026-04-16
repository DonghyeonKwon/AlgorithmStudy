#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

const int N = 100;
int n, l, ret = 0;
int a[N][N];
int b[N][N];

void solve(int adj[N][N]) {
	for (int i = 0; i < n; i++) {
		int cnt = 1;
		int j;
		for (j = 0; j < n-1; j++) {
			if (adj[i][j] == adj[i][j + 1]) cnt++;
			else if (adj[i][j] + 1 == adj[i][j + 1] && cnt >= l) cnt = 1;
			else if (adj[i][j] - 1 == adj[i][j + 1] && cnt >= 0) cnt = -l + 1;
			else break;
		}
		if (j == n - 1 && cnt >= 0) ret++;
	}
	return;
}

int main(int argc, char* argv[]) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> l;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> a[i][j];
			b[j][i] = a[i][j];
		}
	}

	solve(a);
	solve(b);
	cout << ret << '\n';

	return 0;
}