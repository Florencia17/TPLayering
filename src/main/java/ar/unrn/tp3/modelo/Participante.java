package ar.unrn.tp3.modelo;

public class Participante {

private String nombre;
private String telefono;
private String region;

   public Participante (String nombre, String telefono, String region){

       if (!validarDato(nombre)) {
           throw new RuntimeException("Debe ingresar un nombre");
       }
       if (!validarDato(telefono)){
           throw new RuntimeException("Debe ingresar un telefono");
       }
       if (!validarDato(region)){
           throw new RuntimeException("Debe ingresar una region");
       }
       if (!validarTelefono(telefono)){
           throw new RuntimeException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
       }

       if (!validarRegion(region)){
           throw new RuntimeException("Region desconocida. Las conocidas son: China, US, Europa");
       }




       this.nombre = nombre;
       this.telefono = telefono;
       this.region = region;

   }

   public boolean validarDato(String dato){   //para los 3
       return ( dato.equals("") );
   }

    private boolean validarTelefono(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }

   public boolean validarRegion (String region){
       return (!region.equals("China") && !region.equals("US") && !region.equals("Europa"));
   }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getRegion() {
        return region;
    }
}
