
package javaimagesGUI;

import java.awt.image.BufferedImage;
import java.awt.Image;

/**
 *
 * Thanks to,
 * @author Jack
 * edited by Raúl González Cruz
 * email: raul.gonzalezcz@udlap.mx
 */
public class CmatrizTransformacion 
{
    
    public  String[][] ObtenerMatrizPatron(Image patron)
    {
        String arreglo[][];
        CConversion Convertir = new CConversion();
                BufferedImage Nueva = Convertir.Convertir_Buffer(patron);

		//Agrupar
		arreglo = new String[Nueva.getWidth()][Nueva.getHeight()];
		for(int x=0;x<=Nueva.getWidth()-1 ;x++){
			for(int y=0;y<=Nueva.getHeight()-1;y++){
				String val= Integer.toHexString(Nueva.getRGB(x,y)).toString();
                                val=val.substring(2, val.length());
				arreglo[x][y]=val;
			}
		}
                return LiberarRuidos(arreglo);
    }
    
    public  String[][] LiberarRuidos(String[][] MATRIZ)            
    {

        String[][]aux=new String[MATRIZ.length][MATRIZ[0].length];
        for(int i=0;i<MATRIZ.length;i++)
        {
            for(int j=0;j<MATRIZ[0].length;j++)
            {
                String val=MATRIZ[i][j];
                if(val.compareTo("7fffff")>0)
                {aux[i][j]="0";}
                else
                {aux[i][j]="1";}
            }
        }
        return aux;
    
    }
            
    public String[][] Lib_Ruido_RGB(String[][] MATRIZ)
    {
        String[][]aux=new String[MATRIZ.length][MATRIZ[0].length];
        for(int i=0;i<MATRIZ.length;i++)
        {
            for(int j=0;j<MATRIZ[0].length;j++)
            {
                String val=MATRIZ[i][j];
                if(val.compareTo("3fffff")<0)//negro
                {aux[i][j]="0";}
                else
                {
                    if(val.compareTo("7fffff")<0)//gris oscuro
                    {aux[i][j]="1";}
                    else
                    {
                        if(val.compareTo("bffffd")<0)//gris claro
                        {aux[i][j]="2";}
                        else
                        {aux[i][j]="3";}//blanco
                        
               
                    }
                }   
            }
        
        }
        return aux;
    }

    public  void Graficar(String[][] M)
    {
        for(int i=0;i<M.length;i++)
        {
            for(int j=0;j<M[0].length;j++)
            {
                int val= Integer.valueOf(M[i][j]);
                System.out.print(val + " ");
            }
            System.out.print("\n");
        }
        

    }

}

