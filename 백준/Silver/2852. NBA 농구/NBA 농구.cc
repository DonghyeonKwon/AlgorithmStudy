#include <iostream>
#include <vector>
#include <string>

using namespace std;

int a = 0, b = 0, m, sec, s, total_a = 0, total_b = 0;

int main(int argc, char** argv) {
	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		int c;
		string str;
		cin >> c >> str;
		m = stoi(str.substr(0, 2));
		sec = stoi(str.substr(3, 2));

		if (a > b) {
			total_a = total_a + (m * 60) + sec - s;
		}
		else if (b > a) {
			total_b = total_b + (m * 60) + sec - s;
		}

		if (c == 1) a++;
		else b++;

		s = (m * 60) + sec;
	}

	if (a > b) {
		total_a = total_a + (48 * 60) - s;
	}
	else if (b > a) {
		total_b = total_b + (48 * 60) - s;
	}

	printf("%02d:%02d\n", total_a / 60, total_a % 60);
	printf("%02d:%02d\n", total_b / 60, total_b % 60);

	return 0;
}