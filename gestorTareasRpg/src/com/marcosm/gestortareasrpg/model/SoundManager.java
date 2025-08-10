package com.marcosm.gestortareasrpg.model;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundManager {

	Clip clip;
	URL[] urlSounds = new URL[30];

	public SoundManager() {

		urlSounds[0] = getClass().getResource("/sonidos/key_sound.wav");

	}

	public void uploadFile(int i) {

		try {

			AudioInputStream ais = AudioSystem.getAudioInputStream(urlSounds[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void play() {

		clip.start();

	}

	public void repeat() {

		clip.loop(Clip.LOOP_CONTINUOUSLY);

	}

	public void stop() {

		clip.stop();

	}

}