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
package com.arturonaredo.glownetinterview.ui.renderer;

import android.content.Context;

import com.arturonaredo.glownetinterview.global.model.Event;
import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class EventRendererBuilder extends RendererBuilder<Event> {

    public EventRendererBuilder(Context context, EventRenderer.OnEventClicked onEventClicked) {
        Collection<Renderer<Event>> prototypes = getPrototypes(context, onEventClicked);
        setPrototypes(prototypes);
    }

    @Override
    protected Class getPrototypeClass(Event content) {
        return EventRenderer.class;
    }

    private List<Renderer<Event>> getPrototypes(Context context, EventRenderer.OnEventClicked onEventClicked) {
        List<Renderer<Event>> prototypes = new LinkedList<Renderer<Event>>();

        EventRenderer eventRenderer = new EventRenderer(context, onEventClicked);
        prototypes.add(eventRenderer);

        return prototypes;
    }
}