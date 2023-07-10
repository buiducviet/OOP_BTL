package model;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountDownLabel extends JLabel{
	Timer timer;
	public int hours;
	 private int minutes = 0;
     private int seconds = 0;
    public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public CountDownLabel() { 	   
        setFont(new Font("Arial", Font.PLAIN, 17));

        timer = new Timer(1000, new TimerActionListener());
        timer.start();
    }
    public void stop() {
    	 setText("0:00:00");
    	 timer.stop();
    }
    public Timer getTimer() {
		return timer;
	}
	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	private class TimerActionListener implements ActionListener {
        
       

        @Override
        public void actionPerformed(ActionEvent e) {
            if (hours == 0 && minutes == 00 && seconds == 0) {
                ((Timer) e.getSource()).stop();
            } else {
                seconds--;
                if (seconds < 0) {
                    seconds = 59;
                    minutes--;
                    if (minutes < 0) {
                        minutes = 59;
                        hours--;
                    }
                }
                String timeString = String.format("%d:%02d:%02d", hours, minutes, seconds);
                setText(timeString);
            }
        }
    }
}

