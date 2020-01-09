import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Charge implements Serializable{
	ArrayList<Figure> listeFigures;
	
	private ObjectInputStream ois;

	public Charge() {
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Figure> charge(String f) {
		try {
			FileInputStream fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			listeFigures = (ArrayList<Figure>)ois.readObject();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
				e.printStackTrace();
		}
		return listeFigures;
	}

}
