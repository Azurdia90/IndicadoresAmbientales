<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="head.jsp" />
<body>
	<jsp:include page="maindiv.jsp"/>
	<jsp:include page="sidebar.jsp" />

	<div class = "div-menu-calcind">
	 		<img src="assets/images/SIUSACLogo.png" style="width:10vw; height:4vw; padding-left: 5vw; padding-top: 0.5vw;"></img>
	 		<img src="assets/images/1.0_Mesa de trabajo 1.png" style="width:7vw; height:6vw; padding-top: 0.5vw;"></img>
			<div class="tab">
	  			<button class="tablinks" onclick="openInd(event, 'Campos')">Territorio</button>
	  			<button class="tablinks" onclick="openInd(event, 'Campos')">Espacio</button>
	  			<button class="tablinks" onclick="openInd(event, 'Campos')">Edificio</button>
			</div>
 	</div>
 	<div class = "div-title">
 		<label>Calculo de Indicadores</label>
 	</div>
 	<div class = "div-menu-calcindgeneral">
 		<div id="Campos" class="tabcontent">
 			<table class="tablecalcindigen">
	            <tbody>
	            <tr>
	            	<td><label>Unidad</label></td>
	            	<td><select id="Unidad">
			  				<option label="CGP"></option>
							<option label="USAC"></option>
						</select>
					</td>
	            </tr>
	            <tr>
	            	<td><label>Area</label></td>
	            	<td>
		            	<select id="Area">
			  				<option label="Energia"></option>
							<option label="Agua"></option>
						</select>
	            	</td>
	            </tr>
	            <tr>
	            	<td><label>Año a Reportar</label></td>
	            	<td>
		            	<select id="year">
			  				<option label="2023"></option>
							<option label="2022"></option>
							<option label="2021"></option>
							<option label="2020"></option>
						</select>
	            	</td>
	            </tr>
	            <tr>
	            	<td><label>Periocidad de la Variable</label></td>
	            	<td>
	            		<select id="periocidad">
	  							<option label="Anual"></option>
								<option label="Mensual"></option>
						</select>
	            	</td>
	            </tr>
	            </tbody>			
			</table>
		</div>
		<div class="sectionEncarga">
			<label>Encargado</label>
			<table class="tablecalcindEnc">
	            <tbody>
	            <tr>
	            	<td><label>Nombre</label></td>
	            	<td><input></td>
	            </tr>
	            <tr>
	            	<td><label>Fecha Ingreso</label></td>
	            	<td><input type="date"></td>
	            </tr>
	            </tbody>			
			</table>
		</div>
		<div class="sectionVariables">
			<label>Variables</label>
			<table class="tablecalcindVar">
	            <tbody>
	            <tr>
	            	<td><label>Consumo energia (Kw/h)</label></td>
	            	<td><input></td>
	            	<td><label>Pago total de energia Edificios (Q)</label></td>
	            	<td><input></td>
	            	<td><label>Costo de energia por refrigeracion (Q)</label></td>
	            	<td><input></td>
	            </tr>
	            <tr>
	            	<td><label>Consumo energia por iluminacion (Kw/h)</label></td>
	            	<td><input></td>
	            	<td><label>Potencia actual consumida(Kw)</label></td>
	            	<td><input></td>
	            	<td><label>Costo total de energia (Q)</label></td>
	            	<td><input></td>
	            </tr>
	            <tr>
	            	<td><label>Consumo energia por refrigeracion (Kw/h)</label></td>
	            	<td><input></td>
	            	<td><label>Potencia contratada (Kw)</label></td>
	            	<td><input></td>
	            	<td><label>Energia producida por fuentes renovables (Kw)</label></td>
	            	<td><input></td>
	            </tr>
	            <tr>
	            	<td><label>Consumo energia por uso de computo (Kw/h)</label></td>
	            	<td><input></td>
	            	<td><label>Costo de energia por iluminacion (Q)</label></td>
	            	<td><input></td>
	            </tr>
	            </tbody>			
			</table>
		</div>
 	</div>
 	<div class = "div-menu-calcindopc">
  			<button class="button btnoption">Guardar</button>
  			<button class="button btnoption">Ingresar otro año</button>
  			<button class="button btnoption">Enviar a Revision</button>
  			<button class="button btnback" onclick="history.back()">Regresar</button>
 	</div>


<script>
function openInd(evt, opcionInd) {
	var i, tabcontent, tablinks;
	  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(opcionInd).style.display = "block";
  evt.currentTarget.className += " active";
}
</script>
</body>
</html>

 	