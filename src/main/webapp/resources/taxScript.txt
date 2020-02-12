function calculateTax() {
	var propertyType = document.getElementById("propertyId").value;
	var status = document.getElementById("residentId").value;
	var zone = document.getElementById("zonesId").value;
	var constructionYear = document.getElementById("constructionYear").value;
	var area = document.getElementById("area").value;
	if (propertyType !== '' && status !== '' && zone !== '' && constructionYear > 0 && area > 1) {
		getCalculatedTax();
	}
};

function getCalculatedTax() {
	let jsonUrl = window.contextRoot + '/calculateTax';
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var res = JSON.parse(this.response);
			document.getElementById("taxPayable").value = res;
		}
	}
	xhttp.open("POST", jsonUrl);
	xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	xhttp.send('{"zone":"'+document.getElementById("zonesId").value+'","property":"'+document.getElementById("propertyId").value+'","status":"'+document.getElementById("residentId").value+'","constructionYear":'+document.getElementById("constructionYear").value+',"buildArea":'+document.getElementById("area").value+'}');
}


function alphaOnly(evt) {
    var charCode = (evt.which) ? evt.which : window.event.keyCode;

    if (charCode <= 13) {
        return true;
    }
    else {
        var keyChar = String.fromCharCode(charCode);
        var re = /^[a-zA-Z ]+$/
        return re.test(keyChar);
    }
}