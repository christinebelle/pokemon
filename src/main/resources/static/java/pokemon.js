// quand la page html est charge lance la fonction
$(document).ready(function() {

	// fonction appelée lors du click
	$("#btn-get").click(function(e) {
		recherchePokemon(e);
	});
	
});

function recherchePokemon(e) {

	var nom = $("#nomPokemon").val(); // on récupère la variable
	e.preventDefault();
	
	$.ajax({// .ajax pour ne pas recharger la page mais juste le resultat de la fonction
		type : "GET",
		contentType : "application/json",
		url : "/api/pokemonGet/" + nom,
		data : {},// tableau vide pour recevoir la reponse body du controleur
		dataType : 'json',
		cache : false,// false car pas besoin de faire de cache
		timeout : 600000,
		success : function(data) {

			// pour faire le titre du tableau Json
			var json = "<h3>Server Response format JSON</h3><pre>Pokemon trouvé :<br>" + JSON.stringify(data, null, 4)+ "</pre>";
			
			$("#resultat").html(json);
			$("#idPokemon").val(data.idPokemon);
			$("#nomEvol1").val(data.nomEvol1);
			$("#nomEvol2").val(data.nomEvol2);
			$("#idType").val(data.email);
			console.log("SUCCESS : ", data);
		},
		error : function(e) {

			var json = "<h3>Server Response</h3><pre>" + e.responseText	+ "</pre>";
			
			$("#resultat").html(json);

			console.log("ERROR : ", e);
		}
	});
}