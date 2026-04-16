#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main() {
	string s;
	getline(cin, s);

	for (int i = 0; i < s.length(); i++) {
		if (s[i] >= 'A' && s[i] <= 'Z') {
			if (s[i] + 13 > 'Z') s[i] = s[i] - 13;
			else s[i] += 13;
		}
		else if (s[i] >= 'a' && s[i] <= 'z') {
			if (s[i] + 13 > 'z') s[i] = s[i] - 13;
			else s[i] += 13;
		}
	}

	cout << s << '\n';

	return 0;
}