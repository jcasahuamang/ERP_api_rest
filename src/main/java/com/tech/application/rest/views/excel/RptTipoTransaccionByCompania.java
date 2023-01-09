package com.tech.application.rest.views.excel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tech.application.rest.models.entity.MaeTablaDet;
import com.tech.application.rest.models.entity.MaeTipoTransaccion;

public class RptTipoTransaccionByCompania {

	static String SHEET = "Tipo Transaccion";

	 public static ByteArrayInputStream exportarExcel(List<MaeTipoTransaccion> rptTransaccion,List<MaeTablaDet> rptTipo) {
		 
		 try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			 
			 
		    	XSSFSheet sheet = workbook.createSheet(SHEET);
		    	XSSFRow row1 = sheet.createRow(0);
		    	
			      row1.createCell(0).setCellValue("NOMBRE");
			      row1.createCell(1).setCellValue("ABREVIATURA");
			      row1.createCell(2).setCellValue("TIPO");
			      row1.createCell(3).setCellValue("ESTADO");
			      row1.createCell(4).setCellValue("SAL. INI.");
			      row1.createCell(5).setCellValue("TRANSF. INT.");
			      row1.createCell(6).setCellValue("TRANSF. EXT.");			      
			      
			      
			      int IdRow = 1,rowTipo = 0;
			      for (MaeTipoTransaccion transaccion : rptTransaccion) {
			    	  XSSFRow row = sheet.createRow(IdRow++);
				        sheet.autoSizeColumn(IdRow);
				        
				        row.createCell(0).setCellValue(transaccion.getNombre());
				        row.createCell(1).setCellValue(transaccion.getAbreviatura());
				        
				        //Optimizando la busqueda del nombre del tipo de transaccion, en lugar de FOR uso un While
				        rowTipo = 0;
				        while(rowTipo < rptTipo.size() &&  !rptTipo.get(rowTipo).getCodigo().equals(transaccion.getTipo())  ) {
				        	rowTipo++;
				        }
				        if (rowTipo < rptTipo.size()) {
				        	row.createCell(2).setCellValue(rptTipo.get(rowTipo).getNombre());
				        }else {
				        	row.createCell(2).setCellValue(transaccion.getTipo());
				        }
				        				        
				        if (transaccion.getEstado() == 1) {
					        row.createCell(3).setCellValue("Activo");					        	
				        }else {
					        row.createCell(3).setCellValue("Baja");					        	
				        }

				        
				        row.createCell(4).setCellValue("NO");			
				        if (transaccion.getIndSalini() != null ) {
					        if (transaccion.getIndSalini().equals("S"))  {
						        row.createCell(4).setCellValue("SI");					        	
					        }				        	
				        }

				        row.createCell(5).setCellValue("NO");				        
				        if (transaccion.getIndInterno() != null) {
					        if (transaccion.getIndInterno().equals("S") ) {
						        row.createCell(5).setCellValue("SI");					        	
					        }				        	
				        }

				        row.createCell(6).setCellValue("NO");
				        if (transaccion.getIndExterno() != null) {
					        if (transaccion.getIndExterno().equals("S") ) {
						        row.createCell(6).setCellValue("SI");					        	
					        }				        	
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
