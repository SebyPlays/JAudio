package com.github.sebyplays.jaudio;

import lombok.Getter;

public class JAudioInterface {

    @Getter private AudioInputDevice audioInputDevice;
    @Getter private AudioOutputDevice audioOutputDevice;

    public JAudioInterface(){
        this.audioInputDevice = new AudioInputDevice();
        this.audioOutputDevice = new AudioOutputDevice();
        this.audioOutputDevice.setBuffer(this.audioInputDevice.getData());
    }

    public JAudioInterface(AudioOutputDevice audioOutputDevice, AudioInputDevice audioInputDevice){
        this.audioInputDevice = new AudioInputDevice();
        this.audioOutputDevice = new AudioOutputDevice();
        this.audioOutputDevice.setBuffer(this.audioInputDevice.getData());
    }

}
