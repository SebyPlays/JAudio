package com.github.sebyplays.jaudio.api;

import com.github.sebyplays.jaudio.JAudioInterface;

public class JAudio {

    private JAudioInterface jAudioInterface;

    public JAudio(JAudioInterface jAudioInterface){
        this.jAudioInterface = jAudioInterface;
    }

    private void inputMonitoring() {
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    jAudioInterface.getAudioOutputDevice().writeData(jAudioInterface.getAudioInputDevice().getStream());
                }
            }
        }.start();
    }
}
