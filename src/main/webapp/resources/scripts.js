window.onload = function() {

	var jsonUrl = window.contextRoot + '/collectedTax';

	var xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function() {
		
		if (this.readyState == 4 && this.status == 200) {
			
			var z = document.getElementById("table");
			var res = JSON.parse(this.response);
            
           
			for (var i = 0; i < res.length; i++) {
				var element = res[i];
				console.log(element);
				console.log(element.taxCollectedMap);
				var x = document.createElement("TR");
				var keys = Object.keys(element.taxCollectedMap);
				var values = Object.values(element.taxCollectedMap);
				
				var y1 = document.createElement("TD")
				y1.innerHTML = element.zoneName;
				y1.setAttribute("rowspan", keys.length+"");
				x.appendChild(y1);
				var y2 = document.createElement("TD");
				y2.innerHTML=keys[0];
				x.appendChild(y2);
				var y3 = document.createElement("TD");
				y3.innerHTML=values[0];
				x.appendChild(y3);
				z.appendChild(x)
				for (var j = 1; j < keys.length; j++) {

					var x2 = document.createElement("TR");
					var y4 = document.createElement("TD");
					y4.innerHTML = keys[j];
					x2.appendChild(y4);
					var y5 = document.createElement("TD");
					y5.innerHTML = values[j];
					x2.appendChild(y5)
					z.appendChild(x2);

				}
			}
		}
	};
	xhttp.open("POST", jsonUrl, true);
	xhttp.send();
};
