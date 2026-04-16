#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

const int N = 20;
int r, c, ret = 0;
char a[N][N];
int visited[N][N];
bool alp[27];
const int dy[4] = { -1, 0, 1, 0 };
const int dx[4] = { 0, 1, 0, -1 };

void go(int y, int x, int num, int cnt) {
	ret = max(ret, cnt);
	for (int i = 0; i < 4; i++) {
		int ny = y - dy[i];
		int nx = x - dx[i];
		if (ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
		int _next = (1 << (int)(a[ny][nx] - 'A'));
		if ((num & _next) == 0) go(ny, nx, num | _next, cnt + 1);
	}
}

int main(int argc, char* argv[]) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> r >> c;

	for (int i = 0; i < r; i++) {
		string s;
		cin >> s;
		for (int j = 0; j < c; j++) {
			a[i][j] = s[j];
		}
	}

	go(0, 0, 1 << (int)(a[0][0] - 'A'), 1);
	cout << ret << '\n';

	return 0;
}