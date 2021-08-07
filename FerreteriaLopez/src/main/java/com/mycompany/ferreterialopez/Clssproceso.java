
package com.mycompany.ferreterialopez;


public class Clssproceso {
    
    public int SegLocal;
    public int ComisionBan;
    public int Transporte;
    public int flete;
    public int impuestos;
    public String MATRIZ[][];
    public String matrix[][];
    private int VSF;
    private int TGV;
    private double CG;
    private double CGP;
    private String VectorGV[];
    private String VectorGP[];
    private String VectorCT[];
    private String VectorCU[];
    public int TGP;
    
    public Clssproceso(String SL, String CB, String Trans, String Flete, String Imp)
    {
        
        SegLocal=Integer.parseInt(SL);
        ComisionBan=Integer.parseInt(CB);
        Transporte=Integer.parseInt(Trans);
        flete=Integer.parseInt(Flete);
        impuestos=Integer.parseInt(Imp);  
        
    }
    
    public void llenarMatrix(String matriz[][]){
        matrix=matriz;       
    }
    
    public void primerPaso(){
        int precio;
        int cant;
        int suma=0;
        
        for (int i = 0; i < matrix.length; i++) {
            precio=Integer.parseInt(matrix[i][2]);
            cant=Integer.parseInt(matrix[i][0]);
            suma+=precio*cant;
            
        }
        VSF=suma;              
        TGV=SegLocal+ComisionBan+impuestos;
        
        CG=TGV/VSF;
                
    }
            
    public String cuartoPaso(){
        
        primerPaso();
        int precio;
        int cantidad;
        int peso;
        int pesoTotal;
        int suma=0;
        String GranTotal="";
        VectorGV=new String[matrix.length];
        VectorGP=new String[matrix.length];
        VectorCU=new String[matrix.length];
        VectorCT=new String[matrix.length];
        
        for (int i = 0; i < matrix.length; i++) {
            precio=Integer.parseInt(matrix[i][2]);
            cantidad=Integer.parseInt(matrix[i][0]);
            peso=Integer.parseInt(matrix[i][3]);
            VectorGV[i]=Double.toString(precio*CG);
            suma+=peso*cantidad;
        }
        pesoTotal=suma;
        
        TGP=flete+Transporte;
        
        CGP=TGP/pesoTotal;
        
        for (int i = 0; i < matrix.length; i++) {
            peso=Integer.parseInt(matrix[i][2]);
            VectorGP[i]=Double.toString(peso*CGP);
            
        }
        suma=0;
        
        for (int i = 0; i <matrix.length; i++) {
            precio=Integer.parseInt(matrix[i][2]);
            cantidad=Integer.parseInt(matrix[i][0]);
            double gv =Double.valueOf(VectorGV[i]);
            double gp=Double.valueOf(VectorGP[i]);
            double f=precio+gv+gp;
            double g=f*cantidad;
            VectorCU[i] =Double.toString(f);
            VectorCT[i]=Double.toString(g);
            suma+=suma+g;
            
        }
        GranTotal=Integer.toString(suma);
        return GranTotal;
    }
    
    public String[][] matrizMostrar(){
        cuartoPaso();
        MATRIZ= new String[matrix.length][7];    
        
        for (int i = 0; i < matrix.length; i++) {
            MATRIZ[i][0]=matrix[i][0];
            MATRIZ[i][1]=matrix[i][1];
            MATRIZ[i][2]=matrix[i][2];
            MATRIZ[i][3]=VectorGV[i];
            MATRIZ[i][4]=VectorGP[i];
            MATRIZ[i][5]=VectorCU[i];
            MATRIZ[i][6]=VectorCT[i];            
        }

        return MATRIZ;
    }
}
