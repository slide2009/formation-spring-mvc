const remplir = data => {
	$("#tableau").empty()				
	data.forEach(appli => $("#tableau")
	.append(
	`<tr>
	 <td>${appli.id}</td>
	 <td>${appli.nom}</td>
	 <td>${appli.description}</td>
	 </tr>`)) 
}	

$(document).ready(function() {		
	$.get('http://localhost:8080/applications-api/').done(data => remplir(data))

	$("#idAppli").on('keypress',function(e) {
		if(e.which == 13) {
			const idApplication = e.target.value;
			$.ajax({
			url: 'http://localhost:8080/applications-api/'+idApplication,
			method: 'delete',	        
			success: (data,text, xhr) => remplir(data) 
			})										
		}
	})								
})