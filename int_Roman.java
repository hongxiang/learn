public class int_Roman {
	public static void main(String[] args){
		//the program takes two inputs, the first tell program which type is that input(roman or int)
		//the second one is the input value
		//if input is roman number, call RtoI function to change it into int
		if(args[0].equals("roman")) {
			int result = int_Roman.RtoI(args[1]);
			System.out.println(result);
		}
		//if input is int number, call ItoR function to change it into roman
		else if(args[0].equals("int")){
			String result = int_Roman.ItoR(args[1]);
			System.out.println(result);
		}
		//else output error message 
		else {
			System.out.println("please give two input, roman/int + your input");
		}
	}

	public static int RtoI(String in) {
		int out = 0;
		int offset = 0;
		in = in.toUpperCase();
		//first deal with number greater than 1000
		while(in.startsWith("M", offset)) {
			offset ++;
			out += 1000;
		}
		//if >900
		if(in.startsWith("CM", offset)) {
			offset += 2;
			out += 900;
		}
		//elseif >500
		if(in.startsWith("D", offset)) {
			offset += 1;
			out += 500;
		}
		//elseif >400
		if(in.startsWith("CD", offset)) {
			offset += 2;
			out += 400;
		}
		//deal with remaining number that >100
		while(in.startsWith("C", offset)) {
			offset ++;
			out += 100;
		}
		//the followings similiar with above
		if(in.startsWith("XC", offset)) {
			offset += 2;
			out += 90;
		}
		if(in.startsWith("L", offset)) {
			offset += 1;
			out += 50;
		}
		if(in.startsWith("XL", offset)) {
			offset += 2;
			out += 40;
		}
		while(in.startsWith("X", offset)) {
			offset ++;
			out += 10;
		}
		if(in.startsWith("IX", offset)) {
			offset += 2;
			out += 9;
		}
		if(in.startsWith("V", offset)) {
			offset += 1;
			out += 5;
		}
		if(in.startsWith("IV", offset)) {
			offset += 2;
			out += 4;
		}
		if(in.startsWith("I", offset)) {
			offset += 1;
			out += 1;
		}
		return out;
	}
	public static String ItoR(String in) {
		int num = Integer.parseInt(in);
		String out = new String();
		//this function is just like RtoI function
		//it first deals with 1000, then 900, 500, 400......
		while(num >= 1000) {
			num -= 1000;
			out += "M";
		}
		if(num >= 900) {
			num -= 900;
			out += "CM";
		}
		if(num >= 500) {
			num -= 500;
			out += "D";
			while (num >= 100) {
				num -= 100;
				out += "C";
			}
		}
		if(num >= 400) {
			num -= 400;
			out += "CD";
		}
		while (num >= 100) {
			num -= 100;
			out += "C";
		}
		if(num >= 90) {
			num -= 90;
			out += "XC";
		}
		if(num >= 50) {
			num -= 50;
			out += "L";
			while (num >= 10) {
				num -= 10;
				out += "X";
			}
		}
		if(num >= 40) {
			num -= 40;
			out += "XL";
		}
		while (num >= 10) {
			num -= 10;
			out += "X";
		}
		if(num >= 9) {
			num -= 9;
			out += "IX";
		}
		if(num >=5) {
			num -= 5;
			out += "V";
			while (num >= 1) {
				num -= 1;
				out += "I";
			}
		}
		if(num >= 4) {
			num -=4;
			out += "IV";
		}
		while (num >= 1) {
			num -= 1;
			out += "I";
		}
		return out;
	}
}