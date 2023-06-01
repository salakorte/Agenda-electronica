package com.journaldev.maven.maven_test.jar;

import com.aspose.cells.Cell;
import com.aspose.cells.CellArea;
import com.aspose.cells.FindOptions;
import com.aspose.cells.Row;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;

public class app2 {
  public static String Salida = " ";
  
  public static void main(String[] args, String textoBuscado) throws Exception {
    // Ruta del archivo de Excel a buscar
    String rutaArchivo = "\\\\server01\\Cobendai\\It\\Listado telefónico.xlsx";
    
    // Cargar el libro de Excel
    Workbook libro = new Workbook(rutaArchivo);
    
    // Obtener la hoja de trabajo (worksheet) del libro
    Worksheet hoja = libro.getWorksheets().get(0);
    
    // Convertir el texto buscado a minúsculas
    textoBuscado = textoBuscado.toLowerCase();
    
    // Definir el área de búsqueda en la hoja de trabajo
    CellArea areaBusqueda = new CellArea();
    areaBusqueda.StartRow = 0;
    areaBusqueda.EndRow = hoja.getCells().getMaxDataRow();
    areaBusqueda.StartColumn = 0;
    areaBusqueda.EndColumn = hoja.getCells().getMaxDataColumn();
    
    // Limpiar la variable de salida
    Salida = " ";
    
    // Recorrer las filas y columnas dentro del área de búsqueda
    for (int i = areaBusqueda.StartRow; i <= areaBusqueda.EndRow; i++) {
      Row row = hoja.getCells().getRow(i);
      
      // Variable booleana para realizar un seguimiento de si se encuentra el texto buscado en alguna columna de la fila actual
      boolean encontrado = false;
      
      for (int j = areaBusqueda.StartColumn; j <= areaBusqueda.EndColumn; j++) {
        Cell cell = row.get(j);
        
        // Verificar si el valor de la celda contiene el texto buscado (ignorar mayúsculas y minúsculas)
        if (cell.getStringValue().toLowerCase().indexOf(textoBuscado) != -1) {
          encontrado = true;
          break; // Si se encuentra el texto en alguna columna, no es necesario seguir buscando en el resto de las columnas
        }
      }
      
      // Agregar los valores de la fila a la variable de salida solo si se encuentra el texto buscado en alguna columna
      if (encontrado) {
        for (int k = 0; k <= hoja.getCells().getMaxDataColumn(); k++) {
          Cell cell2 = row.get(k);
          Salida = String.valueOf(Salida) + cell2.getStringValue() + "\n";
        }
        Salida = String.valueOf(Salida) + "\n";
      }
    }
    
    // Imprimir la variable de salida en la consola
    System.out.println(Salida);
  }
}