
/**
 * Write a description of class CadaverExquisito here.
 *
 * @author Dennis Zeballos
 * @version 5 ene 2023 menos de 1 hora en la logica del programa
 */
import java.util.ArrayList;
public class CadaverExquisito{//hacer la interfaz grafica en vscode
    private ArrayList<Oracion> oraciones;
    private boolean primeraVez;
    private int index;
    private String ultimaPalabra;
    private String textoCompleto;
    private int aceptadas;
    private int rechazadas;
    private String candidato;

    public CadaverExquisito(){
        oraciones = new ArrayList<>();
        primeraVez = true;
        index = 0;
        ultimaPalabra = "";
        textoCompleto = "";
        aceptadas = 0;
        rechazadas = 0;
        candidato = "";
    }

    public String addOracion(String oracion){
        String res = "";
        String estado = "";
        Oracion oracionObj = new Oracion(oracion);
        if(primeraVez){
            candidato = oracion;
            guardarDatosDe(oracionObj);
            estado = "  ==> aceptado";
            primeraVez = false;
        }else{
            candidato = oracion;
            if(sonIguales(oracionObj)){
                guardarDatosDe(oracionObj);
                estado = " ==> aceptado";
            }else{
                rechazadas++;
                estado = " ==> rechazado";
            }
        }
        res = candidato + estado;
        return res;
    }

    private void guardarDatosDe(Oracion oracionObj){
        if(primeraVez){
            textoCompleto += oracionObj.getOracion();
        }else{
            textoCompleto += oracionObj.getOracionSinPalabraPrefijo();
        }
        oraciones.add(oracionObj);
        ultimaPalabra = oracionObj.getPalabraSufijo();
        aceptadas++;
        index++;
    }

    private boolean sonIguales(Oracion oracionObj){
        boolean sonIguales = false;
        Oracion before = oraciones.get(index - 1);
        String ultimaPalabra = before.getPalabraSufijo().trim();
        String primeraPalabra = oracionObj.getPalabraPrefijo();
        if(ultimaPalabra.equalsIgnoreCase(primeraPalabra)){
            sonIguales = true;
        }else{
            sonIguales = false;
        }
        return sonIguales;
    }

    public String getUltimaPalabra(){
        return ultimaPalabra;
    }

    public void getTextoCompleto(){
        System.out.println(textoCompleto);
    }

    public int getValidas(){
        return aceptadas;
    }

    public int getRechazadas(){
        return rechazadas;
    }
}

