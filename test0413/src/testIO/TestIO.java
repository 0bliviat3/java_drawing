package testIO;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestIO {
	
	TestIO(){
		File file = new File("C:\\signImage");
//		File file2 = new File("C:\\signImage\\file.txt");
		boolean isExist = file.exists();
//		boolean isExist2 = file2.exists();
		System.out.println(isExist);
//		System.out.println(isExist2);
		if(!isExist) {
			file.mkdir();
		}
		
		/*
		if(!isExist2) {
			try {
				file2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd\ta\tHH:mm");
		File[] contents = file.listFiles();
		for(int i=0;i<contents.length;i++) {
			System.out.print(sdf.format(new Date(contents[i].lastModified())));
			if(contents[i].isDirectory()) {
				System.out.print("\t<DIR>\t\t\t"+contents[i].getName());
			}else {
				System.out.print("\t\t\t"+contents[i].length()+"\t"+contents[i].getName());
			}
			System.out.println();
		}*/
		
	}
	
}
