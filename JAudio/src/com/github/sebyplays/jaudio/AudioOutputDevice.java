package com.github.sebyplays.jaudio;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class AudioOutputDevice {

    @Getter private SourceDataLine sourceDataLine;
    @Getter private AudioFormat audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, false);
    @Setter private byte[] buffer;

    @SneakyThrows
    public AudioOutputDevice(){
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
        sourceDataLine.open();
        sourceDataLine.start();
    }

    public void writeData(int dataStream){
        this.sourceDataLine.write(buffer, 0, dataStream);
    }

    public void stop(){
        sourceDataLine.stop();
    }


}
