import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Pong_Applet extends Applet implements Runnable, MouseListener,
		MouseMotionListener {

	int gameWidth, gameHeight;

	// variables used to store mouse location
	int mouseX, mouseY;

	Thread gameThread;

	// variable used to scale the exit button at the top right of the screen
	// (gameWidth/X)
	final int exitButtonXScale = 60;
	final int exitButtonYScale = 40;
	// true/false depening if user is inside of exit box
	boolean userInExit;

	// relative to screen size
	final int paddleScaleX = 80, paddleScaleY = 10;

	int userPaddleXPosition;
	int enemyPaddleXPosition;

	// enemy paddle position
	double enemyPaddleY;
	final double enemyPaddleVelocity = 10;

	Image dbImage;
	Graphics dbg;

	// Ball variables
	double ballX, ballY;
	double ballXVelocity, ballYVelocity;
	final double ballScale = 140;
	final double ballTotalVelocity = 18;

	long timeSinceLastRound;
	long timePerFrame = 20; // frameRate

	// boolean used to determine whether the game has started or not
	boolean gameStarted;

	// Method called when applet is created ;
	public void init(int gameWidth, int gameHeight) {
		this.gameWidth = gameWidth;
		this.gameHeight = gameHeight;

		userPaddleXPosition = gameWidth / 30;
		enemyPaddleXPosition = gameWidth - gameWidth / 30;

		timeSinceLastRound = 0;

		reset();

		// set Background color
		setBackground(new Color(5, 5, 15));

		setSize(gameWidth, gameHeight);

		addMouseListener(this);
		addMouseMotionListener(this);

		this.start();
		run();
	}

	// method called to reset the game variables
	public void reset() {
		userInExit = false;
		gameStarted = false;

		ballX = gameWidth / 2;
		ballY = gameHeight / 2;

		enemyPaddleY = gameHeight / 2;

		randomizeBallVelocity(-1);
	}

	// method used to display graphics/paint
	public void paint(Graphics g) {

		// drawing map
		g.setColor(new Color(200, 200, 230));
		for (int i = 1; i < 20; i++) {
			g.fillRect(gameWidth / 2 - gameWidth / 400, i * (gameHeight / 20)
					- gameHeight / 80, gameWidth / 200, gameHeight / 40);
		}
		g.fillRect(0, 0, gameWidth - gameWidth / exitButtonXScale - 2,
				gameHeight / 100);
		g.fillRect(0, gameHeight - gameHeight / 100, gameWidth, gameHeight / 80);

		// Drawing the user's paddle
		drawPaddle(g, userPaddleXPosition, mouseY);

		// Draw enemy paddle
		drawPaddle(g, enemyPaddleXPosition, (int) enemyPaddleY);

		// draw the ball!
		g.setColor(new Color(200, 200, 230));
		g.fillRect((int) (ballX - gameWidth / ballScale / 2),
				(int) (ballY - gameWidth / ballScale / 2),
				(int) (gameWidth / ballScale), (int) (gameWidth / ballScale));

		// draw exit in corner
		g.setColor(Color.WHITE);
		g.fillRect(gameWidth - gameWidth / exitButtonXScale, 0, gameWidth
				/ exitButtonXScale, gameHeight / exitButtonYScale);

		if (!userInExit) {
			g.setColor(new Color(230, 20, 20));
			g.fillRect(gameWidth - gameWidth / exitButtonXScale + 2, 2,
					gameWidth / exitButtonXScale - 4, gameHeight
							/ exitButtonYScale - 4);
		}

		if (!gameStarted) {
			g.setColor(new Color(100, 255, 100));
			g.setFont(new Font("Arial", Font.BOLD, gameWidth / 26));
			g.drawString("Click to Start!", gameWidth / 2 - gameWidth / 8,
					gameHeight / 2 + gameHeight / 30);
		}
	}

	// draws a paddle according to given x + y
	public void drawPaddle(Graphics g, int xPos, int yPos) {
		g.setColor(new Color(245, 115, 115));
		g.fillRect(xPos - (gameWidth / paddleScaleX) / 2, yPos
				- (gameHeight / paddleScaleY) / 2, gameWidth / paddleScaleX,
				gameHeight / paddleScaleY);
	}

	// double buffer (so screen doesn't flash)
	public void update(Graphics g) {
		if (dbImage == null) {
			dbImage = createImage(this.getSize().width, this.getSize().height);
			dbg = dbImage.getGraphics();
		}
		dbg.setColor(getBackground());
		dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);
		dbg.setColor(getForeground());
		paint(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}

	public void run() {
		// gameLoop
		while (true) {
			updateMouse();

			if (gameStarted) {
				updateBall();
				updateEnemy();
				checkCollisions();
			}

			repaint();

			// used to reglate fps
			long timeToSleep = timePerFrame
					- (System.currentTimeMillis() - timeSinceLastRound);
			if (0 < timeToSleep) {
				try {
					Thread.sleep(timeToSleep);
				} catch (Exception e) {
				}
			}
			timeSinceLastRound = System.currentTimeMillis();
		}
	}

	public void randomizeBallVelocity(int direction) {// direction is 1 if
														// travel right
		// randomize the ball velocity
		double randomVelocity;
		do {// looped so ball does not have really bad velocities
			randomVelocity = direction * Math.random() * ballTotalVelocity;
		} while (randomVelocity < direction * ballTotalVelocity / 4.0
				+ direction * ballTotalVelocity
				&& randomVelocity > direction * ballTotalVelocity / 4.0);

		ballXVelocity = randomVelocity + direction * 2;
		ballYVelocity = ballTotalVelocity + randomVelocity;
		if (Math.random() * 10 > 5)
			ballYVelocity = -ballYVelocity;
	}

	public void checkCollisions() {
		// boundries
		if (ballX > gameWidth || ballX < 0) {
			reset();
		}

		// user paddle Collisions
		if (ballX < userPaddleXPosition + (gameWidth / paddleScaleX) / 2
				&& ballX > userPaddleXPosition - (gameWidth / paddleScaleX) / 2) {
			if (ballY > mouseY - (gameHeight / paddleScaleY) / 2
					&& ballY < mouseY + (gameHeight / paddleScaleY) / 2) {
				// randomizeBallVelocity(1);

				// calculate distance from center of paddle and adjust new
				// velocities accordingly
				double hitLocation = (mouseY + 0.0) - ballY;
				// calculate the fraction relative to the y concerning the
				// paddle
				ballYVelocity = -ballTotalVelocity
						* ((hitLocation + 0.0) / ((gameHeight / paddleScaleY) / 2));
				ballXVelocity = ballTotalVelocity - ballYVelocity;

				// ensure the velocity isn't too small
				if (Math.abs(ballXVelocity) < ballTotalVelocity / 10) {
					if (ballXVelocity > 0) {
						ballXVelocity += ballTotalVelocity / 8;
						ballYVelocity -= ballTotalVelocity / 8;
					} else {
						ballXVelocity -= ballTotalVelocity / 8;
						ballYVelocity += ballTotalVelocity / 8;
					}
				}
			}
		}

		// enemy paddle Collisions
		if (ballX < enemyPaddleXPosition + (gameWidth / paddleScaleX) / 2
				&& ballX > enemyPaddleXPosition - (gameWidth / paddleScaleX)
						/ 2) {
			if (ballY > enemyPaddleY - (gameHeight / paddleScaleY) / 2
					&& ballY < enemyPaddleY + (gameHeight / paddleScaleY) / 2) {
				// randomizeBallVelocity(-1);

				// calculate distance from center of paddle and adjust new
				// velocities accordingly
				double hitLocation = enemyPaddleY - ballY;
				// calculate the fraction relative to the y concerning the
				// paddle
				ballYVelocity = -ballTotalVelocity
						* ((hitLocation + 0.0) / ((gameHeight / paddleScaleY) / 2));
				ballXVelocity = -(ballTotalVelocity - ballYVelocity);

				// ensure the velocity isn't too small
				if (Math.abs(ballXVelocity) < ballTotalVelocity / 10) {
					if (ballXVelocity > 0) {
						ballXVelocity += ballTotalVelocity / 8;
						ballYVelocity -= ballTotalVelocity / 8;
					} else {
						ballXVelocity -= ballTotalVelocity / 8;
						ballYVelocity += ballTotalVelocity / 8;
					}
				}
			}
		}
	}

	public void updateEnemy() {
		if (ballY > enemyPaddleY + enemyPaddleVelocity) {
			enemyPaddleY += enemyPaddleVelocity;
		} else if (ballY < enemyPaddleY - enemyPaddleVelocity) {
			enemyPaddleY -= enemyPaddleVelocity;
		}
	}

	// update the ball position
	public void updateBall() {
		ballX += ballXVelocity;
		ballY += ballYVelocity;

		// bottom screen collide
		if (ballY + ballYVelocity < 0)
			ballYVelocity = -ballYVelocity;

		// top screen collide
		if (ballY + ballYVelocity > gameHeight)
			ballYVelocity = -ballYVelocity;
	}

	// checks mouse collisions
	public void updateMouse() {
		if (mouseX > gameWidth - gameWidth / exitButtonXScale
				&& mouseY < gameHeight / exitButtonYScale) {
			userInExit = true;
		} else if (userInExit) {
			userInExit = false;
		}

	}

	public void mouseReleased(MouseEvent e) {
		if (!gameStarted) {
			gameStarted = true;
		}

		// user has clicked exit
		if (userInExit) {
			log("Goodbye!");
			System.exit(0);
		}
	}

	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	// used to write strings to the console so I don't have to type out
	// System.out.println every time
	public void log(String toOutput) {
		System.out.println(toOutput);
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

}