$(document).ready(function(){
	console.log('main.js loaded');

	
	//Creamos la collecion de usuarios
	
	window.collections.usuarios = new AppUsuario.Collections.Usuarios();

	window.collections.usuarios.on('add', function (model) {
		// Agregar nuevas vistas de usuarios
		var view = new AppUsuario.Views.Usuario({model: model});
		view.render();
		view.$el.prependTo('.student-list');
	});

	var xhr = window.collections.usuarios.fetch();
	
	
	//Creamos la vista que contrala la pagina principal y el pasamos el body
	//va gestionar el boton nuevo y ver más
	window.views.app = new AppUsuario.Views.App( $('body') );
});


