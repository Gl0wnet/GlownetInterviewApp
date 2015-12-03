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
package com.arturonaredo.glownetinterview.ui.activity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.arturonaredo.glownetinterview.R;
import com.arturonaredo.glownetinterview.global.DaggerApplication;
import com.arturonaredo.glownetinterview.global.di.DaggerEventListComponent;
import com.arturonaredo.glownetinterview.global.di.EventListComponent;
import com.arturonaredo.glownetinterview.global.di.EventListModule;
import com.arturonaredo.glownetinterview.global.model.Event;
import com.arturonaredo.glownetinterview.ui.presenter.EventListPresenter;
import com.arturonaredo.glownetinterview.ui.renderer.EventRenderer;
import com.pedrogomez.renderers.RendererAdapter;

import javax.inject.Inject;

import butterknife.InjectView;

public class EventListActivity extends BaseActivity implements EventListPresenter.View{

    @InjectView(R.id.event_list)
    ListView listView;

    @InjectView(R.id.events_progressBar)
    ProgressBar progressBar;

    @Inject
    RendererAdapter<Event> adapter;

    @Inject
    EventListPresenter presenter;

    private EventListComponent component;

    final EventRenderer.OnEventClicked mEventsClickListener = new EventRenderer.OnEventClicked() {
        @Override
        public void onBackgroundClicked(Event event) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        component().inject(this);

        presenter.setView(this);
        presenter.initialize();

        listView.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_events_list;
    }




    private EventListComponent component(){
        if(component == null){
            component = DaggerEventListComponent.builder()
                    .rootComponent(((DaggerApplication)getApplication()).getComponent())
                    .eventListModule(new EventListModule(getApplicationContext(), mEventsClickListener))
                    .build();
        }
        return component;
    }
}
