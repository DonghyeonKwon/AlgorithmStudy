#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

const int N = 10;
const int dy[4] = { -1, 0, 1, 0 };
const int dx[4] = { 0, 1, 0, -1 };
int r, c, k;
char a[N][N];
int visited[N][N];

int dfs(int y, int x) {
	if (y == 0 && x == c - 1) {
		//cout << y << " " << x << " " << k << " " << visited[y][x] << '\n';
		if (k == visited[y][x]) return 1;
		return 0;
	}
	int ret = 0;
	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny < 0 || nx < 0 || ny >= r || nx >= c || visited[ny][nx] || a[ny][nx] == 'T') continue;
		visited[ny][nx] = visited[y][x] + 1;
		ret += dfs(ny, nx);
		visited[ny][nx] = 0;
	}
	return ret;
}

int main(int argc, char* argv[]) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> r >> c >> k;

	string s;
	for (int i = 0; i < r; i++) {
		cin >> s;
		for (int j = 0; j < c; j++) {
			a[i][j] = s[j];
		}
	}
	
	visited[r - 1][0] = 1;	

	cout << dfs(r - 1, 0) << '\n';

	return 0;
}