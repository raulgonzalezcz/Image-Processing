/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaimagesGUI;


import java.awt.Color;
import java.awt.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import javax.swing.JPanel;
/**
 *
 * Thanks to,
 * @author Jack
 * edited by Raúl González Cruz
 * email: raul.gonzalezcz@udlap.mx
 */

public class CEvaluarPatron 
{
    Image aImagen;
    public int EvaluarPatronFiguras(Image Imagen)
            //public ArrayList EvaluarPatronFiguras(Image Imagen)
    {
        ArrayList ListaResultadoRegiones = new ArrayList();
        aImagen=Imagen;
        //convirtiendo imagen a matriz
        CmatrizTransformacion oTransformador=new CmatrizTransformacion();
        String[][] MatrizImagen=oTransformador.ObtenerMatrizPatron(aImagen);
        
        oTransformador.Graficar(MatrizImagen);
        System.out.println("Imagen transformada en matriz");
        //obtener la lista de subregiones
        CAgrupar oGenerarGrup=new CAgrupar();
        int noFiguras = oGenerarGrup.GererarListaGrupos(MatrizImagen, "1");
        /*
        ArrayList ListaGrupos = oGenerarGrup.GererarListaGrupos(MatrizImagen, "1");
        System.out.println("Subregiones hechas");
        //evaluar Cada region dela figura
        int NroRegiones = ListaGrupos.size();
        System.out.println("Numero de regiones: "+NroRegiones);
        for(int i=0;i<NroRegiones;i++)
        {
            System.out.println("Evaluando region " + i);
            String[][] SubRegioni = (String[][])ListaGrupos.get(i);
            double[] Resultadoi=EvaluarRegionFiguraPatron(SubRegioni);
            ListaResultadoRegiones.add(Resultadoi);
        }
        System.out.println("Terminamos la lista");
                */
        return noFiguras;
        
    }
    
    private double [] EvaluarRegion(String[][] SubRegion)
    {
        int ancho = SubRegion.length;
        int largo = SubRegion[0].length;
        
        double[] listaPorcentajes=new double[16]; 
        //obtener lista de patrones
        for(int i=1;i<=16;i++)
        {
            //obteniedo el patron i
            File in=null;
            try
            {
                in = new File("patrones/patron"+i+".png");
            }
            catch(Exception e)
            {
                    System.out.println("no se encontro el parametro imagen..");
            }
            Image Imagenpatron=Toolkit.getDefaultToolkit().getImage(in.getAbsolutePath());
            
            //redimensionando la imagen al tamaño de la region
            Image ImagenRed_Patron = Imagenpatron.getScaledInstance(ancho, largo, 1);
            
            //convirtiendo el patron 
            CmatrizTransformacion oTransform =new CmatrizTransformacion();
            String[][] MatrizPatron=oTransform.ObtenerMatrizPatron(ImagenRed_Patron);
            
            //evaluando porcentajes
            double porcentaje = PorcentajeAproximacion(SubRegion, MatrizPatron);
            
            //guardando porcentajes
            listaPorcentajes[i-1]=porcentaje;
        }
        return listaPorcentajes;
    }
    
    private double PorcentajeAproximacion(String[][] MatrizRegion,String[][] MatrizPAtron)
    {
        int ancho = MatrizRegion.length;
        int alto = MatrizRegion[0].length;
        
        //System.out.print("region=("+ancho+","+alto+")     patron=("+ancho1+","+alto1+")");
        
        int totalPixeles = ancho*alto;
        
        int ContadorPX =0;
        
        for(int i=0;i<ancho;i++)
        {
            for(int j=0;j<alto;j++)
            {
                String ValorRegion = MatrizRegion[i][j];
                String ValorPatron = MatrizPAtron[i][j];
                if(ValorPatron.equals(ValorRegion))
                {
                    ContadorPX=ContadorPX+1;
                }
            }
        }
        System.out.print("total="+totalPixeles+", parecido="+ContadorPX+"\n");
        return ContadorPX*100/totalPixeles;
    }
    
    private double[] EvaluarRegionFiguraPatron(String[][] MatrizRegion)
    {
        double[] Porcentajes = EvaluarRegion(MatrizRegion);
        //inciando porcentaje de figuras
        
        //verificando circulos
        double PorcentajeCirculo=Mayor(Porcentajes, 0, 4);
        //verificando cuadrados
        double PorcentajeCuadrado=Mayor(Porcentajes, 5, 8);
        //verificando triangulos
        double Porcentajetriangulo=Mayor(Porcentajes, 9, 15);
        
        double[] Figuras_100 = new double[3];
        System.out.print("===========\n");
        Figuras_100[0]=PorcentajeCirculo;
        Figuras_100[1]=PorcentajeCuadrado;
        Figuras_100[2]=Porcentajetriangulo;
        return Figuras_100;
    }
    
    public double  Mayor(double[] Porcentajes,int PosI,int PosF)
    {
        double Mayor = Porcentajes[PosI];
        System.out.print(Mayor+"% \n");
        for(int i=PosI+1;i<=PosF;i++)
        {

            double Numi = Porcentajes[i];
            System.out.print(Numi+"% \n");
            if(Numi>Mayor)
            {
                Mayor=Numi;
            }
        }
        return Mayor;
    }
}
