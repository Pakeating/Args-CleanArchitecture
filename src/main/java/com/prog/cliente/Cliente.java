package com.prog.cliente;

/*Se modifica el programa para implementar el uso de args.

La arquitectura limpia aumenta la escalabilidad, mantenibilidad y la facilidad para realizar test contra el codigo.
En general deberia aplicarse siempre que sean deseables las caracteristicas anteriores, lo que viene a llevarnos a pensar que deberia hacerse siempre.
Sin embargo, no tiene sentido en programas pequeños y sencillos en que aplicar la Clean Arquitecture complicaría en sí mismo el desarrollo, 
en parte por la estructura de carpetas, etc, que debe crearse para ello.


Se limpia el código enviando los print a clases separadas. Haber partido de un patrón de diseño hace que el codigo esté mejor organizado de base.
*/
public class Cliente {
    public static void main(String args[]) {
    ProfesionStrategy profesion;
    System.out.println("Bienvenido al sistema de reparacion de averías: ");
    
    try{
     for(int i=0;i<=args.length;i++)  {
        switch (args[i]){

        case "electricidad":
            profesion=new ProfesionElectricist(654433221, "Paco");
            Averia.reparar(profesion);
            break;
        case "fontaneria":
            profesion=new ProfesionFontanero(765544321,"Pepe");
            Averia.reparar(profesion);
            break;
        case "albañileria":
            profesion=new ProfesionAlbanil(876655443,"Isidro");
            Averia.reparar(profesion);
            break;
        case "help":
            verAyuda();
            break;
        default:
            verParametroInvalido();
            break;
            }
        }
    }
    catch(Exception e)
    {
        System.out.println("ERROR ----> Debe introducir un parámetro");
        System.out.println("Tambien puede introducir help como parámetro para ver la lista de parámetros disponibles");
    }
    }
    
    static void verAyuda(){
        System.out.println("Esta es la lista de parámetros disponibles:");
            System.out.println(">>>  electricidad  ----->Para solucionar averías de tipo eléctrico");
            System.out.println(">>>  fontaneria    ----->Para solucionar averías de tuberías y grifos");
            System.out.println(">>>  albañileria   ----->Para solucionar averías estructurales");
    }
    
    static void verParametroInvalido(){
        System.out.println("ERROR ----> Debe introducir un parámetro válido");
            System.out.println("Tambien puede introducir help como parámetro para ver la lista de parámetros disponibles");
    }
}

