package Store_Mangement;
public class Produit {
	private String reference;
	private String nom;
	private String prix;
	private String quantite;
	
	public Produit(String a ,String b ,String c ,String d)
	{
		reference =a;
		nom=b;
		quantite=c;
		prix=d;
	}
	
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getQuantite() {
		return quantite;
	}
	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}
	public String toString()
	{
		return (reference+"        "+nom+" "+quantite+"      "+prix);
	}

}
