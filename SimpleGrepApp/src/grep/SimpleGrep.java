package grep;

public class SimpleGrep {
	/**
	 * 한글 주석 테스트 
	 */
	public SimpleGrep() {
		System.out.println("SimpleGrep 생성자");
	}
	
	public void search(String option, String word, String dir) {
		System.out.printf("grep: %s %s %s\n", option, word, dir);
		
	}
}
