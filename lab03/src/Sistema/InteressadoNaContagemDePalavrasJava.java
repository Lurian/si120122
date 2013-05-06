/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import java.io.File;
import java.util.HashMap;

/**
 *
 * @author Lurian
 */
interface InteressadoNaContagemDePalavrasJava {
    
    public File proximoArquivo();
    
    public void avisaContagemTerminada(HashMap<String, Integer> mapaDaContagem);
    
}
