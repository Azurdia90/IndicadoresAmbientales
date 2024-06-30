//  seleccionamos los dos elementos que ser�n clickables

const toggleButton = document.getElementById("main-menu-button");
const navWrapper = document.getElementById("nav");

/* 
  cada ves que se haga click en el bot�n 
  agrega y quita las clases necesarias 
  para que el men� se muestre.
*/
toggleButton.addEventListener("click", () => {
  toggleButton.classList.toggle("close");
  navWrapper.classList.toggle("show");
});

/* 
  Cu�ndo se haga click fuera del contenedor de enlaces 
  el men� debe esconderse.
*/

navWrapper.addEventListener("click", e => {
  if (e.target.id === "nav") {
    navWrapper.classList.remove("show");
    toggleButton.classList.remove("close");
  }
});