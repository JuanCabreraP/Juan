package fp.universidad.tipos.test;

import fp.universidad.tipos.Despacho;
import fp.universidad.tipos.Espacio;
import fp.universidad.tipos.TipoEspacio;

public class TestDespacho {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   Despacho d1 = new Despacho("F1.32", 25, 1);
       System.out.println(d1);
       
       Despacho d2 = new Despacho("A0.10,0,100");
       System.out.println(d2);
	}

}
