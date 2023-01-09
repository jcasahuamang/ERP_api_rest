package com.tech.application.rest.views.excel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tech.application.rest.models.entity.MaeEntidadContacto;
import com.tech.application.rest.models.entity.RepMaeEntidad;

public class RptMaeEntidadByCompania {

	static String SHEET = "Auxiliar";
	static String SHEETCONTACTO = "Contacto";	
	static String SHEETTIPO = "TipoAuxiliar";
	
	 public static ByteArrayInputStream exportarExcel(List<RepMaeEntidad> rptEntidad, List<MaeEntidadContacto> rptContacto) {
		 
		 try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			 

			      
			/************************  Entidad ****************************************/
		    	XSSFSheet sheet = workbook.createSheet(SHEET);
		    	XSSFRow row1 = sheet.createRow(0);
		    	
			      row1.createCell(0).setCellValue("ID COMPAÑIA");
			      row1.createCell(1).setCellValue("DES EMPRESA");
			      row1.createCell(2).setCellValue("ID AUXILIAR");
			      row1.createCell(3).setCellValue("NOMBRE PRIMERO");
			      row1.createCell(4).setCellValue("NOMBRE SEGUNDO");
			      row1.createCell(5).setCellValue("APELLIDO PATERNO");
			      row1.createCell(6).setCellValue("APELLIDO MATERNO");
			      row1.createCell(7).setCellValue("NOMBRE LEGAL");
			      row1.createCell(8).setCellValue("NOMBRE COMERCIAL");
			      row1.createCell(9).setCellValue("TIPO DOC");
			      row1.createCell(10).setCellValue("DES TIPO DOC");
			      row1.createCell(11).setCellValue("NUM. DOC.");
			      row1.createCell(12).setCellValue("WEBPAGE");
			      row1.createCell(13).setCellValue("EMAIL");
			      row1.createCell(14).setCellValue("TELEFONO 1");
			      row1.createCell(15).setCellValue("TELEFONO 2");
			      row1.createCell(16).setCellValue("PAIS");
			      row1.createCell(17).setCellValue("ESTADO");
			      row1.createCell(18).setCellValue("TIPO AUXILIAR");
			      
			      int IdRow = 1;
			      for (RepMaeEntidad entidad : rptEntidad) {
			    	  XSSFRow row = sheet.createRow(IdRow++);
				        sheet.autoSizeColumn(IdRow);
				        
				        row.createCell(0).setCellValue(entidad.getId_compania());
				        row.createCell(1).setCellValue(entidad.getDes_empresa());
				        row.createCell(2).setCellValue(entidad.getId_entidad());
				        row.createCell(3).setCellValue(entidad.getNombre_primero());
				        row.createCell(4).setCellValue(entidad.getNombre_segundo());
				        row.createCell(5).setCellValue(entidad.getApellido_paterno());
				        row.createCell(6).setCellValue(entidad.getApellido_materno());
				        row.createCell(7).setCellValue(entidad.getNombre_legal());				        
				        row.createCell(8).setCellValue(entidad.getNombre_comercial());
				        row.createCell(9).setCellValue(entidad.getTipo_documento());
				        row.createCell(10).setCellValue(entidad.getDes_tipo_doc());
				        row.createCell(11).setCellValue(entidad.getNumero_documento());
				        row.createCell(12).setCellValue(entidad.getWebpage());
				        row.createCell(13).setCellValue(entidad.getEmail());
				        row.createCell(14).setCellValue(entidad.getTelefono1());
				        row.createCell(15).setCellValue(entidad.getTelefono2());
				        row.createCell(16).setCellValue(entidad.getPais());
				        row.createCell(17).setCellValue(entidad.getEstado());
				        row.createCell(18).setCellValue(entidad.getTipo_Entidad());				        
			      }			      
			      
		    	  //Ajustando columnas
			      int ajuste = 0;    
			      do{    
    		    	  sheet.autoSizeColumn(ajuste);		  
    		    	  ajuste++;    
			      }while(ajuste<=18);   
			      
		            /************************  Contacto ****************************************/

			    	XSSFSheet sheetContac = workbook.createSheet(SHEETCONTACTO);
			    	XSSFRow row1Contac = sheetContac.createRow(0);

			    	row1Contac.createCell(0).setCellValue("ID AUXILIAR");
			    	row1Contac.createCell(1).setCellValue("ID CONTACTO");
			    	row1Contac.createCell(2).setCellValue("NOMBRE COMPLETO");
			    	row1Contac.createCell(3).setCellValue("TELEFONO 1");
			    	row1Contac.createCell(4).setCellValue("EMAIL");
			    	row1Contac.createCell(5).setCellValue("CARGO");

				      int IdRowContac = 1;
				      for (MaeEntidadContacto contacto : rptContacto) {
				    	  XSSFRow rowContac = sheetContac.createRow(IdRowContac++);
				    	  sheetContac.autoSizeColumn(IdRowContac);
					        
				    	  rowContac.createCell(0).setCellValue(contacto.getIdEntidad());
				    	  rowContac.createCell(1).setCellValue(contacto.getId());
				    	  rowContac.createCell(2).setCellValue(contacto.getNombreCompleto());
				    	  rowContac.createCell(3).setCellValue(contacto.getTelefono1());
				    	  rowContac.createCell(4).setCellValue(contacto.getEmail());
				    	  rowContac.createCell(5).setCellValue(contacto.getCargo());
				      }			      
				      
			    	  //Ajustando columnas
				      int ajusteContac = 0;    
				      do{    
				    	  sheetContac.autoSizeColumn(ajusteContac);		  
	    		    	  ajusteContac++;    
				      }while(ajusteContac<=5);   
				      
			 workbook.write(out);
			 return new ByteArrayInputStream(out.toByteArray());
		 } catch (IOException e) {
			 throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		 }
		 
	 }
	
}
