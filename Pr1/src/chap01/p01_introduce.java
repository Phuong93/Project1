package chap01;

public class p01_introduce {
	//Khai bao bien
public static void main01(String[] args) {

	int age 	= 20;
	String name = "phuong";
	
	System.out.println("age:"+ age + "+" + 10 );
	System.out.println("Name:"+ name );
	age 		= 30;
	System.out.println("age:"+ age + "+" + 10 );
	// hang so
	final int YOUR_BIRTHDAY = 2000;
	System.out.println(YOUR_BIRTHDAY);
}
// Data type
public static void main02(String[] args) {

	int var1 		= 12;
	int var2 		= 200;
	boolean var3 	= true;
	double var4 	= 123.456;
	String name = "Phuong Tran";
	System.out.println("Var1:"+ var1 );
	System.out.println("Var2:"+ var2 );
	System.out.println("Var3:"+ var3 );
	System.out.println("Var4:"+ var4 );
	System.out.println("Name:"+ name );
	
}
// chuyen doi kieu du lieu 
public static void main03(String[] args) {

	int var1 		= 12;
	double var2 	= 123.456;
	int var3 		= var1 + (int)var2;
	double var4 	= (double)var1 + var2;
	System.out.println("Var3:" + var3);
	System.out.println("Var4:" + var4);
}
// Toan tu so hoc + - * /( chia lấy nguyên) %( chia lấy dư)
public static void main04(String[] args) {
	int number1 = 20;
	int number2 = 3;
	int result;
	// +
	result = number1 + number2;
	System.out.println("Result 1:" + number1 + "+" + number2 + "=" + result);
	// -
	result = number1 - number2;
	System.out.println("Result 2:" + number1 + "-" + number2 + "=" + result);
	// *
	result = number1 * number2;
	System.out.println("Result 3:" + number1 + "*" + number2 + "=" + result);
	// /
	result = number1 / number2;
	System.out.println("Result 4:" + number1 + "/" + number2 + "=" + result);
	// %
	result = number1 % number2;
	System.out.println("Result 5:" + number1 + "%" + number2 + "=" + result);
	
}
// Toan tu gan += -= *= /= %=
public static void main05(String[] args) {
	int number = 20;
	number = number + 10;
	number +=10;
	System.out.println(number);
	number -=10;
	System.out.println(number);
	number *=10;
	System.out.println(number);
	number /=10;
	System.out.println(number);
	number %=10;
	System.out.println(number);	
}
// Toan tu ++ --
// numberStart ++ trả về gia tri cua numberStart, sau đó tăng number lên 1 đơn vị
//numberStart -- trả về gia tri cua numberStart, sau đó giảm number lên 1 đơn vị
//++numberStart tăng numberStart lên 1 đơn vị, sau đó trả về gtri của numberStart
//--numberStart giảm numberStart lên 1 đơn vị, sau đó trả về gtri của numberStart
public static void main06(String[] args) {
	int numberStart = 20;
	int numberEnd = 0;
	numberEnd = numberStart++;
	System.out.println("Number start:" + numberStart);
	System.out.println("Number end:" + numberEnd);
	numberEnd = numberStart--;
	System.out.println("Number start:" + numberStart);
	System.out.println("Number end:" + numberEnd);
	numberEnd = ++numberStart;
	System.out.println("Number start:" + numberStart);
	System.out.println("Number end:" + numberEnd);
	numberEnd = --numberStart;
	System.out.println("Number start:" + numberStart);
	System.out.println("Number end:" + numberEnd);
}
//Toan tử sánh > < >= <= == != (khác)
public static void main07(String[] args) {
	int numberOne = 20;
	int numberTwo =10;
	boolean result = true;
	
	result = numberOne > numberTwo;
	System.out.println(numberOne + ">" + numberTwo + " is " + result);
	result = numberOne < numberTwo;
	System.out.println(numberOne + "<" + numberTwo + " is " + result);
	result = numberOne >= numberTwo;
	System.out.println(numberOne + ">=" + numberTwo + " is " + result);
	result = numberOne <= numberTwo;
	System.out.println(numberOne + "<=" + numberTwo + " is " + result);
	result = numberOne == numberTwo;
	System.out.println(numberOne + "==" + numberTwo + " is " + result);
	result = numberOne != numberTwo;
	System.out.println(numberOne + "!=" + numberTwo + " is " + result);
	
}
// Toan tu logic && (và ) || ( hoặc) ! (phủ định)
public static void main08(String[] args) {
	int numberOne = 20;
	int numberTwo = 10;
	boolean result = false;
// && true >> tất cả đều phải true
// && false chỉ cần 1 cái false
// || true khi chỉ cần 1 cái true là được
// || false khi tất cả đều phải false
	result = (numberOne > numberTwo) && (numberOne>=numberTwo) && (3<1);
	System.out.println(result);
	result = (numberOne < numberTwo) || (numberOne<numberTwo) || (3!=1);
	System.out.println(result);
	
}
//Java string method
public static void main09(String[] args) {
	// charArt lấy ra value của chuỗi tại 1 ví trí nhất định
	// subString lấy ra chuỗi từ vị trí này đến vị trí kia
	//indexof đếm số thứ tự của vị trí value cần index
	String abc = "This is my Java learning";
	String result = abc.toUpperCase();
	System.out.println(result);
	String result1 = abc.toLowerCase();
	System.out.println(result1);
	int result2 = abc.length();
	System.out.println(result2);
	char result3 = abc.charAt(6);
	System.out.println(result3);
	result = result.substring(5,10);
	System.out.println(result);
	int result4 = abc.indexOf("Java");
	System.out.println(result4);
	
}
//Java tring method continus
public static void main(String[] args) {
	// trim() dùng để remove space ở đầu và cuối của chuỗi
	String str1 = "         I'm Phuong Tran       ";
	String result = str1.trim();
	System.out.println(result);
}

}

