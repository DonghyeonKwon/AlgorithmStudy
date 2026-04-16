#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;

int a[30];

int main() {
	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		string s;
		cin >> s;
		a[s[0] % 'a']++;
	}

	int j = 0;
	for (char i = 'a'; i <= 'z'; i++) {	
		if (a[i - 'a'] >= 5) {
			cout << i;
			j++;
		}
	}
	if (j == 0) {
		cout << "PREDAJA" << '\n';
	}
}