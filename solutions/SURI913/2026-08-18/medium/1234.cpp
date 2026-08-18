#include <iostream>
#include <string>
#define MAX 101
using namespace std;

//스택 문제
int main()
{
	int T =10;
	for (int test_case = 1; test_case <= T; test_case++) {
		int N;
		string pass, answer = "";
		cin >> N >> pass;

		for (char c: pass) {
			if (!answer.empty() && answer.back() == c) {
				answer.pop_back(); //같은문자는 제거
			}
			else answer.push_back(c);
			
		}

		cout << '#' << test_case << " " << answer << endl;


	}
}