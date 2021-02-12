/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Leon1
 */
public class Principal {
    public static void main(String[] args) throws Exception {
         String ruta = "C:/Users/Leon1/OneDrive/Documentos/NetBeansProjects/Analizador/src/analizador/lever.flex";
         String ruta2 = "C:/Users/Leon1/OneDrive/Documentos/NetBeansProjects/Analizador/src/analizador/LexerCup.flex";
         String[] rutaS = {"-parser", "Sintax", "C:/Users/Leon1/OneDrive/Documentos/NetBeansProjects/Analizador/src/analizador/Sintax.cup"};
         generar(ruta,ruta2,rutaS);
    }
    public static void generar(String ruta, String ruta2, String[] rutaS) throws IOException, Exception{
    File archivo;
    archivo = new File(ruta);
    JFlex.Main.generate(archivo);
    archivo = new File(ruta2);
    JFlex.Main.generate(archivo);
    java_cup.Main.main(rutaS);
    
    
    Path rutaSym = Paths.get("C:/Users/Leon1/OneDrive/Documentos/NetBeansProjects/Analizador/src/analizador/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get("C:/Users/Leon1/OneDrive/Documentos/NetBeansProjects/Analizador/sym.java"), 
                Paths.get("C:/Users/Leon1/OneDrive/Documentos/NetBeansProjects/Analizador/src/analizador/sym.java")
        );
        Path rutaSin = Paths.get("C:/Users/Leon1/OneDrive/Documentos/NetBeansProjects/Analizador/src/analizador/Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("C:/Users/Leon1/OneDrive/Documentos/NetBeansProjects/Analizador/Sintax.java"), 
                Paths.get("C:/Users/Leon1/OneDrive/Documentos/NetBeansProjects/Analizador/src/analizador/Sintax.java")
        );
    }
}
        
