#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;

int n;
vector<string> v;

bool cmp(string a, string b) {
	if (a.size() == b.size()) return a < b;
	else return a.size() < b.size();
}

int main(int argc, char** argv) {
	
	cin >> n;

	for (int i = 0; i < n; i++) {
		string str;
		cin >> str;

		string s = "";
		for (int j = 0; j < str.size(); j++) {
			if (isdigit(str[j])) {
				if (s == "0" && str[j] == '0') s = "0";
				if (s != "0" || s.empty()) {
					s += str[j];
				}
				else {
					s.clear();
					s += str[j];
				}
			}
			if ((!isdigit(str[j]) || str[j + 1] == '\0') && s.length() != 0) {
				v.push_back(s);
				s.clear();
			}
		}
	}

	sort(v.begin(), v.end(), cmp);

	for (string i : v) {
		cout << i << "\n";
	}

	return 0;
}