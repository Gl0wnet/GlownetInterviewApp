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
package com.arturonaredo.glownetinterview.ui.presenter.impl;

import android.content.Context;

import com.arturonaredo.glownetinterview.global.DaggerApplication;
import com.arturonaredo.glownetinterview.global.datasource.GetEvents;
import com.arturonaredo.glownetinterview.global.model.Event;
import com.arturonaredo.glownetinterview.ui.presenter.EventListPresenter;

import java.util.List;

public class EventListPresenterImpl extends EventListPresenter implements GetEvents.Listener {
    protected Context mContext;

    public EventListPresenterImpl(Context ctx){
        mContext = ctx;

        ((DaggerApplication)ctx.getApplicationContext())
                .getComponent().inject(this); // This line provides injected fields declared in EventListPresenter.java
    }

    @Override
    public void initialize() {
        interactor.getEvents(this);
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }


    @Override
    public void onEventListReceived(List<Event> events) {

    }

    @Override
    public void onEventListError(Exception e) {

    }

    @Override
    public void onNoInternetAvailable() {

    }
}
