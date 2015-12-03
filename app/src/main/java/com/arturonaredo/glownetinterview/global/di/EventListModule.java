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
package com.arturonaredo.glownetinterview.global.di;

import android.content.Context;
import android.view.LayoutInflater;

import com.arturonaredo.glownetinterview.global.model.Event;
import com.arturonaredo.glownetinterview.ui.presenter.EventListPresenter;
import com.arturonaredo.glownetinterview.ui.presenter.impl.EventListPresenterImpl;
import com.arturonaredo.glownetinterview.ui.renderer.EventRenderer;
import com.arturonaredo.glownetinterview.ui.renderer.EventRendererBuilder;
import com.pedrogomez.renderers.ListAdapteeCollection;
import com.pedrogomez.renderers.RendererAdapter;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class EventListModule {

    RendererAdapter<Event> adapter;
    private final Context mContext;

    public EventListModule(final Context context, final EventRenderer.OnEventClicked listener) {
        mContext = context;
        adapter = new RendererAdapter<Event>(
                LayoutInflater.from(context),
                new EventRendererBuilder(context, listener),
                new ListAdapteeCollection<Event>(new ArrayList<Event>())
        );
    }

    @Provides
    EventListPresenter provideUserListPresenter(){
        return new EventListPresenterImpl(mContext);
    }

    @Provides
    RendererAdapter<Event> provideUserAdapter(){
        return adapter;
    }
}
