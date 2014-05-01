package actions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.primefaces.context.RequestContext;

import entities.Person;

@ManagedBean(name = "administrarActionS")
@SessionScoped
public class Administrador implements Serializable {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 1L;

	public String nombre;
	public String nombre2;

	private Person person;
	private String jsonText;

	public Administrador() {
		person = new Person();
		jsonText = "";
	}

	public String getJsonText() {
		return jsonText;
	}

	public void setJsonText(String jsonText) {
		this.jsonText = jsonText;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String nombreOb() {
		nombre2 = nombre;
		List<Person> personList = new ArrayList<Person>();
		personList.add(person);

		Person p2 = new Person();
		p2.setAge(12);
		p2.setDirection("New York");
		p2.setName("Luis");

		personList.add(p2);
		try {
            RequestContext.getCurrentInstance().execute("alert('This onload script is added from backing bean.')");

            org.primefaces.json.JSONObject jsonObject = new org.primefaces.json.JSONObject(person);
			
			
			jsonText = "{\"first\": \"123\", \"second\": [\"4\", \"5\", \"6\"], \"third\": 789}";
			
			Object personJson = JSONValue.parse(jsonText);
			HashMap<String, Object> map = (HashMap<String, Object>) JSONValue.parse(jsonText);
			JSONArray array = (JSONArray) map.get("second");
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Information",
							(String)array.get(0)));
			jsonText = jsonObject.toString();
			
		} catch (JSONException ex) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Exception: ",
							ex.getMessage()));
		}

		return "";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
