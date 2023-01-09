package com.tech.application.rest.views.excel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tech.application.rest.models.entity.RepMaeTabla;


public class RptMaeTablaByCompania {

	static String SHEET = "Tabla";

	 public static ByteArrayInputStream exportarExcel(List<RepMaeTabla> rptTabla) {
		 
		 try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			 
			/************************  Tabla ****************************************/
		    	XSSFSheet sheet = workbook.createSheet(SHEET);
		    	XSSFRow row1 = sheet.createRow(0);
		    	
			      row1.createCell(0).setCellValue("ID COMPAÑIA");
			      row1.createCell(1).setCellValue("DES EMPRESA");
			      row1.createCell(2).setCellValue("TIPO TABLA");
			      row1.createCell(3).setCellValue("DES TABLA");
			      row1.createCell(4).setCellValue("CODIGO");
			      row1.createCell(5).setCellValue("DES CODIGO");
			      row1.createCell(6).setCellValue("VALOR INI");
			      row1.createCell(7).setCellValue("VALOR FIN");
			      row1.createCell(8).setCellValue("VISIBLE");
			      
			      int IdRow = 1;
			      for (RepMaeTabla tabla : rptTabla) {
			    	  XSSFRow row = sheet.createRow(IdRow++);
				        sheet.autoSizeColumn(IdRow);
				        
				        row.createCell(0).setCellValue(tabla.getId_compania());
				        row.createCell(1).setCellValue(tabla.getDes_empresa());
				        row.createCell(2).setCellValue(tabla.getTipo_tabla());
				        row.createCell(3).setCellValue(tabla.getDes_tipo_tabla());
				        row.createCell(4).setCellValue(tabla.getCodigo());
				        row.createCell(5).setCellValue(tabla.getDes_codigo());
				        if (tabla.getValor_ini() != null) {
					        row.createCell(6).setCellValue(tabla.getValor_ini() );				        	
				        }
				        if (tabla.getValor_fin() != null) {
					        row.createCell(7).setCellValue(tabla.getValor_fin() );				        	
				        }
				        row.createCell(8).setCellValue(tabla.getInd_visible());
			      }			      
			      
		    	  //Ajustando columnas
			      int ajuste = 0;    
			      do{    
    		    	  sheet.autoSizeColumn(ajuste);		  
    		    	  ajuste++;    
			      }while(ajuste<=8);   
			      
				      
			 workbook.write(out);
			 return new ByteArrayInputStream(out.toByteArray());
		 } catch (IOException e) {
			 throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		 }
		 
	 }
	

}
