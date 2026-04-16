#include <iostream>
#include <algorithm>

using namespace std;

const int N = 51;
const int dy[4] = { 0, -1, 0, 1 };
const int dx[4] = { -1, 0, 1, 0 };
int n, m, mx = 0, cnt = 0;
int a[N][N];
int visited[N][N];
int compSize[2501];

int dfs(int y, int x, int cnt) {
	//cout << y << " " << x << '\n';
	if (visited[y][x]) return 0;
	visited[y][x] = cnt;
	int ret = 1;
	for (int i = 0; i < 4; i++) {
		if (!(a[y][x] & (1 << i))) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			ret += dfs(ny, nx, cnt);
		}
	}
	return ret;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;

	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			cin >> a[i][j];
		}
	}

	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (!visited[i][j]) {
				cnt++;
				//cout << cnt << '\n';
				compSize[cnt] = dfs(i, j, cnt);
				mx = max(mx, compSize[cnt]);
			}
		}
	}
	
	int big = 0;
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (i + 1 < m) {
				int a = visited[i + 1][j];
				int b = visited[i][j];
				if (a != b) {
					big = max(big, compSize[a] + compSize[b]);
				}
			}
			if (j + 1 < n) {
				int a = visited[i][j+1];
				int b = visited[i][j];
				if (a != b) {
					big = max(big, compSize[a] + compSize[b]);
				}
			}
		}
	}

	cout << cnt << '\n';
	cout << mx << '\n';
	cout << big << '\n';

	return 0;
}