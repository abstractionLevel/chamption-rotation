package com.championrotation.championrotation.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;

@RestController
@RequestMapping("/api/v1/champion")
    public class ChampionController {

    @GetMapping()
    public String getChampions() throws JSONException {
        String uri = "https://euw1.api.riotgames.com/lol/platform/v3/champion-rotations?api_key=RGAPI-59324ff8-02e4-45bf-b27e-5773df1c9104";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri,String.class);
        JSONObject jsonObject= new JSONObject(result );
        System.out.println(jsonObject.get("freeChampionIds"));

        return  result;
    }
}
