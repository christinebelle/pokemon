// lance fonction quand page html est chargée
$(document).ready(function() {
    
    // Charge les données dans la DataTable
    loadDatatable();
    
    // déclaration d'une variable table
    var table = $("#pokemonTable").dataTable();
    
    // récupération dans formulaire des valeurs attributs pokemon lorsque double clic sur ligne de la database
    $('#pokemonTable tbody').on( 'dblclick', 'tr', function () {
	    let dataRow = table.row( this ).data();
	    $("#idPokemon").val(dataRow.idPokemon);
		$("#nomPokemon").val(dataRow.nomPokemon);
		$("#nomEvol1").val(dataRow.nomEvol1);
		$("#nomEvol2").val(dataRow.nomEvol2);
        $("#idType").val(dataRow.idType);
        
	});
    
    // appelle méthode clic POST avec 2 paramètres (référence bouton et type méthode post)
    $("#btn-post").click(function(e) {
        pokemon_submit($("btn-post"), "POST", table);
    });
    
    // appelle méthode clic PUT avec 2 paramètres (référence bouton et type méthode put) 
    $("#btn-put").click(function(e) {
        pokemon_submit($("btn-put"), "PUT", table);
    });
    
    // appelle méthode clic GET
    $("#btn-get").click(function(e) {
        getByName(e);
    });
    
    // appelle méthode clic DELETE
    $("#btn-delete").click(function(e) {
        deletePokemon();
    });
    
});

// Charge les données dans la DataTable
function loadDatatable() {
	$('#pokemonTable').DataTable({
		"columnDefs": [
	            {
	                "targets": [ 0 ],
	                "sortable" : false
	            },
	            {
	                "targets": [ 3 ],
	                "visible": true
	            }
	        ],
		"ajax" : {
			url : '/api/pokemonGetAll',
			dataSrc : ''
		},
		"columns" : [ 
			{"data" : "idPokemon"},
			{"data" : "nomPokemon"},
			{"data" : "nomEvol1"}, 
			{"data" : "nomEvol2"},
            {"data" : "idType"}
        ]
	});
}

// méthode qui traite POST (création pokémon) et PUT (modification pokémon)
function pokemon_submit(button, httpVerb, table) {
    
    var pokemon = {};
    
	// on récupère les valeurs saisies
	pokemon["idPokemon"] = $("#idPokemon").val();
	pokemon["nomPokemon"] = $("#nomPokemon").val();
	pokemon["nomEvol1"] = $("#nomEvol1").val();
	pokemon["nomEvol2"] = $("#nomEvol2").val();
    pokemon["idType"] = $("#idType").val();
	// on initialise l'url du back
	var url = "/api/pokemon";
    
    // si c'est une création
    if(httpVerb == "POST")
        url += "Post";
	
	// si c'est une modification, on passe l'identifiant
	if(httpVerb == "PUT")
		url += "Update/" + apprenant["idPokemon"];
	
	// on désactive le bouton en cours 
	button.prop("disabled", true);

	// méthode ajax pour faire le lien avec les méthodes back du constructeur
	$.ajax({
		type : httpVerb, // méthode POST ou PUT
		contentType : "application/json", // type de données
		url : url, // url destinatrice
		data : JSON.stringify(pokemon), // transforme les données pokemon en format JSON
		dataType : 'json', // précise le mode de transfert
		cache : false, // pas de cache sollicité
		timeout : 600000, // délai d'attente
		success : function(data) // si ok

            // si c'est une création
            if(httpVerb == "POST")
            var json = "<h3>Server Response au format JSON</h3><pre>Pokemon ajouté :<br>" + JSON.stringify(data, null, 4) + "</pre>";
	
            // si c'est une modification
            if(httpVerb == "PUT")
            var json = "<h3>Server Response au format JSON</h3><pre>pokemon modifié :<br>" + JSON.stringify(data, null, 4) + "</pre>";
			
            // renvoie info format Json adapté au html
			$('#feedbackapprenant').html(json);

			console.log("SUCCESS : ", data);
			button.prop("disabled", false);

			resetForm()
		},
		error : function(e) {

			var json = "<h3>Server Response</h3><pre>" + e.responseText	+ "</pre>";
			
			$('#feedbackapprenant').html(json);

			console.log("ERROR : ", e);
			button.prop("disabled", false);

		}
	});
	
	table.reload(); // recharge les données via ajax et la méthode reload()
}

    
// méthode qui traite GET (affichage d'un pokémon)  
function getByNom(e) {
	
	// on récupère la variable
	var nomPokemon = $("#nomPokemon").val();
	e.preventDefault();
	
	// .ajax recharge juste le résultat de la fonction
	// sans recharger la page entière
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/api/pokemonGet/" + nomPokemon,
		data : {}, // tableau vide pour recevoir réponse
		dataType : 'json',
		cache : false, // false car pas besoin de faire de cache
		timeout : 600000,
		success : function(data) {

			// création du titre du tableau
			var json = "<h3>Server Response format JSON</h3><pre>pokémon trouvé :<br>" + JSON.stringify(data, null, 4) + "</pre>";
			$('#resultat').html(json);
			$("#idPokemon").val(data.idPokemon);
			$("#nomPokemon").val(data.nomPokemon);
			$("#nomEvol1").val(data.nomEvol1);
			$("#nomEvol2").val(data.nomEvol2);
            $("#nomType").val(data.nomType);
            $("#attaqueIm1").val(data.attaqueIm1);
            $("#attaqueIm2").val(data.attaqueIm2);
            $("#attaqueChar1").val(data.attaqueChar1);
            $("#attaqueChar2").val(data.attaqueChar2);
			console.log("SUCCESS : ", data);
		},
		error : function(e) {

			var json = "<h3>Server Response</h3><pre>" + e.responseText	+ "</pre>";
			
			$('#resultat').html(json);

			console.log("ERROR : ", e);
		}
	});
}
   
// méthode qui traite DELETE (suppression d'un pokémon)
function deletePokemon(e) {
   
    var idPokemon = $("#idPokemon").val();

	$.ajax({
		type : "DELETE",
		contentType : "application/json",
		url : "/api/pokemonDelete/" + idPokemon,
		data : {},
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {

			var json = "<h3>Server Response</h3><pre>pokemon numéro " + idPokemon + " supprimé.</pre>";
			$('#feedbackapprenant').html(json);
			console.log("SUCCESS : ", data);

			resetForm();
		},
		error : function(e) {
			var json = "<h3>Server Response</h3><pre>" + e.responseText	+ "</pre>";
			
			$('#feedbackapprenant').html(json);
			console.log("ERROR : ", e);
		}
	});
	table.reload();  
}
    
