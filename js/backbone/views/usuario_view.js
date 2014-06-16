AppUsuario.Views.Usuario = Backbone.View.extend({
	tagName : "li",
	className : "item",
	events : {
		"click .delete" : "deleteUsuario"
	},
	initialize : function () {
		console.log('creado una view de usuario');
		//Compilando el template
		this.template = _.template( $('#article-template').html());
		
		//Cuando eliminamos un modelo tenemos que deshacer la vista
		//this.model.on("change", this.render, this);
	},
	render : function () {
		var data = this.model.toJSON();
		// junto data con el template;
		var html = this.template(data);
		this.$el.html(html);
	},	
	removeList:function () {
        this.$el.unbind();
        this.$el.remove();
    },	
	deleteUsuario : function(e){
		e.stopPropagation();
		var view = this;
		this.model.destroy({ success : function(model, response){
				view.removeList();
			}					
		});
	}
});