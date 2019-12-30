#include<iostream>
#include<string>
#include<cstdlib>
using namespace std;

class Divide2 {
	private :
		 int mat[9] = {1,1,1,1,1,1,1,1,1};
		 int keep = 0;		 
		 int kept = 0;
		 int place = 0;
		 int endImmediate = 0;
		 long score = 0;
		 long highScore = 0;
		 int level = 1;
		 int streak = 0;
		 int gameCount = 0;
		 int nextValues[5] = {0,0,0,0,0};	
	//53, 59, 61, 67, 71, 73, 79, 83, 89, 97
	  	 int values[88] = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,
			21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,
			40,41,42,43,44,45,46,47,48,49,50,51,52,54,55,56,57,58,60,
			62,63,64,65,66,68,69,70,72,74,75,76,77,78,80,81,82,84,85,
			86,87,88,90,91,92,93,94,95,96,98,99};
		 int values1[23] = {2,3,4,5,6,7,8,9,10,12,3,14,15,16,2,18,20,21,5,22,
			4,24,25};
		 int values2[42] = {2,3,4,5,6,7,8,9,3,10,11,2,12,13,14,1,4,5,16,17,7,
			18,19,20,21,22,24,25,26,27,28,30,13,32,33,17,34,35,36,38,
			39,40};
		 int values3[66] = {2,3,4,5,6,7,8,9,10,2,4,8,9,10,11,12,15,13,16,14,
			17,15,16,17,18,19,20,21,22,23,24,25,29,26,27,28,29,30,32,
			23,33,34,35,36,19,38,39,40,42,44,45,46,48,49,50,51,52,54,
			55,56,57,58,57,20,13,60};
		 int values4[85] = {2,3,4,5,6,7,8,9,10,11,12,13,14,2,15,3,16,17,7,18,
			11,19,20,12,29,21,22,23,24,25,27,26,27,3,28,29,30,31,16,32,
			33,34,35,36,37,38,39,40,42,44,45,3,2,46,48,49,50,51,52,2,54,
			55,56,17,19,11,13,57,58,60,62,63,64,65,66,68,70,72,74,75,76,
			77,78,80,20};
		 int values5[108] = {2,3,4,5,6,7,8,9,10,11,5,2,12,13,14,3,17,15,16,17,
			18,19,20,21,22,23,24,15,25,26,27,28,29,30,2,31,32,33,34,35,
			36,3,13,37,38,39,40,41,42,43,44,20,21,27,4,45,46,47,48,16,
			26,49,50,51,52,54,55,56,57,58,60,62,25,17,63,64,19,65,66,
			68,69,70,72,12,74,75,76,77,78,13,80,81,82,84,85,86,87,88,
			90,91,92,93,94,95,96,98,99,21};
		 int values6[111] = {2,3,4,5,6,7,8,9,10,3,2,11,12,13,4,14,11,15,3,16,17,
			18,19,20,21,22,23,24,25,26,27,28,5,29,30,31,32,17,33,34,13,
			35,36,37,7,13,38,39,40,41,42,32,43,44,13,2,45,46,10,47,48,49,
			50,51,52,54,55,17,56,57,58,60,62,63,64,65,66,68,69,70,45,72,
			74,75,19,76,3,77,36,78,3,80,81,82,84,85,86,87,2,88,90,91,19,
			92,93,94,95,96,98,3,99};

		int levelSelector() {
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
		bool isVacant(int p) {
		if(mat[p]>1)
			return false;
		return true;
	}
		bool reorder0() { //1-3
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
		bool reorder1() { //0-2-4
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
		bool reorder2() { //1-5
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
		bool reorder3() { //0-4-6
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
				streak = streak+2;
				mat[3] = 0;
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
		bool reorder4() {//1-3-5-7
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
				streak = streak + 3;
				mat[4] = 0;
				return true;
			}
			else if((mat[1]%mat[4]==0)&&(mat[3]%mat[4]==0)&&(mat[5]%mat[4]==0)&&(mat[1]>=2)&&(mat[3]>=2)&&(mat[5]>=2)) { //135
				mat[1] /= mat[4];
				mat[3] /= mat[4];
				mat[5] /= mat[4];
				mat[4] = 0;
				streak = streak + 2;
				return true;
			}
			else if((mat[1]%mat[4]==0)&&(mat[3]%mat[4]==0)&&(mat[7]%mat[4]==0)&&(mat[1]>=2)&&(mat[3]>=2)&&(mat[7]>=2)) { //137
				mat[1] /= mat[4];
				mat[3] /= mat[4];
				mat[7] /= mat[4];
				streak = streak + 2;
				mat[4] = 0;
				return true;
			}
			else if((mat[1]%mat[4]==0)&&(mat[5]%mat[4]==0)&&(mat[7]%mat[4]==0)&&(mat[1]>=2)&&(mat[5]>=2)&&(mat[7]>=2)) { //157
				mat[1] /= mat[4];
				mat[5] /= mat[4];
				mat[7] /= mat[4];
				mat[4] = 0;
				streak = streak + 2;
				return true;
			}
			else if((mat[3]%mat[4]==0)&&(mat[5]%mat[4]==0)&&(mat[7]%mat[4]==0)&&(mat[3]>=2)&&(mat[5]>=2)&&(mat[7]>=2)) { //357
				mat[3] /= mat[4];
				mat[5] /= mat[4];
				mat[7] /= mat[4];
				mat[4] = 0;
				streak = streak + 2;
				return true;
			}
			else if((mat[1]%mat[4]==0)&&(mat[3]%mat[4]==0)&&(mat[1]>=2)&&(mat[3]>=2)) { //13
				mat[1] /= mat[4];
				mat[3] /= mat[4];
				mat[4] = 0;
				streak++;
				return true;
			}
			else if((mat[1]%mat[4]==0)&&(mat[5]%mat[4]==0)&&(mat[1]>=2)&&(mat[5]>=2)) { //15
				mat[1] /= mat[4];
				mat[5] /= mat[4];
				mat[4] = 0;
				streak++;
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
		bool reorder5() { //2-4-8
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
				streak = streak + 2;
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
		bool reorder6() { //3-7
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
				streak++;
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
		bool reorder7() { //4-6-8
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
				mat[7] = 0;
				streak = streak + 2;
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
		bool reorder8() { //5-7
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
		bool reorder(){
		streak = 0;
		switch(place){
			case(1):if(reorder0()) {
				streak++;
				cout<<"Reordered at position 1"<<endl;
				printMatrix();
			}
			break;
			case(2):if(reorder1()) {
				streak++;
				cout<<"Reordered at position 2"<<endl;
				printMatrix();
			}
			break;
			case(3):if(reorder2()) {
				streak++;
				cout<<"Reordered at position 3"<<endl;
				printMatrix();
			}
			break;
			case(4):if(reorder3()) {
				streak++;
				cout<<"Reordered at position 4"<<endl;
				printMatrix();
			}
			break;
			case(5):if(reorder4()) {
				streak++;
				cout<<"Reordered at position 5"<<endl;
				printMatrix();
			}
			break;
			case(6):if(reorder5()) {
				streak++;
				cout<<"Reordered at position 6"<<endl;
				printMatrix();
			}
			break;
			case(7):if(reorder6()) {
				streak++;
				cout<<"Reordered at position 7"<<endl;
				printMatrix();
			}
			break;
			case(8):if(reorder7()) {
				streak++;
				cout<<"Reordered at position 8"<<endl;
				printMatrix();
			}
			break;
			case(9):if(reorder8()) {
				streak++;
				cout<<"Reordered at position 9"<<endl;
				printMatrix();
			}
			break;
		}
		int i;
		for(i = 0; i <9; i++) {
			if(reorder0()) {
				streak++;
				cout<<"Reordered at position 1"<<endl;
				printMatrix();
				continue;
			}
			else if(reorder1()) {
				streak++;
				cout<<"Reordered at position 2"<<endl;
				printMatrix();
				continue;
			}
			else if(reorder2()) {
				streak++;
				cout<<"Reordered at position 3"<<endl;
				printMatrix();
				continue;
			}
			else if(reorder3()) {
				streak++;
				cout<<"Reordered at position 4"<<endl;
				printMatrix();
				continue;
			}
			else if(reorder4()) {
				streak++;
				cout<<"Reordered at position 5"<<endl;
				printMatrix();
				continue;
			}
			else if(reorder5()) {
				streak++;
				cout<<"Reordered at position 6"<<endl;
				printMatrix();
				continue;
			}
			else if(reorder6()) {
				streak++;
				cout<<"Reordered at position 7"<<endl;
				printMatrix();
				continue;
			}
			else if(reorder7()) {
				streak++;
				cout<<"Reordered at position 8"<<endl;
				printMatrix();
				continue;
			}
			else if(reorder8()) {
				streak++;
				cout<<"Reordered at position 9"<<endl;
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
		void nextValuesGen() {
		int index = 1;
		int size = sizeof(values)/sizeof(values[0]);
		switch(levelSelector()) {
		case(1):	size = sizeof(values1)/sizeof(values1[0]);
		index = rand() % size;
		break;		
		case(2):	size = sizeof(values2)/sizeof(values2[0]);
		index = rand() % size;
		break;
		case(3):	size = sizeof(values3)/sizeof(values3[0]);
		index = rand() % size;
		break;
		case(4):	size = sizeof(values4)/sizeof(values4[0]);
		index = rand() % size;
		break;
		case(5):	size = sizeof(values5)/sizeof(values5[0]);
		index = rand() % size;
		break;
		case(6):	size = sizeof(values6)/sizeof(values6[0]);
		index = rand() % size;
		break;
		default:	index = rand() % size;
		}
		int i;
		for(i = 0; i<4; i++) {
			nextValues[i] = nextValues[i+1];
		}
		nextValues[4] = values[index];
	}
		void printMatrix() {
		cout<<"\t";
		for(int i = 0; i<3; i++) {
			if(mat[i]<=1)
				cout<<" _ ";
			else
				cout<<" "<<mat[i]<<" ";
		}
		cout<<endl;
		cout<<"\t";
		for(int i = 3; i<6; i++) {
			if(mat[i]<=1)
				cout<<" _ ";
			else
				cout<<" "<<mat[i]<<" ";
		}
		cout<<endl;
		cout<<"\t";
		for(int i = 6; i<9; i++) {
			if(mat[i]<=1)
				cout<<" _ ";
			else
				cout<<" "<<mat[i]<<" ";
		}
		cout<<endl;
	}
		void printKeep() {
		if(keep==0)
			cout<<"Keep:  _ "<<endl;
		else
			cout<<"Keep: "<<keep<<endl;
	}
		void printStreak() {
		if(streak>1)
			cout<<"Streak of: "<<streak<<"\t";
		switch(streak) {
		case(2):	cout<<"Good"<<endl;
		score +=10;
		break;
		case(3):	cout<<"Great"<<endl;
		score +=20;
		break;
		case(4):	cout<<"Very Good"<<endl;
		score +=30;
		break;
		case(5):	cout<<"Impressive"<<endl;
		score +=40;
		break;
		case(6):	cout<<"Fabulous"<<endl;
		score +=50;
		break;
		case(7):	cout<<"Fantastic"<<endl;
		score +=60;
		break;
		case(8):	cout<<"Excellent"<<endl;
		score +=70;
		break;		
		}
	}	
		void printScore() {
		cout<<"Score : "<<score<<"\tHigh Score :"<<highScore<<endl;
	}
		void printNext() {
		nextValuesGen();
		cout<<"Next Values are: ";
		int i;
		for(i = 0; i<5; i++)
			cout<<nextValues[i]<<" ";
		cout<<endl;
	}
		void inPlay() {
		if(place==0 && kept == 1) {
			cout<<"A value is already kept!! Value in KEEP: "<<keep<<endl;
			cout<<"Enter Again"<<endl;
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
			cout<<"KEEP is empty!!\nEnter Again"<<endl;
		}
		else if(place==10 && kept ==1){
			cout<<"Where to place kept value : ";
			int keepPlace = 0;
			cin>>keepPlace;
			if(keepPlace<1 || keepPlace>9) {
				cout<<"Invalid Place!!\nTry Again"<<endl;
				takeInput();
			}
			else if(!isVacant(keepPlace-1)) {
				cout<<"Place not empty!!\nEnter Again"<<endl;
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
				cout<<"Place not empty!!\nEnter Again"<<endl;
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
	public:
		string name = "";
		void start() {
		endImmediate = 0;
		gameCount++;
		cout<<endl;
		cout<<"\t\t!!!!! Divide !!!!!\t\t\n";
		if(gameCount==1){
			cout<<"Enter Your Name: ";
			getline(cin,name);
			cout<<endl;
			cout<<"\t\tWelcome "<<name<<endl;
		}
		cout<<"Instructions:\n\t1. Enter 1-9 to put the value in matrix.\n\t2. Enter 0 for keeping the value.\n\t3.Enter 10 for using kept value"<<endl;
		cout<<"Press 1 to start: ";
		int start = 0;
		cin>>start;
		if(start==1) {
			cout<<endl;
			printMatrix();
			printKeep();
			printScore();
			int i;
			for(i = 0; i<4; i++)
				nextValuesGen();
			printNext();
		}
		else{
			endImmediate = 1;
			end();
		}

	}
		void takeInput(){
		int play = 1;
		do {
			cout<<"Where to place: ";
			cin>>place;
			if(place==999&&play!=0) {
				cout<<"!!!!Exiting!!!!"<<endl;
				play=0;
			}
			else if(place <0 || place >10) {
				cout<<"Enter valid Place (0-10)"<<endl;
			}
			else
				play = 0;
		}while(play==1);
		if(place==999)
			endImmediate = 1;
		else
			inPlay();
	}		
		bool end() { 
		if(endImmediate!=1) {
			int i;
			for(i = 0; i < 9;i++) {
				if(mat[i]<=1)
					return false;
			}
		}
		else
			cout<<"~~Game Over~~"<<endl;
		cout<<"Thanks for playing!!"<<endl;
		cout<<"Your Score: "<<score<<endl;
		if(score>highScore) {
			cout<<"\t!!!NEW HIGH SCORE!!!\n\t "<<score<<endl;
			highScore = score;
			score = 0;
		}
		return true;
	}
		bool playAgain() {
		char ans;
		cin>>ans;
		if(ans=='y'||ans=='Y'){
			cout<<endl;
			return true;
		}
		else
			return false;
	}
		
	};
	 int main() {
		Divide2 d1;
		cout<<"Divide2"<<endl;
		do{
			d1.start();
			while(!d1.end()) {
				d1.takeInput();
			}
			cout<<"\nDo you want to Play Again (y/n): ";
		}while(d1.playAgain());
			cout<<"\nHave A Nice Day!!"<<endl;
		return 0;
	}
