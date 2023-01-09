package com.tech.application.rest.models.services.serviceimpl;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tech.application.rest.models.entity.MaeAlmacen;
import com.tech.application.rest.models.entity.MaeCCosto;
import com.tech.application.rest.models.entity.MaeCompania;
import com.tech.application.rest.models.entity.MaeEntidadContacto;
import com.tech.application.rest.models.entity.MaeSede;
import com.tech.application.rest.models.entity.MaeTablaDet;
import com.tech.application.rest.models.entity.MaeTipoTransaccion;
import com.tech.application.rest.models.entity.Pais;
import com.tech.application.rest.models.entity.RepMaeEntidad;
import com.tech.application.rest.models.entity.RepMaeTabla;
import com.tech.application.rest.views.excel.RptAlmacenAllByCompania;
import com.tech.application.rest.views.excel.RptCCostoAllByCompania;
import com.tech.application.rest.views.excel.RptCompaniaAllByCliente;
import com.tech.application.rest.views.excel.RptMaeEntidadByCompania;
import com.tech.application.rest.views.excel.RptMaeTablaByCompania;
import com.tech.application.rest.views.excel.RptSedeAllByCompania;
import com.tech.application.rest.views.excel.RptTipoTransaccionByCompania;

@Service
public class ExcelExportServiceImpl {

	public ByteArrayInputStream exportExcelCompaniaAllByCliente (List<MaeCompania> compania,List<Pais> pais) {
		ByteArrayInputStream in = RptCompaniaAllByCliente.exportarExcel(compania,pais);
		return in;
	}
	
	public ByteArrayInputStream exportExcelSedeAllByCompania (List<MaeSede> sede,List<Pais> pais) {
		ByteArrayInputStream in = RptSedeAllByCompania.exportarExcel(sede,pais);
		return in;
	}	
	
	public ByteArrayInputStream exportExcelAlmacenAllByCompania (List<MaeAlmacen> almacen,List<Pais> pais) {
		ByteArrayInputStream in = RptAlmacenAllByCompania.exportarExcel(almacen,pais);
		return in;
	}		

	public ByteArrayInputStream exportExcelCCostoAllByCompania (List<MaeCCosto> ccosto,List<MaeTablaDet> rptTipoCCosto) {
		ByteArrayInputStream in = RptCCostoAllByCompania.exportarExcel(ccosto,rptTipoCCosto);
		return in;
	}			
	
	public ByteArrayInputStream exportExcelMaeEntidadAllByCompania (List<RepMaeEntidad> entidad, List<MaeEntidadContacto> contacto) {
		ByteArrayInputStream in = RptMaeEntidadByCompania.exportarExcel(entidad,contacto);
		return in;
	}			
	
	public ByteArrayInputStream exportExcelMaeTablaAllByCompania (List<RepMaeTabla> tabla) {
		ByteArrayInputStream in = RptMaeTablaByCompania.exportarExcel(tabla);
		return in;
	}			
	
	public ByteArrayInputStream exportExcelTipoTransaccionAllByCompania (List<MaeTipoTransaccion> transaccion,List<MaeTablaDet> rptTipo) {
		ByteArrayInputStream in = RptTipoTransaccionByCompania.exportarExcel(transaccion,rptTipo);
		return in;
	}			
	
}
