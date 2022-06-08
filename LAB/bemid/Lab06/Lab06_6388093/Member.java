import java.util.ArrayList;

public class Member {
	private String email;
	private String password;
	private ArrayList<Video> vdoList = new ArrayList<Video>();
	
	public Member(String em, String pa) {
//		setVdoList(new ArrayList<Video>());
		email = em;
		password = pa;
	}
	
	public boolean addVideo(Video vdo) {
		if(vdo == null) {
			return false;
		}else {
			getVdoList().add(vdo);
			return true;
		}
	}
	
	public boolean removeVideo(Video vdo) {
		for(Video id: this.getVdoList()) {
			if(id.isEqual(vdo)) {
				System.out.println(vdo);
				getVdoList().remove(vdo);
				System.out.println("is successfully removed.");
				return true;
			}
		}
		return false;
	}
	
	public void printMemberInfo() {
		System.out.println("Email: "+email+" (pwd: "+password+")");
		System.out.println("List of Videos");
//		System.out.println(getVdoList().size());
		for(int i=0; i<getVdoList().size(); i++) {
			Video ne = getVdoList().get(i);
			System.out.print("["+(i+1)+"] "+ne.toString());
			System.out.println("");
		}System.out.println("---------------------");
	}

	public ArrayList<Video> getVdoList() {
		return vdoList;
	}

	public void setVdoList(ArrayList<Video> vdoList) {
		this.vdoList = vdoList;
	}
}
