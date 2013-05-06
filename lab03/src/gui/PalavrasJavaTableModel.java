/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Sistema.ContadorDePalavrasJava;
import Sistema.PalavrasReservadasJava;
import javax.swing.table.AbstractTableModel;



/**
 *
 * @author Lurian
 */
public class PalavrasJavaTableModel extends AbstractTableModel{
    
    private final int PALAVRA_INDEX = 0;
    private final int NUMERO_DE_OCORRENCIAS_INDEX = 1;
    private final String[] columnNames = {"Palavras", "Numero de Ocorrencias"};
    private ContadorDePalavrasJava contador = ContadorDePalavrasJava.getInstance();

    public String[] getColumnNames() {
        return columnNames;
    }

    @Override
    public String getColumnName(int column) {
        return getColumnNames()[column];
    }

    @Override
    public int getColumnCount() {
        return getColumnNames().length;
    }

    @Override
    public int getRowCount() {
        return PalavrasReservadasJava.getPalavras().length;
    }

    @Override
    public Class getColumnClass(int column) {
        switch (column) {
            case PALAVRA_INDEX:
                return String.class;
            case NUMERO_DE_OCORRENCIAS_INDEX:
                return Integer.class;
            default:
                return Object.class;
        }
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String palavra = PalavrasReservadasJava.getPalavras()[rowIndex];

        switch (columnIndex) {
            case PALAVRA_INDEX:
                return palavra;
            case NUMERO_DE_OCORRENCIAS_INDEX:
                return contador.getMapaDaContagem().get(palavra);
            default:
                return "";
        }
    }
}
