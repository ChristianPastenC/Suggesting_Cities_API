# Backend Coding Challenge

## cURL Examples

    # Get suggestions for any city
    $ curl --request GET \ --url https://steady-habitat-398500.uc.r.appspot.com/suggestions?q=London

    # Get suggestions for misspelled city
    $ curl --request GET \ --url https://steady-habitat-398500.uc.r.appspot.com/suggestions?q=Lndon

    # Get suggestions with latitude and longitude params
    $ curl --request GET \ --url https://steady-habitat-398500.uc.r.appspot.com/suggestions?q=Lndon&latitude=42.98339&longitude=-81.23304

    # Get not found suggestions request 
    curl --request GET \ --url https://steady-habitat-398500.uc.r.appspot.com/suggestions?q=TheMiddleOfNowhere

    # Get all cities from another endpoint
    curl --request GET \ --url https://steady-habitat-398500.uc.r.appspot.com/all

## Postman Screenshots Responses

![image](https://github.com/ChristianPastenC/SuggestCities_Gendra/assets/49313732/3909c587-91ec-4107-a83d-831642b337cc)

![image](https://github.com/ChristianPastenC/SuggestCities_Gendra/assets/49313732/e90f4b4e-3c27-4067-a5dd-dc8d99844012)

![image](https://github.com/ChristianPastenC/SuggestCities_Gendra/assets/49313732/f2c8551f-26f5-41e7-b00f-9ff563210a5a)
