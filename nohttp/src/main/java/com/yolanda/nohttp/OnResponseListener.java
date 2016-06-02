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

import com.yolanda.nohttp.rest.Response;

/**
 * Created on 2016/6/1.
 *
 * @author Yan Zhenjie;
 * @deprecated use {@link com.yolanda.nohttp.rest.OnResponseListener} instead.
 */
@Deprecated
public interface OnResponseListener<T> {

    /**
     * When the request starts.
     *
     * @param what the credit of the incoming request is used to distinguish between multiple requests.
     */
    void onStart(int what);

    /**
     * Server correct response to callback when an HTTP request.
     *
     * @param what     the credit of the incoming request is used to distinguish between multiple requests.
     * @param response in response to the results.
     */
    void onSucceed(int what, Response<T> response);

    /**
     * When there was an error correction.
     *
     * @param what          the credit of the incoming request is used to distinguish between multiple requests.
     * @param url           url.
     * @param tag           tag of request callback.
     * @param exception     error types. Error types include the following:<p>{@link com.yolanda.nohttp.error.NetworkError} The network is not available, please check the network.</p>
     *                      <p>{@link com.yolanda.nohttp.error.TimeoutError} Connect to the server or a timeout occurred while reading data.</p>
     *                      <p>{@link com.yolanda.nohttp.error.UnKnownHostError} Is not found in the network of the target server.</p>
     *                      <p>{@link com.yolanda.nohttp.error.URLError} Download url is wrong.</p>
     * @param responseCode  server response code.
     * @param networkMillis request process consumption time.
     */
    void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis);

    /**
     * When the request finish.
     *
     * @param what the credit of the incoming request is used to distinguish between multiple requests.
     */
    void onFinish(int what);

}