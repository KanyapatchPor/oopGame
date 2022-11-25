import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.net.URL;

public class devile {
	Image img;
	Image d1;
	public int x = (int) ((Math.random() + 1000));
	public int y = 350;
	public int count = 0;
	int w = 70;
	int h = 60;

	devile() {
		String imageLocation = "d4.png";
		URL imageURL = this.getClass().getResource(imageLocation);
		img = Toolkit.getDefaultToolkit().getImage(imageURL);

		de.start();
	}

	devile(int x, int y) {
		this.x = x;
		this.y = y;
		String image = "d4.png";
		URL imageUR = this.getClass().getResource(image);
		d1 = Toolkit.getDefaultToolkit().getImage(imageUR);
	}

	Thread de = new Thread(new Runnable() {
		public void run() {
			while (true) {
				x -= 5;
				if (x >= 1000) {
					img = null;
					de = null;
					x = (int) ((Math.random() + 1000));
					;
					y = -10;
				}
				try {
					de.sleep(20);
				} catch (InterruptedException e) {
				}
			}
		}
	});

	public Image getImage() {
		return img;
	}

	public Image getImageDead() {
		return d1;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Rectangle2D getbound() {
		return (new Rectangle2D.Double(x, y, w, h));
	}

}