/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

/**
 *
 * @author Lurian
 */
public abstract class PalavrasReservadasJava {

    private static String[] palavras = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
        "continue", "default", "do", "double", "else", "enum", "extends", "false", "final", "finally", "float", "for", "goto", "if",
        "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "null", "package", "private", "protected",
        "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient",
        "true", "try", "void", "volatile", "while"};

    public static String[] getPalavras() {
        return palavras;
    }
}