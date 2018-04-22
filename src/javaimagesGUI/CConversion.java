package javaimagesGUI;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import java.awt.Image;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * Thanks to,
 * @author Jack
 * edited by Raúl González Cruz
 * email: raul.gonzalezcz@udlap.mx
 */

public class CConversion
{
    Image aImagenOrigen = null;
    Image destino = null;
            
    BufferedImage Convertir_Buffer(Image image) 
    {
	if( image instanceof BufferedImage ) 
        {
		return( (BufferedImage)image );
	} 
        else 
        {
		image = new ImageIcon(image).getImage();
		BufferedImage bufferedImage = new BufferedImage(image.getWidth(null),image.getHeight(null),BufferedImage.TYPE_INT_RGB );
		Graphics g = bufferedImage.createGraphics();
                g.drawImage(image,0,0,null);
		g.dispose();
		return( bufferedImage );
	}
    }
    
    public  Image ConvertirAGrises(Image imagen)
    {
        if (destino == null) 
        {
            try {
                int  p, promedio, rojo, verde, azul;

                BufferedImage Nueva = Convertir_Buffer(imagen);
                  int  a = Nueva.getWidth();  //Ancho
                   int  h = Nueva.getHeight(); //Alto         
                     int totalDePixeles = a * h;
                  int pixeles[] = new int[totalDePixeles];   //Arreglo de pixeles
                  PixelGrabber pg = new PixelGrabber(imagen,0,0,a,h,pixeles,0,a);
                  try
                  {
                   pg.grabPixels();
                   for(int i = 0; i < totalDePixeles; i++)
                   {
                    p = pixeles[i]; //Valor de un pixel
                    rojo = (0xff & (p>>16));  //Desplaza el entero p 16 bits a la derecha y aplica la operacion AND a los primeros 8 bits 
                    verde = (0xff & (p>>8));  //Desplaza el entero p 8 bits a la derecha  y aplica la operacion AND a los siguientes 8 bits
                    azul = (0xff & p) ;        //Aplica la operacion AND a los siguientes 8 bits
                    promedio = (int) ((rojo+verde+azul)/3);
                    pixeles[i]=(0xff000000|promedio<<16|promedio<<8|promedio);
                   }
                   JFrame jfr=new JFrame();
                   destino  = jfr.createImage(new MemoryImageSource(a,h,pixeles,0,a));
                  }catch(InterruptedException e)
                  {
                   JOptionPane.showMessageDialog(null,"Error del sistema : "+e.getMessage(),"Error de Imagen",JOptionPane.OK_OPTION);
                   //this.mensajeDeError = e.getMessage();
                  }
            }
            catch(Exception e){System.out.println(e);
            }
        }
        return destino;
    }
    
    public  String[][] LiberarRuidos(String[][] MATRIZ)            
    {

        String[][]aux=new String[MATRIZ.length][MATRIZ[0].length];
        for(int i=0;i<MATRIZ.length;i++)
        {
            for(int j=0;j<MATRIZ[0].length;j++)
            {
                String val=MATRIZ[i][j];
                if(val.compareTo("7fffff")<0)
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
                //System.out.print(val + " ");
            }
            System.out.print("\n");
        }
        

    }
  
}
