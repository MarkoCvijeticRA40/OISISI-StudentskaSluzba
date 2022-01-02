package persistence;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serialization {
	
	public static boolean run() {
		File f = new File(Database.dbPath);
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			oos.writeObject(Database.getInstance());
			oos.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
