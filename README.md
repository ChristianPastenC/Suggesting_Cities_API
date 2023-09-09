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

