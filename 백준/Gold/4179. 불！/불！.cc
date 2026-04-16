#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <tuple>
#include <cstring>

using namespace std;

#define INF 999999

const int N = 1000;
int r, c, sx, sy, ret = 0;
char a[N][N];
int fire_check[N][N], person_check[N][N];
const int dy[4] = { -1, 0, 1, 0 };
const int dx[4] = { 0, 1, 0, -1 };
queue<pair<int, int> > q;

bool in(int a, int b) {
	return 0 <= a && a < r && 0 <= b && b < c;
}

int main(int argc, char* argv[]) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> r >> c;
	//memset(&fire_check, INF, sizeof(fire_check));
	fill(&fire_check[0][0], &fire_check[0][0] + 1000 * 1000, INF);
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			cin >> a[i][j];
			if (a[i][j] == 'F') {
				fire_check[i][j] = 1; q.push({ i,j });
			}				
			else if (a[i][j] == 'J') {
				sy = i; sx = j;
			}
				
		}
	}

	while (q.size()) {
		int y = q.front().first;
		int x = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (!in(ny, nx)) continue;
			if (fire_check[ny][nx] != INF || a[ny][nx] == '#') continue;
			fire_check[ny][nx] = fire_check[y][x] + 1;
			q.push({ny, nx});
		}
	}

	person_check[sy][sx] = 1;
	q.push({ sy, sx });
	while (q.size()) {
		int y = q.front().first;
		int x = q.front().second;
		q.pop();
		if (x == c - 1 || y == r - 1 || x == 0 || y == 0) {
			ret = person_check[y][x];
			break;
		}
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (!in(ny, nx)) continue;
			if (person_check[ny][nx] || a[ny][nx] == '#') continue;
			if (fire_check[ny][nx] <= person_check[y][x] + 1) continue;
			person_check[ny][nx] = person_check[y][x] + 1;
			q.push({ ny, nx });
		}
	}

	if (ret != 0)
		cout << ret << '\n';
	else
		cout << "IMPOSSIBLE" << '\n';

	return 0;
}