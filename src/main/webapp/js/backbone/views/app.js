AppUsuario.Views.App = Backbone.View.extend({
	events : {
		"click .nuevo" : "showForm",
		"click .modal-background" : "showForm",
		"click .modal-close" : "showForm",
		"click .enviar" : "createUsuario",
		"click .page .root" : "navigateHome"
	},
	initialize : function ($el) {
		this.$el = $el;
	},
	navigateHome : function (e){
		e.stopPropagation();
		Backbone.history.navigate('/', {trigger: true});
	},
	showForm : function (e) {
		e.stopPropagation();
		this.$el.find(".modal-content, .modal-background").toggleClass("active");
		this.$el.find("input[name=nombre]").val("");
	},
	createUsuario : function (e) {
		e.preventDefault();

		var nombre = $('input[name=nombre]').val();

		var data = {
			"nombre" : nombre
		};
		
		//Creamos el modelo
		var model = new AppUsuario.Models.Usuario(data);
		//Guadamos en Server
		var xhr = model.save();
		xhr.done(function(resp, status, xhr) {
			//A�andimos a la coleccion automaticamente lo muestra por pantalla
			if(xhr.status === 201)
			{
				window.collections.usuarios.add(model);
			}
		});
		
		//Cerramos la modal
		this.showForm(e);
	}
});