package Store_Mangement;

import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Main {
    public static boolean validateJavaDate(String strDate) {
    	if(strDate.trim().equals(""))
    	{
    		return true;
    	}
    	else
    	{
    		SimpleDateFormat sdfrmt= new SimpleDateFormat("dd/MM/yyyy");
    		sdfrmt.setLenient(false);
    		try
    		{
    			Date javaDate=sdfrmt.parse(strDate);
    		}catch(ParseException e) {
    			return false;
    		}
    		return true;
    	}
    }
	public static void main(String[] args) {
		Stock s=new Stock();
        s.read();
		Group g=new Group();
		g.read();
		Tabcmd tcm= new Tabcmd();
		tcm.read();
	
		
		 int o;
		 
		int o1;
		do {
		do {
		System.out.println("\nEnter the number of the option you want to perform: \n");
            System.out.println("1/ Product Management \n2/ Client Management \n3/ Order Management \n4/ Quit \n");
		Scanner oo1=new Scanner(System.in);
		o1=oo1.nextInt();
		}while(o1!=1 && o1!=2 && o1!=3 && o1!=4 );
		
		if (o1==1) {
		do {
		 System.out.println("Enter the number of the option you want to perform: \n");
                System.out.println("1/ Add a product \n2/ Remove a product \n3/ Search a product by reference \n4/ Search a product by name \n5/ Display all products");
		Scanner oo=new Scanner(System.in);
		o=oo.nextInt();
		}while(o!=1 && o!=2 && o!=3 && o!=4 && o!=5);
		
		if(o==1)
		{
		int r;
		do {
		System.out.println("Reference (3 digits): ");
		Scanner ref=new Scanner(System.in);
		r=ref.nextInt();
		} while(r<100 || r>999 );
		String re;
		re=""+r;
		
		String nom;
		System.out.println("Name : ");
		Scanner nomm=new Scanner(System.in);
		nom=nomm.nextLine();
		double prix;
		do {
		System.out.println("Price : ");
		Scanner prr=new Scanner(System.in);
		prix=prr.nextDouble();
		} while(prix<0 );
		String pre;
		pre=""+prix;
		int qte;
		do {
		System.out.println("Quantity : ");
		Scanner q=new Scanner(System.in);
		qte=q.nextInt();
		} while(qte<0);
		String quantite;
		quantite=""+qte;
		if(nom.length()<10)
		{
		int pl=10-nom.length();
	
			
			for (int i=0;i<pl;i++)
				nom=nom+" ";
		}
		
		if(quantite.length()<4)
		{
		int pl=4-quantite.length();
	
			
			for (int i=0;i<pl;i++)
				quantite=quantite+" ";
		}
		
		Produit p1=new Produit(re,nom,quantite,pre);
		
		
		s.ajouterP(p1);
		s.save();
		
		
		}
		
		if (o==2)
		{
			int r;
			do {
			System.out.println("Reference (3 digits): ");
			Scanner ref=new Scanner(System.in);
			r=ref.nextInt();
			} while(r<100 || r>999 );
			String re;
			re=""+r;
			s.supprimerP(re);
			s.save();
		}
		if (o==3)
		{
			int r;
			do {
			System.out.println("Reference (3 digits): ");
			Scanner ref=new Scanner(System.in);
			r=ref.nextInt();
			} while(r<100 || r>999 );
			String re;
			re=""+r;
			s.chercherPr(re);
			
		}
		if (o==4)
		{
			String nom;
			System.out.println("Name : ");
			Scanner nomm=new Scanner(System.in);
			nom=nomm.nextLine();
			if(nom.length()<10)
			{
			int pl=10-nom.length();
		
				
				for (int i=0;i<pl;i++)
					nom=nom+" ";
			}
			s.chercherPn(nom);
			
		}
		if (o==5)
		{s.affiche();}
		
		}
		
		
		if (o1==2) {
			do {
			System.out.println("Enter the number of the option you want to perform: \n");
                System.out.println("1/ Add a client \n2/ Remove a client \n3/ Search a client by ID \n4/ Search a client by first name \n5/ Display all clients \n");
                Scanner oo = new Scanner(System.in);
		
			o=oo.nextInt();
			}while(o!=1 && o!=2 && o!=3 && o!=4 && o!=5);
			
			if(o==1)
			{
			String cin;
			do {
			System.out.println("ID (8 digits) : ");
			Scanner cinn=new Scanner(System.in);
			cin=cinn.nextLine();
			} while((cin.length())!=8 );
			
			String nom;
			System.out.println("Family Name : ");
			Scanner nomm=new Scanner(System.in);
			nom=nomm.nextLine();
			String prenom;
			System.out.println("First name : ");
			Scanner prenomm=new Scanner(System.in);
			prenom=prenomm.nextLine();
			String adr;
			System.out.println("Adress : ");
			Scanner adres=new Scanner(System.in);
			adr=adres.nextLine();
			String tel;
			do {
			System.out.println("Phone number (8 digits) : ");
			Scanner tell=new Scanner(System.in);
			tel=tell.nextLine();
			} while((tel.length())!=8 );
			if(nom.length()<10)
			{
			int pl=10-nom.length();
		
				
				for (int i=0;i<pl;i++)
					nom=nom+" ";
			}
			if(prenom.length()<10)
			{
			int pl=10-prenom.length();
		
				
				for (int i=0;i<pl;i++)
					prenom=prenom+" ";
			}
			if(adr.length()<10)
			{
			int pl=10-adr.length();
		
				
				for (int i=0;i<pl;i++)
					adr=adr+" ";
			}
			
		
				
			Client c1=new Client(cin,nom,prenom,adr,tel)	;
			g.ajouter(c1);
			g.save();
			
			
			}
			
			if (o==2)
			{
				String cin;
				do {
				System.out.println("ID (8 digits) : ");
				Scanner cinn=new Scanner(System.in);
				cin=cinn.nextLine();
				} while((cin.length())!=8 );
				g.supprimer(cin);
				g.save();
			}
			if (o==3)
			{
				String cin;
				do {
				System.out.println("ID (8 digits) : ");
				Scanner cinn=new Scanner(System.in);
				cin=cinn.nextLine();
				} while((cin.length())!=8 );
				g.chercherCIN(cin);
				
			}
			if (o==4)
			{
				String nom;
				System.out.println("First name : ");
				Scanner nomm=new Scanner(System.in);
				nom=nomm.nextLine();
				if(nom.length()<10)
				{
				int pl=10-nom.length();
			
					
					for (int i=0;i<pl;i++)
						nom=nom+" ";
				}
				g.cherchern(nom);
			}
			if (o==5)
				g.affiche();			
			}
		
		if (o1==3) {
			
			do {
			System.out.println("Enter the number of the option you want to perform: \n");
                System.out.println("1/ Add an order \n2/ Remove an order \n3/ Search orders by client \n4/ Search orders by product \n5/ Search orders by date \n6/ Display all orders \n");
			Scanner oo=new Scanner(System.in);
			o=oo.nextInt();
			}while(o!=1 && o!=2 && o!=3 && o!=4 &&o!=5 && o!=6);
		
	
		if (o==1)
		{
			
			int r;
			do {
			System.out.println("Porduct's refernce (3 digits) : ");
			Scanner ref=new Scanner(System.in);
			r=ref.nextInt();
			} while(r<100 || r>999 );
			String re;
			re=""+r;
			String cin;
			do {
			System.out.println("Client's ID (8 digits) : ");
			Scanner cinn=new Scanner(System.in);
			cin=cinn.nextLine();
			} while((cin.length())!=8 );
			String d;
			do {
			System.out.println("date : ");
			Scanner cd=new Scanner(System.in);
			d=cd.nextLine();
			} while(validateJavaDate(d)==false );
			int qte;
			do {
			System.out.println("quantity : ");
			Scanner q=new Scanner(System.in);
			qte=q.nextInt();
			} while(qte<0);
			Produit pe=s.retourner(re);
			Client ce=g.retourner(cin);
			if (pe==null)
				System.out.println("Product not found");
			if(ce==null)
				System.out.println("Client not found");
			if ((pe!=null )&&(ce!=null))
			{
				Commande cmd= new Commande(ce,pe,qte,d);
				if(cmd.getProduit()!=null)
				{s.remplacer(cmd.getProduit());
				s.save();
				tcm.ajouter(cmd);
				tcm.save();}
			}
		}
		if (o==2)
		{
			
			int r;
			do {
			System.out.println("Product's reference (3 digitd) : ");
			Scanner ref=new Scanner(System.in);
			r=ref.nextInt();
			} while(r<100 || r>999 );
			String re;
			re=""+r;
			String cin;
			do {
			System.out.println("Client's ID (8 digits) : ");
			Scanner cinn=new Scanner(System.in);
			cin=cinn.nextLine();
			} while((cin.length())!=8 );
			String d;
			//do {
			System.out.println("date : ");
			Scanner cd=new Scanner(System.in);
			d=cd.nextLine();
			//} while(validateJavaDate(d)==false );
			Produit pe=s.retourner(re);
			Client ce=g.retourner(cin);
			if (pe==null)
				System.out.println("Product not found");
			if(ce==null)
				System.out.println("Client not found");
			if ((pe!=null )&&(ce!=null))
			{
				tcm.supprimer(ce,pe,d);
				tcm.save();
			}
		}
	    if (o==3)
	    {
	    	String cin;
			do {
			System.out.println("Client's ID (8 digits) : ");
			Scanner cinn=new Scanner(System.in);
			cin=cinn.nextLine();
			} while((cin.length())!=8 );
			Client ce=g.retourner(cin);
			if(ce==null)
				System.out.println("Client doesnt exist");
			else {
				tcm.chercherc(cin);
			}
			//tcm.affiche();			
				
	    }
	    if (o==4)
	    {
	    	int r;
			do {
			System.out.println("Product's reference (3 digits) : ");
			Scanner ref=new Scanner(System.in);
			r=ref.nextInt();
			} while(r<100 || r>999 );
			String re;
			re=""+r;
			Produit pe=s.retourner(re);
			if(pe==null)
				System.out.println("Product not found");
			else
				tcm.chercherP(re);
	    }
	    if (o==5)
	    {
	    	String d;
			//do {
			System.out.println("date : ");
			Scanner cd=new Scanner(System.in);
			d=cd.nextLine();
			//} while(validateJavaDate(d)==false );
			tcm.chercherd(d);
	    }
	    if (o==6)
	    	tcm.affiche();	
	}
		}while(o1!=4);
	}

}
