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

import com.tech.application.rest.models.entity.MaeCompania;
import com.tech.application.rest.models.entity.Pais;


public class RptCompaniaAllByCliente {

	static String SHEET = "Reporte";
	
	 public static ByteArrayInputStream exportarExcel(List<MaeCompania> rptCompania,List<Pais> rptPais) {
		 
	 
		    try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {

		    	
		    	XSSFSheet sheet = workbook.createSheet(SHEET);
		        
		    	XSSFRow row1 = sheet.createRow(0);
			      
			      row1.createCell(0).setCellValue("ID CLIENTE");
			      row1.createCell(1).setCellValue("ID COMPAÑIA");
			      row1.createCell(2).setCellValue("NOMBRE LEGAL");
			      row1.createCell(3).setCellValue("NOMBRE COMERCIAL");
			      row1.createCell(4).setCellValue("DOC. LEGAL");
			      row1.createCell(5).setCellValue("TELEFONO 1");
			      row1.createCell(6).setCellValue("TELEFONO 2");
			      row1.createCell(7).setCellValue("PAGINA WEB");
			      row1.createCell(8).setCellValue("PAIS");
			      row1.createCell(9).setCellValue("ESTADO");
			      
			      int IdRow = 1,rowPais = 0;
			      
			      for (MaeCompania compania : rptCompania) {
			    	  XSSFRow row = sheet.createRow(IdRow++);
				        sheet.autoSizeColumn(IdRow);
				        
				        row.createCell(0).setCellValue(compania.getIdCliente());
				        row.createCell(1).setCellValue(compania.getId());
				        row.createCell(2).setCellValue(compania.getNombreLegal());
				        row.createCell(3).setCellValue(compania.getNombreComercial());
				        row.createCell(4).setCellValue(compania.getNumeroRegLegal());
				        row.createCell(5).setCellValue(compania.getTelefono1());
				        row.createCell(6).setCellValue(compania.getTelefono2());
				        row.createCell(7).setCellValue(compania.getWebpage());
//				        row.createCell(8).setCellValue(compania.getIdPais());
				        
				        //Optimizando la busqueda del nombre del Pais, en lugar de FOR uso un While
				        rowPais = 0;
				        while(rowPais < rptPais.size() &&  !rptPais.get(rowPais).getId().equals(compania.getIdPais())  ) {
				        	rowPais++;
				        }
				        if (rowPais < rptPais.size()) {
				        	row.createCell(8).setCellValue(rptPais.get(rowPais).getNombre());
				        }else {
				        	row.createCell(8).setCellValue(compania.getIdPais());
				        }
				        
				        /*
				    	if(compania.getIdPais() != null) {
							for (Pais pais : rptPais) {
								if (pais.getId()== compania.getIdPais() ) {
							        row.createCell(8).setCellValue(pais.getNombre());	
							        break;
								}
							}					        
				    	}
				    	*/
				    	
				    	
				        if (compania.getEstado() == 1) {
					        row.createCell(9).setCellValue("Activo");					        	
				        }else {
					        row.createCell(9).setCellValue("Baja");					        	
				        }
				        
			       

				      }
			      
		    	  //Ajustando columnas
			      int ajuste = 0;    
			      do{    
    		    	  sheet.autoSizeColumn(ajuste);		  
    		    	  ajuste++;    
			      }while(ajuste <= 9);
			      
			      workbook.write(out);
			      return new ByteArrayInputStream(out.toByteArray());
			    } catch (IOException e) {
			      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
			    }
	 }
}
