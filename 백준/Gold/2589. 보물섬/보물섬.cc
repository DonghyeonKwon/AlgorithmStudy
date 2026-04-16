#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;

int n, m, mx, _min=987654321;
const int N = 50;
const int dy[4] = { -1, 0, 1, 0 };
const int dx[4] = { 0, 1, 0, -1 };
char a[N][N];
int visited[N][N];
vector<pair<int, int> > v;

void go(int y, int x) {
	memset(visited, 0, sizeof(visited));
	visited[y][x] = 1;
	queue<pair<int, int> > q;
	q.push({ y,x });
	while (q.size()) {
		tie(y, x) = q.front();
		q.pop();
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
			if (visited[ny][nx]) continue;
			if (a[ny][nx] == 'W') continue;
			visited[ny][nx] = visited[y][x] + 1;
			q.push({ ny,nx });
			mx = max(mx, visited[ny][nx]);
		}
	}
}

int main(int argc, char* argv[]) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> a[i][j];
			if (a[i][j] == 'L') v.push_back({ i, j });
		}
	}

	for (pair<int, int> i : v) {
		go(i.first, i.second);
	}

	cout << mx - 1 << '\n';

	return 0;
}