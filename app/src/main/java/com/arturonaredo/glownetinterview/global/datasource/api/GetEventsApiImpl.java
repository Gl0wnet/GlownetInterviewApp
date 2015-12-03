/*
 * Copyright (C) 2015 Glownet.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.arturonaredo.glownetinterview.global.datasource.api;

import com.arturonaredo.glownetinterview.global.datasource.GetEvents;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class GetEventsApiImpl extends GetEvents implements Callback<GetEventsResponse> {
    private static final String ENDPOINT = "http://demo.glownet.com/app/events/events.json";


    public GetEventsApiImpl() {
    }


    @Override
    public void success(GetEventsResponse getEventsResponse, Response response) {

    }

    @Override
    public void failure(RetrofitError error) {

    }

    @Override
    public void getEvents() {

    }
}
