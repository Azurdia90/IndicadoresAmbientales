<div>
	<div class="navbar">
		<img src="${menu_logo}" alt="img"></img> <i class="fa fa-bars"
			onclick="openNav()"></i> <a href="eju_controller">${lista_menu[3]}</a>
		<a href="da_controller">${lista_menu[2]}</a> <a href="prg_controller">${lista_menu[1]}</a>
		<a href="index_controller">INICIO</a> <i class="fa fa-fw fa-search"></i>

	</div>
	<div id="mySidebar" class="sidebar">
		<a href="#" class="closebtn" onclick="closeNav()"><i
			class="fa fa-times" aria-hidden="true"></i></a> <a href="ig_controller"><i
			class="fa fa-angle-left" aria-hidden="true">&nbsp;
				${lista_menu[4]}</i></a> <a href="eve_controller"><i
			class="fa fa-angle-left" aria-hidden="true">&nbsp;
				${lista_menu[5]}</i></a> <a href="ap_controller"><i
			class="fa fa-angle-left" aria-hidden="true">&nbsp;
				${lista_menu[6]}</i></a> <a href="na_controller"><i
			class="fa fa-angle-left" aria-hidden="true">&nbsp;
				${lista_menu[7]}</i></a> <a href="#"><i class="fa fa-angle-left"
			aria-hidden="true">&nbsp; ${lista_menu[8]}</i></a> <a href="#"><i
			class="fa fa-angle-left" aria-hidden="true">&nbsp;
				${lista_menu[9]}</i></a> <a href="#"><i class="fa fa-angle-left"
			aria-hidden="true">&nbsp; ${lista_menu[10]}</i></a> <a
			href="mail_controller"><i class="fa fa-angle-left"
			aria-hidden="true">&nbsp; ${lista_menu[11]}</i></a>
	</div>
</div>

<script>
function openNav() {
  document.getElementById("mySidebar").style.width = "30vw";
}

function closeNav() {
  document.getElementById("mySidebar").style.width = "0";
}
</script>