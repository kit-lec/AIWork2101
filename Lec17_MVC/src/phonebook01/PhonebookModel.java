package phonebook01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// MODEL
//  데이터 표현 객체

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhonebookModel {
	// 멤버변수
	private int uid; // 고유 uid 값 ( 1 ~ ) 중복허용X
	private String name; // 이름 (필수)
	private String phoneNum; // 전화번호 (필수)
	private String memo; // 메모
	private LocalDateTime regDate; // 등록일시

	
	@Override
	public String toString() {
		return String.format("%d] %s : %s : %s : %s", 
				uid, name, phoneNum, memo,
				regDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
				);
	}
	
	
} // end Model











