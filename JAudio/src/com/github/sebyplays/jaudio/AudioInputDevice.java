package com.github.sebyplays.jaudio;

import lombok.Getter;
import lombok.SneakyThrows;

import javax.sound.sampled.*;
import java.util.ArrayList;

public class AudioInputDevice {
    @Getter private AudioFormat audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, false);
    @Getter private TargetDataLine targetDataLine;
    @Getter private byte[] data;
    public ArrayList<AudioInputDevice> audioInputDevices = new ArrayList<>();

    @SneakyThrows
    public AudioInputDevice() {
        DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);
        targetDataLine = (TargetDataLine) AudioSystem.getLine(info);
        targetDataLine.open();
        data = new byte[targetDataLine.getBufferSize() / 5];
        targetDataLine.start();
    }

    @SneakyThrows
    public int getStream(){
        return targetDataLine.read(data, 0, data.length);
    }

    public void stop(){
        targetDataLine.stop();
    }

}
