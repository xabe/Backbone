$(document).ready(function(){
	console.log('main.js loaded');

	//Creamos el router
	window.routers.base = new AppUsuario.Routers.Base();
	
	
	//Creamos la collecion de usuarios
	
	window.collections.usuarios = new AppUsuario.Collections.Usuarios();

	window.collections.usuarios.on('add', function (model) {
		// Agregar nuevas vistas de usuarios
		var view = new AppUsuario.Views.Usuario({model: model});
		view.render();
		view.$el.prependTo('.student-list');
	});

	var xhr = window.collections.usuarios.fetch();
	
	//Inicializamos el router la ruta root
	xhr.done(function () {
			console.log('Start app');

			Backbone.history.start({
				root : webCtx,
				//pushState: true, //Para quitar el # si quitamos el # tenemos que crear un servicio que captura la url y devuelva el index.html
				silent : false //Para que salte el evento
			});
	});
	
	//Creamos la vista que contrala la pagina principal y el pasamos el body
	//va gestionar el boton nuevo y ver más
	window.views.app = new AppUsuario.Views.App( $('body') );
});


