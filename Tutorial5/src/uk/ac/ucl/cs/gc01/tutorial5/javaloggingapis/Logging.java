package uk.ac.ucl.cs.gc01.tutorial5.javaloggingapis;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Purpose: Create a virtual chessboard for two human players
 *
 * Description: Displays a chessboard and allows for the basic moves of chess to
 * be followed.
 *
 * @author Nick
 *
 * @version Date: 9 Oct 2015 18:05:02
 */

public class Logging {
	private final static Logger LOGGER = Logger.getLogger(Logging.class.getName());
    
	public enum Chessmen {
		WHITE_KING, WHITE_QUEEN, WHITE_ROOK, WHITE_BISHOP, WHITE_KNIGHT, WHITE_PAWN, BLACK_KING, BLACK_QUEEN, BLACK_ROOK, BLACK_BISHOP, BLACK_KNIGHT, BLACK_PAWN, EMPTY
	}

	public static void main(String[] args) {
		LOGGER.setLevel(Level.ALL);
		Handler handler = new ConsoleHandler();
		handler.setLevel(Level.ALL);
		LOGGER.setUseParentHandlers(false);
		LOGGER.addHandler(handler);
		Chessmen[][] chessboard = new Chessmen[8][8];
		// create an 8x8 array
		// below is a nested for loop to place the chess pieces in the correct
		// positions
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 0) {
					if (j == 0 || j == 7) {
						chessboard[i][j] = Chessmen.BLACK_ROOK;
					} else if (j == 1 || j == 6) {
						chessboard[i][j] = Chessmen.BLACK_KNIGHT;
					} else if (j == 2 || j == 5) {
						chessboard[i][j] = Chessmen.BLACK_BISHOP;
					} else if (j == 3) {
						chessboard[i][j] = Chessmen.BLACK_QUEEN;
					} else if (j == 4) {
						chessboard[i][j] = Chessmen.BLACK_KING;
					}
				} else if (i == 7) {
					if (j == 0 || j == 7) {
						chessboard[i][j] = Chessmen.WHITE_ROOK;
					} else if (j == 1 || j == 6) {
						chessboard[i][j] = Chessmen.WHITE_KNIGHT;
					} else if (j == 2 || j == 5) {
						chessboard[i][j] = Chessmen.WHITE_BISHOP;
					} else if (j == 3) {
						chessboard[i][j] = Chessmen.WHITE_QUEEN;
					} else if (j == 4) {
						chessboard[i][j] = Chessmen.WHITE_KING;
					}
				} else if (i == 1) {
					chessboard[i][j] = Chessmen.BLACK_PAWN;
				} else if (i == 6) {
					chessboard[i][j] = Chessmen.WHITE_PAWN;
				} else {
					chessboard[i][j] = Chessmen.EMPTY;
				}
			}
		}
		// loop finishes.
		Scanner scanner = new Scanner(System.in);
		// testing
		// chessboard[2][6]=Chessmen.WHITE_BISHOP
		// System.out.println(isValid(chessboard, 1, 7, 2, 6));
		// System.out.println(isValid(chessboard, 0, 6, 2, 5));
		printBoard(chessboard);
		while (true) {
			System.out.println("Enter your move in the form: e.g. 'e1 to e5'");
			String input = scanner.nextLine();
			if (input.equalsIgnoreCase("exit")) {
				LOGGER.severe("Game exited");
				scanner.close();
				break;
			} else {
				while (input.length() != 8) {
					break;
					// this stops any input from being any different from the
					// required 8 characters in the string.
					// nb it does not stop an incorrect selection of 8
					// characters though.
				}
				move(chessboard, input);
				printBoard(chessboard);
			}
		}
	}

	public static void printBoard(Chessmen[][] chessboard) {
		System.out.println("\t a \t b \t c \t d \t e \t f \t g \t h");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (j == 0) {
					System.out.print((i + 1) + ".\t");
				}
				switch (chessboard[i][j]) {
				case BLACK_ROOK:
					System.out.print("\u265C \t");
					break;
				case BLACK_KNIGHT:
					System.out.print("\u265E \t");
					break;
				case BLACK_BISHOP:
					System.out.print("\u265D \t");
					break;
				case BLACK_KING:
					System.out.print("\u265A \t");
					break;
				case BLACK_QUEEN:
					System.out.print("\u265B \t");
					break;
				case WHITE_BISHOP:
					System.out.print("\u2657 \t");
					break;
				case WHITE_QUEEN:
					System.out.print("\u2655 \t");
					break;
				case WHITE_ROOK:
					System.out.print("\u2656 \t");
					break;
				case WHITE_KNIGHT:
					System.out.print("\u2658 \t");
					break;
				case WHITE_KING:
					System.out.print("\u2654 \t");
					break;
				case WHITE_PAWN:
					System.out.print("\u2659 \t");
					break;
				case BLACK_PAWN:
					System.out.print("\u265F \t");
					break;
				case EMPTY:
					System.out.print("\t");
					break;
				}
			}
			System.out.println();
		}
	}

	public static void move(Chessmen[][] chessboard, String move) {
		String[] components = move.split(" ");
		Character[] numbers = new Character[] { '1', '2', '3', '4', '5', '6', '7', '8' };
		Character[] letters = new Character[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
		int oldJ = 0;
		int newJ = 0;
		switch (components[0].charAt(0)) {
		case 'a':
			oldJ = 0;
			break;
		case 'b':
			oldJ = 1;
			break;
		case 'c':
			oldJ = 2;
			break;
		case 'd':
			oldJ = 3;
			break;
		case 'e':
			oldJ = 4;
			break;
		case 'f':
			oldJ = 5;
			break;
		case 'g':
			oldJ = 6;
			break;
		case 'h':
			oldJ = 7;
			break;
		default:
			LOGGER.warning("Invalid selection, please try again");
		}
		// will only enter below if statement, if the first character is within
		// the threshold a-h, preventing multiple error messages.
		try {
			if (Arrays.asList(letters).contains(components[0].charAt(0))
					&& Arrays.asList(numbers).contains(components[0].charAt(1))) {
				switch (components[2].charAt(0)) {
				case 'a':
					newJ = 0;
					break;
				case 'b':
					newJ = 1;
					break;
				case 'c':
					newJ = 2;
					break;
				case 'd':
					newJ = 3;
					break;
				case 'e':
					newJ = 4;
					break;
				case 'f':
					newJ = 5;
					break;
				case 'g':
					newJ = 6;
					break;
				case 'h':
					newJ = 7;
					break;
				default:
					LOGGER.warning( "Invalid selection, please try again");
				}
			} else {
			}
			if ((Arrays.asList(letters).contains(components[0].charAt(0))
					&& Arrays.asList(numbers).contains(components[0].charAt(1))
					&& Arrays.asList(letters).contains(components[2].charAt(0)))) {
				if (Arrays.asList(numbers).contains(components[2].charAt(1))
						&& Arrays.asList(numbers).contains(components[0].charAt(1))
						&& (isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1, oldJ,
								Integer.parseInt(String.valueOf(components[2].charAt(1))) - 1, newJ)) == true) {
					chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
							- 1][newJ] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1)))
									- 1][oldJ];
					chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][oldJ] = Chessmen.EMPTY;
				} else {
					LOGGER.warning( "Invalid selection, please try again");
				}
			}
			else{
				LOGGER.warning("Invalid selection, please try again");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			LOGGER.fine(e.toString());
		}
	}

	/**
	 * Returns a boolean true if the move is valid, false otherwise.
	 *
	 * @param chessboard - virtual chessboard
	 * @param oldI - the old row entry of value 0-7
	 * @param oldJ - the old column entry of value 0-7
	 * @param newI - the new row entry of value 0-7
	 * @param newJ - the new row entry of value 0-7
	 * @return - returns true or false if the method is valid
	 **/
	public static Boolean isValid(Chessmen[][] chessboard, int oldI, int oldJ, int newI, int newJ) {
		Chessmen[] whitePieces = new Chessmen[] { Chessmen.WHITE_KING, Chessmen.WHITE_QUEEN, Chessmen.WHITE_ROOK,
				Chessmen.WHITE_BISHOP, Chessmen.WHITE_KNIGHT, Chessmen.WHITE_PAWN};
		Chessmen[] blackPieces = new Chessmen[] { Chessmen.BLACK_KING, Chessmen.BLACK_QUEEN, Chessmen.BLACK_ROOK,
				Chessmen.BLACK_BISHOP, Chessmen.BLACK_KNIGHT, Chessmen.BLACK_PAWN};
		
		// create two arrays of pieces, one for each player - to check whether
		// the space can be taken by the player or not.
		if (chessboard[oldI][oldJ] == Chessmen.BLACK_PAWN) {
			// checks whether the new position contains a white piece or is
			// empty - if so the move is possible
			if ((chessboard[newI][newJ] == Chessmen.EMPTY)
					&& (((newI - oldI == 1) || ((oldI == 1) && (newI == 3) && chessboard[newI][newJ] == Chessmen.EMPTY
							&& chessboard[2][newJ] == Chessmen.EMPTY)) && (newJ == oldJ))
					|| ((Arrays.asList(whitePieces).contains(chessboard[newI][newJ]) && Distance(oldI, newI) == 1
							&& Distance(oldJ, newJ) == 1)
							// above line allows for either the one
							// vertical move down or if the pawn has not
							// yet moved it can move 2 places
							// provided that the place is empty!
					&& ((newJ < 8) && (newI < 8) && (newI > -1) && (newJ > -1))))
			// above line ensures that the pieces remain on the grid.
			{
				return true;

			}
		} else if (chessboard[oldI][oldJ] == Chessmen.BLACK_ROOK) {
			if ((Arrays.asList(whitePieces).contains(chessboard[newI][newJ])||chessboard[newI][newJ] == Chessmen.EMPTY) && ((newJ == oldJ) || (newI == oldI))
					&& ((newJ < 8) && (newI < 8) && (newI > -1) && (newJ > -1))) {
				return true;
			}
		} else if (chessboard[oldI][oldJ] == Chessmen.BLACK_KING) {
			if ((Arrays.asList(whitePieces).contains(chessboard[newI][newJ])||chessboard[newI][newJ] == Chessmen.EMPTY)
					&& (((Distance(oldI, newI) == 1) && (newJ == oldJ))
							|| ((newI == oldI) && (Distance(newJ, oldJ) == 1))
							|| ((Distance(oldI, newI) == 1) && (Distance(oldJ, newJ) == 1)))
					&& ((newJ < 8) && (newI < 8) && (newI > -1) && (newJ > -1))) {
				return true;
			}
		} else if (chessboard[oldI][oldJ] == Chessmen.BLACK_QUEEN) {
			if ((Arrays.asList(whitePieces).contains(chessboard[newI][newJ])||chessboard[newI][newJ] == Chessmen.EMPTY)
					&& (((newJ == oldJ)) || ((newI == oldI)) || (Distance(oldI, newI) == Distance(oldJ, newJ)))
					&& ((newJ < 8) && (newI < 8) && (newI > -1) && (newJ > -1))) {
				return true;
			}

		} else if (chessboard[oldI][oldJ] == Chessmen.BLACK_BISHOP) {
			if ((Arrays.asList(whitePieces).contains(chessboard[newI][newJ])||chessboard[newI][newJ] == Chessmen.EMPTY)
					&& (Distance(oldI, newI) == Distance(oldJ, newJ))
					&& ((newJ < 8) && (newI < 8) && (newI > -1) && (newJ > -1))) {
				return true;
			}

		} else if (chessboard[oldI][oldJ] == Chessmen.BLACK_KNIGHT) {
			if ((Arrays.asList(whitePieces).contains(chessboard[newI][newJ])||chessboard[newI][newJ] == Chessmen.EMPTY)
					&& (((Distance(oldI, newI) == 2) && Distance(oldJ, newJ) == 1)
							|| (Distance(oldJ, newJ) == 2 && Distance(oldI, newI) == 1))
					&& ((newJ < 8) && (newI < 8) && (newI > -1) && (newJ > -1))) {
				return true;
			}

		} else if (chessboard[oldI][oldJ] == Chessmen.WHITE_KNIGHT) {
			if ((Arrays.asList(blackPieces).contains(chessboard[newI][newJ])||chessboard[newI][newJ] == Chessmen.EMPTY)
					&& (((Distance(oldI, newI) == 2) && Distance(oldJ, newJ) == 1)
							|| (Distance(oldJ, newJ) == 2 && Distance(oldI, newI) == 1))
					&& ((newJ < 8) && (newI < 8) && (newI > -1) && (newJ > -1))) {
				return true;
			}

		} else if (chessboard[oldI][oldJ] == Chessmen.WHITE_BISHOP) {
			if ((Arrays.asList(blackPieces).contains(chessboard[newI][newJ])||chessboard[newI][newJ] == Chessmen.EMPTY)
					&& (Distance(oldI, newI) == Distance(oldJ, newJ))
					&& ((newJ < 8) && (newI < 8) && (newI > -1) && (newJ > -1))) {
				return true;
			}

		} else if (chessboard[oldI][oldJ] == Chessmen.WHITE_QUEEN) {
			if ((Arrays.asList(blackPieces).contains(chessboard[newI][newJ])||chessboard[newI][newJ] == Chessmen.EMPTY)
					&& (((newJ == oldJ)) || ((newI == oldI)) || (Distance(oldI, newI) == Distance(oldJ, newJ)))
					&& ((newJ < 8) && (newI < 8) && (newI > -1) && (newJ > -1))) {
				return true;
			}

		} else if (chessboard[oldI][oldJ] == Chessmen.WHITE_KING) {
			if ((Arrays.asList(blackPieces).contains(chessboard[newI][newJ])||chessboard[newI][newJ] == Chessmen.EMPTY)
					&& (((Distance(oldI, newI) == 1) && (newJ == oldJ))
							|| ((newI == oldI) && (Distance(newJ, oldJ) == 1))
							|| ((Distance(oldI, newI) == 1) && (Distance(oldJ, newJ) == 1)))
					&& ((newJ < 8) && (newI < 8) && (newI > -1) && (newJ > -1))) {
				return true;
			}
		} else if (chessboard[oldI][oldJ] == Chessmen.WHITE_ROOK) {
			if ((Arrays.asList(blackPieces).contains(chessboard[newI][newJ])||chessboard[newI][newJ] == Chessmen.EMPTY)
					&& ((newJ - oldJ == 0) || (newI - oldI == 0))
					&& ((newJ < 8) && (newI < 8) && (newI > -1) && (newJ > -1))) {
				return true;
			}
		} else if (chessboard[oldI][oldJ] == Chessmen.WHITE_PAWN) {
			if ((chessboard[newI][newJ] == Chessmen.EMPTY)
					// can only move if it takes a white piece or if the space
					// is empty
					&& (((newI - oldI == -1) || ((oldI == 6) && (newI == 4) && chessboard[newI][newJ] == Chessmen.EMPTY
							&& chessboard[5][newJ] == Chessmen.EMPTY)) && (newJ == oldJ))
							|| ((Arrays.asList(blackPieces).contains(chessboard[newI][newJ])
									&& Distance(oldI, newI) == 1 && Distance(oldJ, newJ) == 1)
									// above line allows for either the one
									// vertical move down or if the pawn has not
									// yet moved it can move 2 places
									// provided that the place is empty!
									&& ((newJ < 8) && (newI < 8) && (newI > -1) && (newJ > -1))))
			// above line ensures that the pieces remain on the grid.
			{
				return true;

			}
		}
		return false;
	}

	/**
	 * Returns the absolute distance between two integer values.
	 * @param a - value of the first number
	 * @param b - value of the second number
	 * @return - returns the double which is the value of the distance between 2 points 
	 **/
	public static double Distance(int a, int b) {
		double value = 0;
		value = Math.sqrt(Math.pow(b - a, 2));
		return value;
	}
}