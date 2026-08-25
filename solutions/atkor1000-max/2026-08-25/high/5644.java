import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Arrays;

class BC {
	int x;
    int y;
    int range;
    int power;
    
    public BC() {
    	this.x = -1;
        this.y = -1;
        this.range = -1;
        this.power = -1;
    }
    
    public BC(int x, int y, int range, int power) {
    	this.x = x;
        this.y = y;
        this.range = range;
        this.power = power;
    }
}

class Solution
{
    public static Boolean is_in_range(BC bc, int x, int y) {
    	int dist = Math.abs(bc.x - x) + Math.abs(bc.y - y);
        return (dist <= bc.range);
    }
    
	public static void main(String args[]) throws Exception
	{



		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();


		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int P = sc.nextInt();
            int bcCount = sc.nextInt();
            int[] a_movement = new int[P + 1];
            int[] b_movement = new int[P + 1];
            
            for (int a = 0; a < P; a++) {
            	a_movement[a] = sc.nextInt();
            }
            for (int b = 0; b < P; b++) {
            	b_movement[b] = sc.nextInt();
            }
            a_movement[P] = 0;
            b_movement[P] = 0;
            
            int ax = 1;
            int ay = 1;
            int bx = 10;
            int by = 10;
            
            ArrayList<BC> bcs = new ArrayList<>();
            for (int i = 0; i < bcCount; i++) {
            	int x = sc.nextInt();
                int y = sc.nextInt();
                int range = sc.nextInt();
                int power = sc.nextInt();
                BC bc = new BC(x, y, range, power);
                bcs.add(bc);
            }
			
            
            int sum = 0;
            
            
            int[][] dirs = {
                {0, 0},
                {0, -1},
                {1, 0},
                {0, 1},
                {-1, 0}
            };
            
            for (int t = 0; t <= P; t++) {
            	ArrayList<Integer> a_options = new ArrayList<>();
                ArrayList<Integer> b_options = new ArrayList<>();
                ArrayList<Integer> a_powers = new ArrayList<>();
                ArrayList<Integer> b_powers = new ArrayList<>();
                
                
                for (int i = 0; i < bcCount; i++) {
                	if (is_in_range(bcs.get(i), ax, ay)) {
                       	a_options.add(i);
                    	a_powers.add(bcs.get(i).power);
                    }
                    if (is_in_range(bcs.get(i), bx, by)) {
                        b_options.add(i);
                    	b_powers.add(bcs.get(i).power);
                    }
                }
                
                
                if (a_options.isEmpty() && b_options.isEmpty()) {
                }
                else if (b_options.isEmpty()) {
                	Integer[] a_indices = new Integer[a_options.size()];
                    for (int a = 0; a < a_options.size(); a++) a_indices[a] = a;
                    
                    Arrays.sort(a_indices, (i, j) -> Integer.compare(a_powers.get(j), a_powers.get(i)));
                
                	ArrayList<Integer> sorted_a_options = new ArrayList<>();
					ArrayList<Integer> sorted_a_powers = new ArrayList<>();

					for (int i : a_indices) {
    					sorted_a_options.add(a_options.get(i));
    					sorted_a_powers.add(a_powers.get(i));
					}
                    sum += sorted_a_powers.get(0);
                    
                }
                else if (a_options.isEmpty()) {
                	Integer[] b_indices = new Integer[b_options.size()];
                    for (int b = 0; b < b_options.size(); b++) b_indices[b] = b;
                    
                    Arrays.sort(b_indices, (i, j) -> Integer.compare(b_powers.get(j), b_powers.get(i)));
                
                	ArrayList<Integer> sorted_b_options = new ArrayList<>();
					ArrayList<Integer> sorted_b_powers = new ArrayList<>();

					for (int i : b_indices) {
    					sorted_b_options.add(b_options.get(i));
    					sorted_b_powers.add(b_powers.get(i));
					}
                    sum += sorted_b_powers.get(0);
                }
                else {
                	Integer[] a_indices = new Integer[a_options.size()];
                	Integer[] b_indices = new Integer[b_options.size()];
                    
                	for (int a = 0; a < a_options.size(); a++) a_indices[a] = a;
                	for (int b = 0; b < b_options.size(); b++) b_indices[b] = b;
                
                	Arrays.sort(a_indices, (i, j) -> Integer.compare(a_powers.get(j), a_powers.get(i)));
                	
                	ArrayList<Integer> sorted_a_options = new ArrayList<>();
					ArrayList<Integer> sorted_a_powers = new ArrayList<>();

					for (int i : a_indices) {
    					sorted_a_options.add(a_options.get(i));
    					sorted_a_powers.add(a_powers.get(i));
					}	
                
                	Arrays.sort(b_indices, (i, j) -> Integer.compare(b_powers.get(j), b_powers.get(i)));
                
               		ArrayList<Integer> sorted_b_options = new ArrayList<>();
					ArrayList<Integer> sorted_b_powers = new ArrayList<>();

					for (int i : b_indices) {
    					sorted_b_options.add(b_options.get(i));
    					sorted_b_powers.add(b_powers.get(i));
					}
                    
                    
                    int a_best_option = sorted_a_options.get(0);
                    int b_best_option = sorted_b_options.get(0);
                    //System.out.println(t);
                    if (a_best_option != b_best_option) {
                    	sum += sorted_a_powers.get(0);
                        sum += sorted_b_powers.get(0);
                    }
                    else if (a_options.size() == 1 && b_options.size() > 1) {
                        sum += sorted_a_powers.get(0);
                        sum += sorted_b_powers.get(1);
                    }
                    else if (b_options.size() == 1 && a_options.size() > 1) {
                    	sum += sorted_a_powers.get(1);
                        sum += sorted_b_powers.get(0);
                    }
                    else if (a_options.size() == 1 && b_options.size() == 1) {
                    	sum += sorted_a_powers.get(0);
                    }
                    else {
                    	int a_second_power = sorted_a_powers.get(1);
                        int b_second_power = sorted_b_powers.get(1);
                        if (a_second_power < b_second_power) {
                        	sum += sorted_a_powers.get(0);
                            sum += b_second_power;
                        }
                        else {
                        	sum += sorted_b_powers.get(0);
                            sum += a_second_power;
                        }
                    }
                }
                
                ax += dirs[a_movement[t]][0];
                ay += dirs[a_movement[t]][1];
                bx += dirs[b_movement[t]][0];
                by += dirs[b_movement[t]][1];
            }
            
            
            System.out.println("#" + test_case + " " + sum);
		}
	}
}