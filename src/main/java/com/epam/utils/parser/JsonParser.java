package com.epam.utils.parser;

import com.epam.web.soap.Role;
import com.epam.web.soap.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonParser {
    private static final Logger LOGGER = LogManager.getLogger(JsonParser.class);
    private static JSONObject jsonObject;

    static {
        try {
            jsonObject = (JSONObject) (new JSONParser().parse(new FileReader("src/main/resources/data.json")));
        } catch (IOException | ParseException e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public static Role getValidRole(){
        Role role = new Role();
        role.setName(String.valueOf(((JSONObject)jsonObject.get("roles")).get("valid")));
        return role;
    }

    public static Role getInvalidRole(){
        Role role = new Role();
        role.setName(String.valueOf(((JSONObject)jsonObject.get("roles")).get("invalid")));
        return role;
    }

    public static User getValidUser(){
        JSONObject jsonUser = (JSONObject) ((JSONObject)jsonObject.get("users")).get("valid");
        User user = new User();
        user.setUsername(String.valueOf(jsonUser.get("username")));
        user.setPassword(String.valueOf(jsonUser.get("password")));
        user.setRole(getValidRole());
        return user;
    }

    public static User getInvalidUser(){
        JSONObject jsonUser = (JSONObject) ((JSONObject)jsonObject.get("users")).get("invalid");
        User user = new User();
        user.setUsername(String.valueOf(jsonUser.get("username")));
        user.setPassword(String.valueOf(jsonUser.get("password")));
        user.setRole(getInvalidRole());
        return user;
    }

}
