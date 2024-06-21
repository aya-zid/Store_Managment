package Store_Mangement;
import java.io.*;
public class Group {
  private int n;
  private Client [] t;
  public Group(){
	  n=0;
	  t=new Client [100];
  }
  public int getN() 
	{	return n;  }
  
  public void ajouter(Client c)
  {
  	int i=0;
		while (i<n && (t[i].getCIN()).equals(c.getCIN())==false)
		{
			i++;
		}
		if (i==n)
		{t[n]=c;
  	n=n+1;
  	System.out.println("client added successfully");
  	}
		else
		 System.out.println("this ID already exists");
  	
  }
  public void supprimer(String r)
	{
		int i=0;
		while (i<n && (t[i].getCIN()).equals(r)==false)
		{
			i++;
		}
		if (i==n)
			System.out.println("the client with ID "+r+" isnt found ");
		else
		{
			for(int j=i;j<n-1;j++)
			{
				t[j]=t[j+1];
			}
			n=n-1;
			System.out.println("client removed successfully");
		}
	}

  public void chercherCIN(String r)
	{
		int i=0;
		while (i<n && (t[i].getCIN()).equals(r)==false)
		{
			i++;
		}
		if (i==n)
			System.out.println("the client with ID "+r+" isnt found ");
		else 
			System.out.println(t[i]);
		
	}
	public void cherchern(String m)
	{
		int j=0;
		Client [] tm= new Client[100];
		for (int i=0; i<n;i++ )
		{
			if((t[i].getPrenom()).equals(m)==true)
			{
				tm[j]=t[i];
				j++;
			}
		}
		
		if (j == 0)
    System.out.println("No client has the first name " + m);

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
				   new FileWriter( "client.txt"));
		   for (int i=0;i<n;i++)
		   {
		   s=t[i].getCIN()+" "+t[i].getNom()+" "+t[i].getPrenom()+" "+t[i].getAdresse()+" "+t[i].getNum_tel()+"\n";
		   ss=ss+s;
		   }
		   bw.write(ss);
		   bw.close();
		   
	   }catch(Exception ex) {return;}
 }
 public void read()
 {
	   String a ,b,c,d,e;
	   Client z;
	   try
	   {
		   BufferedReader br=new BufferedReader(
				   new FileReader("client.txt"));
		   String s;
		   while ((s=br.readLine())!=null)
		   {
			 a=s.substring(0,8) ;
			 b=s.substring(9,19);
			 c=s.substring(20,30);
			 d=s.substring(31,41);
			 e=s.substring(42);
			 z=new Client(a,b,c,d,e);
			 t[n]=z;
			 n=n+1;
			 
		   }
		   br.close();
	   }catch(Exception ex) {
		   return;
	   }
 }
 public void affiche()
 {
	 System.out.println("CIN       Nom        Prenom     Adresse     Numero telephone");
	   for(int i=0;i<n;i++)
	   {
		   System.out.println(t[i]);
	   }
 }
 public Client retourner(String r)
	{
		int i=0;
		while (i<n && (t[i].getCIN()).equals(r)==false)
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
}
