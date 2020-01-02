/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DivideGame.java
 *
 * Created on Dec 30, 2019, 7:48:20 PM
 */

/**
 *
 * @author PIYUSH GUPTA
 */
import javax.swing.*;
import java.util.Random;
import java.util.Scanner;
public class DivideGame extends javax.swing.JFrame {

    Random random = new Random();
    private int mat[] = {1,1,1,1,1,1,1,1,1};
	private int keep = 0;
	private int kept = 0;
    private int keeping = 0;
	private int place = 0;
	private int endImmediate = 0;
	private long score = 0;
	private int level = 1;
	private int streak = 0;
	private long highScore = 0;
	public String name = "";
	private Scanner s = new Scanner(System.in);
	private int gameCount = 0;
    private int play = 0;
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
				mat[1] = 1;
				mat[3] = 1;
				mat[0] = m>n?n:m;
				streak = streak + 2;
				return true;
			}
			else if((mat[1]%mat[0]==0)&&(mat[3]%mat[0]==0)&&(mat[1]>=2)&&(mat[3]>=2)) { //13
				mat[1] /= mat[0];
				mat[3] /= mat[0];
				mat[0] = 1;
				streak++;
				return true;
			}
			else if((mat[1]%mat[0]==0)&&(mat[1]>=2)){ //1
				mat[1] /=mat[0];
				mat[0] = 1;
				return true;
			}
			else if((mat[3]%mat[0]==0)&&(mat[3]>=2)) { //3
				mat[3] /= mat[0];
				mat[0] = 1;
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
				mat[0] = 1;
				mat[2] = 1;
				mat[4] = 1;
				mat[1] = (m<n)?((m<o?m:o)):(n<o?n:o);
				streak = streak + 3;
				return true;
			}
			else if((mat[0]%mat[1]==0)&&(mat[2]%mat[1]==0)&&(mat[4]%mat[1]==0)&&(mat[0]>=2)&&(mat[2]>=2)&&(mat[4]>=2)) { //024
				mat[0] /= mat[1];
				mat[2] /= mat[1];
				mat[4] /= mat[1];
				mat[1] = 1;
				streak +=2;
				return true;
			}
			else if((mat[0]%mat[1]==0)&&(mat[2]%mat[1]==0)&&(mat[0]>=2)&&(mat[4]>=2)) { //02
				mat[0] /= mat[1];
				mat[2] /= mat[1];
				mat[1] = 1;
				streak++;
				return true;
			}
			else if((mat[0]%mat[1]==0)&&(mat[4]%mat[1]==0)&&(mat[0]>=2)&&(mat[4]>=2)) { //04
				mat[0] /= mat[1];
				mat[4] /= mat[1];
				mat[1] = 1;
				streak++;
				return true;
			}
			else if((mat[2]%mat[1]==0)&&(mat[4]%mat[1]==0)&&(mat[2]>=2)&&(mat[4]>=2)) { //24
				mat[2] /= mat[1];
				mat[4] /= mat[1];
				mat[1] = 1;
				streak++;
				return true;
			}
			else if((mat[0]%mat[1]==0)&&(mat[0]>=2)){ //0
				mat[0] /=mat[1];
				mat[1] = 1;
				return true;
			}
			else if((mat[2]%mat[1]==0)&&(mat[2]>=2)) { //2
				mat[2] /= mat[1];
				mat[1] = 1;
				return true;
			}
			else if((mat[4]%mat[1]==0)&&(mat[4]>=2)) { //4
				mat[4] /= mat[1];
				mat[1] = 1;
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
				mat[1] = 1;
				mat[5] = 1;
				mat[2] = m>n?n:m;
				streak = streak + 2;
				return true;
			}
			else if((mat[1]%mat[2]==0)&&(mat[5]%mat[2]==0)&&(mat[1]>=2)&&(mat[5]>=2)) { //15
				mat[1] /= mat[2];
				mat[5] /= mat[2];
				mat[2] = 1;
				streak++;
				return true;
			}
			else if((mat[1]%mat[2]==0)&&(mat[1]>=2)){ //1
				mat[1] /=mat[2];
				mat[2] = 1;
				return true;
			}
			else if((mat[5]%mat[2]==0)&&(mat[5]>=2)) { //5
				mat[5] /= mat[2];
				mat[2] = 1;
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
				mat[0] = 1;
				mat[4] = 1;
				mat[6] = 1;
				mat[3] = (m<n)?((m<o?m:o)):(n<o?n:o);
				streak = streak + 3;
				return true;
			}
			else if((mat[0]%mat[3]==0)&&(mat[4]%mat[3]==0)&&(mat[6]%mat[3]==0)&&(mat[0]>=2)&&(mat[4]>=2)&&(mat[6]>=2)) { //046
				mat[0] /= mat[3];
				mat[4] /= mat[3];
				mat[6] /= mat[3];
				mat[3] = 1;
				streak += 2;
				return true;
			}
			else if((mat[0]%mat[3]==0)&&(mat[4]%mat[3]==0)&&(mat[0]>=2)&&(mat[4]>=2)) { //04
				mat[0] /= mat[3];
				mat[4] /= mat[3];
				mat[3] = 1;
				streak++;
				return true;
			}
			else if((mat[0]%mat[3]==0)&&(mat[6]%mat[3]==0)&&(mat[0]>=2)&&(mat[6]>=2)) { //06
				mat[0] /= mat[3];
				mat[6] /= mat[3];
				mat[3] = 1;
				streak++;
				return true;
			}
			else if((mat[4]%mat[3]==0)&&(mat[6]%mat[3]==0)&&(mat[4]>=2)&&(mat[6]>=2)) { //46
				mat[4] /= mat[3];
				mat[6] /= mat[3];
				mat[3] = 1;
				streak++;
				return true;
			}
			else if((mat[0]%mat[3]==0)&&(mat[0]>=2)){ //0
				mat[0] /=mat[3];
				mat[3] = 1;
				return true;
			}
			else if((mat[4]%mat[3]==0)&&(mat[4]>=2)) { //4
				mat[4] /= mat[3];
				mat[3] = 1;
				return true;
			}
			else if((mat[6]%mat[3]==0)&&(mat[6]>=2)) { //6
				mat[6] /= mat[3];
				mat[3] = 1;
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
				mat[1] = 1;
				mat[3] = 1;
				mat[5] = 1;
				mat[7] = 1;
				mat[4] = ((m<n)?m:n)<((o<p)?o:p)?((m<n)?m:n):((o<p)?o:p);

			}
			else if((mat[1]%mat[4]==0)&&(mat[3]%mat[4]==0)&&(mat[5]%mat[4]==0)&&(mat[7]%mat[4]==0)
					&&(mat[1]>=2)&&(mat[3]>=2)&&(mat[5]>=2)&&(mat[7]>=2)) { //1357
				mat[1] /= mat[4];
				mat[3] /= mat[4];
				mat[5] /= mat[4];
				mat[7] /= mat[4];
				mat[4] = 1;
				streak += 3;
				return true;
			}
			else if((mat[1]%mat[4]==0)&&(mat[3]%mat[4]==0)&&(mat[5]%mat[4]==0)&&(mat[1]>=2)&&(mat[3]>=2)&&(mat[5]>=2)) { //135
				mat[1] /= mat[4];
				mat[3] /= mat[4];
				mat[5] /= mat[4];
				mat[4] = 1;
				streak += 2;
				return true;
			}
			else if((mat[1]%mat[4]==0)&&(mat[3]%mat[4]==0)&&(mat[7]%mat[4]==0)&&(mat[1]>=2)&&(mat[3]>=2)&&(mat[7]>=2)) { //137
				mat[1] /= mat[4];
				mat[3] /= mat[4];
				mat[7] /= mat[4];
				mat[4] = 1;
				streak += 2;
				return true;
			}
			else if((mat[1]%mat[4]==0)&&(mat[5]%mat[4]==0)&&(mat[7]%mat[4]==0)&&(mat[1]>=2)&&(mat[5]>=2)&&(mat[7]>=2)) { //157
				mat[1] /= mat[4];
				mat[5] /= mat[4];
				mat[7] /= mat[4];
				mat[4] = 1;
				streak += 2;
				return true;
			}
			else if((mat[3]%mat[4]==0)&&(mat[5]%mat[4]==0)&&(mat[7]%mat[4]==0)&&(mat[3]>=2)&&(mat[5]>=2)&&(mat[7]>=2)) { //357
				mat[3] /= mat[4];
				mat[5] /= mat[4];
				mat[7] /= mat[4];
				mat[4] = 1;
				streak += 2;
				return true;
			}
			else if((mat[1]%mat[4]==0)&&(mat[3]%mat[4]==0)&&(mat[1]>=2)&&(mat[3]>=2)) { //13
				mat[1] /= mat[4];
				mat[3] /= mat[4];
				mat[4] = 1;
				streak ++;
				return true;
			}
			else if((mat[1]%mat[4]==0)&&(mat[5]%mat[4]==0)&&(mat[1]>=2)&&(mat[5]>=2)) { //15
				mat[1] /= mat[4];
				mat[5] /= mat[4];
				mat[4] = 1;
				streak ++;
				return true;
			}
			else if((mat[1]%mat[4]==0)&&(mat[7]%mat[4]==0)&&(mat[1]>=2)&&(mat[7]>=2)) { //17
				mat[1] /= mat[4];
				mat[7] /= mat[4];
				mat[4] = 1;
				streak++;
				return true;
			}
			else if((mat[3]%mat[4]==0)&&(mat[5]%mat[4]==0)&&(mat[3]>=2)&&(mat[5]>=2)) { //35
				mat[3] /= mat[4];
				mat[5] /= mat[4];
				mat[4] = 1;
				streak++;
				return true;
			}
			else if((mat[3]%mat[4]==0)&&(mat[7]%mat[4]==0)&&(mat[3]>=2)&&(mat[7]>=2)) { //37
				mat[3] /= mat[4];
				mat[7] /= mat[4];
				mat[4] = 1;
				streak++;
				return true;
			}
			else if((mat[5]%mat[4]==0)&&(mat[7]%mat[4]==0)&&(mat[5]>=2)&&(mat[7]>=2)) { //57
				mat[5] /= mat[4];
				mat[7] /= mat[4];
				mat[4] = 1;
				streak++;
				return true;
			}
			else if((mat[1]%mat[4]==0)&&(mat[1]>=2)){ //1
				mat[1] /=mat[4];
				mat[4] = 1;
				return true;
			}
			else if((mat[3]%mat[4]==0)&&(mat[3]>=2)) { //3
				mat[3] /= mat[4];
				mat[4] = 1;
				return true;
			}
			else if((mat[5]%mat[4]==0)&&(mat[5]>=2)) { //5
				mat[5] /= mat[4];
				mat[4] = 1;
				return true;
			}
			else if((mat[7]%mat[4]==0)&&(mat[7]>=2)) { //7
				mat[7] /= mat[4];
				mat[4] = 1;
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
				mat[2] = 1;
				mat[4] = 1;
				mat[8] = 1;
				mat[5] = (m<n)?((m<o?m:o)):(n<o?n:o);
				streak = streak + 3;
				return true;
			}
			else if((mat[2]%mat[5]==0)&&(mat[4]%mat[5]==0)&&(mat[8]%mat[5]==0)&&(mat[2]>=2)&&(mat[4]>=2)&&(mat[8]>=2)) { //248
				mat[2] /= mat[5];
				mat[4] /= mat[5];
				mat[8] /= mat[5];
				mat[5] = 1;
				streak += 2;
				return true;
			}
			else if((mat[2]%mat[5]==0)&&(mat[4]%mat[5]==0)&&(mat[2]>=2)&&(mat[4]>=2)) { //24
				mat[2] /= mat[5];
				mat[4] /= mat[5];
				mat[5] = 1;
				streak++;
				return true;
			}
			else if((mat[2]%mat[5]==0)&&(mat[8]%mat[5]==0)&&(mat[2]>=2)&&(mat[8]>=2)) { //28
				mat[2] /= mat[5];
				mat[8] /= mat[5];
				mat[5] = 1;
				streak++;
				return true;
			}
			else if((mat[4]%mat[5]==0)&&(mat[8]%mat[5]==0)&&(mat[4]>=2)&&(mat[8]>=2)) { //48
				mat[4] /= mat[5];
				mat[8] /= mat[5];
				mat[5] = 1;
				streak++;
				return true;
			}
			else if((mat[2]%mat[5]==0)&&(mat[2]>=2)){ //2
				mat[2] /=mat[5];
				mat[5] = 1;
				return true;
			}
			else if((mat[4]%mat[5]==0)&&(mat[4]>=2)) { //4
				mat[4] /= mat[5];
				mat[5] = 1;
				return true;
			}
			else if((mat[8]%mat[5]==0)&&(mat[8]>=2)) { //8
				mat[8] /= mat[5];
				mat[5] = 1;
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
				mat[3] = 1;
				mat[7] = 1;
				mat[6] = m>n?n:m;
				streak = streak + 2;
				return true;
			}
			else if((mat[3]%mat[6]==0)&&(mat[7]%mat[6]==0)&&(mat[3]>=2)&&(mat[7]>=2)) { //37
				mat[3] /= mat[6];
				mat[7] /= mat[6];
				mat[6] = 1;
				streak ++;
				return true;
			}
			else if((mat[3]%mat[6]==0)&&(mat[3]>=2)){ //3
				mat[3] /=mat[6];
				mat[6] = 1;
				return true;
			}
			else if((mat[7]%mat[6]==0)&&(mat[7]>=2)) { //7
				mat[7] /= mat[6];
				mat[6] = 1;
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
				mat[4] = 1;
				mat[6] = 1;
				mat[8] = 1;
				mat[7] = (m<n)?((m<o?m:o)):(n<o?n:o);
				streak = streak + 3;
				return true;
			}
			else if((mat[4]%mat[7]==0)&&(mat[6]%mat[7]==0)&&(mat[8]%mat[7]==0)&&(mat[4]>=2)&&(mat[6]>=2)&&(mat[8]>=2)) { //468
				mat[4] /= mat[7];
				mat[6] /= mat[7];
				mat[8] /= mat[7];
				streak += 2;
				mat[7] = 1;
				return true;
			}
			else if((mat[4]%mat[7]==0)&&(mat[6]%mat[7]==0)&&(mat[4]>=2)&&(mat[6]>=2)) { //46
				mat[4] /= mat[7];
				mat[6] /= mat[7];
				mat[7] = 1;
				streak++;
				return true;
			}
			else if((mat[4]%mat[7]==0)&&(mat[8]%mat[7]==0)&&(mat[6]>=2)&&(mat[8]>=2)) { //48
				mat[4] /= mat[7];
				mat[8] /= mat[7];
				mat[7] = 1;
				streak++;
				return true;
			}
			else if((mat[6]%mat[7]==0)&&(mat[8]%mat[7]==0)&&(mat[6]>=2)&&(mat[8]>=2)) { //68
				mat[6] /= mat[7];
				mat[8] /= mat[7];
				mat[7] = 1;
				streak++;
				return true;
			}
			else if((mat[4]%mat[7]==0)&&(mat[4]>=2)){ //4
				mat[4] /=mat[7];
				mat[7] = 1;
				return true;
			}
			else if((mat[6]%mat[7]==0)&&(mat[6]>=2)) { //6
				mat[6] /= mat[7];
				mat[7] = 1;
				return true;
			}
			else if((mat[8]%mat[7]==0)&&(mat[8]>=2)) { //8
				mat[8] /= mat[7];
				mat[7] = 1;
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
				mat[5] = 1;
				mat[7] = 1;
				mat[8] = m>n?n:m;
				streak = streak + 2;
				return true;
			}
			else if((mat[5]%mat[8]==0)&&(mat[7]%mat[8]==0)&&(mat[5]>=2)&&(mat[7]>=2)) {
				mat[5] /= mat[8];
				mat[7] /= mat[8];
				mat[8] = 1;
				streak++;
				return true;
			}
			else if((mat[5]%mat[8]==0)&&(mat[5]>=2)){ //5
				mat[5] /=mat[8];
				mat[8] = 1;
				return true;
			}
			else if((mat[7]%mat[8]==0)&&(mat[7]>=2)) { //7
				mat[7] /= mat[8];
				mat[8] = 1;
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
			}
		break;
		case(2):if(reorder1()) {
			streak++;
		}
		break;
		case(3):if(reorder2()) {
			streak++;
        }
		break;
		case(4):if(reorder3()) {
			streak++;
			}
		break;
		case(5):if(reorder4()){
			streak++;
			}
		break;
		case(6):if(reorder5()){
			streak++;
			}
		break;
		case(7):if(reorder6()){
			streak++;
			}
		break;
		case(8):if(reorder7()){
			streak++;
			}
		break;
		case(9):if(reorder8()){
			streak++;
			}
		break;
		}

		for(int i = 0; i <9; i++) {
			if(reorder0()||reorder1()||	reorder2()||reorder3()||reorder4()||reorder5()||reorder6()||reorder7()||reorder8()) {
				streak++;
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
        if(mat[0]<=1)
				b0.setText("__");
		else
				b0.setText(""+mat[0]);
		if(mat[1]<=1)
				b1.setText("__");
		else
				b1.setText(""+mat[1]);
        if(mat[2]<=1)
				b2.setText("__");
		else
				b2.setText(""+mat[2]);
        if(mat[3]<=1)
				b3.setText("__");
		else
				b3.setText(""+mat[3]);
        if(mat[4]<=1)
				b4.setText("__");
		else
				b4.setText(""+mat[4]);
        if(mat[5]<=1)
				b5.setText("__");
		else
				b5.setText(""+mat[5]);
        if(mat[6]<=1)
				b6.setText("__");
		else
				b6.setText(""+mat[6]);
        if(mat[7]<=1)
				b7.setText("__");
		else
				b7.setText(""+mat[7]);
        if(mat[8]<=1)
				b8.setText("__");
		else
				b8.setText(""+mat[8]);
	}
	private void printKeep() {
		if(keep<=1)
			Keep.setText("__");
		else
			Keep.setText(""+keep);
	}
	private void printStreak() {
		switch(streak) {
		case(2):	Streak.setText("Good, Streak of: "+streak);
		score +=10;
		break;
		case(3):	Streak.setText("Great, Streak of: "+streak);
		score +=20;
		break;
		case(4):	Streak.setText("V.Good, Streak of: "+streak);
		score +=30;
		break;
		case(5):	Streak.setText("Impressive, Streak of: "+streak);
		score +=40;
		break;
		}
	}
	private void printScore() {
		Score.setText("Your Score : "+score);
        HighScore.setText("High Score : "+highScore);
	}
	private void printNext() {
		nextValues();
		nxt0.setText(""+nextValues[0]);
        nxt1.setText(""+nextValues[1]);
        nxt2.setText(""+nextValues[2]);
        nxt3.setText(""+nextValues[3]);
        nxt4.setText(""+nextValues[4]);
	}
	public void start() {
		gameCount++;
        play = 1;
		if(gameCount==1) {
			name=JOptionPane.showInputDialog("Enter Name");
            JOptionPane.showMessageDialog(getParent(),"Hello, Welcome to Divide Game "+ name);
            Name.setText("Player Name: "+name);
		}
		//if(s.nextInt() == 1) {
		//	System.out.println();
       clear();
       printMatrix();
       printKeep();
       printScore();
       for(int i = 0; i<4; i++)
         nextValues();
       printNext();
		

	}
	private void inPlay() {
        Streak.setText("");
		if(place == 0 && kept ==0) {
			keep = nextValues[0];
			kept = 1;
			printMatrix();
			printKeep();
			printScore();
			printNext();
		}
		else if(keeping==1 && kept ==1){
			if(!isVacant(place-1)) {
				JOptionPane.showMessageDialog(getParent(),"Place not empty!!\nEnter Again");
			}
			else {
				mat[place-1] = keep;
				score = score + keep;
				if(reorder())
					score = score + nextValues[0]*streak*levelSelector();
				keep = 1;
				kept = 0;
				printMatrix();
				printKeep();
				printScore();
				//printNext();
			}
            keeping = 0;
		}
		else {
			if(!isVacant(place-1)) {
				JOptionPane.showMessageDialog(getParent(),"Place not empty!!\nEnter Again");
			}
			else {
				mat[place-1] = nextValues[0];
				if(reorder())
					score = score + nextValues[0]*streak*levelSelector();
				printMatrix();
                printKeep();
				printScore();
				printNext();
			}
		}

        int flag = 1;
        for(int i = 0; i < 9;i++) {
            if(mat[i]<=1){
                    flag = 0;
                    break;
                }
        }
        boolean ret = false;
        if(flag==1)
            ret = end();
	}
	public boolean end() {
        play = 0;
		if(endImmediate!=1){
            for(int i = 0; i < 9;i++) {
                if(mat[i]<=1)
                    return false;
            }
        }
        if(score>highScore) {
			JOptionPane.showMessageDialog(getParent(),"!!!NEW HIGH SCORE!!!\nScore: "+score);
            JOptionPane.showMessageDialog(getParent(),"~~Game Over~~\nYour Score: "+score);
			highScore = score;
			score = 0;
            printScore();
		}
        else
            JOptionPane.showMessageDialog(getParent(),"~~Game Over~~\nYour Score: "+score);
             clear();

		return true;
	}
    private void clear(){
        for(int i = 0;i<mat.length;i++)
           mat[i] = 1;
       keep = 1;
       kept = 0;
       keeping = 0;
       level = 1;
       score = 0;
       streak = 0;

    }
	public void playAgain() {
		start();
	}
    /** Creates new form DivideGame */
    public DivideGame() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        b0 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        Keep = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nxt4 = new javax.swing.JLabel();
        nxt3 = new javax.swing.JLabel();
        nxt2 = new javax.swing.JLabel();
        nxt1 = new javax.swing.JLabel();
        nxt0 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        start = new javax.swing.JButton();
        Score = new javax.swing.JLabel();
        HighScore = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        Streak = new javax.swing.JLabel();
        Restart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DIVIDE GAME");
        setForeground(java.awt.Color.black);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("DIVIDE");

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        b0.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        b0.setText("__");
        b0.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        b0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b0ActionPerformed(evt);
            }
        });

        b1.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        b1.setText("__");
        b1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        b2.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        b2.setText("__");
        b2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        b3.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        b3.setText("__");
        b3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        b4.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        b4.setText("__");
        b4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });

        b5.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        b5.setText("__");
        b5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });

        b6.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        b6.setText("__");
        b6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });

        b7.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        b7.setText("__");
        b7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b7ActionPerformed(evt);
            }
        });

        b8.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        b8.setText("__");
        b8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(b0, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b0, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Keep.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        Keep.setText("__");
        Keep.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Keep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeepActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("KEEP");

        nxt4.setFont(new java.awt.Font("Georgia", 0, 36));
        nxt4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nxt4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nxt3.setFont(new java.awt.Font("Georgia", 0, 36));
        nxt3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nxt3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nxt2.setFont(new java.awt.Font("Georgia", 0, 36));
        nxt2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nxt2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nxt1.setFont(new java.awt.Font("Georgia", 0, 36));
        nxt1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nxt1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nxt0.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        nxt0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nxt0.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("NEXT VALUE");

        start.setText("START");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        Score.setText("Your Score : 0");

        HighScore.setText("High Score : 0 ");

        Name.setText("Player Name: ");

        Streak.setText("                                 ");

        Restart.setText("RESTART");
        Restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(nxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Keep, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2))
                            .addComponent(nxt0, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                        .addGap(20, 20, 20))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(205, 205, 205))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(start)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Streak, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Score, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Restart)
                            .addComponent(HighScore, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Restart))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HighScore, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(start, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                        .addComponent(Name)
                        .addComponent(Score, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(Streak)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(Keep, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nxt0, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     
    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        start();        
    }//GEN-LAST:event_startActionPerformed

    private void b0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b0ActionPerformed
        if(play==1){
            place = 1;
            inPlay();
        }
    }//GEN-LAST:event_b0ActionPerformed
    
    private void KeepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeepActionPerformed
        if(keeping == 1)
            keeping = 0;
        else if(kept==0){
            place = 0;
            inPlay();
        }
        else{
            keeping =1;
        }
    }//GEN-LAST:event_KeepActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        if(play==1){
            place = 2;
            inPlay();
        }
    }//GEN-LAST:event_b1ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        if(play==1){
            place = 3;
            inPlay();
        }
    }//GEN-LAST:event_b2ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        if(play==1){
            place = 4;
            inPlay();
        }
    }//GEN-LAST:event_b3ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        if(play==1){
            place = 5;
            inPlay();
        }
    }//GEN-LAST:event_b4ActionPerformed

    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5ActionPerformed
        if(play==1){
            place = 6;
            inPlay();
        }
    }//GEN-LAST:event_b5ActionPerformed

    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6ActionPerformed
        if(play==1){
            place = 7;
            inPlay();
        }
    }//GEN-LAST:event_b6ActionPerformed

    private void b7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b7ActionPerformed
        if(play==1){
            place = 8;
            inPlay();
        }
    }//GEN-LAST:event_b7ActionPerformed

    private void b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b8ActionPerformed
        if(play==1){
            place = 9;
            inPlay();
        }
    }//GEN-LAST:event_b8ActionPerformed

    private void RestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestartActionPerformed
        endImmediate = 1;
        if(play!=1){
            playAgain();
        }
        boolean ret;
        if(play==1){
            ret = end();
            start();
        }
}//GEN-LAST:event_RestartActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DivideGame().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HighScore;
    private javax.swing.JButton Keep;
    private javax.swing.JLabel Name;
    private javax.swing.JButton Restart;
    private javax.swing.JLabel Score;
    private javax.swing.JLabel Streak;
    private javax.swing.JButton b0;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton b8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel nxt0;
    private javax.swing.JLabel nxt1;
    private javax.swing.JLabel nxt2;
    private javax.swing.JLabel nxt3;
    private javax.swing.JLabel nxt4;
    private javax.swing.JButton start;
    // End of variables declaration//GEN-END:variables

}
