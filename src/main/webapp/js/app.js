jQuery(document).ready(function($) {
	alert("Hello! I am an alert box!!");
	$("ajaxCall").submit(function(event) {
	event.preventDefault();
	alert("Hello!");
	ajaxCall();
	});
});
function ajaxCall() {
	var data = {}
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "ajaxCall",
		data : { email: "kunapareddy.vijay560@gmail.com"}
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			display(data);
		},
		error : function(e) {
			console.log("ERROR: ", e);
			display(e);
		},
		done : function(e) {
			console.log("DONE");
		}
	});
}