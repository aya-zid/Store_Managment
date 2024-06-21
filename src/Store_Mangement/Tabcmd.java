package Store_Mangement;
import java.io.*;
public class Tabcmd {
   private int n;
   private Commande []t;
   public Tabcmd()
   {
	   n=0;
	   t=new Commande[150];
   }
   public int getN() 
	{	return n;  }
   public void ajouter(Commande cm)
   {
    t[n]=cm;
   	n=n+1;
   	System.out.println("Order added successfully");
   	}
	
	
	public void supprimer(Client c,Produit p,String d)
	{
		int i=0;
		while (i<n && ((t[i].getClient()).equals(c)==false) && ((t[i].getProduit()).equals(p)==false)
				&& ((t[i].getDate()).equals(d)==false))
		{
			i++;
		}
		if (i==n)
			System.out.println("Order not found");
		else
		{
			for(int j=i;j<n-1;j++)
			{
				t[j]=t[j+1];
			}
			n=n-1;
			System.out.println("Order removed successefully");
		}
	}

	public void chercherP(String p)
	{
		int j=0;
		Commande [] tm= new Commande[100];
		for (int i=0; i<n;i++ )
		{
			if((t[i].getProduit().getReference()).equals(p)==true)
			{
				tm[j]=t[i];
				j++;
			}
		}
		
		if (j==0)
			System.out.println("product not found");
		else {
			for(int i=0;i<j;i++)
				System.out.println(tm[i]);
			
		}
	}
	public void chercherc(String cin)
	{
		int j=0;
		Commande [] tm= new Commande[100];
		for (int i=0; i<n;i++ )
		{
			if((t[i].getClient().getCIN()).equals(cin)==true)
			{
				tm[j]=t[i];
				j++;
			}
		}
		
		if (j==0)
			System.out.println("Client not found");
		else {
			for(int i=0;i<j;i++)
				System.out.println(tm[i]);
			
		}
	}
	public void chercherd(String d)
	{
		int j=0;
		Commande [] tm= new Commande[100];
		for (int i=0; i<n;i++ )
		{
			if((t[i].getDate()).equals(d)==true)
			{
				tm[j]=t[i];
				j++;
			}
		}
		
		if (j==0)
			System.out.println("Date not found");
		else {
			for(int i=0;i<j;i++)
				System.out.println(tm[i]);
			
		}
	}
  public void save()
  {
	   String s,ss="";
	   try
	   {
		   BufferedWriter bw= new BufferedWriter(
				   new FileWriter( "cmd.txt"));
		   for (int i=0;i<n;i++)
		   {
		   s=(t[i].getProduit()).getReference()+" "+(t[i].getClient()).getCIN()+" "+t[i].getDate()+" "+t[i].getQte()+"\n";
		   ss=ss+s;
		   }
		   bw.write(ss);
		   bw.close();
		   
	   }catch(Exception ex) {return;}
  }
  public void read()
  {
	   String a ,b,c,d;
	   Stock aaa=new Stock();
	   aaa.read();
	   Group aa =new Group();
	   aa.read();
	   Commande cm;
	   try
	   {
		   BufferedReader br=new BufferedReader(
				   new FileReader("cmd.txt"));
		   String s;
		   while ((s=br.readLine())!=null)
		   {
			 a=s.substring(0,3) ;
			 b=s.substring(4,12);
			 c=s.substring(13,23);
			 d=s.substring(24);
			 int x= Integer.parseInt(d);
			 Produit pe=aaa.retourner(a);
			Client ce=aa.retourner(b);
			 cm=new Commande(ce,pe,x,c);
			 t[n]=cm;
			 n=n+1; 
		   }
		   br.close();
	   }catch(Exception ex) {
		   return; } }
  public void affiche()
  {System.out.println("CIN        Reference  Quantite   Facture   Date");
	   for(int i=0;i<n;i++)
	   {
		   System.out.println(t[i]);
	   }
  }


}
