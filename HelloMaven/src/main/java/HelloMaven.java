package com.mycom.myapp;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class HelloMaven {

        public static void main(String[] args) {
                Gson gson = new Gson();
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("result", "success");
                String jsonStr = gson.toJson(jsonObject);
                
                System.out.println(jsonStr);
        }
}