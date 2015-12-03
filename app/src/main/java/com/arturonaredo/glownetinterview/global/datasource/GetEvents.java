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
package com.arturonaredo.glownetinterview.global.datasource;

import com.arturonaredo.glownetinterview.global.model.Event;

import java.util.List;

public abstract class GetEvents {
    public void getEvents(final Listener listener){
        setListener(listener);
        getEvents();
    }

    public abstract void getEvents();

    protected Listener listener = new NullListener();

    protected void setListener(Listener listener) {
        if(listener != null)
            this.listener = listener;
    }

    public interface Listener{
        public void onEventListReceived(List<Event> events);
        public void onEventListError(Exception e);
        public void onNoInternetAvailable();
    }

    private class NullListener implements Listener{
        public void onEventListReceived(List<Event> events) { }
        public void onEventListError(Exception e) { }
        public void onNoInternetAvailable() { }
    }
}
