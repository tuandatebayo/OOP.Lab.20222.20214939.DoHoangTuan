package hust.soict.dsai.aims.media;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {
	private String title;
	private int length;
	
	public String getTitle() {
		return title;							
	}

	public int getLength() {
		return length;
	}

	public Track(String title, int length) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.length = length;
	}
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("p");
		} else {
			System.err.println("The track has negative length!");
			PlayerException e = new PlayerException("ERROR: DVD length is non-positive!");
			JDialog d = new JDialog();
            d.setLayout(new FlowLayout());
            d.setTitle("The track has negative length!");
            JLabel info = new JLabel(this.toString());
            d.add(info);
            JLabel m = new JLabel(e.getMessage());
            d.add(m);
            StringBuilder sb = new StringBuilder();
            for (StackTraceElement element : e.getStackTrace()) {
                sb.append(element.toString()).append("\n");
            }
            JLabel st = new JLabel(sb.toString());
            d.add(st);
            JButton b = new JButton("OK");  
            b.addActionListener (new ActionListener(){
                public void actionPerformed(ActionEvent e)  
                {  
                    d.dispose();  
                }  
            });
            d.add(b);   
            d.setSize(100, 100);
            d.setVisible(true);
            throw e;
		}
	}

	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }

	    if (!(obj instanceof Track)) {
	        return false;
	    }

	    Track other = (Track) obj;
	    return title.equals(other.title) && length == other.length;
	}

}
