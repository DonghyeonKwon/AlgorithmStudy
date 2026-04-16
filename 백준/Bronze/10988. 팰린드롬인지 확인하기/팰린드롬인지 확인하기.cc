#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

void solve(string s) {
	string temp = s;
	reverse(s.begin(), s.end());
	if (temp == s) cout << 1 << '\n';
	else cout << 0 << '\n';
}

int main() {
	string s;
	cin >> s;

	solve(s);

	return 0;
}