#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int n;

int main() {
	ios_base::sync_with_stdio(false);
	cout.tie(NULL);
	cin.tie(NULL);

	cin >> n;

	string s;
	cin >> s;

	int pos = s.find('*');
	string pre = s.substr(0, pos);
	string suf = s.substr(pos+1);

	for (int i = 0; i < n; i++) {
		string str;
		
		cin >> str;

		if (pre.size() + suf.size() > str.size()) cout << "NE\n";
		else {
			if (pre == str.substr(0, pre.size()) && suf == str.substr(str.size() - suf.size())) cout << "DA\n";
			else cout << "NE\n";
		}
	}

	return 0;
}