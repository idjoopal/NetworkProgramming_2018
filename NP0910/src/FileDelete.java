import java.io.File;

public class FileDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length != 1) {
			System.out.println("How to use : java FileDelete FILENAME");
			System.exit(0);
		}
		
		File f = new File(args[0]);
		if(f.exists()) {
			boolean deleteflag = f.delete();
			if(deleteflag) {
				System.out.println("Success file delete");
			}else {
				System.out.println("Fail file delete");
			}
		}else {
			System.out.println("File do not Exist");
		}
	}

}
