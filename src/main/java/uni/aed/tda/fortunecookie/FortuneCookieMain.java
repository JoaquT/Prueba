package uni.aed.tda.fortunecookie;

import java.util.Scanner;
import java.util.Random;
import uni.aed.tda.LinkedListTDA.*;
public class FortuneCookieMain {
    private static final FortuneCookieManager fortuna=new FortuneCookieManager();        ;
    private static Scanner scr=new Scanner(System.in).useDelimiter("\n");        
    public static void main(String[] args) {
        FortuneCookieMain fortunaMain=new FortuneCookieMain();        
        fortunaMain.getFortuneCookie();
    }    
    
    private void getFortuneCookie(){        
        String rpta;        
        System.out.println("****Galletas de la Fortuna****");
        System.out.println(fortuna.nexFortune());        
        System.out.println("Pulse S para continuar obteniendo galletas de la fortuna, N para salir:");        
        while(true){
            rpta=scr.next();
            if(!rpta.equalsIgnoreCase("N"))
                System.out.println(fortuna.nexFortune());    
            else break;
        }
        
        LinkedListTDA<String>list = new LinkedListTDA<>();
        while(true){
            System.out.println("a)Agregar galleta de la fortuna\nb)Eliminar galleta de la fortuna\nc)Visualizar la lista");
            char val = scr.next().charAt(0);
            switch (val) {
                case 'a' -> {
                    addCookie(list);
                }
                case 'b' -> {
                    removeCookie(list);
                }
                case 'c' -> {
                    System.out.println("Viendo la lista:");
                    System.out.println(list.toString());
                }
                default -> System.out.println("Seleccionar una opcion valida");
            }
            
            
        }
              
        
    }
    
    private void addCookie(LinkedListTDA<String>list){
        Random random = new Random();
        int indice = random.nextInt(fortuna.size()+1);
        list.add(fortuna.nexFortune());
        System.out.println("Galleta added: "+obtenercokiefinal(list));
        fortuna.remove(indice);
    }
    private void removeCookie(LinkedListTDA<String>list){
        list.removeSegundaOpcion();
    }
    private String obtenercokiefinal(LinkedListTDA<String>list){
        return list.obtenercoladato();
    }
    
    
    
    
}
