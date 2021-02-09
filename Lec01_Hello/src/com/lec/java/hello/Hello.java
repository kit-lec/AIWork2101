package com.lec.java.hello;

/* block comment (블록 주석)
java 첫프로그램
[학습목표]
		- 주석
		- println(), print()
*/
		
public class Hello {

	public static void main(String[] args) {
		//이것은 주석(comment) 입니다
		//이것은 뭐다냥? --> line comment (한줄 주석)
		System.out.println("Hello Java!");
		
		System.out.print("안녕하세요 ");
		System.out.println("자바");
		
		System.out.println();  // 한 라인만 줄바꿈 함
		System.out.println();
				
		//가나다라
		System.out.println("이거 내꼬얌.");
		
		System.out.println(1 + 2);
		System.out.println(1024);
		
		System.out.println("안녕하세요" + " 1일이에요"); // "문자열" + "문자열" => 문자열 연결된 결과
		System.out.println("1" + "2");  // "12"
		

	} // end main()

} // end class














