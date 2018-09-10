import java.io.File;

public class FileList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dir = new File("/Users/jook/Desktop/2018NetworkProgramming-master/NP0910/bin");
		
		File[] list = dir.listFiles();
		
		for(int i=0; i<list.length; i++) {
			System.out.println("FILE Number " + i + " is : " + list[i].getName());
		}
	}

}
