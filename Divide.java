import java.util.Random;
import java.util.Scanner;
public class Divide {
	Random random = new Random();
	private int mat[] = {1,1,1,1,1,1,1,1,1};
	private int keep = 0;
	private int kept = 0;
	private int place = 0;
	private int endImmediate = 0;
	private long score = 0;
	private int level = 1;
	private int streak = 0;
	private long highScore = 0;
	public String name = "";
	private Scanner s = new Scanner(System.in);
	private int gameCount = 0;
	private int nextValues[] = {0,0,0,0,0};	
	//53, 59, 61, 67, 71, 73, 79, 83, 89, 97
	private int values[] = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,
			21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,
			40,41,42,43,44,45,46,47,48,49,50,51,52,54,55,56,57,58,60,
			62,63,64,65,66,68,69,70,72,74,75,76,77,78,80,81,82,84,85,
			86,87,88,90,91,92,93,94,95,96,98,99};
	private int values1[] = {2,3,4,5,6,7,8,9,10,12,3,14,15,16,2,18,20,21,5,22,
			4,24,25};
	private int values2[] = {2,3,4,5,6,7,8,9,3,10,11,2,12,13,14,1,4,5,16,17,7,
			18,19,20,21,22,24,25,26,27,28,30,13,32,33,17,34,35,36,38,
			39,40};
	private int values3[] = {2,3,4,5,6,7,8,9,10,2,4,8,9,10,11,12,15,13,16,14,
			17,15,16,17,18,19,20,21,22,23,24,25,29,26,27,28,29,30,32,
			23,33,34,35,36,19,38,39,40,42,44,45,46,48,49,50,51,52,54,
			55,56,57,58,57,20,13,60};
	private int values4[] = {2,3,4,5,6,7,8,9,10,11,12,13,14,2,15,3,16,17,7,18,
			11,19,20,12,29,21,22,23,24,25,27,26,27,3,28,29,30,31,16,32,
			33,34,35,36,37,38,39,40,42,44,45,3,2,46,48,49,50,51,52,2,54,
			55,56,17,19,11,13,57,58,60,62,63,64,65,66,68,70,72,74,75,76,
			77,78,80,20};
	private int values5[] = {2,3,4,5,6,7,8,9,10,11,5,2,12,13,14,3,17,15,16,17,
			18,19,20,21,22,23,24,15,25,26,27,28,29,30,2,31,32,33,34,35,
			36,3,13,37,38,39,40,41,42,43,44,20,21,27,4,45,46,47,48,16,
			26,49,50,51,52,54,55,56,57,58,60,62,25,17,63,64,19,65,66,
			68,69,70,72,12,74,75,76,77,78,13,80,81,82,84,85,86,87,88,
			90,91,92,93,94,95,96,98,99,21};
	private int values6[] = {2,3,4,5,6,7,8,9,10,3,2,11,12,13,4,14,11,15,3,16,17,
			18,19,20,21,22,23,24,25,26,27,28,5,29,30,31,32,17,33,34,13,
			35,36,37,7,13,38,39,40,41,42,32,43,44,13,2,45,46,10,47,48,49,
			50,51,52,54,55,17,56,57,58,60,62,63,64,65,66,68,69,70,45,72,
			74,75,19,76,3,77,36,78,3,80,81,82,84,85,86,87,2,88,90,91,19,
			92,93,94,95,96,98,3,99};

	private int levelSelector() {
		if(score<100)
			level = 1;
		else if(score<200)
			level = 2;
		else if(score<400)
			level = 3;
		else if(score<800)
			level = 4;
		else if(score<1600)
			level = 5;
		else if(score <3200)
			level = 6;
		else
			level = 7;
		return level;
	}
	private boolean isVacant(int p) {
		if(mat[p]>1)
			return false;
		return true;
	}
	private boolean reorder0() { //1-3
		if(mat[0]>=2) {
			if((mat[0]%mat[1]==0)&&(mat[0]%mat[3]==0)&&(mat[1]>=2)&&(mat[3]>=2)) {
				int m = mat[0]/mat[1];
				int n = mat[0]/mat[3];
				mat[1] = 0;
				mat[3] = 0;
				mat[0] = m>n?n:m;
				streak = streak + 2;
				return true;
			}
			else if((mat[1]%mat[0]==0)&&(mat[3]%mat[0]==0)&&(mat[1]>=2)&&(mat[3]>=2)) { //13
				mat[1] /= mat[0];
				mat[3] /= mat[0];
				mat[0] = 0;
				streak++;
				return true;
			}
			else if((mat[1]%mat[0]==0)&&(mat[1]>=2)){ //1
				mat[1] /=mat[0];
				mat[0] = 0;
				return true;
			}
			else if((mat[3]%mat[0]==0)&&(mat[3]>=2)) { //3
				mat[3] /= mat[0];
				mat[0] = 0;
				return true;
			}
		}
		return false;
	}
	private boolean reorder1() { //0-2-4
		if(mat[1]>=2) {
			if((mat[1]%mat[0]==0)&&(mat[1]%mat[2]==0)&&(mat[1]%mat[4]==0)&&(mat[0]>=2)&&(mat[2]>=2)&&(mat[4]>=2)) {
				int m = mat[1]/mat[0];
				int n = mat[1]/mat[2];
				int o = mat[1]/mat[4];
				mat[0] = 0;
				mat[2] = 0;
				mat[4] = 0;
				mat[1] = (m<n)?((m<o?m:o)):(n<o?n:o);
				streak = streak + 3;
				return true;
			}
			else if((mat[0]%mat[1]==0)&&(mat[2]%mat[1]==0)&&(mat[4]%mat[1]==0)&&(mat[0]>=2)&&(mat[2]>=2)&&(mat[4]>=2)) { //024
				mat[0] /= mat[1];
				mat[2] /= mat[1];
				mat[4] /= mat[1];
				mat[1] = 0;
				streak +=2;
				return true;
			}
			else if((mat[0]%mat[1]==0)&&(mat[2]%mat[1]==0)&&(mat[0]>=2)&&(mat[4]>=2)) { //02
				mat[0] /= mat[1];
				mat[2] /= mat[1];
				mat[1] = 0;
				streak++;
				return true;
			}
			else if((mat[0]%mat[1]==0)&&(mat[4]%mat[1]==0)&&(mat[0]>=2)&&(mat[4]>=2)) { //04
				mat[0] /= mat[1];
				mat[4] /= mat[1];
				mat[1] = 0;
				streak++;
				return true;
			}
			else if((mat[2]%mat[1]==0)&&(mat[4]%mat[1]==0)&&(mat[2]>=2)&&(mat[4]>=2)) { //24
				mat[2] /= mat[1];
				mat[4] /= mat[1];
				mat[1] = 0;
				streak++;
				return true;
			}
			else if((mat[0]%mat[1]==0)&&(mat[0]>=2)){ //0
				mat[0] /=mat[1];
				mat[1] = 0;
				return true;
			}
			else if((mat[2]%mat[1]==0)&&(mat[2]>=2)) { //2
				mat[2] /= mat[1];
				mat[1] = 0;
				return true;
			}	
			else if((mat[4]%mat[1]==0)&&(mat[4]>=2)) { //4
				mat[4] /= mat[1];
				mat[1] = 0;
				return true;
			}
		}
		return false;
	}
	private boolean reorder2() { //1-5
		if(mat[2]>=2) {
			if((mat[2]%mat[1]==0)&&(mat[2]%mat[5]==0)&&(mat[1]>=2)&&(mat[5]>=2)) {
				int m = mat[2]/mat[1];
				int n = mat[2]/mat[5];
				mat[1] = 0;
				mat[5] = 0;
				mat[2] = m>n?n:m;
				streak = streak + 2;
				return true;
			}
			else if((mat[1]%mat[2]==0)&&(mat[5]%mat[2]==0)&&(mat[1]>=2)&&(mat[5]>=2)) { //15
				mat[1] /= mat[2];
				mat[5] /= mat[2];
				mat[2] = 0;
				streak++;
				return true;
			}
			else if((mat[1]%mat[2]==0)&&(mat[1]>=2)){ //1
				mat[1] /=mat[2];
				mat[2] = 0;
				return true;
			}
			else if((mat[5]%mat[2]==0)&&(mat[5]>=2)) { //5
				mat[5] /= mat[2];
				mat[2] = 0;
				return true;
			}
		}
		return false;
	}
	private boolean reorder3() { //0-4-6
		if(mat[3]>=2) {
			if((mat[3]%mat[0]==0)&&(mat[3]%mat[4]==0)&&(mat[3]%mat[6]==0)&&(mat[0]>=2)&&(mat[4]>=2)&&(mat[6]>=2)) {
				int m = mat[3]/mat[0];
				int n = mat[3]/mat[4];
				int o = mat[3]/mat[6];
				mat[0] = 0;
				mat[4] = 0;
				mat[6] = 0;
				mat[3] = (m<n)?((m<o?m:o)):(n<o?n:o);
				streak = streak + 3;
				return true;
			}
			else if((mat[0]%mat[3]==0)&&(mat[4]%mat[3]==0)&&(mat[6]%mat[3]==0)&&(mat[0]>=2)&&(mat[4]>=2)&&(mat[6]>=2)) { //046
				mat[0] /= mat[3];
				mat[4] /= mat[3];
				mat[6] /= mat[3];
				mat[3] = 0;
				streak += 2;
				return true;
			}
			else if((mat[0]%mat[3]==0)&&(mat[4]%mat[3]==0)&&(mat[0]>=2)&&(mat[4]>=2)) { //04
				mat[0] /= mat[3];
				mat[4] /= mat[3];
				mat[3] = 0;
				streak++;
				return true;
			}
			else if((mat[0]%mat[3]==0)&&(mat[6]%mat[3]==0)&&(mat[0]>=2)&&(mat[6]>=2)) { //06
				mat[0] /= mat[3];
				mat[6] /= mat[3];
				mat[3] = 0;
				streak++;
				return true;
			}
			else if((mat[4]%mat[3]==0)&&(mat[6]%mat[3]==0)&&(mat[4]>=2)&&(mat[6]>=2)) { //46
				mat[4] /= mat[3];
				mat[6] /= mat[3];
				mat[3] = 0;
				streak++;
				return true;
			}
			else if((mat[0]%mat[3]==0)&&(mat[0]>=2)){ //0
				mat[0] /=mat[3];
				mat[3] = 0;
				return true;
			}
			else if((mat[4]%mat[3]==0)&&(mat[4]>=2)) { //4
				mat[4] /= mat[3];
				mat[3] = 0;
				return true;
			}
			else if((mat[6]%mat[3]==0)&&(mat[6]>=2)) { //6
				mat[6] /= mat[3];
				mat[3] = 0;
				return true;
			}
		}
		return false;
	}
	private boolean reorder4() {//1-3-5-7
		if(mat[4]>=2) {
			if((mat[4]%mat[1]==0)&&(mat[4]%mat[3]==0)&&(mat[4]%mat[5]==0)&&(mat[4]%mat[7]==0)
					&&(mat[1]>=2)&&(mat[3]>=2)&&(mat[5]>=2)&&(mat[7]>=2)) {
				int m = mat[4]/mat[1];
				int n = mat[4]/mat[3];
				int o = mat[4]/mat[5];
				int p = mat[4]/mat[7];
				mat[1] = 0;
				mat[3] = 0;
				mat[5] = 0;
				mat[7] = 0;
				mat[4] = ((m<n)?m:n)<((o<p)?o:p)?((m<n)?m:n):((o<p)?o:p); 
				
			}
			else if((mat[1]%mat[4]==0)&&(mat[3]%mat[4]==0)&&(mat[5]%mat[4]==0)&&(mat[7]%mat[4]==0)
					&&(mat[1]>=2)&&(mat[3]>=2)&&(mat[5]>=2)&&(mat[7]>=2)) { //1357
				mat[1] /= mat[4];
				mat[3] /= mat[4];
				mat[5] /= mat[4];
				mat[7] /= mat[4];
				mat[4] = 0;
				streak += 3;
				return true;
			}
			else if((mat[1]%mat[4]==0)&&(mat[3]%mat[4]==0)&&(mat[5]%mat[4]==0)&&(mat[1]>=2)&&(mat[3]>=2)&&(mat[5]>=2)) { //135
				mat[1] /= mat[4];
				mat[3] /= mat[4];
				mat[5] /= mat[4];
				mat[4] = 0;
				streak += 2;
				return true;
			}
			else if((mat[1]%mat[4]==0)&&(mat[3]%mat[4]==0)&&(mat[7]%mat[4]==0)&&(mat[1]>=2)&&(mat[3]>=2)&&(mat[7]>=2)) { //137
				mat[1] /= mat[4];
				mat[3] /= mat[4];
				mat[7] /= mat[4];
				mat[4] = 0;
				streak += 2;
				return true;
			}
			else if((mat[1]%mat[4]==0)&&(mat[5]%mat[4]==0)&&(mat[7]%mat[4]==0)&&(mat[1]>=2)&&(mat[5]>=2)&&(mat[7]>=2)) { //157
				mat[1] /= mat[4];
				mat[5] /= mat[4];
				mat[7] /= mat[4];
				mat[4] = 0;
				streak += 2;
				return true;
			}
			else if((mat[3]%mat[4]==0)&&(mat[5]%mat[4]==0)&&(mat[7]%mat[4]==0)&&(mat[3]>=2)&&(mat[5]>=2)&&(mat[7]>=2)) { //357
				mat[3] /= mat[4];
				mat[5] /= mat[4];
				mat[7] /= mat[4];
				mat[4] = 0;
				streak += 2;
				return true;
			}
			else if((mat[1]%mat[4]==0)&&(mat[3]%mat[4]==0)&&(mat[1]>=2)&&(mat[3]>=2)) { //13
				mat[1] /= mat[4];
				mat[3] /= mat[4];
				mat[4] = 0;
				streak ++;
				return true;
			}
			else if((mat[1]%mat[4]==0)&&(mat[5]%mat[4]==0)&&(mat[1]>=2)&&(mat[5]>=2)) { //15
				mat[1] /= mat[4];
				mat[5] /= mat[4];
				mat[4] = 0;
				streak ++;
				return true;
			}
			else if((mat[1]%mat[4]==0)&&(mat[7]%mat[4]==0)&&(mat[1]>=2)&&(mat[7]>=2)) { //17
				mat[1] /= mat[4];
				mat[7] /= mat[4];
				mat[4] = 0;
				streak++;
				return true;
			}
			else if((mat[3]%mat[4]==0)&&(mat[5]%mat[4]==0)&&(mat[3]>=2)&&(mat[5]>=2)) { //35
				mat[3] /= mat[4];
				mat[5] /= mat[4];
				mat[4] = 0;
				streak++;
				return true;
			}
			else if((mat[3]%mat[4]==0)&&(mat[7]%mat[4]==0)&&(mat[3]>=2)&&(mat[7]>=2)) { //37
				mat[3] /= mat[4];
				mat[7] /= mat[4];
				mat[4] = 0;
				streak++;
				return true;
			}
			else if((mat[5]%mat[4]==0)&&(mat[7]%mat[4]==0)&&(mat[5]>=2)&&(mat[7]>=2)) { //57
				mat[5] /= mat[4];
				mat[7] /= mat[4];
				mat[4] = 0;
				streak++;
				return true;
			}
			else if((mat[1]%mat[4]==0)&&(mat[1]>=2)){ //1
				mat[1] /=mat[4];
				mat[4] = 0;
				return true;
			}
			else if((mat[3]%mat[4]==0)&&(mat[3]>=2)) { //3
				mat[3] /= mat[4];
				mat[4] = 0;
				return true;
			}
			else if((mat[5]%mat[4]==0)&&(mat[5]>=2)) { //5
				mat[5] /= mat[4];
				mat[4] = 0;
				return true;
			}
			else if((mat[7]%mat[4]==0)&&(mat[7]>=2)) { //7
				mat[7] /= mat[4];
				mat[4] = 0;
				return true;
			}
		}
		return false;
	}
	private boolean reorder5() { //2-4-8
		if(mat[5]>=2) {
			if((mat[5]%mat[2]==0)&&(mat[5]%mat[4]==0)&&(mat[5]%mat[8]==0)&&(mat[2]>=2)&&(mat[4]>=2)&&(mat[8]>=2)) {
				int m = mat[5]/mat[2];
				int n = mat[5]/mat[4];
				int o = mat[5]/mat[8];
				mat[2] = 0;
				mat[4] = 0;
				mat[8] = 0;
				mat[5] = (m<n)?((m<o?m:o)):(n<o?n:o);
				streak = streak + 3;
				return true;
			}
			else if((mat[2]%mat[5]==0)&&(mat[4]%mat[5]==0)&&(mat[8]%mat[5]==0)&&(mat[2]>=2)&&(mat[4]>=2)&&(mat[8]>=2)) { //248
				mat[2] /= mat[5];
				mat[4] /= mat[5];
				mat[8] /= mat[5];
				mat[5] = 0;
				streak += 2;
				return true;
			}
			else if((mat[2]%mat[5]==0)&&(mat[4]%mat[5]==0)&&(mat[2]>=2)&&(mat[4]>=2)) { //24
				mat[2] /= mat[5];
				mat[4] /= mat[5];
				mat[5] = 0;
				streak++;
				return true;
			}
			else if((mat[2]%mat[5]==0)&&(mat[8]%mat[5]==0)&&(mat[2]>=2)&&(mat[8]>=2)) { //28
				mat[2] /= mat[5];
				mat[8] /= mat[5];
				mat[5] = 0;
				streak++;
				return true;
			}
			else if((mat[4]%mat[5]==0)&&(mat[8]%mat[5]==0)&&(mat[4]>=2)&&(mat[8]>=2)) { //48
				mat[4] /= mat[5];
				mat[8] /= mat[5];
				mat[5] = 0;
				streak++;
				return true;
			}
			else if((mat[2]%mat[5]==0)&&(mat[2]>=2)){ //2
				mat[2] /=mat[5];
				mat[5] = 0;
				return true;
			}
			else if((mat[4]%mat[5]==0)&&(mat[4]>=2)) { //4
				mat[4] /= mat[5];
				mat[5] = 0;
				return true;
			}
			else if((mat[8]%mat[5]==0)&&(mat[8]>=2)) { //8
				mat[8] /= mat[5];
				mat[5] = 0;
				return true;
			}
		}
		return false;
	}
	private boolean reorder6() { //3-7
		if(mat[6]>=2) {
			if((mat[6]%mat[3]==0)&&(mat[6]%mat[7]==0)&&(mat[3]>=2)&&(mat[7]>=2)) {
				int m = mat[6]/mat[3];
				int n = mat[6]/mat[7];
				mat[3] = 0;
				mat[7] = 0;
				mat[6] = m>n?n:m;
				streak = streak + 2;
				return true;
			}
			else if((mat[3]%mat[6]==0)&&(mat[7]%mat[6]==0)&&(mat[3]>=2)&&(mat[7]>=2)) { //37
				mat[3] /= mat[6];
				mat[7] /= mat[6];
				mat[6] = 0;
				streak ++;
				return true;
			}
			else if((mat[3]%mat[6]==0)&&(mat[3]>=2)){ //3
				mat[3] /=mat[6];
				mat[6] = 0;
				return true;
			}
			else if((mat[7]%mat[6]==0)&&(mat[7]>=2)) { //7
				mat[7] /= mat[6];
				mat[6] = 0;
				return true;
			}
		}
		return false;
	}
	private boolean reorder7() { //4-6-8
		if(mat[7]>=2) {
			if((mat[7]%mat[4]==0)&&(mat[7]%mat[6]==0)&&(mat[7]%mat[8]==0)&&(mat[4]>=2)&&(mat[6]>=2)&&(mat[8]>=2)) {
				int m = mat[7]/mat[4];
				int n = mat[7]/mat[6];
				int o = mat[7]/mat[8];
				mat[4] = 0;
				mat[6] = 0;
				mat[8] = 0;
				mat[7] = (m<n)?((m<o?m:o)):(n<o?n:o);
				streak = streak + 3;
				return true;
			}
			else if((mat[4]%mat[7]==0)&&(mat[6]%mat[7]==0)&&(mat[8]%mat[7]==0)&&(mat[4]>=2)&&(mat[6]>=2)&&(mat[8]>=2)) { //468
				mat[4] /= mat[7];
				mat[6] /= mat[7];
				mat[8] /= mat[7];
				streak += 2;
				mat[7] = 0;
				return true;
			}
			else if((mat[4]%mat[7]==0)&&(mat[6]%mat[7]==0)&&(mat[4]>=2)&&(mat[6]>=2)) { //46
				mat[4] /= mat[7];
				mat[6] /= mat[7];
				mat[7] = 0;
				streak++;
				return true;
			}
			else if((mat[4]%mat[7]==0)&&(mat[8]%mat[7]==0)&&(mat[6]>=2)&&(mat[8]>=2)) { //48
				mat[4] /= mat[7];
				mat[8] /= mat[7];
				mat[7] = 0;
				streak++;
				return true;
			}
			else if((mat[6]%mat[7]==0)&&(mat[8]%mat[7]==0)&&(mat[6]>=2)&&(mat[8]>=2)) { //68
				mat[6] /= mat[7];
				mat[8] /= mat[7];
				mat[7] = 0;
				streak++;
				return true;
			}
			else if((mat[4]%mat[7]==0)&&(mat[4]>=2)){ //4
				mat[4] /=mat[7];
				mat[7] = 0;
				return true;
			}
			else if((mat[6]%mat[7]==0)&&(mat[6]>=2)) { //6
				mat[6] /= mat[7];
				mat[7] = 0;
				return true;
			}
			else if((mat[8]%mat[7]==0)&&(mat[8]>=2)) { //8
				mat[8] /= mat[7];
				mat[7] = 0;
				return true;
			}
		}
		return false;
	}
	private boolean reorder8() { //5-7
		if(mat[8]>=2) {
			if((mat[8]%mat[5]==0)&&(mat[8]%mat[7]==0)&&(mat[5]>=2)&&(mat[7]>=2)) {
				int m = mat[8]/mat[5];
				int n = mat[8]/mat[7];
				mat[5] = 0;
				mat[7] = 0;
				mat[8] = m>n?n:m;
				streak = streak + 2;
				return true;
			}
			else if((mat[5]%mat[8]==0)&&(mat[7]%mat[8]==0)&&(mat[5]>=2)&&(mat[7]>=2)) {
				mat[5] /= mat[8];
				mat[7] /= mat[8];
				mat[8] = 0;
				streak++;
				return true;
			}
			else if((mat[5]%mat[8]==0)&&(mat[5]>=2)){ //5
				mat[5] /=mat[8];
				mat[8] = 0;
				return true;
			}
			else if((mat[7]%mat[8]==0)&&(mat[7]>=2)) { //7
				mat[7] /= mat[8];
				mat[8] = 0;
				return true;
			}
		}
		return false;
	}
	private boolean reorder(){
		streak = 0;
		switch(place) {
		case(1):if(reorder0()) {
			streak++;
			System.out.println("Reordered at position 1");
			printMatrix();
			}
		break;
		case(2):if(reorder1()) {
			streak++;
			System.out.println("Reordered at position 2");
			printMatrix();
		}
		break;
		case(3):if(reorder2()) {
			streak++;
			System.out.println("Reordered at position 3");
			printMatrix();
		}
		break;
		case(4):if(reorder3()) {
			streak++;
			System.out.println("Reordered at position 4");
			printMatrix();
		}
		break;
		case(5):if(reorder4()){
			streak++;
			System.out.println("Reordered at position 5");
			printMatrix();
		}
		break;
		case(6):if(reorder5()){
			streak++;
			System.out.println("Reordered at position 6");
			printMatrix();
		}
		break;
		case(7):if(reorder6()){
			streak++;
			System.out.println("Reordered at position 7");
			printMatrix();
		}
		break;
		case(8):if(reorder7()){
			streak++;
			System.out.println("Reordered at position 8");
			printMatrix();
		}
		break;
		case(9):if(reorder8()){
			streak++;
			System.out.println("Reordered at position 9");
			printMatrix();
		}
		break;
		}
		
		for(int i = 0; i <9; i++) {
			if(reorder0()) {
				streak++;
				System.out.println("Reordered at position 1");
				printMatrix();
				continue;
			}
			else if(reorder1()) {
				streak++;
				System.out.println("Reordered at position 2");
				printMatrix();
				continue;
			}
			else if(reorder2()) {
				streak++;
				System.out.println("Reordered at position 3");
				printMatrix();
				continue;
			}
			else if(reorder3()) {
				streak++;
				System.out.println("Reordered at position 4");
				printMatrix();
				continue;
			}
			else if(reorder4()) {
				streak++;
				System.out.println("Reordered at position 5");
				printMatrix();
				continue;
			}
			else if(reorder5()) {
				streak++;
				System.out.println("Reordered at position 6");
				printMatrix();
				continue;
			}
			else if(reorder6()) {
				streak++;
				System.out.println("Reordered at position 7");
				printMatrix();
				continue;
			}
			else if(reorder7()) {
				streak++;
				System.out.println("Reordered at position 8");
				printMatrix();
				continue;
			}
			else if(reorder8()) {
				streak++;
				System.out.println("Reordered at position 9");
				printMatrix();
				continue;
			}
			else {
				printStreak();
				break;
			}
		}
		if(streak!=0)
			return true;
		return false;
	}
	private void nextValues() {
		int index = 1;
		switch(levelSelector()) {
		case(1):	index = random.nextInt(values1.length);
		break;
		case(2):	index = random.nextInt(values2.length);
		break;
		case(3):	index = random.nextInt(values3.length);
		break;
		case(4):	index = random.nextInt(values4.length);
		break;
		case(5):	index = random.nextInt(values5.length);
		break;
		case(6):	index = random.nextInt(values6.length);
		break;
		default:	index = random.nextInt(values.length);
		}
		for(int i = 0; i<4; i++) {
			nextValues[i] = nextValues[i+1];
		}
		nextValues[4] = values[index];
	}
	private void printMatrix() {
		System.out.print("\t");
		for(int i = 0; i<3; i++) {
			if(mat[i]<=1)
				System.out.print(" _ ");
			else
				System.out.print(" "+mat[i]+" ");
		}
		System.out.println();
		System.out.print("\t");
		for(int i = 3; i<6; i++) {
			if(mat[i]<=1)
				System.out.print(" _ ");
			else
				System.out.print(" "+mat[i]+" ");
		}
		System.out.println();
		System.out.print("\t");
		for(int i = 6; i<9; i++) {
			if(mat[i]<=1)
				System.out.print(" _ ");
			else
				System.out.print(" "+mat[i]+" ");
		}
		System.out.println();
	}
	private void printKeep() {
		if(keep==0)
			System.out.println("Keep:  _ ");
		else
			System.out.println("Keep: "+keep);
	}
	private void printStreak() {
		if(streak>1)
			System.out.print("Streak of: "+streak+"\t");
		switch(streak) {
		case(2):	System.out.println("Good");
		score +=10;
		break;
		case(3):	System.out.println("Great");
		score +=20;
		break;
		case(4):	System.out.println("Very Good");
		score +=30;
		break;
		case(5):	System.out.println("Impressive");
		score +=40;
		break;
		case(6):	System.out.println("Fabulous");
		score +=50;
		break;
		case(7):	System.out.println("Fantastic");
		score +=60;
		break;
		case(8):	System.out.println("Excellent");
		score +=70;
		break;		
		}
	}	
	private void printScore() {
		System.out.println("Score : "+score+"\tHigh Score: "+highScore);		
	}
	private void printNext() {
		nextValues();
		System.out.print("Next Values are: ");
		for(int i = 0; i<5; i++)
			System.out.print(nextValues[i] + " ");
		System.out.println();
	}
	public void start() {
		endImmediate = 0;
		System.out.println("\t\t!!!!! Divide !!!!!\t\t\n");
		gameCount++;
		if(gameCount==1) {
			System.out.print("Enter Your Name: ");
			name = s.nextLine();
			System.out.println();
			System.out.println("\t\tWelcome "+name);
		}
		System.out.println("Instructions:\n\t1. Enter 1-9 to put the value in matrix."
				+ "\n\t2. Enter 0 for keeping the value."
				+ "\n\t3.Enter 10 for using kept value");
		System.out.print("Press 1 to start: ");
		if(s.nextInt() == 1) {
			System.out.println();
			printMatrix();
			printKeep();
			printScore();
			for(int i = 0; i<4; i++)
				nextValues();
			printNext();
		}
		else {
			endImmediate = 1;
			end();
		}

	}
	public void takeInput(){
		int play = 1;
		do {
			System.out.print("Where to place: ");
			place = s.nextInt();
			if(place==999&&play!=0) {
				System.out.println("!!!!Exiting!!!!");
				play=0;
			}
			else if(place <0 || place >10) {
				System.out.println("Enter valid Place (0-10)");
			}
			else
				play = 0;
		}while(play==1);
		if(place==999)
			endImmediate = 1;
		else
			inPlay();
	}
	private void inPlay() {
		if(place==0 && kept == 1) {
			System.out.println("A value is already kept!! Value in KEEP: "+keep);
			System.out.println("Enter Again");
			takeInput();
		}
		else if(place == 0 && kept ==0) {
			keep = nextValues[0];
			kept = 1;
			printMatrix();
			printKeep();
			printScore();
			printNext();
		}
		else if(place==10 && kept ==0) {
			System.out.println("KEEP is empty!!\nEnter Again");
		}
		else if(place==10 && kept ==1){
			System.out.print("Where to place kept value : ");
			int keepPlace = s.nextInt();
			if(keepPlace<1 || keepPlace>9) {
				System.out.println("Invalid Place!!\nTry Again");
				takeInput();
			}
			else if(!isVacant(keepPlace-1)) {
				System.out.println("Place not empty!!\nEnter Again");
				takeInput();
			}
			else {
				mat[keepPlace-1] = keep;
				score = score + keep;
				if(reorder())
					score = score + nextValues[0]*streak*levelSelector();
				keep = 0;
				kept = 0;
				printMatrix();
				printKeep();
				printScore();
				printNext();
				
			}				
		}
		else {
			if(!isVacant(place-1)) {
				System.out.println("Place not empty!!\nEnter Again");
				takeInput();				
			}
			else {				
				mat[place-1] = nextValues[0];
				printMatrix();
				//printKeep();
				if(reorder())
					score = score + nextValues[0]*streak*levelSelector();
				printKeep();
				printScore();
				printNext();
			}
		}
	}
	public boolean end() { 
		if(endImmediate!=1) {
			for(int i = 0; i < 9;i++) {
				if(mat[i]<=1)
					return false;
			}}
		else
			System.out.println("~~Game Over~~");
		System.out.println("Thanks for playing!!");
		System.out.println("Your Score: "+score);
		if(score>highScore) {
			System.out.println("!!!NEW HIGH SCORE!!!\n\t "+score);
			highScore = score;
			score = 0;
		}
		return true;
	}
	public boolean playAgain() {
		char ans = s.next().charAt(0);
		String dummy = s.nextLine();
		System.out.println();
		if(ans=='y'||ans=='Y')
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		Divide d1 = new Divide();
		//System.out.println("Divide");
		do{
			d1.start();
			while(!d1.end()) {
				d1.takeInput();
			}
			System.out.print("\nDo you want to Play Again (y/n): ");
	}while(d1.playAgain());
		System.out.println("\nHave A Nice Day!!");
	}

}
