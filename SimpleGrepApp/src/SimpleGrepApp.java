

public class SimpleGrepApp {
	public static void main(String[] args) {
		String optionString = "";	// 검색 옵션 
		String searchWord = "";		// 검색어 
		String dirString = "";		// 디렉토리 또는 파일 
		
		if(args.length != 3) {
			System.out.println("Usage: SimpleGrep [option] [searchword] [dir] ");
			System.out.println("options");
			System.out.println("  -c: Print the total number of words matched with the search keyword");
			System.out.println("  -i: Print the number of lines: case insensitive matching");
			System.out.println("  -n: Print the number of lines including the search word");
			System.exit(0);
		}
		
		for(int i=0; i<args.length; i++) {
			System.out.printf("[%d]: %s\n", i, args[i]);
		}
		optionString = args[0];
		searchWord = args[1];
		dirString = args[2];

		SimpleGrep grep = new SimpleGrep();
		grep.search(optionString, searchWord, dirString);
	}
}
