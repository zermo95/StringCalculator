package it.uniba.tdd;

public class StringCalculator {

	public int add(String numbersStr) throws StringCalculatorException {
		// caso base
		if (numbersStr.isEmpty()) {
			return 0;
		}

		// caso in cui c'è un solo numero
		if (numbersStr.length() == 1) {
			return Integer.parseInt(numbersStr);
		}

		// caso in cui ci sono più numeri
		else {
			int totalSum = 0;
			String delimiter = ",";

			// caso in cui si vuole impostare un altro delimitatore
			// se non viene impostato alcun delimitatore
			// rimane di default la virgola
			if (numbersStr.contains("//")) {
				delimiter = numbersStr.substring(2, 3);
				// System.out.println(delimiter);

				// elimina i tre caratteri iniziali
				numbersStr = numbersStr.substring(4);
				// System.out.println(numbersStr);
			}

			String[] strArray = numbersStr.split("(" + delimiter + ")" + "|(\n)");

			if (numbersStr.contains(",\n") || numbersStr.contains("\n,") || numbersStr.contains(delimiter + "\n")
					|| numbersStr.contains("\n" + delimiter) || numbersStr.contains("--")) {
				throw new StringCalculatorException();
			}

			int[] intArray = new int[strArray.length];

			for (int i = 0; i < strArray.length; i++) {
				intArray[i] = Integer.parseInt(strArray[i]);
				if (intArray[i] < 0) {
					throw new StringCalculatorException();
				} else if (intArray[i] <= 1000) {
					totalSum += intArray[i];
				}

			}
			return totalSum;

		}
	}
}