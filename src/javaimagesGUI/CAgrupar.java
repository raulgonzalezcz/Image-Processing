/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaimagesGUI;
import java.util.ArrayList;
/**
 *
 * Thanks to,
 * @author Jack
 * edited by Raúl González Cruz
 * email: raul.gonzalezcz@udlap.mx
 */
public class CAgrupar 
{
        public String ValorNuevo;
	public String ValorViejo;
	public String arreglo[][];
        
        private int Agrupar(String ArregloDeBusqueda[][],String ValorABuscar,boolean RenombradoAutomaticoGrupos,String ValorAModificar)
        {
            System.out.print("Iniciar Agrupacion...");
		int grupos=0;
		arreglo=ArregloDeBusqueda;
		ValorNuevo=ValorAModificar;
		ValorViejo=ValorABuscar;
                int Ancho = ArregloDeBusqueda[0].length; //de la fila 0 obtenemos el nro de columnas = ancho
                int Alto=ArregloDeBusqueda.length;//numero de filas = alto
		for(int yx=0;yx<Ancho;yx++)
                {
                    for(int yy=0;yy<Alto;yy++)
                    {
    			if(ArregloDeBusqueda[yx][yy]==ValorViejo)
                        {
    				if(RenombradoAutomaticoGrupos==false)
                                {
    					grupos++;
	    				this.BuscarVecino(yx,yy,Ancho,Alto);
	    			}
                                else
                                {
    					grupos++;
    					ValorNuevo=Integer.toString(grupos);
    					this.BuscarVecino(yx,yy,Ancho,Alto);
	    			}
    			}
                    }
                }
                System.out.print("\nNúmero de Grupos: " + grupos);
                return grupos;
        }
        
        private void BuscarVecino(int x,int y,int Ancho,int Alto)
        {
		if((x>=0 &&x<Ancho) && (y>=0 && y<Alto))
                {
                    arreglo[x][y]=ValorNuevo;
		    if(y>0 && arreglo[x][y-1]==ValorViejo)
                    {
			BuscarVecino(x,y-1,Ancho,Alto);
		    }
		    if(x>0 && y>0 && arreglo[x-1][y-1]==ValorViejo)
                    {
			BuscarVecino(x-1,y-1,Ancho,Alto);
		    }
		    if(x>0 && arreglo[x-1][y]==ValorViejo)
                    {
			BuscarVecino(x-1,y,Ancho,Alto);
		    }
                    if(x>0 && y<(Alto-1) && arreglo[x-1][y+1]==ValorViejo)
                    {
			BuscarVecino(x-1,y+1,Ancho,Alto);
                    }
                    if(y<(Alto-1) && arreglo[x][y+1]==ValorViejo)
                    {
			BuscarVecino(x,y+1,Ancho,Alto);
                    }
                    if(y<(Alto-1) && x<(Ancho-1) && arreglo[x+1][y+1]==ValorViejo)
                    {
			BuscarVecino(x+1,y+1,Ancho,Alto);
                    }
                    if(x<(Ancho-1) && arreglo[x+1][y]==ValorViejo)
                    {
			BuscarVecino(x+1,y,Ancho,Alto);
                    }
                    if(x<(Ancho-1) && y>0 && arreglo[x+1][y-1]==ValorViejo)
                    {
			BuscarVecino(x+1,y-1,Ancho,Alto);
                    }
                }
	}
        
        
        public int GererarListaGrupos(String[][] Matriz,String ValorGrupos)
                //public ArrayList GererarListaGrupos(String[][] Matriz,String ValorGrupos)
        {
            //agrupando matriz
            ArrayList ListaG = new ArrayList();
            int NroGrupos = this.Agrupar(Matriz, ValorGrupos, true,ValorGrupos);

            //generando lista de subregiones
            for(int i=1;i<=NroGrupos;i++)
            {
                  String[][] Mi = GenerarSubMatriz(Matriz, String.valueOf(i));
                  int Ancho = Mi.length;
                  int Largo = Mi[0].length;
                   if (Ancho > 5 && Largo >5)
                   {   
                    ListaG.add(Mi);
                   }
            }
            //return ListaG;
            return NroGrupos;
        }
        
        public String[][] GenerarSubMatriz(String[][] MatrizPrincipal,String NroGrupo)
        {
                int Ancho = MatrizPrincipal[0].length;
                int Alto=MatrizPrincipal.length;
                //BUSCANDO LIMITES X0,Y0-X1,Y1
                int X0 =Ancho;
                int Y0 =Alto;
                int X1 =0;
                int Y1 =0;
                System.out.print(""+NroGrupo+" \n");
		for(int x=0;x<Ancho;x++)
                {
                    for(int y=0;y<Alto;y++)
                    {
                        String Valorxy = MatrizPrincipal[x][y];
                        if(Valorxy.equals(NroGrupo))
                        {
                            //verificando si es menor ala posicion Xi
                            if(x < X0)
                            {
                                X0 = x;
                            }
                            //verificando si es menor ala posicion Xi
                            if(x > X1)
                            {
                                X1 = x;
                            }
                            //verificando si es menor ala posicion Yi
                            if(y < Y0)
                            {
                                Y0 = y;
                            }
                            //verificando si es menor ala posicion Xi
                            if(y > Y1)
                            {
                                Y1 = y;
                            }
                        }
                    }
                }
                System.out.print("("+X0+","+Y0+") ; ("+X1+","+Y1+") \n");
                /*Generamos la submatriz*/
                //obteniendo el alto y ancho de lamatriz
                int filas = (X1-X0)+1;
                int columnas = (Y1-Y0)+1;
                
                System.out.print(filas+"-"+columnas+"\n");
                
                String[][] SubMatriz = new String[filas][columnas];
                int posX =0;
                int posY =0;
                for(int i=X0;i<=X1;i++)
                {
                    for(int j=Y0;j<=Y1;j++)
                    {
                        String ValorMatriz = MatrizPrincipal[i][j];
                        if(ValorMatriz.equals(NroGrupo))
                        {
                            SubMatriz[posX][posY]="1";
                        }
                        else
                        {
                            SubMatriz[posX][posY]="0";
                        }
                        posY=posY+1;
                    }
                    posY=0;
                    posX=posX+1;
                }
                
                return SubMatriz;
        }
    
}
