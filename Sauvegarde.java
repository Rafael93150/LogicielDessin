
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Sauvegarde implements Serializable{
	
	public Sauvegarde() {
		
	}
	
	public void sauvegarde(ArrayList<Figure> a) {
		try {
			FileOutputStream fos = new FileOutputStream("sauvegarde");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(a);
			oos.close();
			} 
		catch (IOException e) {
				e.printStackTrace();
			}
		
	}
}
