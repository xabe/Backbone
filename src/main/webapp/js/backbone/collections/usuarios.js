AppUsuario.Collections.Usuarios = Backbone.Collection.extend({
	url : webCtx + '/rest/usuario/all',
	model : AppUsuario.Models.Usuario,
	initialize: function(){
				console.info('Creado una collecion de usuarios');
	}
});