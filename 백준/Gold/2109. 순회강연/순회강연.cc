#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

typedef pair<int, int> P;

int n, d, p, sum;
vector<pair<int, int>> v;
priority_queue<int, vector<int>, greater<int>> pq;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> p >> d;
		v.push_back({ d,p });
	}

	sort(v.begin(), v.end());
	for (int i = 0; i < n; i++) {
		pq.push(v[i].second);
		if (pq.size() > v[i].first) {
			pq.pop();
		}
	}
	while (pq.size()) {
		sum += pq.top(); pq.pop();
	}

	cout << sum << '\n';

	return 0;
}