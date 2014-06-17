//Namespaces
window.AppUsuario = {};
//Constructores
AppUsuario.Views = {};
AppUsuario.Collections = {};
AppUsuario.Models = {};
AppUsuario.Routers = {};
//Variables globales
window.app = {};
window.routers = {};
window.views = {};
window.collections = {};
//Path de la url
var path = window.location.pathname;
var webCtx = path.substring(0, path.indexOf('/', 1));