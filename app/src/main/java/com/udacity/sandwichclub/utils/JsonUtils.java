package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private static final String NAME ="name";
    private static final String MAIN_NAME ="mainName";
    private static final String ALSO_KNOWN_AS = "alsoKnownAs";
    private static final String PLACE_OF_ORIGIN ="placeOfOrigin";
    private static final String DESCRIPTION ="description";
    private static final String IMAGE ="image";
    private static final String INGREDIENTS = "ingredients";

    public static Sandwich parseSandwichJson(String json) {

        Sandwich sandwich= new Sandwich();

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject nameObject= jsonObject.getJSONObject(NAME);
            sandwich.setMainName(nameObject.getString(MAIN_NAME));

            JSONArray jsonArray= nameObject.getJSONArray(ALSO_KNOWN_AS);
            List<String> setAlsoKnownAs= new ArrayList<>();
            for(int i=0 ; i< jsonArray.length() ; i++){
                setAlsoKnownAs.add(jsonArray.getString(i));
            }


            JSONArray ingredientsJsonArray = jsonObject.getJSONArray(INGREDIENTS);
            List<String> ingredients = new ArrayList<>();
            for(int i=0 ;i< ingredientsJsonArray.length(); i++){
                ingredients.add(ingredientsJsonArray.getString(i));
            }

            sandwich.setIngredients(ingredients);
            sandwich.setAlsoKnownAs(setAlsoKnownAs);
            sandwich.setPlaceOfOrigin(jsonObject.getString(PLACE_OF_ORIGIN));
            sandwich.setDescription(jsonObject.getString(DESCRIPTION));
            sandwich.setImage(jsonObject.getString(IMAGE));


        }catch (JSONException e){
            e.printStackTrace();
        }
        return sandwich;





    }
}
