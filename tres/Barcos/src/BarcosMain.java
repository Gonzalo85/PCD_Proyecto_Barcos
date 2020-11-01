import java.rmi.Naming;

public class BarcosMain {
//	private static boolean esta=false;
	
	public BarcosMain(){
		
	}
//	public static void getObjeto(Interface _objeto){
//		objeto=_objeto;
//	}
//	public static boolean verificar(){
//		if(objeto!=null){
//			esta=true;
//		}
//		return esta;
//	}
	  public static void main (String args[]) {
		  Interface objeto1=null;
		  Interface objeto2=null;
		  
		  try {
			objeto1=(Interface) Naming.lookup("Barcos");//casting de las interfaces
			objeto2=(Interface) Naming.lookup("Contenedores");//casting de las interfaces
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		  
		  Puerta P=Puerta.Singleton();
//		  TorreControl T=TorreControl.Singleton();
		  Barco b0=new Barco(P,0,0,objeto1);
		  Barco b1=new Barco(P,1,0,objeto1);
		  BarcoPetrolero p0 = new BarcoPetrolero(P, 2, 0, 0,objeto1);
		  BarcoPetrolero p1 = new BarcoPetrolero(P, 3, 0, 1,objeto1);
		  BarcoPetrolero p2 = new BarcoPetrolero(P, 4, 0, 2,objeto1);
		  BarcoPetrolero p3 = new BarcoPetrolero(P, 5, 0, 3,objeto1);
		  BarcoPetrolero p4 = new BarcoPetrolero(P, 6, 0, 4,objeto1);
		  Barco b7=new Barco(P,7,0,objeto1);
		  Barco b8=new Barco(P,8,0,objeto1);
		  
		  
		  BarcoMercante b9=new BarcoMercante(P,3,0,12,20,5,objeto1,objeto2);
		  
		  Barco b10=new Barco(P,10,1,objeto1);
		  Barco b11=new Barco(P,11,1,objeto1);
		  Barco b12=new Barco(P,12,1,objeto1);
		  Barco b13=new Barco(P,13,1,objeto1);
		  Barco b14=new Barco(P,14,1,objeto1);
		  Barco b15=new Barco(P,15,1,objeto1);
		  Barco b16=new Barco(P,16,1,objeto1);
		  Barco b17=new Barco(P,17,1,objeto1);
		  Barco b18=new Barco(P,18,1,objeto1);
		  Barco b19=new Barco(P,19,1,objeto1);
		  
		  Thread t0= new Thread(b0);
		  Thread t1= new Thread(b1);
		  
		  Thread t2= new Thread(p0);
		  Thread t3= new Thread(p1);
		  Thread t4= new Thread(p2);
		  Thread t5= new Thread(p3);
		  Thread t6= new Thread(p4);
		  
		  Thread t7= new Thread(b7);
		  Thread t8= new Thread(b8);
		  
		  Thread t10= new Thread(b10);
		  Thread t11= new Thread(b11);
		  Thread t12= new Thread(b12);
		  Thread t13= new Thread(b13);
		  Thread t14= new Thread(b14);
		  Thread t15= new Thread(b15);
		  Thread t16= new Thread(b16);
		  Thread t17= new Thread(b17);
		  Thread t18= new Thread(b18);
		  Thread t19= new Thread(b19);
		  
		  Thread t9= new Thread(b9);
		  //gruas
		  Grua gA=new Grua(1);
		  Grua gS=new Grua(2);
		  Grua gH=new Grua(3);
		  
		  Thread tgA= new Thread(gA);
		  Thread tgS= new Thread(gS);
		  Thread tgH= new Thread(gH);
		  
		  //reponedor
		  Reponedor rep=new Reponedor();
		  Thread r1=new Thread(rep);
		  
		  t0.start();
		  t1.start();
		  t2.start();
		  t3.start();
		  t12.start();
		  t13.start();
		  t14.start();
		  t15.start();
		  t16.start();
		  t17.start();
	
		  
		  t4.start();

		  t5.start();

		  t6.start();

		  t7.start();
		  t8.start();


		  t10.start();
		  t11.start();

	
		  t18.start();
		  t19.start();
		  
		  t9.start();

		  
		  tgA.start();
		  tgS.start();

		  tgH.start();
		  
		  r1.start();
		  
		  
		  
//		  System.out.println ("End of main thread");
	  }

}
