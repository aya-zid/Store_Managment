package Store_Mangement;

import java.io.*;
public class Stock {
	private int n;
	private Produit [] t;
	public Stock()
	{
		n=0;
		t =new Produit[150];
	}
	public int getN() 
	{	return n;  }
	
    public void ajouterP(Produit p)
    {
    	int i=0;
		while (i<n && (t[i].getReference()).equals(p.getReference())==false)
		{
			i++;
		}
		if (i==n)
		{t[n]=p;
    	n=n+1;
    	System.out.println("product added sucessfully");
    	}
		else
		 System.out.println("this reference already exists ");
    	
    }
	
	public void supprimerP(String r)
	{
		int i=0;
		while (i<n && (t[i].getReference()).equals(r)==false)
		{
			i++;
		}
		if (i==n)
			System.out.println("the product with reference "+r+" isnt found ");
		else
		{
			for(int j=i;j<n-1;j++)
			{
				t[j]=t[j+1];
			}
			n=n-1;
			System.out.println("product removed successfully");
		}
	}
	public void chercherPr(String r)
	{
		int i=0;
		while (i<n && (t[i].getReference()).equals(r)==false)
		{
			i++;
		}
		if (i==n)
			System.out.println("the product with reference "+r+" isnt found ");
		else 
			System.out.println(t[i]);
		
	}
	public Produit retourner(String r)
	{
		int i=0;
		while (i<n && (t[i].getReference()).equals(r)==false)
		{
			i++;
		}
		if (i==n)
		{
			return null;
		}
			
		else 
			return t[i];
		
	}
	public void remplacer(Produit p)
	{int i=0;
	while (i<n && (t[i].getReference()).equals(p.getReference())==false)
	{
		i++;
	}
		t[i]=p;
	}
	public void chercherPn(String m)
	{
		int j=0;
		Produit [] tm= new Produit[100];
		for (int i=0; i<n;i++ )
		{
			if((t[i].getNom()).equals(m)==true)
			{
				tm[j]=t[i];
				j++;
			}
		}
		
		if (j==0)
			System.out.println("no product has the name  "+m);
		else {
			for(int i=0;i<j;i++)
				System.out.println(tm[i]);}}
   public void save()
   {
	   String s,ss="";
	   try
	   {
		   BufferedWriter bw= new BufferedWriter(
				   new FileWriter("prod.txt"));
		   for (int i=0;i<n;i++)
		   {
		   s=t[i].getReference()+" "+t[i].getNom()+" "+t[i].getQuantite()+" "+t[i].getPrix()+"\n";
		   ss=ss+s;
		   }
		   bw.write(ss);
		   bw.close();
		   
	   }catch(Exception ex) {return;}
   }
   public void read()
   {
	   String a ,b,c,d;
	   Produit p;
	   try
	   {
		   BufferedReader br=new BufferedReader(
				   new FileReader("prod.txt"));
		   String s;
		   while ((s=br.readLine())!=null)
		   {
			 a=s.substring(0,3) ;
			 b=s.substring(4,14);
			 c=s.substring(15,19);
			 d=s.substring(20);
			 p=new Produit(a,b,c,d);
			 t[n]=p;
			 n=n+1;
			 
		   }
		   br.close();
	   }catch(Exception ex) {
		   return;
	   }
   }
   public void affiche()
   { System.out.println("reference  nom        quantité  prix");
	   for(int i=0;i<n;i++)
	   {
		   System.out.println(t[i]);
	   }
   }
}
