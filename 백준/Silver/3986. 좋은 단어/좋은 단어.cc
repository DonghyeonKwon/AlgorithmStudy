#include <iostream>
#include <string>
#include <stack>

using namespace std;

int n;


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;

	int cnt = 0;
	for (int i = 0; i < n; i++) {
		string str;
		stack<char> s;
		cin >> str;

		for (int j = 0; j < str.size(); j++) {
			if (s.empty() == true) {
				s.push(str[j]);
			}
			else if (s.top() == str[j]) {
				s.pop();
			}
			else {
				s.push(str[j]);
			}
		}
		if (s.empty() == true) cnt++;
	}

	cout << cnt << '\n';

	return 0;
}