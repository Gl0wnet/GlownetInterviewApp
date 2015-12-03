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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.arturonaredo.glownetinterview.R;
import com.arturonaredo.glownetinterview.global.model.Event;
import com.pedrogomez.renderers.Renderer;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventRenderer extends Renderer<Event> {
    protected Context mContext;
    protected OnEventClicked listener = new EmptyOnEventClicked();

    public EventRenderer(Context ctx, OnEventClicked onEventClicked) {
        mContext = ctx.getApplicationContext();
        setListener(onEventClicked);
    }

    // TODO Inject views


    public interface OnEventClicked {
        public void onBackgroundClicked(Event event);
    }

    protected void setListener(OnEventClicked listener) {
        if(listener != null)
            this.listener = listener;
    }

    @Override
    protected void setUpView(View rootView) {
        ButterKnife.inject(this, rootView);
    }

    @Override
    protected void hookListeners(View rootView) {

    }

    @OnClick(R.id.event_container)
    public void onClickRow(RelativeLayout root){
        listener.onBackgroundClicked(getContent());
    }

    @Override
    protected View inflate(LayoutInflater inflater, ViewGroup parent) {
        return inflater.inflate(R.layout.row_event, parent, false);
    }

    @Override
    public void render() {
        Event u = getContent();
        renderTitle(u);
        renderDescription(u);
        renderClicks(u);
    }

    private void renderDescription(Event event) {

    }

    private void renderTitle(Event event) {

    }

    private void renderClicks(Event event) {

    }

    private class EmptyOnEventClicked implements OnEventClicked {
        public void onPictureClicked(Event event) { }
        public void onBackgroundClicked(Event event) { }
    }
}