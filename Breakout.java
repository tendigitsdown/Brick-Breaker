/*
 * File: Breakout.java
 * -------------------
 * Name:Sachin Goel
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = HEIGHT - 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;
	
/** Mouse X-Coord */
	public static double mouseX;
	
/** Paddle Object & Ball Object */
	public GRect paddle;
	public GOval ball;
	
/** Animation Steps */
 	private static final int N_STEPS = 1000;
/** Pause Time */
 	private static final int PAUSE_TIME = 20;
 	

/** Velocity Variables */
 	private double vx, vy;
 	
/** Random Number Generator */
 	private RandomGenerator rgen = RandomGenerator.getInstance();

/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
		setupGame();
		addMouseListeners();
		playGame();
	}
	
	// This method sets up the game by drawing all of the bricks on to the board
	private void setupGame() {
		addBricks();
		placePaddle();
		placeBall();
	}
	
	// This method starts the game

	private void playGame() {;
	}
	
	// Initial Ball Drop
	public void mouseClicked(MouseEvent e) {
		vy = 3.0;
		vx = rgen.nextDouble(1.0, 3.0);
		if (rgen.nextBoolean(0.5)) vx = -vx;
		ball.move(vx, vy);
	}
	
	// This method initializes the ball in the center of the screen
	
	private void placeBall() {
		ball = new GOval((WIDTH / 2) - BALL_RADIUS, (HEIGHT / 2) - BALL_RADIUS, 2 * BALL_RADIUS, 2 * BALL_RADIUS);
		ball.setFilled(true);
		add(ball);
	}
	
	// This method determines the movement of the paddle when the mouse is moved
	public void mouseMoved(MouseEvent e) {
		double dx = (e.getX() - paddle.getX());
		if (e.getX() > paddle.getX()) {
			paddle.move(dx, 0);
		}
		else if (e.getX() < paddle.getX()) {
			paddle.move(dx, 0);
		}
	}
	
	// Adds 10 rows of bricks to game screen
	private void addBricks() {
		newRow(Color.RED, BRICK_Y_OFFSET);
		newRow(Color.RED, BRICK_Y_OFFSET + 1 * (BRICK_HEIGHT + BRICK_SEP));
		newRow(Color.RED, BRICK_Y_OFFSET + 2 * (BRICK_HEIGHT + BRICK_SEP));
		newRow(Color.RED, BRICK_Y_OFFSET + 3 * (BRICK_HEIGHT + BRICK_SEP));
		newRow(Color.RED, BRICK_Y_OFFSET + 4 * (BRICK_HEIGHT + BRICK_SEP));
		newRow(Color.WHITE, BRICK_Y_OFFSET + 5 * (BRICK_HEIGHT + BRICK_SEP));
		newRow(Color.BLUE, BRICK_Y_OFFSET + 6 * (BRICK_HEIGHT + BRICK_SEP));
		newRow(Color.BLUE, BRICK_Y_OFFSET + 7 * (BRICK_HEIGHT + BRICK_SEP));
		newRow(Color.BLUE, BRICK_Y_OFFSET + 8 * (BRICK_HEIGHT + BRICK_SEP));
		newRow(Color.BLUE, BRICK_Y_OFFSET + 9 * (BRICK_HEIGHT + BRICK_SEP));	
	}
	
	
	// Creates a new row of bricks
	public void newRow(Color color, int rowHeight){
		for (int i = 0; i < NBRICKS_PER_ROW; i++) {
			int x = BRICK_SEP + (i * (BRICK_SEP + BRICK_WIDTH));
			GRect brick = new GRect(x, rowHeight, BRICK_WIDTH, BRICK_HEIGHT);
			brick.setFilled(true);
			brick.setFillColor(color);
			add(brick);
		}
		
	}
	
	// Draws paddle to the screen
	private void placePaddle() {
		paddle = new GRect((WIDTH / 2) - (PADDLE_WIDTH / 2), PADDLE_Y_OFFSET, PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFilled(true);
		add(paddle);
	}
}
