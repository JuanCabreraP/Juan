package fp.universidad.tipos.test;

import fp.universidad.tipos.Espacio;
import fp.universidad.tipos.TipoEspacio;

public class TestEspacio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Espacio e1 = new Espacio(TipoEspacio.TEORIA,"A3.10", 230, 3);
       System.out.println(e1);
       
       try {
    	   Espacio e2 = new Espacio(TipoEspacio.TEORIA,"A3.10", -3, 3);  
       }catch(Exception e) {
    	   System.out.println(e.getMessage());
       }
       
       Espacio e3 = new Espacio(TipoEspacio.LABORATORIO,"F1.32", 25, 1);
       System.out.println(e3);
       
       Espacio e4 = new Espacio("A0.10,0,100,TEORIA");
       System.out.println(e4);
	}

}
