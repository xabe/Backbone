AppUsuario.Collections.Usuarios = Backbone.Collection.extend({
	url : 'http://localhost:9080/test/usuario/all',
	model : AppUsuario.Models.Usuario,
	initialize: function(){
				console.info('Creado una collecion de usuarios');
	}
});