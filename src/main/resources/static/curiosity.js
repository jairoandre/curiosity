
function getMarsReport() {

	$.ajax({
		method : "GET",
		url : "http://localhost:8080/api/mars/report"
	}).done(
			function(data) {
				marsStatus = data;
				document.getElementById("weather-atmo-opacity").textContent = marsStatus.weatherReport.atmo_opacity;
				document.getElementById("weather-max-temp").textContent = marsStatus.weatherReport.max_temp;
				document.getElementById("weather-min-temp").textContent = marsStatus.weatherReport.min_temp;
				document.getElementById("weather-wind-speed").textContent = marsStatus.weatherReport.wind_speed;
				document.getElementById("weather-terrestrial-date").textContent = marsStatus.weatherReport.earthTime;
				

			}).fail(
					function(data) {
						alert("Could not retrieve Mars report." + data);
					});

}

$(document).ready(function() {

	getMarsReport();

});
