package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Modelo extends Conector {

	public Modelo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void insert(Animal animal) {
		Statement st;
		try {
			st = super.getConexion().createStatement();
			st.execute("INSERT INTO animal (nombre) " + "VALUES ('" + animal.getNombre() + "')");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<Animal> select() {
		ArrayList<Animal> animales = new ArrayList<Animal>();

		try {
			Statement st = super.getConexion().createStatement();
			ResultSet rs = st.executeQuery("select * from animal");
			while (rs.next()) {
				Animal animal = new Animal();

				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");

				animal.setId(id);
				animal.setNombre(nombre);

				animales.add(animal);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return animales;
	}
}
