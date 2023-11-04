package com.example.watchlistApp.Services;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RatingServices {
    String apiurl="https://www.omdbapi.com/?apikey=7aa7cb64&t=";
    public String getratingfromapi(String title)
    {
        try {
            // try to fetch the rating by calling omdb api
            RestTemplate template = new RestTemplate();
            //apiUrl + title

            ResponseEntity<ObjectNode> response = template.getForEntity(apiurl + title, ObjectNode.class);

            ObjectNode jsonObject = response.getBody();

            return jsonObject.path("imdbRating").asText();
        }catch(Exception e) {
            //to user entered rating will be taken
            System.out.println("Either movie name not available or api is down" + e.getMessage());
            return null;
        }


    }
}
