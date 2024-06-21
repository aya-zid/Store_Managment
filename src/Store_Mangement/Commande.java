package Store_Mangement;

public class Commande {
	private String date;
	private Client c;
	private Produit p;
	private int qte;
	private double facture;
	public Commande (Client a,Produit b,int q,String d)
	{
		int i=3;int j=4; 
		String help;
		help=(b.getQuantite()).substring(i,j);
		while(help.equals(" "))
		{
			i--;j--;
			help=(b.getQuantite()).substring(i,j);
			
		}
		
		String x2;
		x2=(b.getQuantite()).substring(0,i+1);
		int x=Integer.parseInt(x2);
		if(x>=q)
		{
			c=a;p=b;qte=q;
			date=d;
			
		   int qtn;qtn=x-qte;
		   String qtnn=""+qtn;
		   if(qtnn.length()<4)
			{
			int pl=4-qtnn.length();
				for (int g=0;g<pl;g++)
					qtnn=qtnn+" ";
			}
			p.setQuantite(qtnn);
			double price=Double.parseDouble(p.getPrix());
			setFacture(price*q);
			
		}
		else System.out.println("Requested quantity of the product is unavailable");

	}
     public Produit getProduit()
     {
    	 return p;
     }
     public Client getClient()
     {
    	 return c;
     }
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getFacture() {
		return facture;
	}
	public void setFacture(double facture) {
		this.facture = facture;
	}
	public int getQte()
	{
		return qte;
	}
	public String toString()
	{
		if (qte/10!=0)
		return (c.getCIN()+"   "+p.getReference()+"        "+qte+"         "+facture+"    "+date);
		else 
			return (c.getCIN()+"   "+p.getReference()+"        "+qte+"          "+facture+"     "+date);
	}
}
