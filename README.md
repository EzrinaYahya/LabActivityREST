# LabActivityREST

--the public API and understand the documentation. 

http://openweathermap.org/api

--the parameters that the API able to receive.
•	coord

o	coord.lon City geo location, longitude

o	coord.lat City geo location, latitude

•	weather (more info Weather condition codes)

o	weather.id Weather condition id

o	weather.main Group of weather parameters (Rain, Snow, Extreme etc.)

o	weather.description Weather condition within the group

o	weather.icon Weather icon id

•	base Internal parameter

•	main

o	main.temp Temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.

o	main.pressure Atmospheric pressure (on the sea level, if there is no sea_level or grnd_level data), hPa

o	main.humidity Humidity, %

o	main.temp_min Minimum temperature at the moment. This is deviation from current temp that is possible for large cities and 
megalopolises geographically expanded (use these parameter optionally). Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.

o	main.temp_max Maximum temperature at the moment. This is deviation from current temp that is possible for large cities and megalopolises geographically expanded (use these parameter optionally). Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.

o	main.sea_level Atmospheric pressure on the sea level, hPa

o	main.grnd_level Atmospheric pressure on the ground level, hPa

•	wind

o	wind.speed Wind speed. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour.

o	wind.deg Wind direction, degrees (meteorological)

•	clouds

o	clouds.all Cloudiness, %

•	rain

o	rain.3h Rain volume for the last 3 hours

•	snow

o	snow.3h Snow volume for the last 3 hours

•	dt Time of data calculation, unix, UTC

•	sys

o	sys.type Internal parameter

o	sys.id Internal parameter

o	sys.message Internal parameter

o	sys.country Country code (GB, JP etc.)

o	sys.sunrise Sunrise time, unix, UTC

o	sys.sunset Sunset time, unix, UTC

•	id City ID

•	name City name

•	cod Internal parameter



