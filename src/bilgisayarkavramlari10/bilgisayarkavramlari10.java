/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bilgisayarkavramlari10;

/**
 *
 * @author maytemur 
 * Java,Programlamaya Giriş serisi bitti Nesne Yönelimli Programlama (Java ile) serisinden devam
 * Object Sınıfı (klonlama,derin ve sığ kopyalama,equals,toString) - 8nci video
 * 
 */
class insan {

    int boy;
}

class ogrenci extends insan implements Cloneable {

    Object kopyala() throws CloneNotSupportedException {
        return this.clone();
    }
    ogrenci kopyala2(){
        ogrenci temp= new ogrenci();
        temp.boy=this.boy;
        return temp;
    }
    boolean equals(ogrenci rhs){
        return this.boy==rhs.boy; //right hand side'ın kısaltması sağ taraftaki ile eşitmi?
    }
    public String toString(){
        return "bu objenin boyu"+this.boy;
    }
}

public class bilgisayarkavramlari10 {

    public static void main(String[] args) throws CloneNotSupportedException {
        // TODO code application logic here
        insan ali = new insan();
        insan ahmet = ali; //////////////shallow copy(sığ kopyalama)
        ali.boy = 180;
        System.out.println(ahmet.boy);
        if (ali == ahmet) {
            System.out.println("eşitler");
        }
        if (ali.equals(ahmet)) {
            System.out.println("eşitler2");
        }
        ogrenci ayse= new ogrenci();
        ayse.boy=160;
        ogrenci fatma=(ogrenci)ayse.kopyala(); /////////// Deep Copy() derin kopyalama
        System.out.println(ayse.boy);
        System.out.println(fatma.boy);
        fatma.boy=190;
        System.out.println(ayse.boy);
        System.out.println(fatma.boy);
        ayse.boy=190;
        if (ayse==fatma) {
            System.out.println("eşitler3");
        }
        if (ayse.equals(fatma)) {
            System.out.println("eşitler4");
        }
        //bunlar 2 ayrı varlık olduğu için eşit değiller deep copy yapıldı!
        
        System.out.println(ayse);
        System.out.println(ayse.hashCode()); //her objenin ayrı hashcode'u var objeleri birbiriyle
        //karşılaştırmaya yarar        
    }
}