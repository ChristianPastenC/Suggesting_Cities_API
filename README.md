# Backend Coding Challenge

## cURL Examples

    # Get suggestions for any city
    $ curl --request GET \ --url https://suggesting-cities-api.onrender.com/suggestions?city_name=London

    # Get suggestions for misspelled city
    $ curl --request GET \ --url https://suggesting-cities-api.onrender.com/suggestions?city_name=Lndon

    # Get suggestions with latitude and longitude params
    $ curl --request GET \ --url https://suggesting-cities-api.onrender.com/suggestions?city_name=Lndon&lat=42.98339&lon=-81.23304

    # Get not found suggestions request 
    curl --request GET \ --url https://suggesting-cities-api.onrender.com/suggestions?city_name=TheMiddleOfNowhere

    # Get cities by country code
    curl --request GET \ --url https://suggesting-cities-api.onrender.com/search_by_country?country_code=MX
    
    # Get all cities from another endpoint
    curl --request GET \ --url https://suggesting-cities-api.onrender.com/all

