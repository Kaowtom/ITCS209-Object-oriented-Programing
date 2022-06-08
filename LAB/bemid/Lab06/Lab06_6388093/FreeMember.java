//import java.util.ArrayList;

public class FreeMember extends Member {
	
//	private ArrayList<Video> vdoList;

	public FreeMember(String em, String pa) {
		super(em, pa);
	}

	final int FREE_LIMITED_VDOs =3;
	private int numberDownloadVDO = 0;
	
	@Override
	public boolean addVideo(Video vdo){
		if(numberDownloadVDO == FREE_LIMITED_VDOs) {
			System.out.println(vdo);
			System.out.println("cannot be downloaded because the number of the video is reaching the limit.");
			return false;
		}else {
			getVdoList().add(vdo);
			numberDownloadVDO++;
			return true;
		}
	}
	
	@Override
	public boolean removeVideo(Video vdo) {
		if(numberDownloadVDO==FREE_LIMITED_VDOs) {
			numberDownloadVDO--;
		}
		return super.removeVideo(vdo);
//		for(Video id: this.getVdoList()) {
//			if(id.isEqual(vdo)) {
//				getVdoList().remove(vdo);
//				numberDownloadVDO--;
//				System.out.println(vdo);
//				System.out.println("is successfully removed.");
//				return true;
//			}
//		}
//		return false;
	}
	
	@Override
	public void printMemberInfo() {
		System.out.println("---- FREE MEMBER ----");
		super.printMemberInfo();
	}
	public int getNumVideo() {
		return numberDownloadVDO;
	}
}
