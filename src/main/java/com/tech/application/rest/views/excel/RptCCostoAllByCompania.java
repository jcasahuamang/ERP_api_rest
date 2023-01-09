package com.tech.application.rest.views.excel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/*
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
*/
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tech.application.rest.models.entity.MaeCCosto;
import com.tech.application.rest.models.entity.MaeTablaDet;

public class RptCCostoAllByCompania {

	static String SHEET = "Reporte";

	 public static ByteArrayInputStream exportarExcel(List<MaeCCosto> rptCCosto,List<MaeTablaDet> rptTipoCCosto) {
		 
		 try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			 
			 
		    	XSSFSheet sheet = workbook.createSheet(SHEET);
		    	XSSFRow row1 = sheet.createRow(0);
		    	
			      row1.createCell(0).setCellValue("ID COMPAÑIA");
			      row1.createCell(1).setCellValue("ID C.COSTO");
			      row1.createCell(2).setCellValue("NOMBRE");
			      row1.createCell(3).setCellValue("TIPO");
			      row1.createCell(4).setCellValue("COD. SUP");
			      row1.createCell(5).setCellValue("ESTADO");
			      
			      
			      int IdRow = 1,rowTipo = 0;
			      for (MaeCCosto ccosto : rptCCosto) {
			    	  XSSFRow row = sheet.createRow(IdRow++);
				        sheet.autoSizeColumn(IdRow);
				        
				        row.createCell(0).setCellValue(ccosto.getIdCompania());
				        row.createCell(1).setCellValue(ccosto.getId());
				        row.createCell(2).setCellValue(ccosto.getNombre());
				        row.createCell(3).setCellValue(ccosto.getTipo());
				        row.createCell(4).setCellValue(ccosto.getCodigoUnidadSuperior());

				        //Optimizando la busqueda del nombre del tipo de ccosto, en lugar de FOR uso un While
				        rowTipo = 0;
				        while(rowTipo < rptTipoCCosto.size() &&  !rptTipoCCosto.get(rowTipo).getCodigo().equals(ccosto.getTipo())  ) {
				        	rowTipo++;
				        }
				        if (rowTipo < rptTipoCCosto.size()) {
				        	row.createCell(3).setCellValue(rptTipoCCosto.get(rowTipo).getNombre());
				        }else {
				        	row.createCell(3).setCellValue(ccosto.getTipo());
				        }
				        
				        
				        if (ccosto.getEstado() == 1) {
					        row.createCell(5).setCellValue("Activo");					        	
				        }else {
					        row.createCell(5).setCellValue("Baja");					        	
				        }
				        
			      }			      
			      
		    	  //Ajustando columnas
			      int ajuste = 0;    
			      do{    
    		    	  sheet.autoSizeColumn(ajuste);		  
    		    	  ajuste++;    
			      }while(ajuste <= 5);   			      
			      
			 workbook.write(out);
			 return new ByteArrayInputStream(out.toByteArray());
		 } catch (IOException e) {
			 throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		 }
		 
	 }
	 
}
