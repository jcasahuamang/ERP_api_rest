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

import com.tech.application.rest.models.entity.MaeSede;
import com.tech.application.rest.models.entity.Pais;

public class RptSedeAllByCompania {

	static String SHEET = "Reporte";
	
	 public static ByteArrayInputStream exportarExcel(List<MaeSede> rptSede,List<Pais> rptPais) {
		 
	 
		 try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
    	
				
		    	XSSFSheet sheet = workbook.createSheet(SHEET);
		    	XSSFRow row1 = sheet.createRow(0);
		    	

			      row1.createCell(0).setCellValue("ID COMPAÑIA");
			      row1.createCell(1).setCellValue("ID SEDE");
			      row1.createCell(2).setCellValue("NOMBRE");
			      row1.createCell(3).setCellValue("DIRECCION");
			      row1.createCell(4).setCellValue("TELEFONO 1");
			      row1.createCell(5).setCellValue("TELEFONO 2");
			      row1.createCell(6).setCellValue("PAIS");
			      row1.createCell(7).setCellValue("ESTADO");
			      
			      int IdRow = 1,rowPais = 0;
			      for (MaeSede sede : rptSede) {
			    	  XSSFRow row = sheet.createRow(IdRow++);
				        sheet.autoSizeColumn(IdRow);
				        
				        row.createCell(0).setCellValue(sede.getIdCompania());
				        row.createCell(1).setCellValue(sede.getId());
				        row.createCell(2).setCellValue(sede.getNombre());
				        row.createCell(3).setCellValue(sede.getDireccion());
				        row.createCell(4).setCellValue(sede.getTelefono1());
				        row.createCell(5).setCellValue(sede.getTelefono2());
				        //row.createCell(6).setCellValue(sede.getIdPais());

				        //Optimizando la busqueda del nombre del Pais, en lugar de FOR uso un While
				        rowPais = 0;
				        while(rowPais < rptPais.size() &&  !rptPais.get(rowPais).getId().equals(sede.getIdPais())  ) {
				        	rowPais++;
				        }
				        if (rowPais < rptPais.size()) {
				        	row.createCell(6).setCellValue(rptPais.get(rowPais).getNombre());
				        }else {
				        	row.createCell(6).setCellValue(sede.getIdPais());
				        }
				        
				        
				        if (sede.getEstado() == 1) {
					        row.createCell(7).setCellValue("Activo");					        	
				        }else {
					        row.createCell(7).setCellValue("Baja");					        	
				        }
				        
			      }
			      
		    	  //Ajustando columnas
			      int ajuste = 0;    
			      do{    
    		    	  sheet.autoSizeColumn(ajuste);		  
    		    	  ajuste++;    
			      }while(ajuste <= 7);
			      
			 workbook.write(out);
			 return new ByteArrayInputStream(out.toByteArray());
		 } catch (IOException e) {
			 throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		 }
	 }
}
