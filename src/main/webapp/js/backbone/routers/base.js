AppUsuario.Routers.Base = Backbone.Router.extend({
	routes : {
		"" : "root",
		"usuario/:id" : "usuarioSingle"
	},
	root : function () {
		console.log('Estoy en root');

		window.app.state = "root";
		window.app.usuario = null;
	},
	usuarioSingle : function (id) {
		console.log('Estoy en un usuario');

		window.app.state = "usuarioSingle";
		window.app.usuario = parseInt(id,10); 
	}
});