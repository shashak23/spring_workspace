package my.spring.springweb.sample01.vo;

public class Member {
	private String memberName;
	private int memberAge;
	private String memberAddr;
	
	public Member () {
		
	}
	
	public Member(String memberName, int memberAge, String memberAddr) {
		super();
		this.memberName = memberName;
		this.memberAge = memberAge;
		this.memberAddr = memberAddr;
	}
	
	
}
