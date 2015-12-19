package hopestudio.org.lims.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by dengzhirong on 15.12.8.
 */
public class JsonUtil {

    /*
    * 将Json字符串转换成JsonObject
    * */
    public JSONObject ToJSONObeject(String jsonString) {
        try {
            return new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
    * 将Json字符串转换成JSONArray
    * */
    public JSONArray toJSONArray(String jsonString) {
        try {
            return new JSONArray(jsonString);

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
    * 将Object对象转换成JSON字符串
    * */
    public String toJSONString(Object object) {
        // ...
        return "";
    }

    /*
    * 将ArrayList数组转换成JSON字符串
    * */
    public String toJSONString(ArrayList arrayList) {
        JSONObject jsonObject = new JSONObject();
        for(int i = 0; i < arrayList.size(); i++) {
            try {
                jsonObject.put(i + "", arrayList.get(i));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jsonObject.toString();
    }

}
