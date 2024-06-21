package Store_Mangement;


public class Client {
	private String CIN;
	private String nom;
	private String prenom;
	private String adresse;
	private String num_tel;
	
	public Client (String a,String b, String c,String d,String e)
	{
		CIN=a;
		nom=b;
		prenom=c;
		adresse=d;
		num_tel=e;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNum_tel() {
		return num_tel;
	}
	public void setNum_tel(String num_tel) {
		this.num_tel = num_tel;
	}
    public String toString()
    {
    	return (CIN+"  "+nom+" "+prenom+" "+adresse+"  "+num_tel);
    }
}
