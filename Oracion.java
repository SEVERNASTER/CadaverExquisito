public class Oracion{
    private String oracion;
    private String oracionSinPalabraPrefijo;
    private String palabraPrefijo;
    private String palabraSufijo;
    private String palabras[];

    public Oracion(String oracion){        
        this.oracion = oracion;
        oracionSinPalabraPrefijo = "";
        palabraPrefijo = "";
        palabraSufijo = "";
        pasarArreglo(oracion);
        getPrefijo(palabras);
        getSufijo(palabras);
        getSinPrefijo(palabras);
    }

    private void pasarArreglo(String oracion){
        palabras = new String[oracion.length()];
        for(int i = 0; i <= oracion.length() - 1; i++){   //para decir q agarre un caracter en el indice i y lo guarde en el arreglo
            palabras[i] = oracion.substring(i , i + 1);
        }
    }

    private void getPrefijo(String palabras[]){
        int pos = 0;
        pos = oracion.indexOf(" ");
        if(pos > 0){
            for(int i = 0; i < pos; i++){
                palabraPrefijo += palabras[i];
            }
        }else{
            for(int i = 0; i < palabras.length; i++){
                palabraPrefijo += palabras[i];
            }
        }

    }

    private void getSufijo(String palabras[]){
        int pos = 0;
        pos = oracion.lastIndexOf(" ");
        if(pos > 0){
            for(int i = pos; i < palabras.length; i++){
                palabraSufijo += palabras[i];
            }
        }else{
            for(int i = 0; i < palabras.length; i++){
                palabraSufijo += palabras[i];
            }
        }

    }

    private void getSinPrefijo(String palabras[]){
        int pos = 0;
        pos = oracion.indexOf(" ");
        if(pos > 0){
            for(int i = pos; i < palabras.length; i++){
                oracionSinPalabraPrefijo += palabras[i];
            }
        }else{
            oracionSinPalabraPrefijo = "";
        }

    }

    public String getPalabraPrefijo(){
        return palabraPrefijo;
    }

    public String getPalabraSufijo(){
        return palabraSufijo;
    }

    public String getOracion(){
        return oracion;
    }

    public String getOracionSinPalabraPrefijo(){
        return oracionSinPalabraPrefijo;
    }

}