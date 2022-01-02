package persistence;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserialization {
	
	public static boolean run() {
		File f = new File(Database.dbPath);
		if (!f.exists())
			return false;
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
			Database.setInstance((Database) ois.readObject());
			ois.close();
			return true;
		} catch (Exception e) {
			return false;
		} 
	} 
}
