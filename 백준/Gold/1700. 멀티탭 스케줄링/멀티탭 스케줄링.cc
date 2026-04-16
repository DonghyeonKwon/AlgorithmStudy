#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

const int INF = 987654321;
bool visited[100];
int a[100], n, k, cnt = 0;
vector<int> v;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> k;

	for (int i = 0; i < k; i++) {
		cin >> a[i];
	}

	for (int i = 0; i < k; i++) {
		if (!visited[a[i]]) {
			if (v.size() == n) {
				int last_idx = 0, pos;
				for (int _a : v) {
					int here_pick = INF;
					for (int j = i + 1; j < k; j++) {
						if (_a == a[j]) {
							here_pick = j; break;
						}
					}
					if (last_idx < here_pick) {
						last_idx = here_pick;
						pos = _a;
					}
				}
				visited[pos] = false;
				cnt++;
				v.erase(find(v.begin(), v.end(), pos));
			}
			v.push_back(a[i]); visited[a[i]] = true;
		}
	}
	cout << cnt << '\n';

	return 0;
}