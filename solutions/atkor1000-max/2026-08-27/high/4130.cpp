#include<iostream>
#include<deque>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin>>T;
	for(test_case = 1; test_case <= T; ++test_case)
	{

		int K;
        cin >> K;
        deque<int> magnet_1;
        deque<int> magnet_2;
        deque<int> magnet_3;
        deque<int> magnet_4;
        
        for (int i = 0; i < 8; i++) {int m; cin >> m; magnet_1.push_back(m);}
        for (int i = 0; i < 8; i++) {int m; cin >> m; magnet_2.push_back(m);}
        for (int i = 0; i < 8; i++) {int m; cin >> m; magnet_3.push_back(m);}
        for (int i = 0; i < 8; i++) {int m; cin >> m; magnet_4.push_back(m);}
        
        for (int turn = 0; turn < K; turn++) {
        	int magnet; cin >> magnet;
            int turn_dir; cin >> turn_dir;
            
            bool first_match = (magnet_1[2] != magnet_2[6]);
            bool second_match = (magnet_2[2] != magnet_3[6]);
            bool third_match = (magnet_3[2] != magnet_4[6]); 
            
            if (magnet == 1) {
            	if (turn_dir == 1) {int a = magnet_1.back(); magnet_1.pop_back(); magnet_1.push_front(a);
                	if (first_match) {int b = magnet_2.front(); magnet_2.pop_front(); magnet_2.push_back(b);
                    	if (second_match) {int c = magnet_3.back(); magnet_3.pop_back(); magnet_3.push_front(c);
                        	if (third_match) {int d = magnet_4.front(); magnet_4.pop_front(); magnet_4.push_back(d);}
                        }	
                    }
                }
                else {int a = magnet_1.front(); magnet_1.pop_front(); magnet_1.push_back(a);
                	if (first_match) {int b = magnet_2.back(); magnet_2.pop_back(); magnet_2.push_front(b);
                    	if (second_match) {int c = magnet_3.front(); magnet_3.pop_front(); magnet_3.push_back(c);
                        	if (third_match) {int d = magnet_4.back(); magnet_4.pop_back(); magnet_4.push_front(d);}
                        }	
                    }
                }
            }
            else if (magnet == 2) {
            	if (turn_dir == 1) {int b = magnet_2.back(); magnet_2.pop_back(); magnet_2.push_front(b);
                	if (first_match) {int a = magnet_1.front(); magnet_1.pop_front(); magnet_1.push_back(a);}
                    if (second_match) {int c = magnet_3.front(); magnet_3.pop_front(); magnet_3.push_back(c);
                     	if (third_match) {int d = magnet_4.back(); magnet_4.pop_back(); magnet_4.push_front(d);}
                 	}
                    
                }
                else {int b = magnet_2.front(); magnet_2.pop_front(); magnet_2.push_back(b);
                	if (first_match) {int a = magnet_1.back(); magnet_1.pop_back(); magnet_1.push_front(a);}
                    if (second_match) {int c = magnet_3.back(); magnet_3.pop_back(); magnet_3.push_front(c);
                        if (third_match) {int d = magnet_4.front(); magnet_4.pop_front(); magnet_4.push_back(d);}
                    }	
            	}
        	}
            else if (magnet == 3) {
            	if (turn_dir == 1) {int c = magnet_3.back(); magnet_3.pop_back(); magnet_3.push_front(c);
                	if (third_match) {int d = magnet_4.front(); magnet_4.pop_front(); magnet_4.push_back(d);}
                    if (second_match) {int b = magnet_2.front(); magnet_2.pop_front(); magnet_2.push_back(b);
                     	if (first_match) {int a = magnet_1.back(); magnet_1.pop_back(); magnet_1.push_front(a);}
                 	}
                    
                }
                else {int c = magnet_3.front(); magnet_3.pop_front(); magnet_3.push_back(c);
                	if (third_match) {int d = magnet_4.back(); magnet_4.pop_back(); magnet_4.push_front(d);}
                    if (second_match) {int b = magnet_2.back(); magnet_2.pop_back(); magnet_2.push_front(b);
                        if (first_match) {int a = magnet_1.front(); magnet_1.pop_front(); magnet_1.push_back(a);}
                    }	
            	}
        	}
                
            else {
            	if (turn_dir == 1) {int d = magnet_4.back(); magnet_4.pop_back(); magnet_4.push_front(d);
                	if (third_match) {int c = magnet_3.front(); magnet_3.pop_front(); magnet_3.push_back(c);
                    	if (second_match) {int b = magnet_2.back(); magnet_2.pop_back(); magnet_2.push_front(b);
                        	if (first_match) {int a = magnet_1.front(); magnet_1.pop_front(); magnet_1.push_back(a);}
                        }	
                    }
                }
                else {int d = magnet_4.front(); magnet_4.pop_front(); magnet_4.push_back(d);
                	if (third_match) {int c = magnet_3.back(); magnet_3.pop_back(); magnet_3.push_front(c);
                    	if (second_match) {int b = magnet_2.front(); magnet_2.pop_front(); magnet_2.push_back(b);
                        	if (first_match) {int a = magnet_1.back(); magnet_1.pop_back(); magnet_1.push_front(a);}
                        }	
                    }
                }
            }
        
        }
        
        
        int answer = 0;
        answer += magnet_1[0] * 1 + magnet_2[0] * 2 + magnet_3[0] * 4 + magnet_4[0] * 8;
        
        cout << "#" << test_case << " " << answer << endl;
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}