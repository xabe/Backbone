//Sobreescribimos el metodo sync de backbone para obtener el id de Location
//cuando se crea un modelo

//var sync = Backbone.sync;
//Backbone.sync = function(method, model, options) {
//	var xhr = sync.apply(this, arguments);
//  	xhr.done(function(resp, status, xhr) {
//    	if (!model.get("id") && xhr.status === 201) 
//   	{
//	    	var location = xhr.getResponseHeader("Location");
//	    	console.log(location);
//	        if (location) 
//	        {
//	            var fragments = location.split("/");
//	            var id = fragments[fragments.length - 1];
//	            model.set("id", id);
//	        }
//   		 }
//  	});
//  	return xhr;
//};



AppUsuario.Models.Usuario = Backbone.Model.extend({
	urlRoot : 'http://localhost:9080/test/usuario/',
	initialize: function(){
				console.info('Creado un usuario');
	},
	parse : function(response, options) {
		console.log('parse');
		var xhr = options.xhr;
		if (!this.get("id") && xhr.status === 201) 
		{
			var location = xhr.getResponseHeader("Location");
			console.log(location);
			if (location) 
			{
				var fragments = location.split("/");
				var id = fragments[fragments.length - 1];
				this.set("id", id);
			}
		}
		return response;
	}
});