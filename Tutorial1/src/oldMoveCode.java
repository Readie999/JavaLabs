/* import java.util.Arrays;

import Question5.Chessmen;

// parse move string into components
		String[] components = move.split(" ");
		Character[] numbers = new Character[]{'1', '2', '3', '4', '5', '6', '7', '8'};
		switch (components[0].charAt(0)) {
		case 'a':
			// Since char.At(1) gives a char value must use the following to
			// convert it into a string
			// and then convert it into an integer using Integer.ParseInt - this
			// therefore allows the number to be used directly
			// nb subtract 1 since the labelled chessboard starts from 1 but the
			// count starts from chessboard[0][0]

			if (Arrays.asList(numbers).contains(components[0].charAt(1))){ 
				//the above line checks whether the character inputted is contained in the char array numbers - returns true if so.
				if (components[2].charAt(0) == 'a') {
					if (Arrays.asList(numbers).contains(components[2].charAt(1))&& 
							(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 0, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 0))==true ) {
						// the below line moves the piece to the selected
						// position, the second line makes the previous position
						// empty.
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][0] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][0];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][0] = Chessmen.EMPTY;
					} else {
						System.err.print("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'b') {
					if (Arrays.asList(numbers).contains(components[2].charAt(1))&&
							(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 0, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 1))==true ) 
					// note have to subtract one due to the numering issue in java
				{
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][1] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][0];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][0] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'c') {
					if (Arrays.asList(numbers).contains(components[2].charAt(1))&& (isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 0, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 2))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][2] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][0];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][0] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'd') {
					if (Arrays.asList(numbers).contains(components[2].charAt(1))&& (isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 0, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 3))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][3] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][0];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][0] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'e') {
					if (Arrays.asList(numbers).contains(components[2].charAt(1))&& (isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 0, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 4))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][4] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][0];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][0] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'f') {
					if (Arrays.asList(numbers).contains(components[2].charAt(1))&& (isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 0, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 5))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][5] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][0];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][0] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'g') {
					if (Arrays.asList(numbers).contains(components[2].charAt(1))&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 0, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 6))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][6] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][0];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][0] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'h') {
						if (Arrays.asList(numbers).contains(components[2].charAt(1))&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 0, 
										Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 7))==true ) {
							chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
									- 1][7] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][0];
							chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][0] = Chessmen.EMPTY;
						} else {
							System.out.println("Invalid selection, please try again");
					}
				} else {
					System.out.println("Invalid selection, please try again");
				}

			} else { System.out.println("oh:(");
			}

			break;
		case 'b':
			if (Arrays.asList(numbers).contains(components[0].charAt(1))) {
				if (components[2].charAt(0) == 'a') {
					if (Arrays.asList(numbers).contains(components[2].charAt(1))&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 1, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 0))==true ){
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][0] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][1];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][1] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'b') {
					if (Arrays.asList(numbers).contains(components[2].charAt(1))&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 1, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 1))==true ){
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][1] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][1];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][1] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'c') {
					if (Arrays.asList(numbers).contains(components[2].charAt(1))&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 1, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 2))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][2] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][1];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][1] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'd') {
					if (Arrays.asList(numbers).contains(components[2].charAt(1))&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 1, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 3))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][3] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][1];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][0] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'e') {
					if (Arrays.asList(numbers).contains(components[2].charAt(1))&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 1, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 4))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][4] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][1];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][1] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'f') {
					if (Arrays.asList(numbers).contains(components[2].charAt(1))&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 1, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 5))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][5] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][1];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][1] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'g') {
					if (Arrays.asList(numbers).contains(components[2].charAt(1))&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 1, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 6))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][6] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][1];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][1] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'h') {
					if (Arrays.asList(numbers).contains(components[2].charAt(1)) &&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 1, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 7))==true ){
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][7] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][1];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][1] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else {
					System.out.println("Invalid selection, please try again");
				}

			} else {
				System.out.println("Invalid selection, please try again");
			}

			break;
		case 'c':
			if (components[0].charAt(1) == '1' || components[0].charAt(1) == '2' || components[0].charAt(1) == '3'
					|| components[0].charAt(1) == '4' || components[0].charAt(1) == '5'
					|| components[0].charAt(1) == '6' || components[0].charAt(1) == '7'
					|| components[0].charAt(1) == '8') {
				if (components[2].charAt(0) == 'a') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 2, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 0))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][0] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][2];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][2] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'b') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 2, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 1))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][1] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][2];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][2] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'c') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 2, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 2))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][2] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][2];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][2] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'd') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 2, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 3))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][3] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][2];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][2] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'e') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8') &&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 2, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 4))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][4] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][2];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][2] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'f') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8') &&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 2, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 5))==true ){
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][5] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][2];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][2] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'g') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 2, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 6))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][6] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][2];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][2] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'h') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 2, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 7))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][7] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][2];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][2] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else {
					System.out.println("Invalid selection, please try again");
				}

			} else {
				System.out.println("Invalid selection, please try again");
			}

			break;
		case 'd':
			if (components[0].charAt(1) == '1' || components[0].charAt(1) == '2' || components[0].charAt(1) == '3'
					|| components[0].charAt(1) == '4' || components[0].charAt(1) == '5'
					|| components[0].charAt(1) == '6' || components[0].charAt(1) == '7'
					|| components[0].charAt(1) == '8') {
				if (components[2].charAt(0) == 'a') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 3, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 0))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][0] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][3];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][3] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'b') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 3, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 1))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][1] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][3];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][3] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'c') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 3, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 2))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][2] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][3];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][3] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'd') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 3, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 3))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][3] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][3];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][3] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'e') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 3, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 4))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][4] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][3];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][3] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'f') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 3, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 5))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][5] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][3];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][3] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'g') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 3, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 6))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][6] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][3];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][3] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'h') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 3, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 7))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][7] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][3];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][3] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else {
					System.out.println("Invalid selection, please try again");
				}

			} else {
				System.out.println("Invalid selection, please try again");
			}

			break;
		case 'e':
			if (components[0].charAt(1) == '1' || components[0].charAt(1) == '2' || components[0].charAt(1) == '3'
					|| components[0].charAt(1) == '4' || components[0].charAt(1) == '5'
					|| components[0].charAt(1) == '6' || components[0].charAt(1) == '7'
					|| components[0].charAt(1) == '8') {
				if (components[2].charAt(0) == 'a') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 4, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 0))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][0] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][4];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][4] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'b') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 4, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 1))==true ){
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][1] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][4];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][4] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'c') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 4, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 2))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][2] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][4];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][4] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'd') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 4, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 3))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][3] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][4];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][4] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'e') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 4, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 4))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][4] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][4];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][4] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'f') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 4, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 5))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][5] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][4];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][4] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'g') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 4, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 6))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][6] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][4];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][4] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'h') {
						if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 4, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 7))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][7] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][4];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][4] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else {
					System.out.println("Invalid selection, please try again");
				}

			} else {
				System.out.println("Invalid selection, please try again");
			}

			break;
		case 'f':
			if (components[0].charAt(1) == '1' || components[0].charAt(1) == '2' || components[0].charAt(1) == '3'
					|| components[0].charAt(1) == '4' || components[0].charAt(1) == '5'
					|| components[0].charAt(1) == '6' || components[0].charAt(1) == '7'
					|| components[0].charAt(1) == '8') {
				if (components[2].charAt(0) == 'a') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 5, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 0))==true ){
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][0] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][5];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][5] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'b') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 5, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 1))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][1] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][5];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][5] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'c') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 5, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 2))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][2] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][5];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][5] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'd') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 5, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 3))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][3] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][5];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][5] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'e') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 5, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 4))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][4] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][5];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][5] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'f') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 5, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 5))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][5] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][5];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][5] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'g') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 5, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 6))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][6] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][5];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][5] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'h') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 5, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 7))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][7] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][5];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][5] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else {
					System.out.println("Invalid selection, please try again");
				}

			} else {
				System.out.println("Invalid selection, please try again");
			}

			break;
		case 'g':
			if (components[0].charAt(1) == '1' || components[0].charAt(1) == '2' || components[0].charAt(1) == '3'
					|| components[0].charAt(1) == '4' || components[0].charAt(1) == '5'
					|| components[0].charAt(1) == '6' || components[0].charAt(1) == '7'
					|| components[0].charAt(1) == '8') {
				if (components[2].charAt(0) == 'a') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 6, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 0))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][0] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][6];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][6] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'b') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 6, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 1))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][1] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][6];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][6] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'c') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 6, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 2))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][2] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][6];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][6] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'd') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 6, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 3))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][3] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][6];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][6] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'e') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 6, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 4))==true ){
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][4] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][6];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][6] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'f') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 6, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 5))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][5] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][6];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][6] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'g') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 6, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 6))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][6] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][6];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][6] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'h') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 6, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 7))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][7] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][6];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][6] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else {
					System.out.println("Invalid selection, please try again");
				}

			} else {
				System.out.println("Invalid selection, please try again");
			}

			break;
		case 'h':
			if (components[0].charAt(1) == '1' || components[0].charAt(1) == '2' || components[0].charAt(1) == '3'
					|| components[0].charAt(1) == '4' || components[0].charAt(1) == '5'
					|| components[0].charAt(1) == '6' || components[0].charAt(1) == '7'
					|| components[0].charAt(1) == '8') {
				if (components[2].charAt(0) == 'a') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 7, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 0))==true )  {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][0] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][7];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][7] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'b') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 7, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 1))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][1] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][7];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][7] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'c') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 7, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 2))==true ){
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][2] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][7];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][7] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'd') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 7, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 3))==true ){
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][3] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][7];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][7] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'e') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 7, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 4))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][4] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][7];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][7] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'f') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 7, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 5))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][5] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][7];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][7] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'g') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 7, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 6))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][6] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][7];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][7] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else if (components[2].charAt(0) == 'h') {
					if ((components[2].charAt(1) == '1' || components[2].charAt(1) == '2'
							|| components[2].charAt(1) == '3' || components[2].charAt(1) == '4'
							|| components[2].charAt(1) == '5' || components[2].charAt(1) == '6'
							|| components[2].charAt(1) == '7' || components[2].charAt(1) == '8')&&(isValid(chessboard, Integer.parseInt(String.valueOf(components[0].charAt(1)))-1, 7, 
									Integer.parseInt(String.valueOf(components[2].charAt(1)))-1, 7))==true ) {
						chessboard[Integer.parseInt(String.valueOf(components[2].charAt(1)))
								- 1][7] = chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][7];
						chessboard[Integer.parseInt(String.valueOf(components[0].charAt(1))) - 1][7] = Chessmen.EMPTY;
					} else {
						System.out.println("Invalid selection, please try again");
					}
				} else {
					System.out.println("Invalid selection, please try again");
				}

			} else {
				System.out.println("Invalid selection, please try again");
			}

			break;
		default:
			System.out.println("Invalid selection, please try again");
		}
	}*/
