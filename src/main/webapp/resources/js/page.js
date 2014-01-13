/* Verifica se o browser suporta o HTML5 */

function supports_html5_storage() {
  try {
    return 'localStorage' in window && window['localStorage'] !== null;
  } catch (e) {
    return false;
  }
}

if(!supports_html5_storage) {
	alert("Navegador sem suporte para HTML5. Tente um diferente.");
	window.location = "http://www.google.com/intl/pt-BR/chrome/browser/";
}

/*

if(!sessionStorage["test"]) 
	sessionStorage["test"] = 1;
else
	alert(++sessionStorage["test"]); 

*/