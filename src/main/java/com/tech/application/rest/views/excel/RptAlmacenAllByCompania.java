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

import com.tech.application.rest.models.entity.MaeAlmacen;
import com.tech.application.rest.models.entity.Pais;

public class RptAlmacenAllByCompania {

	static String SHEET = "Reporte";

	 public static ByteArrayInputStream exportarExcel(List<MaeAlmacen> rptAlmacen,List<Pais> rptPais) {
		 
		 try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			 
			 
		    	XSSFSheet sheet = workbook.createSheet(SHEET);
		    	XSSFRow row1 = sheet.createRow(0);
		    	
			      row1.createCell(0).setCellValue("ID COMPAÑIA");
			      row1.createCell(1).setCellValue("ID ALMACEN");
			      row1.createCell(2).setCellValue("NOMBRE");
			      row1.createCell(3).setCellValue("TIPO");
			      row1.createCell(4).setCellValue("DIRECCION");
			      row1.createCell(5).setCellValue("VIRTUAL");
			      row1.createCell(6).setCellValue("PAIS");
			      row1.createCell(7).setCellValue("ESTADO");
			      
			      int IdRow = 1,rowPais = 0;
			      for (MaeAlmacen almacen : rptAlmacen) {
			    	  XSSFRow row = sheet.createRow(IdRow++);
				        sheet.autoSizeColumn(IdRow);
				        
				        row.createCell(0).setCellValue(almacen.getIdCompania());
				        row.createCell(1).setCellValue(almacen.getId());
				        row.createCell(2).setCellValue(almacen.getNombre());
				        row.createCell(3).setCellValue(almacen.getTipo());
				        row.createCell(4).setCellValue(almacen.getDireccion());
				        row.createCell(5).setCellValue(almacen.getIndVirtual());
				        //row.createCell(6).setCellValue(almacen.getIdPais());

				        //Optimizando la busqueda del nombre del Pais, en lugar de FOR uso un While
				        rowPais = 0;
				        while(rowPais < rptPais.size() &&  !rptPais.get(rowPais).getId().equals(almacen.getIdPais())  ) {
				        	rowPais++;
				        }
				        if (rowPais < rptPais.size()) {
				        	row.createCell(6).setCellValue(rptPais.get(rowPais).getNombre());
				        }else {
				        	row.createCell(6).setCellValue(almacen.getIdPais());
				        }
				        
				        
				        if (almacen.getEstado() == 1) {
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
