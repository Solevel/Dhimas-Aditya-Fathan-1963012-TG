/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppdb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class Fungsi {
    
    public void SimpanDinamis(String NamaTabelnya, String[] Fieldnya, String[] Isi){
           try {
               String SQLSave = "INSERT INTO "+NamaTabelnya+" "+getFieldTabel(Fieldnya)+" VALUES "+getValueTabel(Isi);
               Connection conn=(Connection)Koneksi.koneksiDB();
               Statement st=conn.createStatement();
               st.executeUpdate(SQLSave);
               st.close();
               System.out.println("Data Berhasil Disimpan");
           } catch (Exception e){
           System.out.println(e.toString());
}
}
    
    public String getFieldTabel(String[] FieldTabelnya){
        String hasil="";
       int deteksiIndexAkhir=FieldTabelnya.length-1;
        try {
           for (int i = 0; i < FieldTabelnya.length; i++){
               
               if (i==deteksiIndexAkhir){
                   hasil=hasil+FieldTabelnya[i];
               } else {
                    hasil=hasil+FieldTabelnya[i]+",";
               }
              
           }
        }catch (Exception e){
            System.out.println(e.toString());
}
    return "("+hasil+")";
    
}

    public String getValueTabel(String[] IsiTabelnya){
       String hasil="";
       int DeteksiIndex=IsiTabelnya.length-1;
       try {
            for (int i = 0; i < IsiTabelnya.length; i++){
                 if (i==DeteksiIndex){
                         hasil=hasil+"'"+IsiTabelnya[i]+"'";
                     } else {
                         hasil=hasil+"'"+IsiTabelnya[i]+"',";
                     }
            }
       }catch (Exception e){
           System.out.println(e.toString());
}
    return "("+hasil+")";
}
    
    public void setJudulTabel(JTable NamaTabel, String[] JudulKolom){
           try {
                DefaultTableModel Tabel = new DefaultTableModel(null, JudulKolom);
                NamaTabel.setModel(Tabel);
                for (int i=0; i< JudulKolom.length;i++){
                    Tabel.addColumn(JudulKolom[i]);
                }
                
           }catch (Exception e){
           System.out.println(e.toString());
}
       
}
    
    public Object[][] isiTabel(String SQL, int jumlah){
           Object[][] data = null;
           try {
               Connection conn=(Connection)Koneksi.koneksiDB();
               Statement st=conn.createStatement();
               ResultSet rs = st.executeQuery(SQL);
               rs.last();
               int baris = rs.getRow();
               rs.beforeFirst();
               int j=0;
               
               data = new Object[baris][jumlah];
               
               while (rs.next()){
                   for (int i=0; i< jumlah; i++){
                       data[j][i]=rs.getString(i+1);
                   }
                   j++;
               }              
           }catch (Exception e){
               System.out.println(e.toString());
           }
           return data;
       }
    
    public void tampilIsiTabel(JTable NamaTabel, String SQL, String[] Kolom){
      try {
        NamaTabel.setModel(new DefaultTableModel(isiTabel(SQL,Kolom.length), Kolom));
           }catch (Exception e){
           System.out.println(e.toString());
        }
    }
    
    public String getFieldTabel(String[] Field, String[] value){
             String hasil="";
             int lokasi = Field.length-1;
            try {
              for (int i =0; i< Field.length; i++){
                 if (i ==lokasi){
                     hasil=hasil +Field[i]+" ='"+value[i]+"'";
                 } else{
                     hasil=hasil +Field[i]+" ='"+value[i]+"',";
                 } 
              }  
               
            }catch (Exception e){
              System.out.println(e.toString());
               
           }
        return hasil;
       }
         
        public void UbahDinamis(String NamaTabel, String PrimaryKey, String PrimaryValue, String[] Field, String[] value){
          try {
            Connection conn=(Connection)Koneksi.koneksiDB();
            Statement st=conn.createStatement();
            String SQL = "UPDATE "+NamaTabel+" SET "+getFieldTabel(Field, value)+" WHERE "+PrimaryKey+"='"+PrimaryValue+"'";
            st.executeUpdate(SQL);
            conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di edit");
          }catch (Exception e){
            System.out.println(e.toString());
        } 
    }
        
        public void HapusDinamis(String NamaTabel, String Key, String Value){
           try {
               
               String SQL="DELETE FROM "+NamaTabel+" WHERE "+Key+"='"+Value+"'";
               Connection conn=(Connection)Koneksi.koneksiDB();
               Statement st=conn.createStatement();
               st.executeUpdate(SQL);
               st.close();
               JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
           }catch (Exception e){
               System.out.println(e.toString());
           }
    }
        
        
        
       
    
}
