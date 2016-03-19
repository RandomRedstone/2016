package code.team;

public class Member {
	public String fn;
	public String mi;
	public String ln;
	public String business;
	public String product;
	public boolean varsity;
	public int rank;
	public Member(String first, String middle, String last, String business, String product, boolean varsity, int rank) {
		this.fn=first;
		this.mi=middle;
		this.ln=last;
		this.business=business;
		this.product=product;
		this.varsity=varsity;
		this.rank=rank;
	}
	static double time;
	public void addHours (double atime) {
		time=time+atime;
	}
	public double getHours () {
		return time;
	}
	public double getMinutes () {
		return time*60;
	}
	public int[] getTime() {
		int[] newtime = {(int) (time-time%1),(int) ((time%1)*60)}; 
		return newtime;
	}
}
