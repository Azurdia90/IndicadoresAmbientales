<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<jsp:include page="head.jsp" />
	</head>
<body>
	<div class="scroll-container">
		<div class="navbar">
			<img src="${menu_logo}" alt="img"></img>
		</div>
		<div class="scroll-page" id="page-1">
			<div class="container">
				<c:if test="${not empty pagina}">
						<div class="row">
							 <div class="column" id="divModAdmin">
							 	<h5>Pagina</h5>							 	
							 	<form action="admin_controller?command=editPage" method="post" enctype="multipart/form-data">
								 	<span class="brmedium"></span> 
								 	<input type="hidden" name="pagina_id" id="pagina_id" value="${pagina.getId()}">
								 	<label id="labelmodpagcode">Código</label>
								 	<input type="text" id="pagina_codigo" name="pagina_codigo" value="${pagina.getCodigo()}">
								 	<span class="brmedium"></span> 
								 	<label id="labelmodpagname">Titulo Pagina</label>
								 	<input type="text" id="pagina_nombre" name="pagina_nombre" value="${pagina.getNombre()}">
								 	<span class="brmedium"></span> 
								 	<label id="labelmodpagimage">Imagen</label>
								 	<input type="file" id="pagina_imagen" name="pagina_imagen">
								 	<span class="brmedium"></span> 
								 	<label id="labelmodpagdescripcion">Descripcion </label>
								 	<input type="text" id="pagina_descripcion" name="pagina_descripcion" value="${pagina.getDescripcion()}">
								 	<span class="brmedium"></span> 
								 	<label id="labelmodpagvisible">Visible</label>
								 	<input type="checkbox" ${pagina.getVisible() == 1 ? 'checked' : ''}>
								 	<button type="submit" id="btnedit" name="btnedit" value=>Actualizar</button>
								 </form>
							</div>
							<div class="column" id="divModSec">
							 	<h5>Secciones</h5>
							 	<c:if test="${not empty pagina.getLista_secciones()}">
							 	<select id="lista_secciones" name="lista_secciones" >
					 			<option value=""> -- Seleccione una opción -- </option>
					 			<c:forEach items="${pagina.getLista_secciones()}" var="option">
				                	<option value="${option.getId()}"><c:out value="${option.getCodigo()} - ${option.getTitulo()}"/></option>
				            	</c:forEach>
					        	</select>
					        	</c:if>
					 			<span class="brsmall"></span>
							 	<form action="admin_controller?command=sectionActions" method="post" enctype="multipart/form-data">
							 		<input type="hidden" name="seccion_pagina_id" id="seccion_pagina_id" value="${pagina.getId()}">
							 		<input type="hidden" name="seccion_id" id="seccion_id" value="">
							 		<label id="labelmodsec">Codigo</label>
							 		<input type="text" id="seccion_codigo" name="seccion_codigo" value="">
								 	<span class="brsmall"></span>
								 	<label id="labelmodsec">Tipo de sección</label>
								 	<select id="lista_seccion_tipo" name="lista_seccion_tipo" >
						 			<option value=""> -- Seleccione una opción -- </option>
						 			<c:forEach items="${secciones}" var="option">
				                       <option value="${option.getId()}"><c:out value="${option.getCodigo()} - ${option.getNombre()}"/></option>
					            	</c:forEach>
						        	</select>
						        	<span class="brsmall"></span>
								 	<label id="labelmodsec">Titulo de la sección</label>
								 	<input type="text" id="seccion_titulo" name="seccion_titulo" value="">
								 	<span class="brsmall"></span>
								 	<label id="labelmodsec">Imagen</label>
								 	<input type="file" id="seccion_imagen" name="seccion_imagen">								 	
								 	<span class="brsmall"></span>
								 	<label id="labelmodsec">Texto</label>
								 	<textarea id="seccion_texto" name="seccion_texto" rows="4" cols="50"></textarea>
								 	<span class="brsmall"></span>
								 	<label id="labelmodsec">Enlace</label>
								 	<input type="text" id="seccion_enlace" name="seccion_enlace" value="">
								 	<span class="brsmall"></span>
								 	<label id="labelmodsec">Estilo CSS</label>
								 	<input type="text" id="seccion_css" name="seccion_css" value="">
								 	<span class="brsmall"></span>
								 	<label id="labelmodsec">Descripcion</label>
								 	<input type="text" id="seccion_descripcion" name="seccion_descripcion" value="">
								 	<span class="brsmall"></span>
								 	<label id="labelmodsec">Visible</label>
								 	<input type="checkbox" id="seccion_visible" name="seccion_visible">
								 	<div id="seccion_action_buttons">
								 		<button type="submit" id="seccion_btnedit" name="seccion_btnedit" value="editSeccion">Modificar</button>
								 		<button type="button" id="seccion_btnclear" name="seccion_btnclear" value="clearSeccion">Agregar</button>
								 		<button type="submit" id="seccion_btndelete" name="seccion_btndelete" value=deleteSeccion"">Eliminar</button>
								 	</div>
								 	<div id="seccion_confirm_buttons" class="hidden">
						                <button type="submit" id="seccion_btnadd" name="seccion_btnadd" value="addSeccion">Aceptar</button>
						                <button type="button" id="seccion_btncancel" name="seccion_btncancel" value="cancelSeccion">Cancelar</button>
						            </div>
							 	</form>
							</div>
							<div class="column" id="divModCarrete">
								<c:if test="${not empty pagina.getLista_carrete()}">
							 	<h5>Carretes</h5>
							 	<select id="lista_carretes" name="lista_carretes" >
					 			<option value=""> -- Seleccione una opción -- </option>
					 			<c:forEach items="${pagina.getLista_carrete()}" var="option">
				                	<option value="${option.getId()}"><c:out value="${option.getCodigo()} - ${option.getTitulo()}"/></option>
				            	</c:forEach>
					        	</select>
					 			<span class="brsmall"></span>
							 	<form action="admin_controller?command=carreteActions" method="post" enctype="multipart/form-data">
							 		<input type="hidden" name="carrete_pagina_id" id="carrete_pagina_id" value="${pagina.getId()}">
							 		<input type="hidden" name="carrete_id" id="carrete_id" value="">
							 		<label id="labelmodcar">Codigo</label>
							 		<input type="text" id="carrete_codigo" name="carrete_codigo" value="">
								 	<span class="brsmall"></span>
								 	<label id="labelmodcar">Titulo</label>
								 	<input type="text" id="carrete_titulo" name="carrete_titulo" value="">
								 	<span class="brsmall"></span>								
								 	<label id="labelmodcar">Estilo CSS</label>
								 	<input type="text" id="carrete_css" name="carrete_css" value="">
								 	<span class="brsmall"></span>
								 	<label id="labelmodcar">Descripcion</label>
								 	<input type="text" id="carrete_descripcion" name="carrete_descripcion" value="">
								 	<span class="brsmall"></span>
								 	<label id="labelmodcar">Visible</label>
								 	<input type="checkbox" id="carrete_visible" name="carrete_visible">
								 	<div id="carrete_action_buttons">
								 		<button type="submit" id="carrete_btnedit"   name="carrete_btnedit"   value="editMenu">Modificar</button>
								 		<button type="button" id="carrete_btnclear"  name="carrete_btnclear"  value="clearMenu">Agregar</button>
								 		<button type="submit" id="carrete_btndelete" name="carrete_btndelete" value=deleteMenu"">Eliminar</button>
								 	</div>
								 	<div id="carrete_confirm_buttons" class="hidden">
						                <button type="submit" id="carrete_btnadd"    name="carrete_btnadd"    value="addMenu">Aceptar</button>
						                <button type="button" id="carrete_btncancel" name="carrete_btncancel" value="cancelMenu">Cancelar</button>
						            </div>
							 	</form>
							 	</c:if>
							</div>
							<span class="brsmall"></span>
							<div class="column" id="divModMenu">
								<c:if test="${not empty pagina.getLista_carrete()}">
							 	<h5>Contenido Carrete</h5>
							 	<select id="lista_carrete_seccion" name="lista_carrete_seccion" >
						 			<option value=""> -- Seleccione una opción -- </option>
						        </select>
							 	<form action="admin_controller?command=carreteSectionActions" method="post" enctype="multipart/form-data">
							 		<input type="hidden" name="carrete_seccion_carrete_id" id="carrete_seccion_carrete_id" value="">
							 		<input type="hidden" name="carrete_seccion_id"       id="carrete_seccion_id" value="">
							 		<label id="labelmodmenu">Tipo de Contenido</label>
							 		<select id="carrete_seccion_lista_tipo" name="carrete_seccion_lista_tipo" >
						 				<option value=""> -- Seleccione una opción -- </option>
						 				<option value="0"> 001 - Imagen </option>
						 				<option value="1"> 002 - Tip Ambiental</option>
						        	</select>
						        	<span class="brsmall"></span>
						        	<label id="labelcarretesecciontema">Tema Tip</label>
						        	<select id="carrete_seccion_lista_tema" name="carrete_seccion_lista_tema" >
						 				<option value="0"> -- Seleccione una opción -- </option>
						 				<option value="1"> 001 - Verde </option>
						 				<option value="2"> 002 - Anaranjado </option>
						 				<option value="3"> 003 - Azul </option>
						 				<option value="4"> 004 - Amarillo </option>
						        	</select>
						        	<span class="brsmall"></span>
							 		<label id="labelmodmenu">Codigo</label>
							 		<input type="text" id="carrete_seccion_codigo" name="carrete_seccion_codigo" value="">
								 	<span class="brsmall"></span>
								 	<label id="labelmodmenu">Titulo</label>
								 	<input type="text" id="carrete_seccion_titulo" name="carrete_seccion_titulo" value="">
								 	<span class="brsmall"></span>
								    <label id="labelcarreteseccionsubtitulo">Subtitulo</label>
								 	<input type="text" id="carrete_seccion_subtitulo" name="carrete_seccion_subtitulo" value="">
								 	<span class="brsmall"></span>
								 	<label id="labelcarretesecciontexto">Texto</label>
								 	<textarea id="carrete_seccion_texto" name="carrete_seccion_texto" rows="4" cols="50"></textarea>
								 	<span class="brsmall"></span>
								 	<label id="labelmodsec">Imagen</label>
								 	<input type="file" id="carrete_seccion_imagen" name="carrete_seccion_imagen">	
								 	<span class="brsmall"></span>
								 	<label id="labelmodmenu">Enlace</label>
								 	<input type="text" id="carrete_seccion_enlace" name="carrete_seccion_enlace" value="">
								 	<span class="brsmall"></span>
								 	<label id="labelmodmenu">Estilo CSS</label>
								 	<input type="text" id="carrete_seccion_css" name="carrete_seccion_css" value="">
								 	<span class="brsmall"></span>								 															 	
								 	<label id="labelmodmenu">Visible</label>
								 	<input type="checkbox" id="carrete_seccion_visible" name="carrete_seccion_visible">
								 	<div id="carrete_seccion_action_buttons">
								 		<button type="submit" id="carrete_seccion_btnedit"   name="carrete_seccion_btnedit"   value="editCarreteSeccion">Modificar</button>
								 		<button type="button" id="carrete_seccion_btnclear"  name="carrete_seccion_btnclear"  value="clearCarreteSeccion">Agregar</button>								 		
								 		<button type="submit" id="carrete_seccion_btndelete" name="carrete_seccion_btndelete" value=deleteCarreteSeccion"">Eliminar</button>
								 	</div>
								 	<div id="carrete_seccion_confirm_buttons" class="hidden">
						                <button type="submit" id="carrete_seccion_btnadd"    name="carrete_seccion_btnadd"    value="addCarreteSeccion">Aceptar</button>
						                <button type="button" id="carrete_seccion_btncancel" name="carrete_seccion_btncancel" value="cancelCarreteSeccion">Cancelar</button>
						            </div>
							 	</form>
							 	</c:if>
							</div>
							<div class="column" id="divModMenu">
							 	<c:if test="${not empty pagina.getLista_menu()}">
							 	<h5>Menús</h5>
							 	<select id="lista_menus" name="lista_menus" >
					 			<option value=""> -- Seleccione una opción -- </option>
					 			<c:forEach items="${pagina.getLista_menu()}" var="option">
				                	<option value="${option.getId()}"><c:out value="${option.getCodigo()} - ${option.getTitulo()}"/></option>
				            	</c:forEach>
					        	</select>
					 			<span class="brsmall"></span>
							 	<form action="admin_controller?command=menuActions" method="post" enctype="multipart/form-data">
							 		<input type="hidden" name="menu_pagina_id" id="menu_pagina_id" value="${pagina.getId()}">
							 		<input type="hidden" name="menu_id" id="menu_id" value="">
							 		<label id="labelmodmenu">Codigo</label>
							 		<input type="text" id="menu_codigo" name="menu_codigo" value="">
								 	<span class="brsmall"></span>
								 	<label id="labelmodmenu">Titulo</label>
								 	<textarea id="menu_titulo" name="menu_titulo" rows="4" cols="50"></textarea>
								 	<span class="brsmall"></span>
								 	<label id="labelmodmenu">Estilo CSS</label>
								 	<input type="text" id="menu_css" name="menu_css" value="">
								 	<span class="brsmall"></span>
								 	<label id="labelmodmenu">Descripcion</label>
								 	<input type="text" id="menu_descripcion" name="menu_descripcion" value="">														 	
						        	<span class="brsmall"></span>
								 	<label id="labelmodmenu">Visible</label>
								 	<input type="checkbox" id="menu_visible" name="menu_visible">
								 	<div id="menu_action_buttons">
								 		<button type="submit" id="menu_btnedit" name="menu_btnedit" value="editMenu">Modificar</button>
								 		<button type="button" id="menu_btnclear" name="menu_btnclear" value="clearMenu">Agregar</button>
								 		<button type="submit" id="menu_btndelete" name="menu_btndelete" value=deleteMenu"">Eliminar</button>
								 	</div>
								 	<div id="menu_confirm_buttons" class="hidden">
						                <button type="submit" id="menu_btnadd" name="menu_btnadd" value="addMenu">Aceptar</button>
						                <button type="button" id="menu_btncancel" name="menu_btncancel" value="cancelMenu">Cancelar</button>
						            </div>
							 	</form>
							 	<span class="brsmall"></span>
							 	<h5>Lista Opciones</h5>
							 	<select id="lista_menu_seccion" name="lista_menu_seccion" >
						 			<option value=""> -- Seleccione una opción -- </option>
						        </select>
							 	<form action="admin_controller?command=menuSectionActions" method="post" enctype="multipart/form-data">
							 		<input type="hidden" name="menu_seccion_menu_id" id="menu_seccion_menu_id" value="">
							 		<input type="hidden" name="menu_seccion_id"       id="menu_seccion_id" value="">
							 		<label id="labelmodmenu">Codigo</label>
							 		<input type="text" id="menu_seccion_codigo" name="menu_seccion_codigo" value="">
								 	<span class="brsmall"></span>
								 	<label id="labelmodmenu">Texto</label>
								 	<input type="text" id="menu_seccion_texto" name="menu_seccion_texto" value="">
								 	<span class="brsmall"></span>
								 	<label id="labelmodsec">Imagen</label>
								 	<input type="file" id="menu_seccion_imagen" name="menu_seccion_imagen">	
								 	<span class="brsmall"></span>
								 	<label id="labelmodmenu">Enlace</label>
								 	<input type="text" id="menu_seccion_enlace" name="menu_seccion_enlace" value="">
								 	<span class="brsmall"></span>
								 	<label id="labelmodmenu">Estilo CSS</label>
								 	<input type="text" id="menu_seccion_css" name="menu_seccion_css" value="">
								 	<span class="brsmall"></span>								 															 	
								 	<label id="labelmodmenu">Visible</label>
								 	<input type="checkbox" id="menu_seccion_visible" name="menu_seccion_visible">
								 	<div id="menu_seccion_action_buttons">
								 		<button type="submit" id="menu_seccion_btnedit"   name="menu_seccion_btnedit" value="editMenuSeccion">Modificar</button>
								 		<button type="button" id="menu_seccion_btnclear"  name="menu_seccion_btnclear" value="clearMenuSeccion">Agregar</button>
								 		<button type="submit" id="menu_seccion_btndelete" name="menu_seccion_btndelete" value=deleteMenuSeccion"">Eliminar</button>
								 	</div>
								 	<div id="menu_seccion_confirm_buttons" class="hidden">
						                <button type="submit" id="menu_seccion_btnadd"    name="menu_seccion_btnadd"    value="addMenuSeccion">Aceptar</button>
						                <button type="button" id="menu_seccion_btncancel" name="menu_seccion_btncancel" value="cancelMenuSeccion">Cancelar</button>
						            </div>
							 	</form>
							 	</c:if>
							</div>
						</div>
				</c:if>
			</div>
		</div>
	</div>
	
	<script>
	
	/**********************************************************************************************************
	********************************* TODO LO RELACIONADO A SECCIONES *****************************************
	***********************************************************************************************************/
	$(document).ready(function() {
	    //console.log('Document ready');
	    $('#lista_secciones').on('change', function() {
	        //console.log('Select option changed');
	        var selectedOptionId = $(this).val();
	        //console.log('Selected option ID:', selectedOptionId);
	        if (selectedOptionId) {
	            $.ajax({
	                url: 'admin_controller?command=showSeccion&id=' + selectedOptionId,
	                method: 'GET',
	                success: function(data) {             
	                	//console.log('Received section data:', data);          
	                    $('#seccion_id').val(data.id);
	                    $('#seccion_codigo').val(data.codigo);
	                    $('#seccion_titulo').val(data.titulo);
	                    $('#lista_seccion_tipo').val(data.tipo);
	                    //$('#seccion_imagen').val(data.imagen);
	                    $('#seccion_texto').val(data.texto);
	                    $('#seccion_css').val(data.css);
	                    $('#seccion_descripcion').val(data.descripcion);
	                    $('#seccion_visible').val(data.visible);
	                    
	                    if (data.visible) {
	                        $('#seccion_visible').prop('checked', true);
	                    } else {
	                        $('#seccion_visible').prop('checked', false);
	                    }
	                },
	                error: function(xhr, status, error) {
	                    console.error('Error fetching section data:', error);
	                }
	            });
	        }
	    });
	});

	// Cuando se presiona el botón de limpiar sección
    $('#seccion_btnclear').click(function(event) {
        event.preventDefault();
        var highestCode = 0;
        $('#lista_secciones option').each(function() {
            var text = $(this).text();
            var code = parseInt(text.split(' - ')[0]);
            if (!isNaN(code) && code > highestCode) {
                highestCode = code;
            }
        });
        var newCode = (highestCode + 1).toString().padStart(3, '0');

        $('#seccion_id').val('');
        $('#seccion_codigo').val(newCode);
        $('#lista_seccion_tipo').val('');
        $('#seccion_titulo').val('');
        $('#seccion_imagen').val('');
        $('#seccion_texto').val('');
        $('#seccion_enlace').val('');
        $('#seccion_css').val('');
        $('#seccion_descripcion').val('');
        $('#seccion_visible').prop('checked', true);

        $('#lista_secciones').prop('disabled', true);
        $('#seccion_action_buttons').addClass('hidden');
        $('#seccion_confirm_buttons').removeClass('hidden');
        
        $('#lista_secciones').val($('#lista_secciones option:first').val());
    });

    // Cuando se presiona el botón de cancelar sección
    $('#seccion_btncancel').click(function(event) {
        event.preventDefault();
        
        $('#seccion_id').val('');
        $('#seccion_codigo').val('');
        $('#lista_seccion_tipo').val('');
        $('#seccion_titulo').val('');
        $('#seccion_imagen').val('');
        $('#seccion_texto').val('');
        $('#seccion_enlace').val('');
        $('#seccion_css').val('');
        $('#seccion_descripcion').val('');
        $('#seccion_visible').prop('checked', false);

        $('#lista_secciones').prop('disabled', false);
        $('#seccion_action_buttons').removeClass('hidden');
        $('#seccion_confirm_buttons').addClass('hidden');
        
        $('#lista_secciones').val($('#lista_secciones option:first').val());
    });

    // Submisión del formulario de sección
    $('#seccionForm').submit(function(event) {
        event.preventDefault();
        $.ajax({
            url: $(this).attr('action'),
            type: $(this).attr('method'),
            data: new FormData(this),
            processData: false,
            contentType: false,
            success: function(response) {
                if (response.success) {
                	// Reset the form fields
                	$('#seccionForm')[0].reset();
                    $('#seccion_action_buttons').removeClass('hidden');
                    $('#seccion_confirm_buttons').addClass('hidden');
                    $('#lista_secciones').prop('disabled', false);
                    $('#lista_secciones').val($('#lista_secciones option:first').val());
                    alert("Sección agregada exitosamente!");
                } else {
                    alert("Error: " + response.message);
                }
            },
            error: function() {
                alert("Error al agregar la sección.");
            }
        });
    });
    
    /**********************************************************************************************************
	********************************* TODO LO RELACIONADO A CARRETE  ******************************************
	***********************************************************************************************************/
	
	// Cuando se selecciona un carrete
    $('#lista_carretes').on('change', function() {
        var selectedOptionId = $(this).val();
        if (selectedOptionId) {
            $.ajax({
                url: 'admin_controller?command=showCarrete&id=' + selectedOptionId,
                method: 'GET',
                success: function(data) {
                	$('#carrete_seccion_carrete_id').val(data.id);
                    $('#carrete_id').val(data.id);
                    $('#carrete_codigo').val(data.codigo);
                    $('#carrete_titulo').val(data.titulo);
                    $('#carrete_texto').val(data.texto);
                    $('#carrete_css').val(data.css);
                    $('#carrete_descripcion').val(data.descripcion);
                    $('#carrete_visible').prop('checked', data.visible);
                 	// Llenar el select #lista_carrete_seccion
                    fillCarreteSections(data.carrete_secciones);
                    
                },
                error: function(xhr, status, error) {
                    console.error('Error fetching section data:', error);
                }
            });
        }
    });
    
 	// Cuando se presiona el botón de limpiar carrete
    $('#carrete_btnclear').click(function(event) {
        event.preventDefault();
        var highestCode = 0;
        $('#lista_carretes option').each(function() {
            var text = $(this).text();
            var code = parseInt(text.split(' - ')[0]);
            if (!isNaN(code) && code > highestCode) {
                highestCode = code;
            }
        });
        var newCode = (highestCode + 1).toString().padStart(3, '0');
		
        $('#carrete_id').val('');
        $('#carrete_codigo').val(newCode);
        $('#carrete_titulo').val('');
        $('#carrete_css').val('');
        $('#carrete_descripcion').val('');
        $('#carrete_visible').prop('checked', true);

        $('#carrete_menus').prop('disabled', true);
        $('#carrete_action_buttons').addClass('hidden');
        $('#carrete_confirm_buttons').removeClass('hidden');
        
        $('#lista_carretes').val($('#lista_carretes option:first').val());
        
        $('#lista_carrete_seccion').val($('#lista_menu_seccion option:first').val());
        $('#lista_carrete_seccion').prop('disabled', true);
        $('#carrete_seccion_id').val('');
        $('#carrete_seccion_id').prop('disabled', true);
        $('#carrete_seccion_codigo').val('');
        $('#carrete_seccion_codigo').prop('disabled', true);
        $('#carrete_seccion_texto').val('');
        $('#carrete_seccion_texto').prop('disabled', true);
        $('#carrete_seccion_css').val('');
        $('#carrete_seccion_css').prop('disabled', true);
        $('#carrete_seccion_enlace').val('');
        $('#carrete_seccion_enlace').prop('disabled', true);
        $('#carrete_seccion_visible').prop('checked', false);
        $('#carrete_seccion_visible').prop('disabled', true);
    });

    // Cuando se presiona el botón de cancelar carrete
    $('#carrete_btncancel').click(function(event) {
        event.preventDefault();
        
        $('#carrete_id').val('');
        $('#carrete_codigo').val('');
        $('#carrete_titulo').val('');
        $('#carrete_css').val('');
        $('#carrete_descripcion').val('');
        $('#carrete_visible').prop('checked', false);

        $('#lista_carretes').prop('disabled', false);
        $('#carrete_action_buttons').removeClass('hidden');
        $('#carrete_confirm_buttons').addClass('hidden');
        
        $('#lista_carretes').val($('#lista_carretes option:first').val());
        
        $('#lista_carrete_seccion').val($('#lista_menu_seccion option:first').val());
        $('#lista_carrete_seccion').prop('disabled', false);
        $('#carrete_seccion_id').val('');
        $('#carrete_seccion_id').prop('disabled', false);
        $('#carrete_seccion_codigo').val('');
        $('#carrete_seccion_codigo').prop('disabled', false);
        $('#carrete_seccion_texto').val('');
        $('#carrete_seccion_texto').prop('disabled', false);
        $('#carrete_seccion_css').val('');
        $('#carrete_seccion_css').prop('disabled', false);
        $('#carrete_seccion_enlace').val('');
        $('#carrete_seccion_enlace').prop('disabled', false);
        $('#carrete_seccion_visible').prop('checked', false);
        $('#carrete_seccion_visible').prop('disabled', false);
    });
    
  	//Para cargar las secciones del carrete seleccionado
	function fillCarreteSections(secciones) {
        var $lista_carrete_seccion = $('#lista_carrete_seccion');
        $lista_carrete_seccion.html('<option value=""> -- Seleccione una opción -- </option>'); // Limpiar el select
        //console.log('List seccion:', secciones);
        secciones.forEach(function(option) {
            $lista_carrete_seccion.append(
                $('<option>', { value: option.id, text: option.codigo + ' - ' + option.tittle })
            );
        });
        
     $('#carrete_seccion_id').val('');
     $('#carrete_seccion_codigo').val('');
     $('#carrete_seccion_titulo').val('');
     $('#carrete_seccion_css').val('');
     $('#carrete_seccion_enlace').val('');
     $('#carrete_seccion_visible').prop('checked', false);
    }
    
    /**********************************************************************************************************
	************************** TODO LO RELACIONADO A LAS SECCIONES CARRETES ***********************************
	***********************************************************************************************************/
  	
	$('#lista_carrete_seccion').on('change', function() {
        //console.log('Select option changed');
        var selectedOptionId = $(this).val();
        //console.log('Selected option ID:', selectedOptionId);
        if (selectedOptionId) {
            $.ajax({
                url: 'admin_controller?command=showCarreteSeccion&id=' + selectedOptionId,
                method: 'GET',
                success: function(data) {             
                	//console.log('Received section data:', data);	
                    $('#carrete_seccion_id').val(data.id);
                    $('#carrete_seccion_lista_tipo').val(data.tipo);
                    $('#carrete_seccion_codigo').val(data.codigo);
                    //$('#seccion_imagen').val(data.imagen);
                    $('#carrete_seccion_titulo').val(data.titulo);
                    $('#carrete_seccion_enlace').val(data.enlace);
                    $('#carrete_seccion_css').val(data.css);
                    $('#carrete_seccion_visible').val(data.visible);
                    
                    if (data.tipo == 1) {
                    	$('#labelcarreteseccionsubtitulo').show();
            	    	$('#carrete_seccion_subtitulo').show();
            	    	$('#labelcarretesecciontexto').show();
            	        $('#carrete_seccion_texto').show();
            	        $('#labelcarretesecciontema').show();
            	        $('#carrete_seccion_lista_tema').show();
            	        
            	    } else {
            	    	$('#labelcarreteseccionsubtitulo').hide();
            	    	$('#carrete_seccion_subtitulo').hide();
            	    	$('#labelcarretesecciontexto').hide();
            	        $('#carrete_seccion_texto').hide();
            	        $('#labelcarretesecciontema').hide();
            	        $('#carrete_seccion_lista_tema').hide();
            	    }
                    
                    $('#carrete_seccion_lista_tipo').prop('disabled', true);
                    if (data.visible) {
                        $('#carrete_seccion_visible').prop('checked', true);
                    } else {
                        $('#carrete_seccion_visible').prop('checked', false);
                    }
                    
            	    
                },
                error: function(xhr, status, error) {
                    console.error('Error fetching carrete section data:', error);
                }
            });
        }
    });
	
	$('#carrete_seccion_lista_tipo').on('change', function() 
	{
	    var tipo = $('#carrete_seccion_lista_tipo').val();
		//console.log('Received data:', tipo);
	    if (tipo == 1) {
	    	$('#labelcarreteseccionsubtitulo').show();
	    	$('#carrete_seccion_subtitulo').show();
	    	$('#labelcarretesecciontexto').show();
	        $('#carrete_seccion_texto').show();
	        $('#labelcarretesecciontema').show();
	        $('#carrete_seccion_lista_tema').show();
	    } else {
	    	$('#labelcarreteseccionsubtitulo').hide();
	    	 $('#carrete_seccion_subtitulo').hide();
	    	 $('#labelcarretesecciontexto').hide();
		     $('#carrete_seccion_texto').hide();
		     $('#labelcarretesecciontema').hide();
		     $('#carrete_seccion_lista_tema').hide();
	    }
	    
	});

	$('#carrete_seccion_btnclear').click(function(event) {
    	event.preventDefault();
    	
    	var highestCode = 0;
        $('#lista_carrete_seccion option').each(function() {
            var text = $(this).text();
            var code = parseInt(text.split(' - ')[0]);
            if (!isNaN(code) && code > highestCode) {
                highestCode = code;
            }
        });
        var newCode = highestCode + 1;
        newCode =  newCode.toString().padStart(3, '0');
     
	     $('#carrete_seccion_id').val('');
	     $('#carrete_seccion_codigo').val(newCode);
	     $('#carrete_seccion_titulo').val('');
	     $('#carrete_seccion_css').val('');
	     $('#carrete_seccion_enlace').val('');
	     $('#carrete_seccion_visible').prop('checked', true);
	     $('#carrete_seccion_subtitulo').val('');
	     $('#carrete_seccion_texto').val('');
	
	     $('#lista_carrete_seccion').prop('disabled', true);
	     $('#carrete_seccion_action_buttons').addClass('hidden');
	     $('#carrete_seccion_lista_tipo').prop('disabled', false);
	     $('#carrete_seccion_confirm_buttons').removeClass('hidden');
	     	
	     $('#lista_carrete_seccion').val($('#lista_carrete_seccion option:first').val());
	     $('#carrete_seccion_lista_tipo').val($('#carrete_seccion_lista_tipo option:first').val());
	 });
	
	 $('#carrete_seccion_btncancel').click(function(event) {
	 	event.preventDefault();
	 	
	     $('#carrete_seccion_id').val('');
	     $('#carrete_seccion_codigo').val('');
	     $('#carrete_seccion_titulo').val('');
	     $('#carrete_seccion_css').val('');
	     $('#carrete_seccion_enlace').val('');
	     $('#carrete_seccion_visible').prop('checked', false);
	     $('#carrete_seccion_subtitulo').val('');
	     $('#carrete_seccion_texto').val('');
	 	
	 	$('#lista_carrete_seccion').prop('disabled', false);
	 	$('#carrete_seccion_lista_tipo').prop('disabled', false);
	    $('#carrete_seccion_action_buttons').removeClass('hidden');
	    $('#carrete_seccion_confirm_buttons').addClass('hidden');
	    
	    $('#lista_carrete_seccion').val($('#lista_carrete_seccion option:first').val());
	    $('#carrete_seccion_lista_tipo').val($('#carrete_seccion_lista_tipo option:first').val());
	 });
    
    /**********************************************************************************************************
	********************************* TODO LO RELACIONADO A MENUS *********************************************
	***********************************************************************************************************/
    
    $('#lista_menus').on('change', function() {
        //console.log('Select option changed');
        var selectedOptionId = $(this).val();
        //console.log('Selected option ID:', selectedOptionId);
        if (selectedOptionId) {
            $.ajax({
                url: 'admin_controller?command=showMenu&id=' + selectedOptionId,
                method: 'GET',
                success: function(data) {             
                	//console.log('Received section data:', data);	
                	$('#menu_seccion_menu_id').val(data.id);          
                    $('#menu_id').val(data.id);
                    $('#menu_codigo').val(data.codigo);
                    $('#menu_titulo').val(data.titulo);
                    $('#menu_texto').val(data.texto);
                    $('#menu_css').val(data.css);
                    $('#menu_descripcion').val(data.descripcion);
                    $('#menu_visible').val(data.visible);
                    // Llenar el select #lista_menu_seccion
                    fillMenuSections(data.menu_secciones);
                    
                    if (data.visible) {
                        $('#menu_visible').prop('checked', true);
                    } else {
                        $('#menu_visible').prop('checked', false);
                    }
                },
                error: function(xhr, status, error) {
                    console.error('Error fetching menu data:', error);
                }
            });
        }
    });
    
 	// Cuando se presiona el botón de limpiar menú
    $('#menu_btnclear').click(function(event) {
        event.preventDefault();
        var highestCode = 0;
        $('#lista_menus option').each(function() {
            var text = $(this).text();
            var code = parseInt(text.split(' - ')[0]);
            if (!isNaN(code) && code > highestCode) {
                highestCode = code;
            }
        });
        var newCode = (highestCode + 1).toString().padStart(3, '0');

        $('#menu_seccion_menu_id').val('');
        $('#menu_id').val('');
        $('#menu_codigo').val(newCode);
        $('#menu_titulo').val('');
        $('#menu_css').val('');
        $('#menu_enlace').val('');
        $('#menu_descripcion').val('');
        $('#menu_visible').prop('checked', true);

        $('#lista_menus').prop('disabled', true);
        $('#menu_action_buttons').addClass('hidden');
        $('#menu_confirm_buttons').removeClass('hidden');
        
        $('#lista_menus').val($('#lista_menus option:first').val());
        
        $('#lista_menu_seccion').val($('#lista_menu_seccion option:first').val());
        $('#lista_menu_seccion').prop('disabled', true);
        $('#menu_seccion_id').val('');
        $('#menu_seccion_id').prop('disabled', true);
        $('#menu_seccion_codigo').val('');
        $('#menu_seccion_codigo').prop('disabled', true);
        $('#menu_seccion_texto').val('');
        $('#menu_seccion_texto').prop('disabled', true);
        $('#menu_seccion_css').val('');
        $('#menu_seccion_css').prop('disabled', true);
        $('#menu_seccion_enlace').val('');
        $('#menu_seccion_enlace').prop('disabled', true);
        $('#menu_seccion_visible').prop('checked', false);
        $('#menu_seccion_visible').prop('disabled', true);
    });

    // Cuando se presiona el botón de cancelar menú
    $('#menu_btncancel').click(function(event) {
        event.preventDefault();
		
        $('#menu_seccion_menu_id').val(''); 
        $('#menu_id').val('');
        $('#menu_codigo').val('');
        $('#menu_titulo').val('');
        $('#menu_css').val('');
        $('#menu_enlace').val('');
        $('#menu_descripcion').val('');
        $('#menu_visible').prop('checked', false);

        $('#lista_menus').prop('disabled', false);
        $('#menu_action_buttons').removeClass('hidden');
        $('#menu_confirm_buttons').addClass('hidden');
        
        $('#lista_menus').val($('#lista_menus option:first').val());
        
        $('#lista_menu_seccion').val($('#lista_menu_seccion option:first').val());
        $('#lista_menu_seccion').prop('disabled', false);
        $('#menu_seccion_id').val('');
        $('#menu_seccion_id').prop('disabled', false);
        $('#menu_seccion_codigo').val('');
        $('#menu_seccion_codigo').prop('disabled', false);
        $('#menu_seccion_texto').val('');
        $('#menu_seccion_texto').prop('disabled', false);
        $('#menu_seccion_css').val('');
        $('#menu_seccion_css').prop('disabled', false);
        $('#menu_seccion_enlace').val('');
        $('#menu_seccion_enlace').prop('disabled', false);
        $('#menu_seccion_visible').prop('checked', false);
        $('#menu_seccion_visible').prop('disabled', false);
        
    });

	//Para cargar las secciones del menu seleccionado
	function fillMenuSections(secciones) {
        var $lista_menu_seccion = $('#lista_menu_seccion');
        $lista_menu_seccion.html('<option value=""> -- Seleccione una opción -- </option>'); // Limpiar el select
        secciones.forEach(function(option) {
            $lista_menu_seccion.append(
                $('<option>', { value: option.id, text: option.codigo + ' - ' + option.texto })
            );
        });
        
     $('#menu_seccion_id').val('');
     $('#menu_seccion_codigo').val('');
     $('#menu_seccion_texto').val('');
     $('#menu_seccion_css').val('');
     $('#menu_seccion_enlace').val('');
     $('#menu_seccion_visible').prop('checked', false);
    }
    
    /**********************************************************************************************************
	************************** TODO LO RELACIONADO A LAS SECCIONES MENUS **************************************
	***********************************************************************************************************/
	
	$('#lista_menu_seccion').on('change', function() {
        //console.log('Select option changed');
        var selectedOptionId = $(this).val();
        //console.log('Selected option ID:', selectedOptionId);
        if (selectedOptionId) {
            $.ajax({
                url: 'admin_controller?command=showMenuSeccion&id=' + selectedOptionId,
                method: 'GET',
                success: function(data) {             
                	//console.log('Received section data:', data);	 	          
                    $('#menu_seccion_id').val(data.id);
                    $('#menu_seccion_codigo').val(data.codigo);
                    //$('#seccion_imagen').val(data.imagen);
                    $('#menu_seccion_texto').val(data.texto);
                    $('#menu_seccion_enlace').val(data.enlace);
                    $('#menu_seccion_css').val(data.css);
                    $('#menu_seccion_visible').val(data.visible);
                    
                    if (data.visible) {
                        $('#menu_seccion_visible').prop('checked', true);
                    } else {
                        $('#menu_seccion_visible').prop('checked', false);
                    }
                },
                error: function(xhr, status, error) {
                    console.error('Error fetching section data:', error);
                }
            });
        }
    });
    
    
	$('#menu_seccion_btnclear').click(function(event) {
    	event.preventDefault();
    	
    	var highestCode = 0;
        $('#lista_menu_seccion option').each(function() {
            var text = $(this).text();
            var code = parseInt(text.split(' - ')[0]);
            if (!isNaN(code) && code > highestCode) {
                highestCode = code;
            }
        });
        var newCode = highestCode + 1;
        newCode =  newCode.toString().padStart(3, '0');
     
	     $('#menu_seccion_id').val('');
	     $('#menu_seccion_codigo').val(newCode);
	     $('#menu_seccion_texto').val('');
	     $('#menu_seccion_css').val('');
	     $('#menu_seccion_enlace').val('');
	     $('#menu_seccion_visible').prop('checked', true);
	
	     $('#lista_menu_seccion').prop('disabled', true);
	     $('#menu_seccion_action_buttons').addClass('hidden');
	     $('#menu_seccion_confirm_buttons').removeClass('hidden');
	     
	     $('#lista_menu_seccion').val($('#lista_menu_seccion option:first').val());
	 });
	
	 $('#menu_seccion_btncancel').click(function(event) {
	 	event.preventDefault();
	 	
	     $('#menu_seccion_id').val('');
	     $('#menu_seccion_codigo').val('');
	     $('#menu_seccion_texto').val('');
	     $('#menu_seccion_css').val('');
	     $('#menu_seccion_enlace').val('');
	     $('#menu_seccion_visible').prop('checked', false);
	 	
	 	$('#lista_menu_seccion').prop('disabled', false);
	    $('#menu_seccion_action_buttons').removeClass('hidden');
	    $('#menu_seccion_confirm_buttons').addClass('hidden');
	    
	    $('#lista_menu_seccion').val($('#lista_menu_seccion option:first').val());
	 });
    
	</script>
	
</body>
</html>