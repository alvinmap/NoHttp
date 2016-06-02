/*
 * Copyright © Yan Zhenjie. All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yolanda.nohttp;

import android.text.TextUtils;

import com.yolanda.nohttp.rest.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created on 2016/6/1.
 *
 * @author Yan Zhenjie;
 * @deprecated use {@link com.yolanda.nohttp.rest.JsonObjectRequest}
 */
@Deprecated
public class JsonObjectRequest extends com.yolanda.nohttp.rest.RestRequest<JSONObject> {

    public static final String ACCEPT = "application/json";

    public JsonObjectRequest(String url) {
        super(url);
    }

    public JsonObjectRequest(String url, RequestMethod requestMethod) {
        super(url, requestMethod);
    }

    @Override
    public String getAccept() {
        return ACCEPT;
    }

    @Override
    public JSONObject parseResponse(String url, Headers responseHeaders, byte[] responseBody) {
        JSONObject jsonObject = null;
        String jsonStr = StringRequest.parseResponseString(url, responseHeaders, responseBody);

        if (!TextUtils.isEmpty(jsonStr))
            try {
                jsonObject = new JSONObject(jsonStr);
            } catch (JSONException e) {
                Logger.e(e);
            }
        if (jsonObject == null)
            try {
                jsonObject = new JSONObject("{}");
            } catch (JSONException e) {
            }
        return jsonObject;
    }

}
