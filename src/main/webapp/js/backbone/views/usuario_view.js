AppUsuario.Views.Usuario = Backbone.View.extend({
	tagName : "li",
	className : "item",
	events : {
		"click .delete" : "deleteUsuario",
		"click img" : "navigate",
		"click .actulizar" : "actulizarUsuario"
	},
	initialize : function () {
		console.log('creado una view de usuario');
		
		var self = this;
		
		//escuchamo el evento de router en root
		window.routers.base.on('route:root', function () {
			self.$el.css('display', 'block');
			self.render();
		});

		//escuchamo el evento de router en usuarioSingle
		window.routers.base.on('route:usuarioSingle', function () {
			
			
			
			if(window.app.usuario == self.model.get('id'))
			{
				self.renderExtend();
				self.$el.css('display', 'block');
			}
			else
			{
				self.$el.hide();
			}
		});


		
		//Compilando el template
		this.template = _.template( $('#usuario-template').html());
		this.templateExtend = _.template( $('#usuario-extended-template').html() );
		//Cuando eliminamos un modelo tenemos que deshacer la vista
		//this.model.on("change", this.render, this);
	},
	navigate : function (e){
		e.stopPropagation();
		Backbone.history.navigate('usuario/'+this.model.get('id'), {trigger: true});
	},
	renderExtend : function () {
		var data = this.model.toJSON();
		var html = this.templateExtend(data);
		this.$el.html( html );
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
	},
	actulizarUsuario : function(e){
		e.stopPropagation();
		var nombre = this.$el.find('input[name=nombre]').val();
		this.model.set('nombre', nombre);
		this.model.save();
		Backbone.history.navigate('/', {trigger: true});
	}
});